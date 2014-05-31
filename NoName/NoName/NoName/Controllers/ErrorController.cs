using System.Web.Mvc;

namespace NoName.Controllers {
    public class ErrorController : BootstrapBaseController {
        public ActionResult HTTP404() {
            return View();
        }

        public ActionResult General() {
            return View();
        }

        public ActionResult Validation() {
            return View();
        }
    }
}