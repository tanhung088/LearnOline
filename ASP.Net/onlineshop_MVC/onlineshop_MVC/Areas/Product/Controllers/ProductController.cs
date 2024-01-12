using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace onlineshop_MVC.Areas.Product.Controllers
{
    public class ProductController : Controller
    {
        // GET: Product/Product
        public ActionResult Index()
        {
            return View();
        }
    }
}