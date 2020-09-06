import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        this.setMinimumSize(new Dimension(50, 50));
        this.addMouseListener(new MouseAdapter() {
            final PopUp menu = new PopUp();

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
                if (e.isPopupTrigger()) {
                    popUp(e);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUp(e);
                }
            }

            public void popUp(MouseEvent e) {
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    int width = e.getX();
                    int height = e.getY();
                    setSize(width, height);
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

    private class PopUp extends JPopupMenu {
        JMenuItem quit;

        public PopUp() {
            quit = new JMenuItem(new AbstractAction("Quit") {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    MainFrame.this.dispose();
                    System.exit(0);
                }
            });
            this.add(quit);
        }
    }
}