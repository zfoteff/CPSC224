public class MVCTester
{
    public static void main(String[] args)
    {
        //  Swing - java GUI framework we will be using
        //  Other frameworks - JavaFX, AWT, Android, ...
        //  GUI - Guided User Interface

        //  Container: an object that stores other objects
        //  View: GUI components that is drawn on the screen

        //  In Swing there are three top level containers
        //      1) JFrame (ex. a window)
        //      2) JDialog (ex. little tiny pop up window)
        //      3) JApplet (ex. a window running in a web browser)

        //  2 Ways to make a JFrame
        //  1. Directly
        /*
        JFrame frame = new JFrame("My GUI Title");
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
        //  good to set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        */

        //  2. Subclass JFrame

        //  What is a design pattern?: A reusable solution to a common software engineering program
        //  MVC: Model View Controller
        //  model - data and the data logic of our app
        //      - "backend" of our app
        //      - EX. authentication system of a login app
        //  View - GUI for out app
        //      - "frontend" of our app
        //      - EX. what the user sees in our login app (JFrame)
        //  Controller - "glue" between model and view
        //      - handles view events
        //      - EX. the logic for what happens when a user presses login

        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
