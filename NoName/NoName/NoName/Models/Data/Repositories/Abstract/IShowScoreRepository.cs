using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface IShowScoreRepository {
        List<ShowScore> GetScoresForUser(int userid);

        ShowScore GetScoreForUserAndShow(int userid, int showid);

        int GetAverageScoreForShow(int showid);
    }
}