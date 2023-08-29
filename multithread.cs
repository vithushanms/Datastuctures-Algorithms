using System;
using System.Threading;

namespace multithread
{
    class program
    {
        static void Main(string[] args)
        {
            Thread myThread = new Thread(printA);
            myThread.Start();

            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("B"+ i);
            }

        }

        static void printA(){
            for(int i = 0; i < 100; i ++)
            {
                Console.WriteLine("A" + i);
            }
        }
    }
}