using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface IContactRepository {
        ContactCategory GetCategoryByID(int id);

        void SendMessage(Message message);
    }
}