using System;

namespace OOP
{
    class circle
    {
        private int radius { get;set;}

        public int getRadius()
        {
            return radius;
        }

        public void setRadius(int radius)
        {
            this.radius = radius;
        }
    }

    class Myapp
    {
        public static void Main(String[] args){
            circle MyCircle = new circle();
            MyCircle.setRadius(10);
            Console.WriteLine(MyCircle.getRadius().ToString());
        }
    }
}