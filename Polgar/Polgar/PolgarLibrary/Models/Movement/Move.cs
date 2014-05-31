using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Movement {
    public enum Direction {
        Horizontal,
        Vertical,
        Forwards,
        Diagonal
    }

    public class Move {
        public Direction Direction { get; set; }
        public int Amount { get; set; }
    }
}