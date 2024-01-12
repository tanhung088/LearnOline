using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace DethiLapTop
{
    //Khai bao delegate
    public delegate void onValid(string s);
    public class laptop : Computer
    {
        string model;
        int price;
        bool isThin;
        //Khai bao event cua delegate onValid
        public event onValid Valid;
        //Tao ham su dung delegate
        public void validProcess(string s)
        {
            throw new Exception(s);
        }
        //tao constructor ko parameter
        public laptop()
        {
            //Goi event
            Valid += validProcess;
        }
        //tao cac properties cho cac fields
        public string pModel
        {
            get
            {
                return model;
            }
            set
            {
                //Chi chap nhan ki tu ki so va khoang trang \\s la khoang trang
                Regex reg = new Regex("[a-zA-Z_0-9]|\\s");
                if (reg.IsMatch(value))
                {
                    model = value;
                }
                else
                {
                    Valid("Model only contains letters, digits and white space!!!");
                }
            }
        }

        public int pPrice
        {
            get { return price; }
            set
            {
                if (value <= 0)
                {
                    Valid("Price must be > 0");
                }
                else
                {
                    price = value;
                }
            }
        }

        public bool pIsThin
        {
            get { return isThin; }
            set
            {
                isThin = value;
            }
        }

        public override void PrintInfo()
        {
            Console.WriteLine("Model : {0}\tPrice: {1}\tThin: {2}", pModel, pPrice, pIsThin);
        }
    }
}
