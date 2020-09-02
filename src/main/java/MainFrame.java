import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {
    int posX, posY;
    public MainFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(150, 75);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBounds(0,0,150,75);
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                posX = mouseEvent.getX();
                posY = mouseEvent.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                setLocation(e.getXOnScreen()-posX,e.getYOnScreen() - posY);
            }
        });
        JLabel time = new JLabel();
        TimeChange tc = time::setText;
        Time timeChange = new Time(tc);
        this.add(time);
        this.setVisible(true);
    }

}
