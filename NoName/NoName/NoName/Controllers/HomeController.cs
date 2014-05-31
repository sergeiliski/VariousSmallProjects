using System.Web.Mvc;

namespace NoName.Controllers {
    public class HomeController : BootstrapBaseController {
        public ActionResult Index() {
            return View();
        }
    }
}