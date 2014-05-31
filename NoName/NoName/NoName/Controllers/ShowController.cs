using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using PagedList;
using System.Linq;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class ShowController : BootstrapBaseController {
        private readonly IShowRepository _showRepository;
        private IShowScoreRepository _scoreRepository;

        public ShowController(IShowRepository showRepository, IShowScoreRepository showScoreRepository) {
            _showRepository = showRepository;
            _scoreRepository = showScoreRepository;
        }

        public ActionResult Index(string query = "", int page = 1) {
            IPagedList<ShowViewModel> model;

            if (Request.IsAjaxRequest()) {
                model = ViewModelFactory.Instance.CreateShowViewModels(_showRepository.GetShows()
                                                                                           .Where(
                                                                                               x =>
                                                                                               x.Title.ToLower()
                                                                                                .Contains(
                                                                                                    query.ToLower())))
                                             .OrderByDescending(x => x.LatestRelease).ToList().ToPagedList(page, 15);
                return PartialView("_Shows", model);
            }

            model = ViewModelFactory.Instance.CreateShowViewModels(_showRepository.GetShows()).OrderByDescending(x => x.LatestRelease).ToList().ToPagedList(page, 15);
            return View(model);
        }

        public ActionResult Show(int showID, int season = 1) {
            ViewBag.Season = season;
            return View(ViewModelFactory.Instance.CreateShowViewModel(_showRepository.GetShowByID(showID)));
        }

        public ActionResult Episode(int episodeID) {
            return View(ViewModelFactory.Instance.CreateEpisodeViewModel(_showRepository.GetEpisodeByID(episodeID)));
        }

        public ActionResult AutoComplete(string term) {
            var result = _showRepository.GetShows().Where(x => x.Title.ToLower().Contains(term.ToLower())).Take(10).Select(x => new {
                label = x.Title
            });

            return Json(result, JsonRequestBehavior.AllowGet);
        }

        //TODO: create partial views for scores
        public ActionResult ShowScore(int showID) {
            return PartialView("_ShowScore", _scoreRepository.GetAverageScoreForShow(showID));
        }

        public ActionResult MyScore(int showID) {
            var userid = ((UserViewModel) Session["user"]).ID;
            return PartialView("_MyScore", _scoreRepository.GetScoreForUserAndShow(userid, showID));
        }
    }
}