using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using OnlineShop_CoreMVC_TongHop.Reponsitory.Admin;

namespace OnlineShop_CoreMVC_TongHop.Areas.Admin.Controllers
{
	[Area("Admin")]
	public class AdminController : Controller
	{
		private IAdmin _amindReponsitory;

		public AdminController(IAdmin aindReponsitory) 
		{
			this._amindReponsitory = aindReponsitory;
		}
		public IActionResult Index()
		{

			var result = _amindReponsitory.GetAllUsers();
			ViewBag.userId = new SelectList(result, "User_Id", "User_Name");  
			return View(result);
		}
	}
}
