using System; // using <Khai bao thu vien>

namespace Bai2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine(10.2f);
            Console.WriteLine(true);
            Console.Write(Environment.NewLine); // Su dung lenh xuong dong
            Console.WriteLine(Console.Read()); // Doc 1 ky tu va in ra ma ASCII
            Console.WriteLine(Console.ReadLine());//Co the ket hop 2 lenh nay

            Console.ReadKey();//Doc 1 ky tu ban phim va tra ve kieu du lieu consolekeyinfo  
            Console.ReadKey(false); // Hien thi phim bam ra man hinh
            Console.ReadKey(true); // Ko hien thi phim bam ra man minh
        }
    }
}
