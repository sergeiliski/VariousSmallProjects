using NoName.Models.Domain;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.ViewModels {
    public class ViewModelFactory {
        private static ViewModelFactory _instance;

        private ViewModelFactory() {
        }

        public static ViewModelFactory Instance {
            get { return _instance ?? (_instance = new ViewModelFactory()); }
        }

        public List<ShowViewModel> CreateShowViewModels(IEnumerable<Show> shows) {
            return shows.Select(CreateShowViewModel).ToList();
        }

        private List<EpisodeViewModel> CreateEpisodeViewModels(IEnumerable<Episode> episodes, ShowViewModel show) {
            return episodes.Select(episode => CreateEpisodeViewModel(episode, show)).ToList();
        }

        public ShowViewModel CreateShowViewModel(Show show) {
            var result = new ShowViewModel {
                ShowID = show.ShowID,
                Title = show.Title,
                Description = show.Description,
                StartDate = show.StartDate,
                EndDate = show.EndDate,
                EZTV = show.EZTV,
                IMDb = show.IMDb,
                EZTVID = show.EZTVID,
                TVDBID = show.TVDBID,
                LastUpdated = show.LastUpdated,
                Poster = show.Poster
            };

            result.Episodes = CreateEpisodeViewModels(show.Episodes, result);
            result.Genres = CreateGenreViewModels(show.Genres);
            return result;
        }

        public EpisodeViewModel CreateEpisodeViewModel(Episode episode) {
            return CreateEpisodeViewModel(episode, CreateShowViewModel(episode.Show));
        }

        public EpisodeViewModel CreateEpisodeViewModel(Episode episode, ShowViewModel show) {
            return new EpisodeViewModel {
                EpisodeNumber = episode.EpisodeNumber,
                Season = episode.Season,
                ShowID = episode.ShowID,
                EpisodeID = episode.EpisodeID,
                Title = episode.Title,
                Description = episode.Description,
                AirDate = episode.AirDate,
                DownloadLink = episode.DownloadLink,
                Show = show
            };
        }

        public List<FAQViewModel> CreateFAQViewModels(IEnumerable<FAQ> faq) {
            return faq.Select(CreateFAQViewModel).ToList();
        }

        public FAQViewModel CreateFAQViewModel(FAQ faq) {
            return new FAQViewModel {
                ID = faq.ID,
                Category = faq.Category,
                Question = faq.Question,
                Answer = faq.Answer
            };
        }

        public List<NewsBulletinViewModel> CreateNewsBulletinViewModels(IEnumerable<NewsBulletin> news) {
            return news.Select(CreateNewsBulletinViewModel).ToList();
        }

        public NewsBulletinViewModel CreateNewsBulletinViewModel(NewsBulletin bulletin) {
            return new NewsBulletinViewModel {
                ID = bulletin.ID,
                Title = bulletin.Title,
                Timestamp = bulletin.Timestamp,
                Introduction = bulletin.Introduction,
                Body = bulletin.Body
            };
        }

        public UserViewModel CreateUserViewModel(User user) {
            var result = new UserViewModel {
                ID = user.ID,
                Username = user.Username,
                Email = user.Email,
                RegistrationDate = user.RegistrationDate
            };

            result.ShowSubscriptions = CreateShowSubscriptionViewModels(user.ShowSubscriptions, result);
            return result;
        }

        private List<ShowSubscriptionViewModel> CreateShowSubscriptionViewModels(IEnumerable<ShowSubscription> subs, UserViewModel user) {
            return subs.Select(sub => CreateShowSubscriptionViewModel(sub, user)).ToList();
        }

        private ShowSubscriptionViewModel CreateShowSubscriptionViewModel(ShowSubscription sub, UserViewModel user) {
            var result = new ShowSubscriptionViewModel {
                ShowID = sub.ShowID,
                UserID = sub.UserID,
                User = user
            };

            result.Show = CreateShowViewModel(sub.Show);
            return result;
        }

        private List<GenreViewModel> CreateGenreViewModels(IEnumerable<Genre> genres) {
            return genres.Select(CreateGenreViewModel).ToList();
        }

        private GenreViewModel CreateGenreViewModel(Genre genre) {
            return new GenreViewModel {
                ID = genre.ID,
                Name = genre.Name
            };
        }
    }
}