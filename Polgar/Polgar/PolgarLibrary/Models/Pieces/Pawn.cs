using PolgarLibrary.Models.Movement;
using System.Collections.Generic;

namespace PolgarLibrary.Models.Pieces {
    public class Pawn : Piece {
        private bool _hasMadeFirstMove = false;
        public Pawn(Color color)
            : base(color) {
            Name = ChessPiece.Pawn;
            Worth = 1;
        }

        public override List<Move> GetPossibleMoves() {
            return new List<Move>
                {
                    new Move
                        {
                            Amount = 2,
                            Direction = Direction.Forwards,
                        }
                };
        }

        public bool HasMadeFirstMove() {
            return _hasMadeFirstMove;
        }

        public void MakeFirstMove() {
            _hasMadeFirstMove = true;
        }
    }
}