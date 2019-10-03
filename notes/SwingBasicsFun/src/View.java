import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    private Controller controller;

    public View(Controller c)
    {
        super("My Login App");  // Accesses JFrame constructor
        this.controller = c;

        setupUI();
    }

    public void setupUI()
    {
        setVisible(true);   // is a JFrame so dont need an identifier
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}
