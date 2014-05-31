using PolgarLibrary.Models.Pieces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Utilities {
    public static class Utils {
        public static Piece[,] TransformSetToChessboard(HashSet<Location> chessboard) {
            var result = new Piece[9, 9];
            for (var i = 1; i < 9; i++) {
                for (var k = 1; k < 9; k++) {
                    var location = chessboard.FirstOrDefault(loc => loc.X == i && loc.Y == k);
                    result[i, k] = location == null ? null : location.Piece;
                }
            }

            return result;
        }
    }
}