using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events {
    public class NSA {
        public string Name {
            get { return "(Inter)National Spying Assholes"; }
        }

        public void Surveil(object sender, LookForEventArgs e) {
            Console.WriteLine("Beep boop intercepted illegal transmission! Initiate Drones.");
        }
    }
}