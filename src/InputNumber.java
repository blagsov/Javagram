import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class InputNumber extends JPanel {
    private JPanel roolPanel;
    private JButton NextFormButton;
    private JTextField telephonNumber;
    private JLabel Text;
    private JButton exit;
    private JPanel panellogo;
    private JButton hide;
    private JPanel panelNumberInput;
    private BufferedImage logo;
    private BufferedImage background;
    private InputCode inputCode;
    private MyFrame myFrame;
    private InputNumber inputNumber;

    public InputNumber() throws IOException {

        try {
            logo = ImageIO.read(new File("sources/GUI Components/logo.png"));
            background = ImageIO.read(new File("sources/fon-sova.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        telephonNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(1);
            }
        });
    }
    public JButton getHide() {
        return hide;
    }

    public JPanel getRoolPanel() {
        return roolPanel;
    }


    private void createUIComponents() throws IOException {
        panellogo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 0, null);
            }
        };

        panelNumberInput = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 39, 315, 39);
            }
        };
        roolPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

    }

    public void addActionListenerForSwitchAction(ActionListener actionListener) {
        NextFormButton.addActionListener(actionListener);
    }

}