import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    int posX, posY;
    JLabel time;

    public MainFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 75);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBounds(0, 0, 150, 75);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                posX = mouseEvent.getX();
                posY = mouseEvent.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            int lastY;

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    if (lastY < e.getYOnScreen()) {
                        setSize(MainFrame.this.getWidth() - 1, MainFrame.this.getHeight() - 1);
                    } else {
                        setSize(MainFrame.this.getWidth() + 1, MainFrame.this.getHeight() + 1);
                    }
                    lastY = e.getYOnScreen();
                } else {
                    setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
                }
            }
        });
        time = new JLabel();
        TimeChange tc = time::setText;
        Time timeChange = new Time(tc);
        this.add(time);
        this.setVisible(true);
    }

    private void incFontSize() {
        time.setFont(new Font(Font.SERIF, Font.PLAIN, time.getFont().getSize() + 1));
    }

}
