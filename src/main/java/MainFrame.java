import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 150);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setUndecorated(true);
        JLabel time = new JLabel();
        TimeChange tc = time::setText;
        Time timeChange = new Time(tc);
        this.add(time);
        this.setVisible(true);
        timeChange.sendTime();
    }
}
