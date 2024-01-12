using System;
using System.Collections.Generic;
using System.Text;

namespace DethiLapTop
{
    public class laptopmanager
    {
        List<laptop> list = new List<laptop>();
        laptop lap;

        public laptopmanager()
        {

        }

        public void addLaptop()
        {
            lap = new laptop();
            //Nhap model
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter Model : ");
                    lap.pModel = Console.ReadLine();
                    break;
                }
               
                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }

            //Nhap price
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter Price : ");
                    lap.pPrice = int.Parse(Console.ReadLine());
                    break;
                }
                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }

            //Nhap Thin
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter isThin : ");
                    lap.pIsThin = bool.Parse(Console.ReadLine());
                    break;
                }
                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }
            //them 1 doi tuong lap va list
            list.Add(lap);
        }

        public void showAll()
        {
            if (list.Count == 0)
            {
                Console.WriteLine("List is empty!!!");
            }
            else
            {
                foreach (var lap in list)
                {
                    lap.PrintInfo();
                }
            }
        }

        //ham in ra may tinh mong
        public void PrintIsThin()
        {
            if (list.Count == 0)
            {
                Console.WriteLine("List is empty!!!");
            }
            else
            {
                int countThin = 0;
                foreach (var lap in list)
                {
                    if (lap.pIsThin == true)
                    {
                        lap.PrintInfo();
                        countThin++;
                    }
                }
            }
        }
    }
}
