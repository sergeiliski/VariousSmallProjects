using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface INewsBulletinRepository {
        NewsBulletin GetNewsBulletin(int id);

        ICollection<NewsBulletin> GetAllBulletins();
    }
}