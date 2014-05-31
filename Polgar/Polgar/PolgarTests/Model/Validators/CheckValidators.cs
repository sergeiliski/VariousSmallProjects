using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Movement.Validation;
using PolgarTests.Model.data;
using PolgarTests.Model.data.TestCaseProviders;

namespace PolgarTests.Model.Validators
{
    [TestClass]
    public class CheckValidators
    {
        private readonly TestCaseProvider _testCaseProvider = new TestCaseProvider();

        [TestMethod]
        public void EndMoveIsCheck()
        {
            var situation = _testCaseProvider.GetChessBoardForEndMoveCheck();
            var validator = new CheckValidator();

            var startLocation = situation.StartLocation;
            var chessboard = new HashSet<Location> {startLocation};
            foreach (var piece in situation.OtherPieces)
            {
                chessboard.Add(piece);
            }

            foreach (var endLocation in situation.InvalidEndLocations)
            {
                Assert.AreEqual(validator.Validate(chessboard, startLocation, endLocation), ValidationResult.Forbidden);
            }
        }

        [TestMethod]
        public void PieceBlocksCheckAndWantsToMove()
        {
        }

        [TestMethod]
        public void StartingMoveIsCheck()
        {
        }

        [TestMethod]
        public void PawnPutsMeCheck()
        {
        }

        [TestMethod]
        public void KnightPutsMeCheck()
        {
        }

        [TestMethod]
        public void QueenPutsMeCheck()
        {
        }

        [TestMethod]
        public void KingPutsMeCheck()
        {
        }

        [TestMethod]
        public void CantMoveAnotherPieceWhileCheck()
        {
        }
    }
}