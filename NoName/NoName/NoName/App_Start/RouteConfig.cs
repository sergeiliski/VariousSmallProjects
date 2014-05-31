using NavigationRoutes;
using NoName.Controllers;
using NoName.Localization;
using System.Web.Mvc;
using System.Web.Routing;

namespace NoName.App_Start {

    public class RouteConfig {

        public static void RegisterRoutes(RouteCollection routes) {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
                );
        }
    }
}