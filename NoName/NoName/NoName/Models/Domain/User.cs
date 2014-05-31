using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.Domain {
    public class User {
        public int ID { get; set; }

        public string Username { get; set; }

        public string Email { get; set; }

        public DateTime RegistrationDate { get; set; }

        public virtual ICollection<ShowSubscription> ShowSubscriptions { get; set; }

        public bool IsSubscribedTo(int showID) {
            return (ShowSubscriptions.Any(x => x.ShowID == showID));
        }

        public void Subscribe(Show show) {
            ShowSubscriptions.Add(new ShowSubscription {
                UserID = ID,
                User = this,
                Show = show,
                ShowID = show.ShowID
            });
        }

        public void UnSubscribe(int showID) {
            var sub = ShowSubscriptions.FirstOrDefault(x => x.ShowID == showID);
            ShowSubscriptions.Remove(sub);
        }
    }
}