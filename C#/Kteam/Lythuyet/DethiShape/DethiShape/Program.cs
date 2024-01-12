using System;

namespace DethiShape
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice;
            shapemanager shapeManager = new shapemanager();
            do
            {
                Console.WriteLine("1. Add new circle");
                Console.WriteLine("2. Add new rectangle");
                Console.WriteLine("3. Dispay area");
                Console.WriteLine("4. Exit");
                Console.WriteLine("Enter your choice (1-4) :");
                choice = int.Parse(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        shapeManager.addCirle();
                        break;
                    case 2:
                        shapeManager.addRec();
                        break;
                    case 3:
                        shapeManager.showAll();
                        break;
                    default:
                        break;
                }
            } while (choice != 4);
        }
    }
}
