using Ninject;
using Ninject.Web.Common;
using NoName.Mailers;
using NoName.Models.Data;
using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Data.Repositories.Concrete;
using System;
using System.Web.Mvc;
using System.Web.Routing;

namespace NoName.App_Start {
    public class NinjectControllerFactory : DefaultControllerFactory {
        private IKernel kernel;

        public NinjectControllerFactory() {
            kernel = new StandardKernel();
            AddBindings();
        }

        protected override IController GetControllerInstance(RequestContext requestContext, Type controllerType) {
            return (controllerType == null) ? null : (IController) kernel.Get(controllerType);
        }

        private void AddBindings() {
            kernel.Bind<DatabaseContext>().ToSelf().InSingletonScope();
            kernel.Bind<IUserRepository>().To<UserRepository>().InRequestScope();
            kernel.Bind<IShowRepository>().To<ShowRepository>().InRequestScope();
            kernel.Bind<INewsBulletinRepository>().To<NewsBulletinRepository>().InRequestScope();
            kernel.Bind<IFAQRepository>().To<FAQRepository>().InRequestScope();
            kernel.Bind<IAdministrator>().To<Administrator>().InRequestScope();
            kernel.Bind<IContactRepository>().To<ContactRepository>().InRequestScope();
            kernel.Bind<IUserMailer>().To<UserMailer>().InRequestScope();
            kernel.Bind<IGenreRepository>().To<GenreRepository>().InRequestScope();
            kernel.Bind<IShowScoreRepository>().To<ShowScoreRepository>().InRequestScope();
        }
    }
}