import java.util.Arrays;

public class PointTester
{
    public static void main(String[] args)
    {
        Point p1 = new Point();
        Point p2 = new Point(2, 5);

        Point[] points = new Point[5]; // initializes 5 null point references

        for(int i = 0; i< points.length; i++)
        {
            points[i] = new Point(i, i);
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(Arrays.toString(points));
    }
}
