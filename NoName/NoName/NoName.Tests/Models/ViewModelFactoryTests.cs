using Microsoft.VisualStudio.TestTools.UnitTesting;
using NoName.Models.ViewModels;
using System.Linq;

namespace NoName.Tests.Models {
    [TestClass]
    public class ViewModelFactoryTests {
        private TestContext _context;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
        }

        [TestMethod]
        public void ShowViewModel() {
            var show = _context.Shows.FirstOrDefault(x => x.ShowID == 1);
            var result = ViewModelFactory.Instance.CreateShowViewModel(show);

            Assert.IsNotNull(show);
            Assert.IsNotNull(result);
            Assert.IsInstanceOfType(result, typeof(ShowViewModel));
            Assert.AreEqual(show.ShowID, result.ShowID);
            Assert.AreEqual(show.Title, result.Title);
            Assert.AreEqual(show.Description, result.Description);
            Assert.AreEqual(show.StartDate, result.StartDate);
            Assert.IsNull(result.EndDate);
            Assert.AreEqual(show.IMDb, result.IMDb);
            Assert.AreEqual(show.EZTV, result.EZTV);
        }

        [TestMethod]
        public void MultipleShowViewModels() {
            var shows = _context.Shows.ToList();
            var result = ViewModelFactory.Instance.CreateShowViewModels(shows);

            Assert.IsNotNull(shows);
            Assert.IsNotNull(result);
            Assert.AreEqual(shows.Count, result.Count);
            foreach (var showViewModel in result) {
                Assert.IsInstanceOfType(showViewModel, typeof(ShowViewModel));
            }
        }

        [TestMethod]
        public void EpisodeViewModelWithSingleParameter() {
            var episode = _context.Episodes.FirstOrDefault(x => x.EpisodeID == 2);
            var result = ViewModelFactory.Instance.CreateEpisodeViewModel(episode);

            Assert.IsNotNull(episode);
            Assert.IsNotNull(result);
            Assert.IsInstanceOfType(result, typeof(EpisodeViewModel));
            Assert.AreEqual(episode.EpisodeID, result.EpisodeID);
            Assert.AreEqual(episode.ShowID, result.ShowID);
            Assert.AreEqual(episode.EpisodeNumber, result.EpisodeNumber);
            Assert.AreEqual(episode.Season, result.Season);
            Assert.AreEqual(episode.Title, result.Title);
            Assert.AreEqual(episode.Description, result.Description);
            Assert.AreEqual(episode.AirDate, result.AirDate);
            Assert.AreEqual(episode.DownloadLink, result.DownloadLink);
            Assert.IsInstanceOfType(result.Show, typeof(ShowViewModel));
            Assert.AreEqual(episode.Show.ShowID, result.Show.ShowID);
        }

        [TestMethod]
        public void EpisodeViewModelWithMultipleParameters() {
            var show = _context.Shows.FirstOrDefault(x => x.ShowID == 1);
            var episode = show.Episodes.FirstOrDefault(x => x.EpisodeNumber == 1);
            var result = ViewModelFactory.Instance.CreateEpisodeViewModel(episode,
                                                                          ViewModelFactory.Instance.CreateShowViewModel(
                                                                              show));

            Assert.IsNotNull(show);
            Assert.IsNotNull(episode);
            Assert.IsNotNull(result);
            Assert.IsInstanceOfType(result, typeof(EpisodeViewModel));
            Assert.IsInstanceOfType(result.Show, typeof(ShowViewModel));
            Assert.AreEqual(episode.Show.ShowID, result.Show.ShowID);
            Assert.AreEqual(episode.EpisodeID, result.EpisodeID);
        }

        [TestMethod]
        public void FAQViewModel() {
            var faq = _context.FAQ.FirstOrDefault(x => x.ID == 1);
            var result = ViewModelFactory.Instance.CreateFAQViewModel(faq);

            Assert.IsNotNull(faq);
            Assert.IsNotNull(result);
            Assert.IsInstanceOfType(result, typeof(FAQViewModel));
            Assert.AreEqual(faq.ID, result.ID);
            Assert.AreEqual(faq.Category, result.Category);
            Assert.AreEqual(faq.Question, result.Question);
            Assert.AreEqual(faq.Answer, result.Answer);
        }

        [TestMethod]
        public void MultipleNewsBulletinViewModels() {
            var news = _context.NewsBulletins.ToList();
            var result = ViewModelFactory.Instance.CreateNewsBulletinViewModels(news);

            Assert.IsNotNull(news);
            Assert.IsNotNull(result);
            Assert.AreEqual(news.Count, result.Count);
            foreach (var showViewModel in result) {
                Assert.IsInstanceOfType(showViewModel, typeof(NewsBulletinViewModel));
            }
        }

        [TestMethod]
        public void NewsBulletinViewModel() {
            var bulletin = _context.NewsBulletins.FirstOrDefault(x => x.ID == 1);
            var result = ViewModelFactory.Instance.CreateNewsBulletinViewModel(bulletin);

            Assert.IsNotNull(bulletin);
            Assert.IsNotNull(result);
            Assert.IsInstanceOfType(result, typeof(NewsBulletinViewModel));
            Assert.AreEqual(bulletin.ID, result.ID);
            Assert.AreEqual(bulletin.Title, result.Title);
            Assert.AreEqual(bulletin.Timestamp, result.Timestamp);
            Assert.AreEqual(bulletin.Introduction, result.Introduction);
            Assert.AreEqual(bulletin.Body, result.Body);
        }

        [TestMethod]
        public void UserviewModel() {
            var user = _context.Users.FirstOrDefault(x => x.ID == 1);
            var result = ViewModelFactory.Instance.CreateUserViewModel(user);

            Assert.IsNotNull(user);
            Assert.IsNotNull(result);
            Assert.IsNotNull(user.ShowSubscriptions);
            Assert.IsNotNull(result.ShowSubscriptions);
            Assert.IsInstanceOfType(result, typeof(UserViewModel));
            Assert.AreEqual(user.ID, result.ID);
            Assert.AreEqual(user.Username, result.Username);
            Assert.AreEqual(user.Email, result.Email);
            Assert.AreEqual(user.RegistrationDate, result.RegistrationDate);
            Assert.AreEqual(user.ShowSubscriptions.Count, result.ShowSubscriptions.Count);
            Assert.AreEqual(user.ShowSubscriptions.FirstOrDefault(x => x.ShowID == 1).Show.Episodes.Count, result.ShowSubscriptions.FirstOrDefault(x => x.ShowID == 1).Show.Episodes.Count);
        }
    }
}