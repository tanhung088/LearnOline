using DemoCore_MVC.Models;
using DemoCore_MVC.Reponsitory;
using Microsoft.AspNetCore.Mvc;

namespace DemoCore_MVC.Controllers
{
    public class EmployeeController : Controller
    {
        //goi interface
        private IEmployeeReponsitory _empReponsitory;
        public EmployeeController(IEmployeeReponsitory empReponsitory) 
        {
            this._empReponsitory = empReponsitory;
        }
        [HttpGet]
        public IActionResult Index()
        {
            //thong qua interface goi den imp
            var result = _empReponsitory.GetEmployees();
            return View(result);
        }

		[HttpPost]
		public IActionResult Index(string inputSearch)
		{
			//thong qua interface goi den imp
			var result = _empReponsitory.GetEmployees();
			if (!String.IsNullOrEmpty(inputSearch))
			{
				var listSearch = result.Where(e=>e.Emp_name.ToLower().Contains(inputSearch.ToLower()));
				return View(listSearch);
			}
			else
			{
				return View(result);
			}
		}

		public IActionResult Delete(int id) 
        {
            _empReponsitory.DeleteEmp(id);
            return RedirectToAction("Index");

		}
        [HttpGet]
		public IActionResult Create()
		{
			//thong qua interface goi den imp
			return View();
		}
		[HttpPost]
		public IActionResult Create(Employee emp)
		{
            try
            {
                if (ModelState.IsValid) 
                {
					_empReponsitory.AddEmp(emp);
					return RedirectToAction("Index");
				}
            }
            catch (Exception ex) 
            {
                ModelState.AddModelError(string.Empty, ex.Message);
            }
            return View();
		}

		[HttpGet]
		public IActionResult Update(int id)
		{
            var result = _empReponsitory.GetEmployee(id);
			//thong qua interface goi den imp
			return View(result);
		}

        [HttpPost]
        public IActionResult Update(Employee emp) 
        {
			try
			{
				if (ModelState.IsValid)
				{
					_empReponsitory.UpdateEmp(emp);
					return RedirectToAction("Index");
				}
			}
			catch (Exception ex)
			{
				ModelState.AddModelError(string.Empty, ex.Message);
			}
            return View();
        }
	}
}
