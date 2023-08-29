using System;

namespace SumOfDigits
{
    public class program
    {
        public static void Main(string[] args)
        {
            var input = Console.ReadLine();
            var vals = input.Split(' ');
            var a = int.Parse(vals[0]);
            var b = int.Parse(vals[1]);
            Console.WriteLine(a+b);
        }
    }
}
