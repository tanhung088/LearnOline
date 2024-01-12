using System;
using System.Collections.Generic;
using System.Text;

namespace DethiShape
{
    class rectangle : shape
    {
        public double width, length;
        public double pWidth {
            get { return width; }
            set
            {
                if (value > 0)
                {
                    width = value;
                }
                else
                {
                    throw new Exception("Width must be > 0");
                }
            } 
        }

        public double pLength
        {
            get { return length; }
            set
            {
                if (value > 0)
                {
                    length = value;
                }
                else
                {
                    throw new Exception("Length must be > 0");
                }
            }
        }
        public override void viewArea()
        {
            Console.WriteLine("AreaRectangle: = {0}" ,pWidth*pLength );
        }
    }
}
