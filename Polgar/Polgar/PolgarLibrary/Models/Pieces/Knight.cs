using PolgarLibrary.Models.Movement;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Pieces {
    public class Knight : Piece {
        public Knight(Color color)
            : base(color) {
            Name = ChessPiece.Knight;
            Worth = 3;
        }

        public override List<Move> GetPossibleMoves() {
            return new List<Move>();
        }
    }
}