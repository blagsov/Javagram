import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;

public class SettingsProfileForm {

    private JButton hide;
    private JButton exit;
    private JTextField name;
    private JTextField surname;

    public JButton getBack() {
        return back;
    }

    private JButton back;
    private JButton save;
    private JButton exitSettings;
    private JPanel panelSettingsProfile;
    private JPanel windowProfile;
    private BufferedImage background;
    private MyFrame myFrame;

    public SettingsProfileForm() throws IOException {
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        surname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(1);
            }
        });
    }

    public JPanel getPanelSettingsProfile() {
        return panelSettingsProfile;
    }

    public JButton getHide() {
        return hide;
    }

    private void createUIComponents() {

        panelSettingsProfile = new JPanel();
        Color color = new Color(0, 0, 0, 194);
        panelSettingsProfile.setBackground(color);

        name = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 42, 150, 42);
            }
        };

        surname = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 42, 150, 42);
            }
        };
    }

    public void addActionListenerBackToMain(ActionListener actionListener) {
        back.addActionListener(actionListener);
    }
}
