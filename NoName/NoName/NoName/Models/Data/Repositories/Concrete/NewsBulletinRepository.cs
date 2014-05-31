using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.Data.Repositories.Concrete {
    public class NewsBulletinRepository : INewsBulletinRepository {
        private DatabaseContext _db;

        public NewsBulletinRepository(DatabaseContext db) {
            _db = db;
        }

        public NewsBulletin GetNewsBulletin(int id) {
            return _db.NewsBulletins.FirstOrDefault(x => x.ID == id);
        }

        public ICollection<NewsBulletin> GetAllBulletins() {
            return _db.NewsBulletins.ToList();
        }
    }
}