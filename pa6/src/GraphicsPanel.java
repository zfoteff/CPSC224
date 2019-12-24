/**
 *   This file defines a new GraphicPanel object which allows the user to draw shapes and store them in the database
 *   The object extends JPanel which allows us to call paintComponent() for drawing shapes on the screen
 *   The database allows us to store the draw shapes, then redraw them every time repaint() is called
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #6
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 11/21/2019
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel
{
    protected View targetView;
    protected Point start;
    protected Point end;
    public boolean isLine;
    public boolean isRect;
    public boolean isEllipse;
    public boolean isFilled;
    public boolean stillDrawing;
    private String shapeType;
    private ArrayList<MyShape> shapeList;
    public ContactDatabaseHelper helper;

    /**
     * EVC for a new Graphics panel
     *
     * @param view View parent view the panel is a part of
     */
    public GraphicsPanel(View view)
    {
        targetView = view;
        isLine = false;
        isRect = false;
        isEllipse = false;
        isFilled = false;
        stillDrawing = false;
        shapeType = "";
        helper = new ContactDatabaseHelper();
        shapeList = new ArrayList<>();
        setBackground(Color.WHITE);
    }

    /**
     * This method allows the user to use their mouse and draw shapes and have them be displayed on the screen
     * The shapes are stored and accessed from a database after the user has drawn them, but can be cleared later
     *
     * @param g Graphics object
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);

        if (shapeList.isEmpty())
        {
            System.out.println("shapeList is empty");
        }

        shapeList = helper.getAllShapes();

        if (!shapeList.isEmpty())
        {
            for (MyShape shape : shapeList)
            {
                if (shape.isFilled())
                    g2.fill(shape.getShape());

                else
                    g2.draw(shape.getShape());
            }
        }


        if (start != null)
        {
            int x = start.x;
            int y = start.y;
            int w = Math.abs(start.x - end.x);
            int h = Math.abs(start.y - end.y);

            if (isLine)
            {
                Line2D.Double line = new Line2D.Double(x, y, end.x, end.y);
                shapeType = "line";
                g2.draw(line);
            }

            else if (isRect)
            {
                Rectangle2D.Double rect = new Rectangle2D.Double(x, y, w, h);
                shapeType = "rect";
                if (isFilled)
                    g2.fill(rect);
                else
                    g2. draw(rect);
            }

            else if (isEllipse)
            {
                Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, w, h);
                shapeType = "ellipse";
                if (isFilled)
                    g2.fill(ellipse);
                else
                    g2.draw(ellipse);
            }
        }

    }

    /**
     * Method defines a new MyShape object from the user drawn object and adds it to the database for persistence
     */
    public void addShape()
    {
        MyShape newShape;

        if (shapeType.equals("line"))
            newShape = new MyShape(shapeType, start.x, start.y, end.x, end.y, isFilled);
        else
            newShape = new MyShape(shapeType, start.x, start.y, Math.abs(start.x - end.x), Math.abs(start.y - end.y),
                    isFilled);

        helper.insertShape(newShape);
    }

    /**
     * Method closes connection between the database and the GraphicsPanel
     *
     */
    public void close() { helper.closeConnection(); }

    /**
     * Method clears all shapes from the GraphicsPanel and from the database
     */
    public void clearShapes()
    {
        helper.clearAllShapes();
        repaint();
    }
}
