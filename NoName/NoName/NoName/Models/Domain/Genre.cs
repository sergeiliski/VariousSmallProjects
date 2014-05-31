using System.Collections.Generic;

namespace NoName.Models.Domain {
    public class Genre {
        public int ID { get; set; }

        public string Name { get; set; }

        public virtual ICollection<Show> Shows { get; set; }
    }
}