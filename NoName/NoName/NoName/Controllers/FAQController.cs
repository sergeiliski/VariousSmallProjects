using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.ViewModels;
using System.Web.Mvc;

namespace NoName.Controllers {
    public class FAQController : BootstrapBaseController {
        private readonly IFAQRepository _faqRepository;

        public FAQController(IFAQRepository faqRepository) {
            _faqRepository = faqRepository;
        }

        public ActionResult Index() {
            return View(ViewModelFactory.Instance.CreateFAQViewModels(_faqRepository.GetAllQuestions()));
        }
    }
}