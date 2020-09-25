import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyChar()){
                    case '+':
                        modFont(1);
                        break;
                    case '-':
                        modFont(-1);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {}
        });
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

    public void modFont(int delta) {
        Font font = time.getFont();
        delta = (font.getSize() + delta > 0) ? font.getSize() + delta : 1;
        time.setFont(new Font(font.getName(), Font.PLAIN, delta));
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