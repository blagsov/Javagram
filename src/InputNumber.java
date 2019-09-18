import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.UserContact;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class InputNumber extends JPanel {
    private JPanel rootPanel;
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
    private static final Pattern NUMBER = Pattern.compile("\\+?[1-9]+");

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 513573, "0f6da352025704385c3a257082bbd21c");
        String phoneNumber = reader.readLine().trim();
        phoneNumber = phoneNumber.replaceAll("[^0-9]+", "");
        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(phoneNumber);
        System.out.println(checkedPhone.isRegistered());

        AuthSentCode sentCode = bridge.authSendCode(phoneNumber);

    }

    public JButton getHide() {
        return hide;
    }

    public JPanel getRootPanel() {
        return rootPanel;
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
        rootPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

    }

    public void addActionListenerForSwitchAction(ActionListener actionListener) throws IOException {

        NextFormButton.addActionListener(actionListener);
    }

}