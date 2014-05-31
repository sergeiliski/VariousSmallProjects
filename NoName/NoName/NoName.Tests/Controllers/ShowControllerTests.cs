using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using NoName.Controllers;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;

namespace NoName.Tests.Controllers {
    [TestClass]
    public class ShowControllerTests {
        private ShowController _showController;
        private Mock<IShowRepository> _showRepository;
        private TestContext _context;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
            _showRepository = new Mock<IShowRepository>();
            _showController = new ShowController(_showRepository.Object);
        }

        [TestMethod]
        public void ReturnAllShows() {
            var data = _context.Shows;
            _showRepository.Setup(x => x.GetShows()).Returns(data);

            var result = _showController.Index() as ViewResult;

            Assert.IsNotNull(data);
            Assert.IsNotNull(result);
            Assert.AreEqual(data.Count, ((List<ShowViewModel>) result.Model).Count);

            _showRepository.Verify(x => x.GetShows(), Times.Once());
        }

        [TestMethod]
        public void ReturnShowDetails() {
            var data = _context.Shows.FirstOrDefault(x => x.ShowID == 1);
            _showRepository.Setup(x => x.GetShowByID(1)).Returns(data);

            var result = _showController.Show(data.ShowID) as ViewResult;

            Assert.IsNotNull(data);
            Assert.IsNotNull(result);
            Assert.AreEqual(data.ShowID, ((ShowViewModel) result.Model).ShowID);
            Assert.AreEqual(data.Episodes.Count, ((ShowViewModel) result.Model).Episodes.Count);

            _showRepository.Verify(x => x.GetShowByID(data.ShowID), Times.Once());
        }

        [TestMethod]
        public void ReturnEpisodeDetails() {
            var data = _context.Episodes.FirstOrDefault(x => x.EpisodeID == 2);
            _showRepository.Setup(x => x.GetEpisodeByID(2)).Returns(data);

            var result = _showController.Episode(data.EpisodeID) as ViewResult;

            Assert.IsNotNull(data);
            Assert.IsNotNull(result);
            Assert.AreEqual(data.Title, ((EpisodeViewModel) result.Model).Title);

            _showRepository.Verify(x => x.GetEpisodeByID(data.EpisodeID), Times.Once());
        }
    }
}