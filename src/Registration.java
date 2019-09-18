import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Registration extends JPanel {
    public JButton getHide() {
        return hide;
    }

    private JButton hide;
    private JButton exit;
    private JPanel panellogo;
    private JTextField surname;
    private JTextField nameT;
    private JButton nextForm;

    public JPanel getPanelRegistration() {
        return panelRegistration;
    }

    private JPanel panelRegistration;
    private BufferedImage background;
    private BufferedImage logo;

    public Registration() throws IOException {
        surname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nameT.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        background = ImageIO.read(new File("sources/fon-sova.jpg"));
        logo = ImageIO.read(new File("sources/GUI Components/logo-mini.png"));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(1);
            }
        });
    }

    private void createUIComponents() {
        panelRegistration = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

        panellogo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 0, null);
            }
        };

        nameT = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 39, 200, 39);
            }
        };
        surname = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 40, 200, 40);
            }
        };

    }
}