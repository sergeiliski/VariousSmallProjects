using System;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.ViewModels {
    public class ShowViewModel {
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

        public List<EpisodeViewModel> Episodes { get; set; }

        public List<ShowSubscriptionViewModel> ShowSubscriptions { get; set; }

        public List<GenreViewModel> Genres { get; set; }

        public DateTime LatestRelease {
            get {
                var result = Episodes.Where(x => x.AirDate <= DateTime.Now).ToList();
                return result.Count == 0 ? new DateTime(1970, 01, 01) : result.Max(x => x.AirDate);
            }
        }
    }
}