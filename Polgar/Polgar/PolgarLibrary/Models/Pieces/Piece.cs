using PolgarLibrary.Models.Movement;
using System.Collections.Generic;

namespace PolgarLibrary.Models.Pieces {
    public enum ChessPiece {
        Pawn,
        Knight,
        Bishop,
        Rook,
        Queen,
        King
    }

    public enum Color {
        Black,
        White
    }

    public abstract class Piece {
        protected Piece(Color color) {
            Color = color;
        }

        public ChessPiece Name { get; protected set; }

        public int Worth { get; protected set; }

        public Color Color { get; private set; }

        public abstract List<Move> GetPossibleMoves();
    }
}