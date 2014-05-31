using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoName.Tests.Models {
    [TestClass]
    public class UserTests {
        private TestContext _context;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
        }

        [TestMethod]
        public void SubscribeToShow() {
            var user = _context.Users.FirstOrDefault(x => x.ID == 2);
            var show = _context.Shows.FirstOrDefault(x => x.ShowID == 2);

            Assert.IsNotNull(user);
            Assert.IsNotNull(show);
            Assert.AreEqual(0, user.ShowSubscriptions.Count);

            user.Subscribe(show);

            Assert.AreEqual(1, user.ShowSubscriptions.Count);
        }

        [TestMethod]
        public void UnSubscribeFromShow() {
            var user = _context.Users.FirstOrDefault(x => x.ID == 1);
            var show = _context.Shows.FirstOrDefault(x => x.ShowID == 2);

            Assert.IsNotNull(user);
            Assert.IsNotNull(show);
            Assert.AreEqual(2, user.ShowSubscriptions.Count);

            user.UnSubscribe(show.ShowID);

            Assert.AreEqual(1, user.ShowSubscriptions.Count);
        }
    }
}