using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class NewsController : BootstrapBaseController {
        private readonly INewsBulletinRepository _newsBulletinRepository;

        public NewsController(INewsBulletinRepository newsBulletinRepository) {
            _newsBulletinRepository = newsBulletinRepository;
        }

        public ActionResult Index() {
            return View(ViewModelFactory.Instance.CreateNewsBulletinViewModels(_newsBulletinRepository.GetAllBulletins()));
        }

        public ActionResult Story(int id) {
            return
                View(ViewModelFactory.Instance.CreateNewsBulletinViewModel(_newsBulletinRepository.GetNewsBulletin(id)));
        }
    }
}