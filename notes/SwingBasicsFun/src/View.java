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

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // y-axis lines everything in one column

        JLabel loginLabel = new JLabel("Login to continue");
        JTextField textField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        contentPanel.add(loginLabel);
        contentPanel.add(textField);
        contentPanel.add(passField);
        contentPanel.add(loginButton);

        getContentPane().add(contentPanel);
        pack();

    }
}
