using NoName.Models.Data;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace NoName.Migrations {

    using System.Data.Entity.Migrations;

    internal sealed class Configuration : DbMigrationsConfiguration<DatabaseContext> {
        private DatabaseContext _context;

        public Configuration() {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(DatabaseContext context) {
            _context = context;
            foreach (var ep in _context.Episodes) {
                _context.Episodes.Remove(ep);
            }

            //LoadShows();
            //LoadEpisodes();
            //LoadMessages();
            LoadFAQ();
            LoadBulletins();
            LoadCategories();
            LoadGenres();

            try {
                context.SaveChanges();
            } catch (System.Data.Entity.Validation.DbEntityValidationException e) {
                var outputLines = new List<string>();
                foreach (var eve in e.EntityValidationErrors) {
                    outputLines.Add(string.Format(
                        "{0}: Entity of type \"{1}\" in state \"{2}\" has the following validation errors:",
                        DateTime.Now, eve.Entry.Entity.GetType().Name, eve.Entry.State));
                    foreach (var ve in eve.ValidationErrors) {
                        outputLines.Add(string.Format(
                            "- Property: \"{0}\", Error: \"{1}\"",
                            ve.PropertyName, ve.ErrorMessage));
                    }
                }
                System.IO.File.AppendAllLines(@"c:\temp\errors.txt", outputLines);
                throw;
            }
        }

        private void LoadShows() {
            _context.Shows.AddOrUpdate(new Show {
                ShowID = 1,
                Title = "Game of thrones",
                Description = "A tale about kings and lords.",
                StartDate = new DateTime(2013, 04, 23),
                EndDate = null,
                IMDb = "http://www.imdb.com/title/tt0944947/",
                EZTV = "http://eztv.it/shows/481/game-of-thrones/",
                Episodes = new Collection<Episode>()
            });

            _context.Shows.AddOrUpdate(new Show {
                ShowID = 2,
                Title = "House MD",
                Description = "A brilliant doctor gone bad",
                StartDate = new DateTime(2011, 03, 01),
                EndDate = new DateTime(2012, 09, 15),
                IMDb = "http://www.imdb.com/title/tt0412142/?ref_=sr_3",
                EZTV = "http://eztv.it/shows/124/house/",
                Episodes = new Collection<Episode>()
            });
        }

        private void LoadEpisodes() {
            _context.Episodes.AddOrUpdate(new Episode {
                EpisodeID = 1,
                ShowID = 1,
                Season = 1,
                EpisodeNumber = 1,
                Title = "Pilot",
                Description = "Start of the season!",
                AirDate = new DateTime(2013, 04, 23),
                DownloadLink =
                    "http://torrent.zoink.it/Game.of.Thrones.S03E10.720p.HDTV.x264-EVOLVE.[eztv].torrent",
            });

            _context.Episodes.AddOrUpdate(new Episode {
                EpisodeID = 2,
                ShowID = 2,
                Season = 1,
                EpisodeNumber = 1,
                Title = "Pilot",
                Description = "House meets the rest",
                AirDate = new DateTime(2011, 03, 01),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
            });

            _context.Episodes.AddOrUpdate(new Episode {
                EpisodeID = 3,
                ShowID = 2,
                Season = 1,
                EpisodeNumber = 2,
                Title = "The tjingeltjangel",
                Description = "House makes noise",
                AirDate = new DateTime(2012, 03, 08),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
            });

            _context.Episodes.AddOrUpdate(new Episode {
                EpisodeID = 4,
                ShowID = 2,
                Season = 2,
                EpisodeNumber = 3,
                Title = "The end",
                Description = "House dies, everyone sad.",
                AirDate = new DateTime(2012, 09, 15),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
            });
        }

        private void LoadMessages() {
            _context.Messages.AddOrUpdate(new Message {
                ID = 1,
                Date = DateTime.Now,
                Email = "SomeMail@dingske.be",
                UserID = 1,
                CategoryID = 1,
                Subject = "My subject",
                Body = "Here some text!"
            });

            _context.Messages.AddOrUpdate(new Message {
                ID = 2,
                Date = new DateTime(2013, 04, 15),
                Email = "SecondExample@lala.com",
                UserID = null,
                CategoryID = 3,
                Subject = "Another subject",
                Body = "The second message."
            });
        }

        private void LoadFAQ() {
            _context.FAQ.AddOrUpdate(new FAQ {
                ID = 1,
                Category = FAQCategory.General.ToString(),
                Question = "Question 1",
                Answer = "Answer 1"
            });

            _context.FAQ.AddOrUpdate(new FAQ {
                ID = 2,
                Category = FAQCategory.Shows.ToString(),
                Question = "Question 2",
                Answer = "Answer 2"
            });

            _context.FAQ.AddOrUpdate(new FAQ {
                ID = 3,
                Category = FAQCategory.Shows.ToString(),
                Question = "Question 3",
                Answer = "Answer 3"
            });

            _context.FAQ.AddOrUpdate(new FAQ {
                ID = 4,
                Category = FAQCategory.Account.ToString(),
                Question = "Question 4",
                Answer = "Answer 4"
            });
        }

        private void LoadBulletins() {
            _context.NewsBulletins.AddOrUpdate(new NewsBulletin {
                ID = 1,
                Title = "An example",
                Timestamp = new DateTime(2013, 05, 14, 05, 23, 14),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });

            _context.NewsBulletins.AddOrUpdate(new NewsBulletin {
                ID = 2,
                Title = "Second example",
                Timestamp = new DateTime(2013, 05, 12, 03, 04, 14),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });

            _context.NewsBulletins.AddOrUpdate(new NewsBulletin {
                ID = 3,
                Title = "Third example",
                Timestamp = new DateTime(2013, 05, 19, 07, 43, 56),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });
        }

        private void LoadCategories() {
            _context.ContactCategories.AddOrUpdate(new ContactCategory {
                ID = 1,
                Category = "My account"
            });

            _context.ContactCategories.AddOrUpdate(new ContactCategory {
                ID = 2,
                Category = "Website functionality"
            });

            _context.ContactCategories.AddOrUpdate(new ContactCategory {
                ID = 3,
                Category = "Suggestions"
            });

            _context.ContactCategories.AddOrUpdate(new ContactCategory {
                ID = 3,
                Category = "Other"
            });
        }

        private void LoadGenres() {
            var genres = new List<String> { "Action and Adventure", "Animation", "Children", "Comedy", "Crime", "Documentary",
                                            "Drama", "Family", "Fantasy", "Food", "Game Show", "Home and Garden", "Horror",
                                            "Mini-Series", "News", "Reality", "Science-Fiction", "Soap", "Special Interest",
                                            "Sport", "Suspense", "Talk Show", "Thriller", "Travel", "Western"};

            foreach (var genre in genres) {
                _context.Genres.AddOrUpdate(new Genre {
                    Name = genre
                });
            }
        }
    }
}