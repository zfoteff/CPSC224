public class CicleTester
{
    public static void main(String[] args)
    {
        Point circleCenter = new Point(3, 4);
        Circle c = new Circle(3, circleCenter);

        System.out.println(c.toString());
    }
}
