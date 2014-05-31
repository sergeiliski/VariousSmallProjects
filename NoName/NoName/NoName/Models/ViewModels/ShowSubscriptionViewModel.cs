using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.ViewModels {
    public class ShowSubscriptionViewModel {
        public int UserID { get; set; }

        public int ShowID { get; set; }

        public UserViewModel User { get; set; }

        public ShowViewModel Show { get; set; }
    }
}