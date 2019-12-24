/**
 *   This file defines the MyShape class object that is used to make shapes permanent
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #6
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 11/21/2019
 */

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class MyShape
{
    private Shape shape;
    private String shapeType;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean filled;

    /**
     * EVC constructor for a new MyShape object
     *
     * @param paramShapeType String of one of the three different types of shapes
     * @param paramX1 int x1 coordinate
     * @param paramY1 int y1 coordinate
     * @param paramW int x2 coordinate
     * @param paramH int y2 coordinate
     * @param isFilled boolean indicating whether the shapes is filled or not
     */
    public MyShape(String paramShapeType, int paramX1, int paramY1, int paramW, int paramH, boolean isFilled)
    {
        this.x1 = paramX1;
        this.y1 = paramY1;
        this.x2 = paramW;
        this.y2 = paramH;
        this.shapeType = paramShapeType;
        this.filled = isFilled;

        if (shapeType.equals("line"))
            shape = new Line2D.Double(x1, y1, x2, y2);

        else if (shapeType.equals("rect"))
            shape = new Rectangle2D.Double(x1, y1, x2, y2);

        else if (shapeType.equals("ellipse"))
            shape = new Ellipse2D.Double(x1, y1, x2, y2);
    }

    /**
     * Method returns which shape the object contains
     *
     * @return String indicating which shape the object contains
     */
    public String getShapeType() { return shapeType; }

    /**
     * Method returns the x1 coordinate of the object
     *
     * @return int x1 coordinate
     */
    public int getX1() { return x1; }

    /**
     * Method returns the y1 coordinate of the object
     *
     * @return int y1 coordinate
     */
    public int getY1() { return y1; }

    /**
     * Method returns the x2 coordinate or the width component of the object
     *
     * @return int x2 coordinate or width component
     */
    public int getX2() { return x2; }

    /**
     * Method returns the y2 coordinate or the height component of the object
     *
     * @return int y2 coordinate or height component
     */
    public int getY2() { return y2; }

    /**
     * Method returns boolean indicating whether the shape is filled or not
     *
     * @return boolean indicating whether the object is filled or not
     */
    public boolean isFilled() { return filled; }

    /**
     * Method returns Shape the object represents
     *
     * @return Shape object the MyShape object contains
     */
    public Shape getShape() { return shape; }
}
