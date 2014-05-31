using Mvc.Mailer;
using NoName.Models.Domain;

namespace NoName.Mailers {
    public interface IUserMailer {
        MvcMailMessage Contact(Message message);
    }
}