using Microsoft.AspNetCore.Mvc;

namespace OnlineShop_CoreMVC_TongHop.Areas.Login.Controllers
{
    [Area("Login")]
    public class LoginController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
