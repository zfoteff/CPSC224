public class Point
{
    private int x;
    private int y;

    public Point()
    {
        x = 0;
        y = 0;
    }


    public Point(int paramX, int paramY)
    {
        x = paramX;
        y = paramY;
    }


    @Override
    public String toString()
    {
        return "("+this.x+", "+this.y+")";
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
