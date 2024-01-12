using Microsoft.AspNetCore.Mvc;
using OnlineShop_CoreMVC_TongHop.Reponsitory.Admin;

namespace OnlineShop_CoreMVC_TongHop.Areas.Product.Controllers
{
	[Area("Product")]
	public class ProductController : Controller
	{
		private IAdmin _proReponsitory;

		public ProductController(IAdmin proReponsitory)
		{
			this._proReponsitory = proReponsitory;
		}
		[HttpGet]
		public IActionResult Index()
		{
			var result = _proReponsitory.GetAllUsers();
			return View(result);
		}
	}
}
