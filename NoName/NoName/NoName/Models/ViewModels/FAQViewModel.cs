using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.ViewModels {
    public class FAQViewModel {
        public int ID { get; set; }

        public string Category { get; set; }

        public string Question { get; set; }

        public string Answer { get; set; }
    }
}