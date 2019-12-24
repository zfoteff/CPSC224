/**
 *   This file declares a View object that displays GUI elements and an instance of a GraphicsPanel to the user
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */

import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    private Controller controller;
    protected JLabel status = new JLabel("X: 0 Y: 0");
    protected JButton clear = new JButton("Clear");
    protected JButton quit = new JButton("Quit");
    protected JRadioButton line = new JRadioButton("Line");
    protected JRadioButton rect = new JRadioButton("Rectangle");
    protected JRadioButton ellipse = new JRadioButton("Ellipse");
    protected JCheckBox filled = new JCheckBox("Fill");
    protected ButtonGroup selectedShape = new ButtonGroup();
    protected GraphicsPanel graphicsPanel;

    /**
     * EVC for View object
     * @param controller Controller that can manipulate View elements
     */
    public View(Controller controller)
    {
        super("Canvas");
        this.controller = controller;

        setupUI();
    }

    /**
     * Method initializes and arranges GUI elements in the view
     */
    public void setupUI()
    {
        JPanel masterPanel = (JPanel) getContentPane();
        JPanel optionPanel = new JPanel();
        JPanel canvasOptions = new JPanel();
        JPanel shapeOptions = new JPanel();
        graphicsPanel = new GraphicsPanel(this);
        graphicsPanel.setPreferredSize(new Dimension(750, 500));

        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.setPreferredSize(new Dimension(750, 600));

        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.X_AXIS));
        optionPanel.setPreferredSize(new Dimension(750, 100));

        selectedShape.add(line);
        selectedShape.add(rect);
        selectedShape.add(ellipse);

        //  set up canvasOptions panel
        canvasOptions.setLayout(new BoxLayout(canvasOptions, BoxLayout.X_AXIS));
        canvasOptions.setPreferredSize(new Dimension(150, 100));
        canvasOptions.add(clear);
        canvasOptions.add(quit);
        canvasOptions.setBorder(BorderFactory.createTitledBorder("Canvas Options"));

        //  set up shape options panel
        shapeOptions.setLayout(new BoxLayout(shapeOptions, BoxLayout.X_AXIS));
        shapeOptions.setPreferredSize(new Dimension(300, 100));
        shapeOptions.add(line);
        shapeOptions.add(rect);
        shapeOptions.add(ellipse);
        shapeOptions.add(filled);
        shapeOptions.setBorder(BorderFactory.createTitledBorder("Shape Options"));

        optionPanel.add(canvasOptions);
        optionPanel.add(shapeOptions);

        masterPanel.add(optionPanel);
        masterPanel.add(graphicsPanel);
        masterPanel.add(status);

        setVisible(true);
        pack();
    }

}
