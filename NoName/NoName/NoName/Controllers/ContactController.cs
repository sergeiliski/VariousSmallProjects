using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using NoName.Models.ViewModels;
using System;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class ContactController : BootstrapBaseController {
        private IContactRepository _contactRepository;
        private IUserRepository _userRepository;

        public ContactController(IContactRepository contactRepository, IUserRepository userRepository) {
            _contactRepository = contactRepository;
            _userRepository = userRepository;
        }

        [HttpPost]
        public ActionResult Contact(string category, string subject, string body, string email) {
            if (string.IsNullOrWhiteSpace(email) || string.IsNullOrWhiteSpace(body) || string.IsNullOrWhiteSpace(category) || category == "0" || string.IsNullOrWhiteSpace(subject)) {
                Error("Not every field has been filled in correctly!");
                return View("~/Views/Error/Validation.cshtml");
            }

            var toSend = new Message {
                Date = DateTime.Now,
                Email = email,
                CategoryID = Convert.ToInt32(category),
                Body = body,
                Subject = subject
            };

            var uservm = ((UserViewModel) Session["user"]);
            if (uservm != null) {
                toSend.UserID = uservm.ID;
                toSend.Sender = _userRepository.GetUserByID(uservm.ID);
            }

            _contactRepository.SendMessage(toSend);
            Success("Your message has been sent! Please allow us some time to respond.");
            return RedirectToAction("Index", "Home");
        }
    }
}