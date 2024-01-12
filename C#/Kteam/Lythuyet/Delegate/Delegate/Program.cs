using System;

namespace Delegate
{
    class employee
    {
        private string Name { get; set; }
        private int Age { get; set; }
        private string Designation { get; set; }
        static void Main(string[] args)
        {
            employee emp = new employee
            {
                Name = "Nguyen Tan Hung",
                Age = 23,
                Designation = "student"
            };
            Console.WriteLine("Name : {0}", emp.Name);
            Console.WriteLine("Hello World!");
        }
    }
}
