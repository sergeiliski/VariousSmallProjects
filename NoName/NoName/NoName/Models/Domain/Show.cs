using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace NoName.Models.Domain {
    public class Show {
        public Show() {
            Episodes = new Collection<Episode>();
            Genres = new Collection<Genre>();
        }
        public int ShowID { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public DateTime StartDate { get; set; }

        public DateTime? EndDate { get; set; }

        public string IMDb { get; set; }

        public string EZTV { get; set; }

        public int EZTVID { get; set; }

        public int TVDBID { get; set; }

        public long LastUpdated { get; set; }

        public string Poster { get; set; }

        public virtual ICollection<Episode> Episodes { get; set; }

        public virtual ICollection<ShowSubscription> ShowSubscriptions { get; set; }

        public virtual ICollection<Genre> Genres { get; set; }

        public Episode GetEpisodeByID(int id) {
            return Episodes.FirstOrDefault(x => x.EpisodeID == id);
        }
    }
}