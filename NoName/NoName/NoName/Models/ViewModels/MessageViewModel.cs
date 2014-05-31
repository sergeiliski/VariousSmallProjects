using System;
using System.ComponentModel.DataAnnotations;

namespace NoName.Models.ViewModels {
    public class MessageViewModel {
        public int ID { get; set; }

        public DateTime Date { get; set; }

        public int? UserID { get; set; }

        public string Email { get; set; }

        public string Subject { get; set; }

        public string Body { get; set; }

        public int CategoryID { get; set; }

        public ContactCategoryViewModel Category { get; set; }

        public UserViewModel Sender { get; set; }
    }
}