using NoName.Models.Data.Repositories.Abstract;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class AdminController : BootstrapBaseController {
        private IAdministrator _administrator;

        public AdminController(IAdministrator administrator) {
            _administrator = administrator;
        }

        public ActionResult PopulateDatabase() {
            _administrator.PopulateDatabase();
            return RedirectToAction("Index", "Show");
        }

        public ActionResult UpdateDatabase() {
            _administrator.UpdateDatabase();
            return RedirectToAction("Index", "Show");
        }

        public ActionResult Crawl(int showID, string returnUrl) {
            _administrator.Crawl(showID);
            return Redirect(returnUrl);
        }
    }
}