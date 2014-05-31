using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Movement.Validation {
    public class CheckValidator : IMoveValidator{
        public ValidationResult Validate(HashSet<Location> board, Location start, Location end)
        {
            var startX = start.X;
            var startY = start.Y;

            
        }
    }
}
