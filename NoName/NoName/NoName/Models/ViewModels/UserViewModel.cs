using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.ViewModels {
    public class UserViewModel {
        public int ID { get; set; }

        public string Username { get; set; }

        public string Email { get; set; }

        public DateTime RegistrationDate { get; set; }

        public List<ShowSubscriptionViewModel> ShowSubscriptions { get; set; }
    }
}