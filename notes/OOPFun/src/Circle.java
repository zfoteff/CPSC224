public class Circle
{
    private double r;
    private Point center;

    public Circle()
    {
        this.r = 1.0;
        this.center = new Point();
    }

    public Circle(double userRadius, Point userCenter)
    {
        this.r = userRadius;
        this.center = userCenter;
    }

    @Override
    public String toString()
    {
        return "Circle: r = "+r+"  center = ("+center.getX()+", "+center.getY()+")";
    }

    public double getR()
    {
        return r;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    public Point getCenter()
    {
        return center;
    }

    public void setCenter(Point center)
    {
        this.center = center;
    }
}
