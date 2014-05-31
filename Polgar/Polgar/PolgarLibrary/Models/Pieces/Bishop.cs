using PolgarLibrary.Models.Movement;
using System.Collections.Generic;

namespace PolgarLibrary.Models.Pieces {
    public class Bishop : Piece {
        public Bishop(Color color)
            : base(color) {
            Name = ChessPiece.Bishop;
            Worth = 3;
        }

        public override List<Move> GetPossibleMoves() {
            return new List<Move>
                {
                    new Move
                        {
                            Amount = 7,
                            Direction = Direction.Diagonal,
                        }
                };
        }
    }
}