using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using NoName.Controllers;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;

namespace NoName.Tests.Controllers {
    [TestClass]
    public class NewsControllerTests {
        private NewsController _newsController;
        private Mock<INewsBulletinRepository> _newsBulletinRepository;
        private TestContext _context;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
            _newsBulletinRepository = new Mock<INewsBulletinRepository>();
            _newsController = new NewsController(_newsBulletinRepository.Object);
        }

        [TestMethod]
        public void ReturnAllBulletins() {
            var data = _context.NewsBulletins;
            _newsBulletinRepository.Setup(x => x.GetAllBulletins()).Returns(data);

            var result = _newsController.Index() as ViewResult;

            Assert.IsNotNull(data);
            Assert.IsNotNull(result);
            Assert.AreEqual(data.Count, ((List<NewsBulletinViewModel>) result.Model).Count);

            _newsBulletinRepository.Verify(x => x.GetAllBulletins(), Times.Once());
        }

        [TestMethod]
        public void ReturnBulletinDetails() {
            var data = _context.NewsBulletins.FirstOrDefault(x => x.ID == 1);
            _newsBulletinRepository.Setup(x => x.GetNewsBulletin(1)).Returns(data);

            var result = _newsController.Story(data.ID) as ViewResult;

            Assert.IsNotNull(data);
            Assert.IsNotNull(result);
            Assert.AreEqual(data.ID, ((NewsBulletinViewModel) result.Model).ID);

            _newsBulletinRepository.Verify(x => x.GetNewsBulletin(data.ID), Times.Once());
        }
    }
}