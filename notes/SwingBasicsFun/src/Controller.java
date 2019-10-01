import javax.swing.*;
import java.awt.*;

public class Controller
{
    public static void main(String[] args)
    {
        //  Swing - java GUI framework we will be using

        JFrame frame = new JFrame("My GUI Title");
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
        //  good to set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
    }
}
