using DemoCore_MVC.Models;

namespace DemoCore_MVC.Reponsitory
{
    public interface IEmployeeReponsitory
    {
        //khoi tao 1 danh sach employee
        List<Employee> GetEmployees();

        //
        Employee GetEmployee(int id);
        void AddEmp(Employee emp);

        void UpdateEmp(Employee updateEmp);

        void DeleteEmp(int id);

    }
}
