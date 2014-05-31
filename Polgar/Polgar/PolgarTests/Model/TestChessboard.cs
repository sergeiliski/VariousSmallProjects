using Microsoft.VisualStudio.TestTools.UnitTesting;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Pieces;

namespace PolgarTests.Model {
    [TestClass]
    public class TestChessboard {
        private Chessboard _board;
        private Piece[,] _pieces;

        [TestInitialize]
        public void Initialize() {
            _board = new Chessboard();
            _pieces = _board.GetChessboard();
        }

        [TestMethod]
        public void AddPawnsToBoard() {
            for (var i = 1; i < 8; i++) {
                Assert.IsTrue(_pieces[i, 2].Name == ChessPiece.Pawn && _pieces[i, 2].Color == Color.White, "Row: " + i);
                Assert.IsTrue(_pieces[i, 7].Name == ChessPiece.Pawn && _pieces[i, 7].Color == Color.Black, "Row: " + i);
            }
        }

        [TestMethod]
        public void AddKnightsToBoard() {
            Assert.IsTrue(_pieces[2, 1].Name == ChessPiece.Knight && _pieces[2, 1].Color == Color.White);
            Assert.IsTrue(_pieces[7, 1].Name == ChessPiece.Knight && _pieces[7, 1].Color == Color.White);
            Assert.IsTrue(_pieces[2, 8].Name == ChessPiece.Knight && _pieces[2, 8].Color == Color.Black);
            Assert.IsTrue(_pieces[7, 8].Name == ChessPiece.Knight && _pieces[7, 8].Color == Color.Black);
        }

        [TestMethod]
        public void AddBishopsToBoard() {
            Assert.IsTrue(_pieces[3, 1].Name == ChessPiece.Bishop && _pieces[3, 1].Color == Color.White);
            Assert.IsTrue(_pieces[6, 1].Name == ChessPiece.Bishop && _pieces[6, 1].Color == Color.White);
            Assert.IsTrue(_pieces[3, 8].Name == ChessPiece.Bishop && _pieces[3, 8].Color == Color.Black);
            Assert.IsTrue(_pieces[6, 8].Name == ChessPiece.Bishop && _pieces[6, 8].Color == Color.Black);
        }

        [TestMethod]
        public void AddRooksToBoard() {
            Assert.IsTrue(_pieces[1, 1].Name == ChessPiece.Rook && _pieces[1, 1].Color == Color.White);
            Assert.IsTrue(_pieces[8, 1].Name == ChessPiece.Rook && _pieces[8, 1].Color == Color.White);
            Assert.IsTrue(_pieces[1, 8].Name == ChessPiece.Rook && _pieces[1, 8].Color == Color.Black);
            Assert.IsTrue(_pieces[8, 8].Name == ChessPiece.Rook && _pieces[8, 8].Color == Color.Black);
        }

        [TestMethod]
        public void AddQueensToBoard() {
            Assert.IsTrue(_pieces[5, 1].Name == ChessPiece.Queen && _pieces[5, 1].Color == Color.White);
            Assert.IsTrue(_pieces[5, 8].Name == ChessPiece.Queen && _pieces[5, 8].Color == Color.Black);
        }

        [TestMethod]
        public void AddKingsToBoard() {
            Assert.IsTrue(_pieces[4, 1].Name == ChessPiece.King && _pieces[4, 1].Color == Color.White);
            Assert.IsTrue(_pieces[4, 8].Name == ChessPiece.King && _pieces[4, 8].Color == Color.Black);
        }

        [TestMethod]
        public void CannotMoveOutsideBounds() {
            Assert.IsFalse(_board.CanMoveToLocation(5, 4, 9, 0));
        }

        [TestMethod]
        public void CannotMoveToStartingPosition() {
            Assert.IsFalse(_board.CanMoveToLocation(5, 4, 5, 4));
        }
    }
}