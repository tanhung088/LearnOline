using DemoCore_MVC.Models;

namespace DemoCore_MVC.Reponsitory
{
    public class EmployeeReponsitoryImp : IEmployeeReponsitory
    {
        private DatabaseContext _dbContext;
        public EmployeeReponsitoryImp(DatabaseContext dbContext) 
        {
            this._dbContext = dbContext;
        }
        public void AddEmp(Employee emp)
        {
            _dbContext.Employees.Add(emp);
            _dbContext.SaveChanges();
        }

        public void DeleteEmp(int id)
        {
            //cach 1
            //truy van LINQ
            //Employee emp = (from e in _dbContext.Employees where e.Emp_id == emp_id select e).SingleOrDefault();
            //kiem tra xem emp co type ?
            //cach 2
            var deleteEmp = _dbContext.Employees.SingleOrDefault(e => e.Emp_id.Equals(id));
            if (deleteEmp != null)
            {
                _dbContext.Employees.Remove(deleteEmp);
                _dbContext.SaveChanges();
            }
        }

        public Employee GetEmployee(int id)
        {
            Employee emp = (from e in _dbContext.Employees where e.Emp_id == id select e).SingleOrDefault();
            return emp;
        }

        public List<Employee> GetEmployees()
        {
            return _dbContext.Employees.ToList();
        }

        public void UpdateEmp(Employee updateEmp)
        {
            var emp = _dbContext.Employees.SingleOrDefault(e=>e.Emp_id.Equals(updateEmp.Emp_id));
            if (emp != null)
            {
                emp.Emp_name = updateEmp.Emp_name;
                emp.Phone = updateEmp.Phone;
                emp.Skills = updateEmp.Skills;
                emp.Experiences = updateEmp.Experiences;
                _dbContext.SaveChanges();
            }
        }
    
	}
}
