import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 150);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setUndecorated(true);
        this.setVisible(true);
    }
}
