using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarLibrary.Models.Movement.Validation {
    public enum ValidationResult {
        Forbidden,
        Allowed
    }

    public interface IMoveValidator {
        ValidationResult Validate(HashSet<Location> board, Location start, Location end);
    }
}