using System;
using System.Collections.Generic;
using System.Text;

namespace DethiShape
{
    public class shapemanager
    {
        List<shape> list = new List<shape>();
        circle c;
        rectangle r;

        public shapemanager()
        {

        }
        
        public void addCirle()
        {
            c = new circle();
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter radius : ");
                    c.pRadius = double.Parse(Console.ReadLine());
                    break;
                }

                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }
            list.Add(c);
        }

        public void addRec()
        {
            r = new rectangle();
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter width : ");
                    r.pWidth = double.Parse(Console.ReadLine());
                    break;
                }

                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }

            while (true)
            {
                try
                {
                    Console.WriteLine("Enter length : ");
                    r.pLength = double.Parse(Console.ReadLine());
                    break;
                }

                catch (Exception e)
                {

                    Console.WriteLine(e.Message);
                }
            }

            list.Add(r);
        }

        public void showAll()
        {
            if (list.Count == 0)
            {
                Console.WriteLine("List is empty!!!");
            }
            else
            {
                
                foreach (var l in list)
                {
                    l.viewArea();
                }
            }
        }
    }
}
