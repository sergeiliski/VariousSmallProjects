using HtmlAgilityPack;
using NoName.Infrastructure;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Linq;
using System.Net;
using System.Xml.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class Administrator : IAdministrator {
        private IShowRepository _showRepository;
        private IGenreRepository _genreRepository;

        public Administrator(IShowRepository showRepository, IGenreRepository genreRepository) {
            _showRepository = showRepository;
            _genreRepository = genreRepository;
        }

        /* Crawls one show and adds (or updates) the data accordingly */
        public void Crawl(int showID) {
            var website = new HtmlWeb();
            var url = _showRepository.GetShowByID(showID).EZTV;
            var doc = website.Load(url);

            var nodes =
                doc.DocumentNode.Descendants()
                   .Where(x => x.Attributes.Contains("class") && x.Attributes["class"].Value == "forum_thread_post");

            foreach (var node in nodes) {
                var title = node.ParentNode.ChildNodes[3].ChildNodes[1].Attributes["title"].Value;
                var link = node.ParentNode.ChildNodes[5].ChildNodes[1].Attributes["href"].Value;

                var show = _showRepository.GetShowByTitle(title);
                var episode = new Episode {
                    DownloadLink = link,
                    Show = show,
                    ShowID = show.ShowID,
                    AirDate = new DateTime(2010, 05, 05),
                    Description = "No description yet",
                    Season = 1,
                    EpisodeNumber = 2,
                    Title = title,
                };

                _showRepository.InsertEpisode(episode);
            }
        }

        /* A full, one time population of the database with an entire crawl of the implemented APIs */
        /* Retrieves a list of all series from EZTV and performs a search on TheTVDB for each one */
        public void PopulateDatabase() {
            // Using the dropdown list on eztv as the source of all series titles
            const string url = "http://eztv.it";
            var website = new HtmlWeb();
            var doc = website.Load(url);

            var options =
                doc.DocumentNode.Descendants()
                   .FirstOrDefault(x => x.Attributes.Contains("name") && x.Attributes["name"].Value == "SearchString");

            if (options != null) {
                var eztvID = "";
                foreach (var node in options.ChildNodes) {
                    var title = node.InnerText;
                    if (node.Attributes.Contains("value")) {
                        eztvID = node.Attributes["value"].Value;
                    }

                    if (title != "" && eztvID != "") {
                        DownloadShowInfo(title, eztvID);
                    }
                }
            }
        }

        /* Updates the entire database with the updated data gathered from the implemented APIs */
        public void UpdateDatabase() {
            throw new NotImplementedException();
        }

        private void DownloadShowInfo(string showTitle, string eztvID) {
            var urlTitle = showTitle.ToURL();
            var eztvTitle = urlTitle.Replace("%20", "-");

            // Retrieve current time
            var web = new WebClient();
            var response = web.DownloadString("http://thetvdb.com/api/GetSeries.php?seriesname=" + urlTitle);
            var tree = XDocument.Parse(response);

            var root = tree.Element("Data");
            if (root != null) {
                var show = root.Element("Series");
                if (show != null) {
                    var description = "";
                    var TVDBID = "";
                    var title = "";
                    var imdbID = "";
                    DateTime? startDate = null;

                    if (show.Element("seriesid") != null) {
                        TVDBID = show.Element("seriesid").Value;
                    }

                    if (show.Element("SeriesName") != null) {
                        title = show.Element("SeriesName").Value;
                    }

                    if (show.Element("Overview") != null && show.Element("Overview").Value.Trim() != string.Empty) {
                        description = show.Element("Overview").Value.Trim().Truncate(1024);
                    }

                    if (show.Element("IMDB_ID") != null) {
                        imdbID = show.Element("IMDB_ID").Value;
                    }

                    if (show.Element("FirstAired") != null) {
                        var start = show.Element("FirstAired");
                        var year = Convert.ToInt32(start.Value.Substring(0, 4));
                        var month = Convert.ToInt32(start.Value.Substring(5, 2));
                        var day = Convert.ToInt32(start.Value.Substring(8, 2));
                        startDate = new DateTime(year, month, day);
                    }

                    var imdb = "";
                    if (!string.IsNullOrWhiteSpace(imdbID)) {
                        imdb = "http://imdb.com/title/" + imdbID + "/";
                    }

                    var eztv = "http://eztv.it/shows/" + eztvID + "/" + eztvTitle + "/";

                    if (startDate != null) {
                        var newShow = new Show {
                            Title = title,
                            Description = description,
                            StartDate = startDate.Value,
                            EZTVID = Convert.ToInt32(eztvID),
                            EZTV = eztv,
                            IMDb = imdb,
                            TVDBID = Convert.ToInt32(TVDBID),
                            EndDate = null
                        };

                        if (imdbID != string.Empty && description != string.Empty && TVDBID != string.Empty && title != string.Empty) {
                            LoadEpisodesForShow(newShow);
                        }
                    }
                }
            }
        }

        /* Adds episodes, poster and associated genres to the given show and sends it to the repository */
        private void LoadEpisodesForShow(Show show) {
            var web = new WebClient();
            var response = web.DownloadString("http://thetvdb.com/api/42A681658736CA43/series/" + show.TVDBID + "/all/");
            var tree = XDocument.Parse(response);

            var root = tree.Element("Data");

            if (root != null) {
                // TODO: implement updates
                var f_update = root.Element("Series").Element("lastupdated");
                if (f_update != null) {
                    var lastupdate = f_update.Value;
                    show.LastUpdated = Convert.ToInt64(lastupdate);
                }

                var f_poster = root.Element("Series").Element("poster");
                if (f_poster != null) {
                    var poster = "http://thetvdb.com/banners/" + f_poster.Value;
                    show.Poster = poster;
                }

                var f_genres = root.Element("Series").Element("Genre");
                if (f_genres != null) {
                    var genres = f_genres.Value.Split('|');
                    foreach (var genre in genres) {
                        if (!string.IsNullOrWhiteSpace(genre.Trim())) {
                            show.Genres.Add(_genreRepository.GetGenreByName(genre));
                        }
                    }
                }

                foreach (var epi in tree.Descendants("Episode")) {
                    var f_season = epi.Element("SeasonNumber");
                    var season = 0;
                    if (f_season != null) {
                        season = Convert.ToInt32(f_season.Value);
                    }

                    var f_episode = epi.Element("EpisodeNumber");
                    var episode = 0;
                    if (f_episode != null) {
                        episode = Convert.ToInt32(f_episode.Value);
                    }

                    var f_title = epi.Element("EpisodeName");
                    var title = "";
                    if (f_title != null) {
                        title = f_title.Value.Truncate(512);
                    }

                    var f_date = epi.Element("FirstAired");
                    var airDate = new DateTime(1970, 01, 01);
                    if (f_date != null && f_date.Value != string.Empty) {
                        var year = Convert.ToInt32(f_date.Value.Substring(0, 4));
                        var month = Convert.ToInt32(f_date.Value.Substring(5, 2));
                        var day = Convert.ToInt32(f_date.Value.Substring(8, 2));
                        airDate = new DateTime(year, month, day);
                    }

                    var f_description = epi.Element("Overview");
                    var description = "No description available";
                    if (f_description != null) {
                        description = f_description.Value.Truncate(1024);
                    }

                    if (season != 0 && episode != 0 && title != string.Empty) {
                        show.Episodes.Add(new Episode {
                            Show = show,
                            ShowID = show.ShowID,
                            AirDate = airDate,
                            Description = description,
                            EpisodeNumber = episode,
                            Season = season,
                            Title = title,
                        });
                    }
                }

                _showRepository.InsertShow(show);
            }
        }
    }
}