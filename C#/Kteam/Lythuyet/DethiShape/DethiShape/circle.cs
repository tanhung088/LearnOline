using System;
using System.Collections.Generic;
using System.Text;

namespace DethiShape
{
    class circle : shape
    {
        public double radius;
        public double pRadius {
            get { return radius; }
            set
            {
                if(value > 0)
                {
                    radius = value;
                }
                else
                {
                    throw new Exception("Radius must be > 0");
                }
            }
        }
        public override void viewArea()
        {
            Console.WriteLine("AreaCircle = {0}", Math.PI*pRadius*2);
        }
    }
}
