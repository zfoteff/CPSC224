import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    protected JTextField usernameTextField;
    protected JPasswordField passwordField;
    protected JButton loginButton;
    protected JLabel statusLabel;

    public View(Controller controller) {
        super("My Login App");
        this.controller = controller;

        setupUI();
    }

    private void setupUI() {
        setVisible(true);
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(); // light weight container
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // all views in the single column (Y_AXIS) or single row (X_AXIS)
        // have to have the same alignment


        JLabel loginLabel = new JLabel("Login to Continue");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(loginLabel);

        usernameTextField = new JTextField();
        usernameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(usernameTextField);

        passwordField = new JPasswordField();
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(loginButton);

        statusLabel = new JLabel(" ");
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(statusLabel);

        getContentPane().add(contentPanel);

        pack();
    }

}
