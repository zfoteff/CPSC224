import java.util.Scanner;
import javax.swing.*;

public class Controller
{
    private Model model;
    private View view;

    public Controller(Model m)
    {
        this.model = m;
        this.view = new View(this);
    }
}
