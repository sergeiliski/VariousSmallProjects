using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events {
    public class LookForEventArgs : EventArgs {
        public string LookingFor { get; set; }
    }
}