using PolgarLibrary.Models.Movement;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Pieces {
    public class Queen : Piece {
        public Queen(Color color)
            : base(color) {
            Name = ChessPiece.Queen;
            Worth = 9;
        }

        public override List<Move> GetPossibleMoves() {
            return new List<Move>
                {
                    new Move
                        {
                            Amount = 7,
                            Direction = Direction.Vertical,
                        },
                    new Move
                        {
                            Amount = 7,
                            Direction = Direction.Horizontal,
                        },
                    new Move
                        {
                            Amount = 7,
                            Direction = Direction.Diagonal,
                        }
                };
        }
    }
}