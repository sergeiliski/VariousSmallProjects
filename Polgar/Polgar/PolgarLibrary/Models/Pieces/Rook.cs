using PolgarLibrary.Models.Movement;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Pieces {
    public class Rook : Piece {
        public Rook(Color color)
            : base(color) {
            Name = ChessPiece.Rook;
            Worth = 5;
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
                };
        }
    }
}