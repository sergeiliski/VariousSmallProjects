using PolgarLibrary.Models.Movement;
using System.Collections.Generic;

namespace PolgarLibrary.Models.Pieces {
    public class King : Piece {
        public King(Color color)
            : base(color) {
            Name = ChessPiece.King;
            Worth = 0;
        }

        public override List<Move> GetPossibleMoves() {
            return new List<Move>
                {
                    new Move
                        {
                            Amount = 1,
                            Direction = Direction.Vertical,
                        },
                    new Move
                        {
                            Amount = 1,
                            Direction = Direction.Horizontal,
                        },
                    new Move
                        {
                            Amount = 1,
                            Direction = Direction.Diagonal,
                        }
                };
        }
    }
}