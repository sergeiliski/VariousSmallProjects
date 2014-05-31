using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class UserController : Controller {
        private IUserRepository _userRepository;
        private IShowRepository _showRepository;

        public UserController(IUserRepository userRepository, IShowRepository showRepository) {
            _userRepository = userRepository;
            _showRepository = showRepository;
        }

        public ActionResult Subscriptions() {
            var user = (UserViewModel) Session["user"];
            return View(user);
        }

        public ActionResult Subscribe(int showID) {
            var show = _showRepository.GetShowByID(showID);
            var userID = ((UserViewModel) Session["user"]).ID;
            _userRepository.Subscribe(userID, show);

            Session["user"] = ViewModelFactory.Instance.CreateUserViewModel(_userRepository.GetUserByID(userID));
            return RedirectToAction("Subscriptions");
        }

        public ActionResult UnSubscribe(int showID) {
            var userID = ((UserViewModel) Session["user"]).ID;
            _userRepository.UnSubscribe(userID, showID);

            Session["user"] = ViewModelFactory.Instance.CreateUserViewModel(_userRepository.GetUserByID(userID));
            return RedirectToAction("Subscriptions");
        }
    }
}