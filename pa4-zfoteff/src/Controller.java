import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
