import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
    //  Has reference to view and model so they can be directly manipulated
    private Model model;
    private View view;

    public Controller(Model m)
    {
        this.model = m;
        this.view = new View(this);

        /*  When we hit login, we want the program to
            1)  grab username and password
            2)  authenticate user with model
            3)  update the status label
        */

        /*  Event listening
         Callbacks:
          - Uses action listeners (interface)
              + button.addActionListener(this): that reference is stored in list of references
              + reference.actionPerformed(ActionEvent e)   : returns action from list of references (callback)
                                                             And executes commands associated with that action
          - Any object that uses an action listener has to override actionPerformed
        */

        //  2 ways to implement action listener
        //  1) Have controller do it
        //  override actionPerformed and register this instance of Controller as the callback of the object
        //  view.loginButton.addActionListener(this);

        //  2) Define a new class (outer or nested) that implements action listener
        //  create an object of the class and register
        //  anonymous class: lets you define class, and instantiate it, and register it as listener in one go

        view.loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton button = (JButton) e.getSource();
                System.out.println(button.getText());

                String username = Controller.this.view.textField.getText(); // this works differently with anon classes
                String password = new String(view.passField.getPassword());

                boolean passwordCheck = m.authenticate(username, password);

                if (passwordCheck)
                    view.loginLabel.setText("Welcome, "+ username);

                else
                    view.loginLabel.setText("Login incorrect");
            }
        });



    }

    /*  Overriding for option 1
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
    }
    */
}

