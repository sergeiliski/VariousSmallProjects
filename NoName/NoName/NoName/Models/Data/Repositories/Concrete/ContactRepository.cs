using NoName.Mailers;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class ContactRepository : IContactRepository {
        private DatabaseContext _db;
        private IUserMailer _mailer;

        public ContactRepository(DatabaseContext db, IUserMailer mailer) {
            _db = db;
            _mailer = mailer;
        }

        public ContactCategory GetCategoryByID(int id) {
            return _db.ContactCategories.FirstOrDefault(x => x.ID == id);
        }

        public void SendMessage(Message message) {
            message.Category = GetCategoryByID(message.CategoryID);
            _db.Messages.Add(message);
            _mailer.Contact(message).Send();
            _db.SaveChanges();
        }
    }
}