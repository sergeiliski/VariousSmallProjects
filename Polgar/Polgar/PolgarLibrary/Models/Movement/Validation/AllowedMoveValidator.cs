using PolgarLibrary.Models.Pieces;
using System;
using System.Collections.Generic;
using System.Linq;

namespace PolgarLibrary.Models.Movement.Validation {
    public class AllowedMoveValidator : IMoveValidator {
        private HashSet<Location> _board;
        private Location _start, _end;

        public ValidationResult Validate(HashSet<Location> board, Location start, Location end) {
            this._board = board;
            this._start = start;
            this._end = end;

            var piece = start.Piece;
            var possibleMoves = piece.GetPossibleMoves();

            // TODO: Check if I'm a knight
            // TODO: Check if it's an edge case (pawn-behind, castling, promotion)
            // TODO: Check I'm not check at any of the intermediate moves nor end move

            foreach (var move in possibleMoves) {
                // Vertical moves - Rooks, Queens, Kings
                if (move.Direction == Direction.Vertical) {
                    if (((end.Y >= start.Y - move.Amount) || (end.Y <= start.Y + move.Amount)) && end.X == start.X) {
                        if (CanMoveVertically()) {
                            return ValidationResult.Allowed;
                        }
                    }
                }

                // Forward moves - Pawns
                if (move.Direction == Direction.Forwards) {
                    if (end.X == start.X) {
                        var amount = ((piece is Pawn) && (piece as Pawn).HasMadeFirstMove()) ? 1 : 2;

                        for (var i = 1; i <= amount; i++) {
                            if (piece.Color == Color.White) {
                                if (LocationOccupied(start.X, start.Y + i)) {
                                    return ValidationResult.Forbidden;
                                }

                                if (IsEndLocation(start.X, _start.Y + i)) {
                                    return ValidationResult.Allowed;
                                }
                            } else if (piece.Color == Color.Black) {
                                if (LocationOccupied(start.X, start.Y - i)) {
                                    return ValidationResult.Forbidden;
                                }

                                if (IsEndLocation(start.X, _start.Y - i)) {
                                    return ValidationResult.Allowed;
                                }
                            }
                        }
                    }
                }

                // Horizontal moves - Rooks, Queens, Kings
                if (move.Direction == Direction.Horizontal) {
                    if (((end.X >= start.X - move.Amount) || (end.X <= start.X + move.Amount)) && end.Y == start.Y) {
                        if (CanMoveHorizontally()) {
                            return ValidationResult.Allowed;
                        }
                    }
                }

                // Diagonal moves - Bishops, Queens
                if (move.Direction == Direction.Diagonal) {
                    if (CanMoveDiagonally()) {
                        return ValidationResult.Allowed;
                    }
                }
            }

            return ValidationResult.Forbidden;
        }

        private bool CanMoveVertically() {
            for (var i = Math.Min(_start.Y, _end.Y); i < Math.Max(_start.Y, _end.Y); i++) {
                if (LocationOccupied(_start.X, i)) {
                    return false;
                }
            }

            return true;
        }

        private bool CanMoveHorizontally() {
            for (var i = Math.Min(_start.X, _end.X); i < Math.Max(_start.X, _end.X); i++) {
                if (LocationOccupied(i, _start.Y)) {
                    return false;
                }
            }

            return true;
        }

        private bool CanMoveDiagonally() {
            // You can never end up on the same line
            if (_start.X == _end.X || _start.Y == _end.Y) {
                return false;
            }

            // Check for obstruction in top-right direction
            var count = 1;
            while (_start.X + count <= _end.X && _start.Y + count <= _end.Y) {
                var currX = _start.X + count;
                var currY = _start.Y + count;

                if (LocationOccupied(currX, currY)) {
                    return false;
                }

                if (_end.X == currX && _end.Y == currY) {
                    return true;
                }

                count++;
            }

            // Check for obstruction in bottom-left direction
            count = 1;
            while (_start.X - count >= _end.X && _start.Y - count >= _end.Y) {
                var currX = _start.X - count;
                var currY = _start.Y - count;

                if (LocationOccupied(currX, currY)) {
                    return false;
                }

                if (_end.X == currX && _end.Y == currY) {
                    return true;
                }
                count++;
            }

            // Check for obstruction in top-left direction
            count = 1;
            while (_start.X - count > 0) {
                var currX = _start.X - count;
                var currY = _start.Y + count;

                if (LocationOccupied(currX, currY)) {
                    return false;
                }

                if (_end.X == currX && _end.Y == currY) {
                    return true;
                }
                count++;
            }

            // Check for obstruction in bottom-right direction
            count = 1;
            while (_start.Y - count > 0) {
                var currX = _start.X + count;
                var currY = _start.Y - count;

                if (LocationOccupied(currX, currY)) {
                    return false;
                }

                if (_end.X == currX && _end.Y == currY) {
                    return true;
                }
                count++;
            }

            return false;
        }

        private bool LocationOccupied(int x, int y) {
            var occupied = _board.FirstOrDefault(entry => entry.X == x && entry.Y == y) != null;
            if (occupied && IsEndLocation(x, y)) {
                var endPiece = GetPieceAtlocation(x, y);
                if (endPiece != null) {
                    // Pawns can't slay the a piece on their natural movement route
                    if (_start.Piece.Name != ChessPiece.Pawn) {
                        // If the colors are the same, return true: it's occupied
                        // If the colors are different, return false: it is not functionally occupied
                        return _start.Piece.Color == endPiece.Color;
                    }
                }
            }

            if (_start.Piece is King) {
                return new CheckValidator().Validate(_board, _start, _end) == ValidationResult.Forbidden;
            }

            return occupied && !IsStartLocation(x, y);
        }

        private bool IsEndLocation(int currX, int currY) {
            return currX == _end.X && currY == _end.Y;
        }

        private bool IsStartLocation(int currX, int currY) {
            return currX == _start.X && currY == _start.Y;
        }

        private Piece GetPieceAtlocation(int x, int y) {
            var firstOrDefault = _board.FirstOrDefault(entry => entry.X == x && entry.Y == y);
            if (firstOrDefault != null) {
                return firstOrDefault.Piece;
            }

            throw new ArgumentException("Board does not contain piece.");
        }
    }
}