using Microsoft.VisualStudio.TestTools.UnitTesting;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Pieces;

namespace PolgarTests.Model {
    [TestClass]
    public class TestPossibleMovesFromBeginPosition {
        private Chessboard _board;

        [TestInitialize]
        public void Initialize() {
            _board = new Chessboard();
        }

        [TestMethod]
        public void PawnsCanMove1Spot() {
            for (var i = 1; i < 8; i++) {
                // White pawns
                Assert.IsTrue(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 3), string.Format("White pawns 1 spot. X = {0}; Y = {1}", i, 3));

                // Black pawns
                Assert.IsTrue(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 6), string.Format("Black pawns 1 spot. X = {0}; Y = {1}", i, 3));
            }
        }

        [TestMethod]
        public void PawnsCanMove2Spots() {
            for (var i = 1; i < 8; i++) {
                // White pawns
                Assert.IsTrue(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 4), string.Format("White pawns 2 spots. X = {0}; Y = {1}", i, 4));

                // Black pawns
                Assert.IsTrue(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 5), string.Format("Black pawns 2 spots. X = {0}; Y = {1}", i, 5));
            }
        }

        [TestMethod]
        public void IllegalPawnMoves() {
            for (var i = 1; i <= 8; i++) {
                // White pawns
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 1), string.Format("White can move to {0}", 1));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 2), string.Format("White can move to {0}", 2));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 5), string.Format("White can move to {0}", 5));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 6), string.Format("White can move to {0}", 6));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 7), string.Format("White can move to {0}", 7));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 2, endX: i, endY: 8), string.Format("White can move to {0}", 8));

                // Black pawns
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 8), string.Format("Black can move to {0}", 8));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 7), string.Format("Black can move to {0}", 7));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 4), string.Format("Black can move to {0}", 4));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 3), string.Format("Black can move to {0}", 3));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 2), string.Format("Black can move to {0}", 2));
                Assert.IsFalse(_board.CanMoveToLocation(startX: i, startY: 7, endX: i, endY: 1), string.Format("Black can move to {0}", 1));
            }
        }

        [TestMethod]
        public void KnightsCanMoveInFront() {
            // White knights
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 1, endX: 1, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 1, endX: 3, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 1, endX: 6, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 1, endX: 8, endY: 3));

            // Black knights
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 7, endX: 1, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 7, endX: 3, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 7, endX: 6, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 7, endX: 8, endY: 3));
        }

        [TestMethod]
        public void IllegalKnightMoves() {
            // White knights
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 1, endX: 1, endY: 4));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 1, endX: 2, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 1, endX: 6, endY: 2));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 1, endX: 8, endY: 7));

            // Black knights
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 7, endX: 1, endY: 2));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 2, startY: 7, endX: 3, endY: 1));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 7, endX: 5, endY: 3));
            Assert.IsTrue(_board.CanMoveToLocation(startX: 7, startY: 7, endX: 1, endY: 3));
        }
    }
}