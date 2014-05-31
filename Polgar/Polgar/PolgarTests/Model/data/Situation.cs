using PolgarLibrary.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PolgarTests.Model.data {
    public class Situation {
        public Location StartLocation { get; set; }
        public IEnumerable<Location> ValidEndLocations { get; set; }
        public IEnumerable<Location> InvalidEndLocations { get; set; }
        public IEnumerable<Location> OtherPieces { get; set; }
    }
}