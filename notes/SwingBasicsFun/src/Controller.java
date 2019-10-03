import javax.swing.*;
import java.awt.*;

public class Controller
{
    //  Has reference to view and model so they can be directly manipulated
    private Model model;
    private View view;

    public Controller(Model m)
    {
        this.model = m;
        this.view = new View(this);
    }
}

