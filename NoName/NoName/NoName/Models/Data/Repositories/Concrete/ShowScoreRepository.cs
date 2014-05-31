using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class ShowScoreRepository : IShowScoreRepository {
        private DatabaseContext _db;

        public ShowScoreRepository(DatabaseContext db) {
            _db = db;
        }

        public List<ShowScore> GetScoresForUser(int userid) {
            return _db.ShowScores.Where(x => x.UserID == userid).ToList();
        }

        public ShowScore GetScoreForUserAndShow(int userid, int showid) {
            return _db.ShowScores.FirstOrDefault(x => x.UserID == userid && x.ShowID == showid);
        }

        public int GetAverageScoreForShow(int showid) {
            return (int) Math.Round(_db.ShowScores.Where(x => x.ShowID == showid).ToList().Average(x => x.Score));
        }
    }
}