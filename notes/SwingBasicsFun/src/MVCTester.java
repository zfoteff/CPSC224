public class MVCTester {
    public static void main(String[] args) {
        // Swing - the Java GUI framework we are gonna use
        // GUI - graphical user interface

        // other GUI frameworks for Java... JavaFX, AWT, Android, ....
        // container: an object that stores other objects... (views)
        // view: GUI components that is drawn on the screen
        // in swing there are 3 top level containers
        // 1. JFrame (e.g. a window)
        // 2. JDialog (e.g. a small alert window)
        // 3. JApplet (e.g. a window running in a web browser)

        // 2 ways to create JFrame
        // 1. directly
//        JFrame frame = new JFrame("My GUI Title");
//        frame.setVisible(true);
//        frame.setPreferredSize(new Dimension(400, 400));
//        // good to set
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();

        // 2. subclass JFrame

        // What is a design pattern?
        // a reusable solution to a common software engineering problem
        // MVC - model view controller
        // model - data and the data logic of our app
        // - "backend" of our app
        // - e.g. authentication system of a login app
        // view - GUI for our app
        // - "frontend" of our app
        // e.g. what the user sees in our login app (JFrame)
        // controller - "glue" between the model and the view
        // e.g. the logic for what happens when the user presses login
        // controller handles view events

        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
