using Microsoft.VisualStudio.TestTools.UnitTesting;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Movement.Validation;
using PolgarLibrary.Models.Pieces;
using PolgarTests.Model.data;
using System;
using System.Collections.Generic;
using PolgarTests.Model.data.TestCaseProviders;

namespace PolgarTests.Model.Validators {
    [TestClass]
    public class AllowedMoveValidators {
        private readonly TestCaseProvider _testCaseProvider = new TestCaseProvider();

        /**************/
        /*** PAWNS ***/
        /**************/

        [TestMethod]
        public void AllowedPawnMoveValidatorWithValidInput() {
            var situations = _testCaseProvider.GetBasicPawnMoves();
            var validator = new AllowedMoveValidator();

            foreach (var situation in situations) {
                var startLocation = situation.StartLocation;

                foreach (var endLocation in situation.ValidEndLocations) {
                    Assert.AreEqual(ValidationResult.Allowed, validator.Validate(new HashSet<Location> { startLocation }, startLocation, endLocation), String.Format("Valid move pawn. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
                }
            }
        }

        [TestMethod]
        public void AllowedPawnMoveValidatorWithInvalidInput() {
            var situations = _testCaseProvider.GetBasicPawnMoves();
            var validator = new AllowedMoveValidator();

            foreach (var situation in situations) {
                var startLocation = situation.StartLocation;

                if (startLocation.Y != 2 && startLocation.Y != 7) {
                    ((Pawn) startLocation.Piece).MakeFirstMove();
                }

                var chessboard = new HashSet<Location>();
                foreach (var piece in situation.OtherPieces) {
                    chessboard.Add(piece);
                }

                foreach (var endLocation in situation.InvalidEndLocations) {
                    Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid move pawn. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
                }
            }
        }

        /***************/
        /*** BISHOPS ***/
        /***************/

        [TestMethod]
        public void AllowedBishopMoveValidatorWithValidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Bishop);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(new HashSet<Location> { startLocation }, startLocation, endLocation), String.Format("Valid move bishop. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void AllowedBishopMoveValidatorWithInvalidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Bishop);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid move bishop. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithBishopValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Bishop);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(chessboard, startLocation, endLocation), String.Format("Valid bishop slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithBishopInValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Bishop);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid bishop slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        /*************/
        /*** ROOKS ***/
        /*************/

        [TestMethod]
        public void AllowedRookMoveValidatorWithValidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Rook);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(new HashSet<Location> { startLocation }, startLocation, endLocation), String.Format("Valid move rook. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void AllowedRookMoveValidatorWithInvalidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Rook);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid move rook. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithRookValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Rook);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(chessboard, startLocation, endLocation), String.Format("Valid rook slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithRookInValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Rook);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid rook slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        /**************/
        /*** QUEENS ***/
        /**************/

        [TestMethod]
        public void AllowedQueenMoveValidatorWithValidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Queen);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(new HashSet<Location> { startLocation }, startLocation, endLocation), String.Format("Valid move queen. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void AllowedQueenMoveValidatorWithInvalidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.Queen);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid move queen. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithQueenValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Queen);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(chessboard, startLocation, endLocation), String.Format("Valid queen slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithQueenInValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.Queen);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid queen slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        /*************/
        /*** KINGS ***/
        /*************/

        [TestMethod]
        public void AllowedKingMoveValidatorWithValidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.King);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(new HashSet<Location> { startLocation }, startLocation, endLocation), String.Format("Valid move king. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void AllowedKingMoveValidatorWithInvalidInput() {
            var situation = _testCaseProvider.GetMoves(ChessPiece.King);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid move king. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithKingValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.King);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.ValidEndLocations) {
                Assert.AreEqual(ValidationResult.Allowed, validator.Validate(chessboard, startLocation, endLocation), String.Format("Valid king slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }

        [TestMethod]
        public void SlayPiecesWithKingInValid() {
            var situation = _testCaseProvider.GetSlayingMoves(ChessPiece.King);
            var validator = new AllowedMoveValidator();

            var startLocation = situation.StartLocation;

            var chessboard = new HashSet<Location> { startLocation };
            foreach (var piece in situation.OtherPieces) {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations) {
                Assert.AreEqual(ValidationResult.Forbidden, validator.Validate(chessboard, startLocation, endLocation), String.Format("Invalid king slaying. X: {0};\tY: {1}", endLocation.X, endLocation.Y));
            }
        }
    }
}