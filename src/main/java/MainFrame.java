import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 75);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        JLabel time = new JLabel();
        TimeChange tc = time::setText;
        Time timeChange = new Time(tc);

        this.add(time);
        this.setVisible(true);
    }
}
