using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface IUserRepository {
        User GetUserByID(int id);

        User GetUserByUsername(string username);

        ICollection<User> GetAllUsers();

        bool UsernameExists(string username);

        void Subscribe(int userID, Show show);

        void UnSubscribe(int userID, int showID);
    }
}