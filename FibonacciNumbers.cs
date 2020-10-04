//Fibonacci Numbers

using System;
using System.Collections.Generic;
using System.Linq;

namespace Fibonacci
{
    public class Program
    {
        public static void Main(string[] args)
        {
            List<int> numbers = new List<int>();
            numbers.Add(1);
            numbers.Add(2);

            for(int i = 0; i < 10; i++)
            {
                numbers.Add(calculateNext(numbers));
            }
            
            foreach(var j in numbers)
            {
                Console.WriteLine(j.ToString());
            }
        }

        public static int calculateNext(List<int> numList)
        {
            int nextNum = 0;
            int length = numList.IndexOf(numList.Last<int>());
            int lastNum = numList[length];
            int previousNum = numList[length-1];
            nextNum = lastNum + previousNum;
            return nextNum;
        }
    }
}