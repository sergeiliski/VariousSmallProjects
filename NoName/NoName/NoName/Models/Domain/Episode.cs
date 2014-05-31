using System;

namespace NoName.Models.Domain {
    public class Episode {
        public int EpisodeID { get; set; }

        public int ShowID { get; set; }

        public int EpisodeNumber { get; set; }

        public int Season { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public DateTime AirDate { get; set; }

        public string DownloadLink { get; set; }

        public virtual Show Show { get; set; }
    }
}