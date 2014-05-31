using PolgarLibrary.Models.Movement.Validation;
using PolgarLibrary.Models.Pieces;
using PolgarLibrary.Models.Utilities;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace PolgarLibrary.Models {
    public class Chessboard {
        private readonly HashSet<Location> _chessboard = new HashSet<Location>();

        public Chessboard() {
            InitChessBoard();
        }

        private void InitChessBoard() {
            // Pawns
            for (var i = 1; i <= 8; i++) {
                AddPiece(i, 2, new Pawn(Color.White));
                AddPiece(i, 7, new Pawn(Color.Black));
            }

            // Knights
            AddPiece(2, 1, new Knight(Color.White));
            AddPiece(7, 1, new Knight(Color.White));
            AddPiece(2, 8, new Knight(Color.Black));
            AddPiece(7, 8, new Knight(Color.Black));

            // Bishops
            AddPiece(3, 1, new Bishop(Color.White));
            AddPiece(6, 1, new Bishop(Color.White));
            AddPiece(3, 8, new Bishop(Color.Black));
            AddPiece(6, 8, new Bishop(Color.Black));

            // Rooks
            AddPiece(1, 1, new Rook(Color.White));
            AddPiece(8, 1, new Rook(Color.White));
            AddPiece(1, 8, new Rook(Color.Black));
            AddPiece(8, 8, new Rook(Color.Black));

            // Queens
            AddPiece(5, 1, new Queen(Color.White));
            AddPiece(5, 8, new Queen(Color.Black));

            // Kings
            AddPiece(4, 1, new King(Color.White));
            AddPiece(4, 8, new King(Color.Black));
        }

        private void AddPiece(int x, int y, Piece piece) {
            _chessboard.Add(new Location {
                X = x,
                Y = y,
                Piece = piece
            });
        }

        public Piece[,] GetChessboard() {
            return Utils.TransformSetToChessboard(_chessboard);
        }

        public bool CanMoveToLocation(int startX, int startY, int endX, int endY) {
            var startLocation = GetLocation(startX, startY);
            var endLocation = GetLocation(endX, endY);

            Debug.Assert(startLocation != null, string.Format("End X: {0}; end Y: {1}", endX, endY));
            Debug.Assert(endLocation != null, string.Format("End X: {0}; end Y: {1}", endX, endY));

            // Check if all values are within the board boundaries
            if (!((endX >= 1 && endX <= 8) && (endY >= 1 && endY <= 8))) {
                return false;
            }

            // Check if start and end location differ
            if (endX == startX && endY == startY) {
                return false;
            }

            // I cannot be check
            //var checkValidator = new AmICheckValidator();
            //if (checkValidator.Validate(_chessboard, startLocation, endLocation) == ValidationResult.Forbidden) {
            //    return false;
            //}

            // Is it a legal move?
            var moveValidator = new AllowedMoveValidator();
            if (moveValidator.Validate(_chessboard, startLocation, endLocation) == ValidationResult.Forbidden) {
                return false;
            }

            return true;
        }

        private Location GetLocation(int x, int y) {
            var result = _chessboard.FirstOrDefault(loc => loc.X == x && loc.Y == y) ?? new Location { X = x, Y = y };
            return result;
        }
    }
}