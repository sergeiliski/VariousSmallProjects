using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace NoName.Tests.Models {
    [TestClass]
    public class ShowTests {
        private TestContext _context;

        [TestInitialize]
        public void Initializer() {
            _context = new TestContext();
        }

        [TestMethod]
        public void GetEpisodeFromID() {
            var result = _context.Shows.FirstOrDefault(x => x.ShowID == 2);

            Assert.IsNotNull(result);
            Assert.AreEqual(3, result.Episodes.Count);

            var episode = result.GetEpisodeByID(2);

            Assert.AreEqual(1, episode.EpisodeNumber);
            Assert.AreEqual(2, episode.EpisodeID);
            Assert.AreEqual("Pilot", episode.Title);
        }
    }
}