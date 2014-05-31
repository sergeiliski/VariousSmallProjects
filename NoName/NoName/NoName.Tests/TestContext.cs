using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace NoName.Tests {
    public class TestContext {
        public TestContext() {
            LoadShows();
            LoadFAQ();
            LoadNewsBulletins();
            LoadUsers();
        }

        public ICollection<Show> Shows { get; set; }

        public ICollection<Episode> Episodes { get; set; }

        public ICollection<FAQ> FAQ { get; set; }

        public ICollection<NewsBulletin> NewsBulletins { get; set; }

        public ICollection<User> Users { get; set; }

        private void LoadShows() {
            Shows = new Collection<Show>();
            Episodes = new Collection<Episode>();

            var got = new Show {
                ShowID = 1,
                Title = "Game of thrones",
                Description = "A tale about kings and lords.",
                StartDate = new DateTime(2011, 05, 23),
                EndDate = null,
                IMDb = "http://www.imdb.com/title/tt0944947/",
                EZTV = "http://eztv.it/shows/481/game-of-thrones/",

                Episodes = new Collection<Episode>()
            };

            var gotep1 = new Episode {
                EpisodeID = 1,
                ShowID = 1,
                Season = 1,
                EpisodeNumber = 1,
                Title = "Pilot",
                Description = "Start of the season!",
                AirDate = new DateTime(2011, 09, 15),
                DownloadLink =
                    "http://torrent.zoink.it/Game.of.Thrones.S03E10.720p.HDTV.x264-EVOLVE.[eztv].torrent",
                Show = got
            };

            var house = new Show {
                ShowID = 2,
                Title = "House MD",
                Description = "A brilliant doctor gone bad",
                StartDate = new DateTime(2004, 03, 01),
                EndDate = new DateTime(2011, 09, 15),
                IMDb = "http://www.imdb.com/title/tt0412142/?ref_=sr_3",
                EZTV = "http://eztv.it/shows/124/house/",

                Episodes = new Collection<Episode>()
            };

            var houseep1 = new Episode {
                EpisodeID = 2,
                ShowID = 2,
                Season = 1,
                EpisodeNumber = 1,
                Title = "Pilot",
                Description = "House meets the rest",
                AirDate = new DateTime(2004, 03, 01),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
                Show = house
            };

            var houseep2 = new Episode {
                EpisodeID = 3,
                ShowID = 2,
                Season = 1,
                EpisodeNumber = 2,
                Title = "The tjingeltjangel",
                Description = "House makes noise",
                AirDate = new DateTime(2004, 03, 08),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
                Show = house
            };

            var houseep3 = new Episode {
                EpisodeID = 4,
                ShowID = 2,
                Season = 2,
                EpisodeNumber = 3,
                Title = "The end",
                Description = "House dies, everyone sad.",
                AirDate = new DateTime(2004, 03, 15),
                DownloadLink =
                    "http://torrent.zoink.it/House.S08E16.HDTV.x264-LOL.[eztv].torrent",
                Show = house
            };

            got.Episodes.Add(gotep1);
            Episodes.Add(gotep1);

            house.Episodes.Add(houseep1);
            house.Episodes.Add(houseep2);
            house.Episodes.Add(houseep3);

            Episodes.Add(houseep1);
            Episodes.Add(houseep2);
            Episodes.Add(houseep3);

            Shows.Add(got);
            Shows.Add(house);
        }

        private void LoadFAQ() {
            FAQ = new Collection<FAQ>();

            FAQ.Add(new FAQ {
                ID = 1,
                Category = FAQCategory.General.ToString(),
                Question = "Question 1",
                Answer = "Answer 1"
            });

            FAQ.Add(new FAQ {
                ID = 2,
                Category = FAQCategory.Shows.ToString(),
                Question = "Question 2",
                Answer = "Answer 2"
            });
        }

        private void LoadNewsBulletins() {
            NewsBulletins = new Collection<NewsBulletin>();

            NewsBulletins.Add(new NewsBulletin {
                ID = 1,
                Title = "An example",
                Timestamp = new DateTime(2013, 05, 14, 05, 23, 14),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });

            NewsBulletins.Add(new NewsBulletin {
                ID = 2,
                Title = "Second example",
                Timestamp = new DateTime(2013, 05, 12, 03, 04, 14),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });

            NewsBulletins.Add(new NewsBulletin {
                ID = 3,
                Title = "Third example",
                Timestamp = new DateTime(2013, 05, 19, 07, 43, 56),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });

            NewsBulletins.Add(new NewsBulletin {
                ID = 4,
                Title = "Fourth example",
                Timestamp = new DateTime(2013, 05, 14, 11, 0, 0),
                Introduction = "An example introduction",
                Body = "Body body body body body body body"
            });
        }

        private void LoadUsers() {
            Users = new Collection<User>();

            var jos = new User {
                ID = 1,
                Username = "Jos",
                Email = "Jos@hotmail.com",
                RegistrationDate = new DateTime(2013, 05, 05)
            };

            jos.ShowSubscriptions = new Collection<ShowSubscription>();
            jos.ShowSubscriptions.Add(new ShowSubscription {
                ShowID = 1,
                Show = Shows.FirstOrDefault(x => x.ShowID == 1),
                User = jos,
                UserID = 1
            });

            jos.ShowSubscriptions.Add(new ShowSubscription {
                ShowID = 2,
                Show = Shows.FirstOrDefault(x => x.ShowID == 2),
                User = jos,
                UserID = 1
            });

            var stefaan = new User {
                ID = 2,
                Username = "Stefaan",
                Email = "summail@dismail.xxx",
                RegistrationDate = new DateTime(2013, 04, 04),
                ShowSubscriptions = new Collection<ShowSubscription>()
            };

            Users.Add(jos);
            Users.Add(stefaan);
        }
    }
}