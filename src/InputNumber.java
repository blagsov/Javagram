import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class InputNumber extends JPanel {

    private JPanel rootPanel;
    private JButton NextFormButton;
    private JTextField phoneNumber;
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

    private TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 513573, "0f6da352025704385c3a257082bbd21c");

    public InputNumber() throws IOException {

        try {
            logo = ImageIO.read(new File("sources/GUI Components/logo.png"));
            background = ImageIO.read(new File("sources/fon-sova.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.exit(1);
            }
        });


        // bridge = new TelegramApiBridge("149.154.167.50:443", 513573, "0f6da352025704385c3a257082bbd21c");
        String number = phoneNumber.getText().trim();
        number = number.replaceAll("[^0-9]+", "");
        if (NUMBER.matcher(number).matches()) {
            AuthCheckedPhone checkedPhone = bridge.authCheckPhone(number);
            System.out.println(checkedPhone.isRegistered());
        }
        else Text.setText("Неправильно введен номер!");

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

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JButton getNextFormButton() {
        return NextFormButton;
    }

    public void setNextFormButton(JButton nextFormButton) {
        NextFormButton = nextFormButton;
    }

    public JTextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(JTextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JLabel getText() {
        return Text;
    }


    public JButton getExit() {
        return exit;
    }


    public JPanel getPanellogo() {
        return panellogo;
    }

    public void setPanellogo(JPanel panellogo) {
        this.panellogo = panellogo;
    }

    public JPanel getPanelNumberInput() {
        return panelNumberInput;
    }

    public void setPanelNumberInput(JPanel panelNumberInput) {
        this.panelNumberInput = panelNumberInput;
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }

    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    public InputCode getInputCode() {
        return inputCode;
    }

    public void setInputCode(InputCode inputCode) {
        this.inputCode = inputCode;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public InputNumber getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(InputNumber inputNumber) {
        this.inputNumber = inputNumber;
    }

    public TelegramApiBridge getBridge() {
        return bridge;
    }


}