using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NoName.Models.Data.Repositories.Concrete {
    public class FAQRepository : IFAQRepository {
        private DatabaseContext _db;

        public FAQRepository(DatabaseContext db) {
            _db = db;
        }

        public ICollection<FAQ> GetAllQuestions() {
            return _db.FAQ.ToList();
        }
    }
}