using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using NoName.Controllers;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System.Collections.Generic;
using System.Web.Mvc;

namespace NoName.Tests.Controllers {
    [TestClass]
    public class FAQControllerTests {
        private TestContext _context;
        private Mock<IFAQRepository> _faqRepository;
        private FAQController _controller;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
            _faqRepository = new Mock<IFAQRepository>();
            _controller = new FAQController(_faqRepository.Object);
        }

        [TestMethod]
        public void ReturnAllFAQ() {
            var data = _context.FAQ;
            _faqRepository.Setup(x => x.GetAllQuestions()).Returns(data);

            var result = _controller.Index() as ViewResult;
            Assert.IsNotNull(result);
            Assert.AreEqual(data.Count, ((List<FAQViewModel>) result.Model).Count);

            _faqRepository.Verify(x => x.GetAllQuestions(), Times.Once());
        }
    }
}