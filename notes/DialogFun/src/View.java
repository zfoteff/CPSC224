import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    private Controller c;

    protected JLabel description = new JLabel("Please enter an integer");
    protected JButton send = new JButton("Done");
    protected JTextField userEntry = new JTextField();
    protected JLabel status = new JLabel(" ");


    public View(Controller c)
    {
        super("Dialog Fun");
        this.c = c;

        setupUI();
        pack();

        send.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = userEntry.getText();

                try {
                    int value = Integer.parseInt(text);
                    status.setText("Squared: "+(value*value));

                    // JDialog - mini JFrame that pops up and waits for user interaction

                } catch (NumberFormatException ex) {
                    status.setText("Not an integer");

                    int choice = JOptionPane.showConfirmDialog(View.this,
                            "Not an integer. Try again?", "Invalid input",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null);

                    if (choice == JOptionPane.NO_OPTION) // 1
                        System.exit(0);
                }
            }
        });
    }

    private void setupUI()
    {
        setVisible(true);
        setSize(new Dimension(250, 100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(description);
        send.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(send);
        userEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(userEntry);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(status);

        getContentPane().add(content);
    }
}
