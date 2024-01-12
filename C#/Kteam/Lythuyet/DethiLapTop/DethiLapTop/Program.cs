using System;

namespace DethiLapTop
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice;
            laptopmanager laptopManager = new laptopmanager();
            do
            {
                Console.WriteLine("1. Add new");
                Console.WriteLine("2. Show all");
                Console.WriteLine("3. Dispay laptop isThin");
                Console.WriteLine("4. Exit");
                Console.WriteLine("Enter your choice (1-4) :");
                choice = int.Parse(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        laptopManager.addLaptop();
                        break;
                    case 2:
                        laptopManager.showAll();
                        break;
                    case 3:
                        laptopManager.PrintIsThin();
                        break;
                    default:
                        break;
                }
            } while (choice != 4);
        }
    }
}
