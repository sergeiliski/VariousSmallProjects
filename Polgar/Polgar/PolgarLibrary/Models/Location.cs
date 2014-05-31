using PolgarLibrary.Models.Pieces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models {
    public class Location {
        public int X { get; set; }
        public int Y { get; set; }
        public Piece Piece { get; set; }

        public override bool Equals(object obj) {
            if (ReferenceEquals(null, obj))
                return false;
            if (ReferenceEquals(this, obj))
                return true;
            if (obj.GetType() != this.GetType())
                return false;
            var loc = (Location) obj;
            return X == loc.X && Y == loc.Y;
        }

        public override int GetHashCode() {
            unchecked {
                int hashCode = X;
                hashCode = (hashCode * 397) ^ Y;
                hashCode = (hashCode * 397) ^ (Piece != null ? Piece.GetHashCode() : 0);
                return hashCode;
            }
        }
    }
}