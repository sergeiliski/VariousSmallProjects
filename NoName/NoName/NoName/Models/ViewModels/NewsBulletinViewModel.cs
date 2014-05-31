using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.ViewModels {
    public class NewsBulletinViewModel {
        public int ID { get; set; }

        public string Title { get; set; }

        public string Introduction { get; set; }

        public string Body { get; set; }

        public DateTime Timestamp { get; set; }

        public int PosterID { get; set; }
    }
}