using System;
using System.Collections.Generic;
using PolgarLibrary.Models;
using PolgarLibrary.Models.Pieces;

namespace PolgarTests.Model.data.TestCaseProviders {
    public partial class TestCaseProvider {
        public IEnumerable<Situation> GetBasicPawnMoves() {
            return new List<Situation>
                {
                    new Situation
                        {
                            StartLocation = new Location {X = 4, Y = 2, Piece = new Pawn(Color.White)},
                            ValidEndLocations = new List<Location>
                                {
                                    new Location {X = 4, Y = 3},
                                    new Location {X = 4, Y = 4}
                                },
                            OtherPieces = new List<Location>(),
                            InvalidEndLocations = new List<Location>
                                {
                                    new Location {X = 4, Y = 5},
                                    new Location {X = 4, Y = 8},
                                    new Location {X = 3, Y = 4},
                                    new Location {X = 5, Y = 4}
                                }
                        },
                    new Situation
                        {
                            StartLocation = new Location {X = 6, Y = 7, Piece = new Pawn(Color.Black)},
                            ValidEndLocations = new List<Location>
                                {
                                    new Location {X = 6, Y = 6},
                                    new Location {X = 6, Y = 5}
                                },
                            OtherPieces = new List<Location>(),
                            InvalidEndLocations = new List<Location>
                                {
                                    new Location {X = 6, Y = 4},
                                    new Location {X = 5, Y = 7},
                                    new Location {X = 7, Y = 6},
                                    new Location {X = 6, Y = 1}
                                }
                        },
                    new Situation
                        {
                            StartLocation = new Location {X = 2, Y = 2, Piece = new Pawn(Color.White)},
                            OtherPieces =
                                new List<Location> {new Location {X = 2, Y = 3, Piece = new Bishop(Color.White)}},
                            ValidEndLocations = new List<Location> {},
                            InvalidEndLocations = new List<Location>
                                {
                                    new Location {X = 2, Y = 3},
                                    new Location {X = 2, Y = 4},
                                    new Location {X = 3, Y = 4},
                                    new Location {X = 1, Y = 3}
                                }
                        },
                    new Situation
                        {
                            StartLocation = new Location {X = 2, Y = 2, Piece = new Pawn(Color.White)},
                            OtherPieces =
                                new List<Location> {new Location {X = 2, Y = 4, Piece = new Bishop(Color.White)}},
                            ValidEndLocations = new List<Location> {new Location {X = 2, Y = 3}},
                            InvalidEndLocations = new List<Location>
                                {
                                    new Location {X = 2, Y = 4},
                                    new Location {X = 3, Y = 4},
                                    new Location {X = 1, Y = 3}
                                }
                        },
                    new Situation
                        {
                            StartLocation = new Location {X = 5, Y = 4, Piece = new Pawn(Color.Black)},
                            ValidEndLocations = new List<Location> {new Location {X = 5, Y = 3}},
                            OtherPieces = new List<Location>(),
                            InvalidEndLocations = new List<Location>
                                {
                                    new Location {X = 5, Y = 2},
                                    new Location {X = 6, Y = 3},
                                    new Location {X = 5, Y = 5}
                                }
                        }
                };
        }

        public Situation GetMoves(ChessPiece piece) {
            switch (piece) {
                case ChessPiece.Bishop:
                    return GetChessBoardForBishopMoves();

                case ChessPiece.King:
                    return GetChessBoardForKingMoves();

                case ChessPiece.Queen:
                    return GetChessBoardForQueenMoves();

                case ChessPiece.Rook:
                    return GetChessboardForRookMoves();

                default:
                    throw new ArgumentException();
            }
        }

        private Situation GetChessboardForRookMoves() {
            return new Situation {
                StartLocation = new Location {
                    X = 4,
                    Y = 5,
                    Piece = new Rook(Color.White)
                },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 4, Y = 1},
                            new Location {X = 4, Y = 3},
                            new Location {X = 3, Y = 5},
                            new Location {X = 8, Y = 5},
                            new Location {X = 2, Y = 5},
                        },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 2, Y = 5, Piece = new Bishop(Color.Black)},
                            new Location {X = 4, Y = 6, Piece = new Bishop(Color.Black)}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 3, Y = 1},
                            new Location {X = 1, Y = 8},
                            new Location {X = 5, Y = 3},
                            new Location {X = 5, Y = 4},
                            new Location {X = 1, Y = 5},
                            new Location {X = 4, Y = 8},
                        }
            };
        }

        private Situation GetChessBoardForBishopMoves() {
            return new Situation {
                StartLocation = new Location {
                    X = 3,
                    Y = 3,
                    Piece = new Bishop(Color.Black)
                },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 4, Y = 4},
                            new Location {X = 7, Y = 7},
                            new Location {X = 2, Y = 4},
                            new Location {X = 8, Y = 8},
                            new Location {X = 5, Y = 1},
                        },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 2, Y = 2, Piece = new Bishop(Color.Black)},
                            new Location {X = 5, Y = 2, Piece = new Bishop(Color.Black)}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 3, Y = 1},
                            new Location {X = 3, Y = 8},
                            new Location {X = 1, Y = 1},
                            new Location {X = 5, Y = 3},
                            new Location {X = 5, Y = 4},
                            new Location {X = 6, Y = 1},
                        }
            };
        }

        private Situation GetChessBoardForQueenMoves() {
            return new Situation {
                StartLocation = new Location {
                    X = 8,
                    Y = 4,
                    Piece = new Queen(Color.White)
                },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 5, Y = 1},
                            new Location {X = 7, Y = 5},
                            new Location {X = 8, Y = 1},
                            new Location {X = 4, Y = 8},
                            new Location {X = 8, Y = 5},
                        },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 7, Y = 4, Piece = new Bishop(Color.Black)},
                            new Location {X = 6, Y = 6, Piece = new Bishop(Color.Black)}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 3, Y = 1},
                            new Location {X = 1, Y = 8},
                            new Location {X = 5, Y = 3},
                            new Location {X = 5, Y = 8},
                            new Location {X = 5, Y = 4},
                            new Location {X = 5, Y = 7},
                        }
            };
        }

        private Situation GetChessBoardForKingMoves() {
            return new Situation {
                StartLocation = new Location {
                    X = 4,
                    Y = 4,
                    Piece = new King(Color.Black)
                },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 4, Y = 3},
                            new Location {X = 5, Y = 3},
                            new Location {X = 4, Y = 5},
                            new Location {X = 3, Y = 3},
                        },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 5, Y = 5, Piece = new Bishop(Color.Black)}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 3, Y = 1},
                            new Location {X = 1, Y = 8},
                            new Location {X = 5, Y = 2},
                            new Location {X = 5, Y = 8},
                            new Location {X = 5, Y = 5},
                        }
            };
        }

        public Situation GetSlayingMoves(ChessPiece piece) {
            switch (piece) {
                case ChessPiece.Bishop:
                    return GetBishopMovesForSlaying();

                case ChessPiece.King:
                    return GetKingMovesForSlaying();

                case ChessPiece.Queen:
                    return GetQueenMovesForSlaying();

                case ChessPiece.Rook:
                    return GetRookMovesForSlaying();

                default:
                    throw new ArgumentException();
            }
        }

        private Situation GetRookMovesForSlaying() {
            return new Situation {
                StartLocation = new Location { X = 4, Y = 5, Piece = new Rook(Color.Black) },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 2, Y = 5, Piece = new Bishop(Color.White)},
                            new Location {X = 4, Y = 1, Piece = new Bishop(Color.Black)}
                        },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 2, Y = 5},
                            new Location {X = 3, Y = 5},
                            new Location {X = 4, Y = 3}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 4, Y = 1},
                            new Location {X = 1, Y = 5}
                        }
            };
        }

        private Situation GetBishopMovesForSlaying() {
            return new Situation {
                StartLocation = new Location { X = 4, Y = 5, Piece = new Bishop(Color.White) },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 6, Y = 7, Piece = new Bishop(Color.White)},
                            new Location {X = 3, Y = 4, Piece = new Queen(Color.Black)}
                        },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 5, Y = 6},
                            new Location {X = 5, Y = 4},
                            new Location {X = 3, Y = 4}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 7, Y = 8},
                            new Location {X = 6, Y = 7},
                            new Location {X = 2, Y = 3}
                        }
            };
        }

        private Situation GetQueenMovesForSlaying() {
            return new Situation {
                StartLocation = new Location { X = 4, Y = 5, Piece = new Queen(Color.White) },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 4, Y = 3, Piece = new Bishop(Color.White)},
                            new Location {X = 3, Y = 4, Piece = new Pawn(Color.Black)},
                            new Location {X = 8, Y = 5, Piece = new Rook(Color.Black)}
                        },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 5, Y = 6},
                            new Location {X = 5, Y = 4},
                            new Location {X = 3, Y = 4},
                            new Location {X = 8, Y = 5}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 4, Y = 3},
                            new Location {X = 2, Y = 3}
                        }
            };
        }

        private Situation GetKingMovesForSlaying() {
            return new Situation {
                StartLocation = new Location { X = 4, Y = 5, Piece = new King(Color.White) },
                OtherPieces = new List<Location>
                        {
                            new Location {X = 3, Y = 4, Piece = new Bishop(Color.White)},
                            new Location {X = 4, Y = 4, Piece = new Bishop(Color.Black)},
                            new Location {X = 3, Y = 6, Piece = new Rook(Color.Black)}
                        },
                ValidEndLocations = new List<Location>
                        {
                            new Location {X = 5, Y = 3},
                            new Location {X = 4, Y = 4},
                            new Location {X = 3, Y = 6}
                        },
                InvalidEndLocations = new List<Location>
                        {
                            new Location {X = 3, Y = 4},
                            new Location {X = 4, Y = 6},
                            new Location {X = 3, Y = 5}
                        }
            };
        }

        public HashSet<Location> GetChessBoardWithRookCheck() {
            var chessboard = new HashSet<Location>
                {
                    new Location
                        {
                            X = 4,
                            Y = 3,
                            Piece = new King(Color.White)
                        },
                    new Location
                        {
                            X = 7,
                            Y = 3,
                            Piece = new Rook(Color.Black)
                        },
                    new Location
                        {
                            X = 4,
                            Y = 5,
                            Piece = new Rook(Color.Black)
                        }
                };

            return chessboard;
        }
    }
}