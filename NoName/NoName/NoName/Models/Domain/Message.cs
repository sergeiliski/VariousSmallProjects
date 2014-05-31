using System;

namespace NoName.Models.Domain {
    public class Message {
        public int ID { get; set; }

        public DateTime Date { get; set; }

        public int? UserID { get; set; }

        public string Email { get; set; }

        public string Subject { get; set; }

        public string Body { get; set; }

        public int CategoryID { get; set; }

        public virtual ContactCategory Category { get; set; }

        public virtual User Sender { get; set; }
    }
}