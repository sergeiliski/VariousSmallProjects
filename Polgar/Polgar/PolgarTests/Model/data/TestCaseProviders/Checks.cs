using System.Collections.Generic;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Pieces;

namespace PolgarTests.Model.data.TestCaseProviders
{
    public partial class TestCaseProvider
    {
        public Situation GetChessBoardForEndMoveCheck()
        {
            return new Situation
            {
                StartLocation = new Location {X = 4, Y = 4, Piece = new King(Color.White)},
                OtherPieces = new List<Location>
                {
                    new Location {X = 7, Y = 5, Piece = new Rook(Color.Black)}
                },
                InvalidEndLocations = new List<Location>
                {
                    new Location {X = 4, Y = 5}
                }
            };
        }
    }
}