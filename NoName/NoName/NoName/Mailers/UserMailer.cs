using Mvc.Mailer;
using NoName.Models.Domain;
using System.Net.Mail;

namespace NoName.Mailers {
    public class UserMailer : MailerBase, IUserMailer {
        public UserMailer() {
            MasterName = "_Layout";
        }

        public virtual MvcMailMessage Contact(Message message) {
            ViewBag.Message = message;
            return Populate(x => {
                x.Subject = "[" + message.Category.Category + "] " + message.Subject;
                x.ViewName = "Contact";
                x.To.Add("jer_vannevel@hotmail.com");
                x.From = new MailAddress(message.Email);
            });
        }
    }
}