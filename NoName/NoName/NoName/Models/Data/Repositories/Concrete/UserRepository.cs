using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class UserRepository : IUserRepository {
        private DatabaseContext _db;

        public UserRepository(DatabaseContext db) {
            _db = db;
        }

        public User GetUserByID(int id) {
            return _db.Users.FirstOrDefault(x => x.ID == id);
        }

        public User GetUserByUsername(string username) {
            return _db.Users.FirstOrDefault(x => x.Username == username);
        }

        public ICollection<User> GetAllUsers() {
            return _db.Users.ToList();
        }

        public bool UsernameExists(string username) {
            return _db.Users.Any(x => x.Username == username);
        }

        public void Subscribe(int userID, Show show) {
            var user = GetUserByID(userID);
            if (!user.IsSubscribedTo(show.ShowID)) {
                user.Subscribe(show);
                Save();
            }
        }

        public void UnSubscribe(int userID, int showID) {
            var user = GetUserByID(userID);
            if (user.IsSubscribedTo(showID)) {
                user.UnSubscribe(showID);
                Save();
            }
        }

        private void Save() {
            _db.SaveChanges();
        }
    }
}