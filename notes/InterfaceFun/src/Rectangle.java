public class Rectangle extends Object implements Shape
{
    protected double width;
    protected double height;

    //  DVC
    public Rectangle()
    {
        width = 0.0;
        height = 0.0;
    }

    //  EVC
    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    @Override
    public double computePerimeter()
    {
        return width*2 + height*2;
    }

    @Override
    public double computeArea()
    {
        return width*height;
    }

    @Override
    public String toString()
    {
        return "Rectangle{"+
                "width="+width+
                ", height="+height+
                "}";
    }
}
