using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class ShowRepository : IShowRepository {
        private DatabaseContext _db;

        public ShowRepository(DatabaseContext db) {
            _db = db;
        }

        public Show GetShowByID(int id) {
            return _db.Shows.FirstOrDefault(x => x.ShowID == id);
        }

        public Show GetShowByTitle(string title) {
            return _db.Shows.FirstOrDefault(x => x.Title == title);
        }

        public Episode GetEpisodeByID(int id) {
            return _db.Episodes.FirstOrDefault(x => x.EpisodeID == id);
        }

        public ICollection<Show> GetShows() {
            return _db.Shows.ToList();
        }

        public void InsertShow(Show show) {
            if (!_db.Shows.Any(x => x.Title == show.Title)) {
                _db.Shows.Add(show);
                _db.SaveChanges();
            }
        }

        public void InsertEpisode(Episode episode) {
            var show = _db.Shows.FirstOrDefault(x => x.ShowID == episode.ShowID);
            if (show != null) {
                show.Episodes.Add(episode);
                _db.SaveChanges();
            }
        }
    }
}