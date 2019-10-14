import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    private Controller controller;

    //  Making these fields protected allows you to access them in other files
    protected JTextField textField = new JTextField();
    protected JPasswordField passField = new JPasswordField();
    protected JButton loginButton = new JButton("Login");
    protected JLabel loginLabel = new JLabel("Login to continue");

    public View(Controller c)
    {
        super("My Login App");  // Accesses JFrame constructor
        this.controller = c;

        setupUI();
        pack();
    }

    public void setupUI()
    {
        setVisible(true);   // is a JFrame so don't need an identifier
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // y-axis lines everything in one
        // column

        //  All the vies in the single column (Y_AXIS) or single row (X_AXIS) have to have the same alignment

        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(loginLabel);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(textField);
        passField.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(passField);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(loginButton);

        getContentPane().add(contentPanel);
    }
}
