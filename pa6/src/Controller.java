/**
 *   This file creates the controller of the program, which handles the behavior of all buttons and facilitates
 *   connections to the database
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #6
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 11/21/2019
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

public class Controller
{
    protected Model model;
    protected View view;

    /**
     * DVC constructor for the controller class, creates all action listeners and mouse listeners for the program
     */
    public Controller()
    {
        view = new View(this);

        view.clear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear?");

                if (confirm == YES_OPTION)
                {
                    view.graphicsPanel.clearShapes();
                    view.graphicsPanel.repaint();
                }
            }
        });

        view.quit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               save();
            }
        });

        view.graphicsPanel.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                return;
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if (view.line.isSelected())
                {
                    view.graphicsPanel.isLine = true;
                    view.graphicsPanel.isRect = false;
                    view.graphicsPanel.isEllipse = false;
                    if (view.filled.isSelected())
                        view.graphicsPanel.isFilled = true;
                    else
                        view.graphicsPanel.isFilled = false;
                }

                else if (view.rect.isSelected())
                {
                    view.graphicsPanel.isLine = false;
                    view.graphicsPanel.isRect = true;
                    view.graphicsPanel.isEllipse = false;
                    if (view.filled.isSelected())
                        view.graphicsPanel.isFilled = true;
                    else
                        view.graphicsPanel.isFilled = false;
                }

                else if (view.ellipse.isSelected())
                {
                    view.graphicsPanel.isLine = false;
                    view.graphicsPanel.isRect = false;
                    view.graphicsPanel.isEllipse = true;
                    if (view.filled.isSelected())
                        view.graphicsPanel.isFilled = true;
                    else
                        view.graphicsPanel.isFilled = false;
                }

                view.graphicsPanel.start = e.getPoint();
                view.graphicsPanel.end = null;
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                view.graphicsPanel.end = e.getPoint();
                view.graphicsPanel.stillDrawing = false;
                view.graphicsPanel.addShape();
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent)
            {
                return;
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent)
            {
               return;
            }
        });

        view.graphicsPanel.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                view.graphicsPanel.stillDrawing = true;
                view.graphicsPanel.end = e.getPoint();
                view.graphicsPanel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                Point cur = e.getPoint();
                view.status.setText("X: " + cur.getX() + "Y: "+cur.getY());
            }
        });

        view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        view.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);

                save();
            }
        });
    }

    /**
     * Helper function that prompts the user to save their drawings and exit the program afterwards
     */
    public void save()
    {
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to save",
                "Save?", JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice == CANCEL_OPTION)
            return;

            //  close program
        else if (choice == YES_OPTION)
        {
            view.graphicsPanel.close();
            System.exit(0);
        }

        //  close program and clear all shapes
        else if (choice == NO_OPTION)
        {
            view.graphicsPanel.clearShapes();
            view.graphicsPanel.close();
            System.exit(0);
        }
    }

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Controller c = new Controller();
    }
}
