using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.Domain {
    public class ShowSubscription {
        public int UserID { get; set; }

        public int ShowID { get; set; }

        public virtual User User { get; set; }

        public virtual Show Show { get; set; }
    }
}