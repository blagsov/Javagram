import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ContactList extends JPanel {


    private JPanel panelContacts;
    private JButton hide;
    private JButton exit;
    private JTextField textSearch;
    private ActionListener actionListener;

    public JButton getSetting() {
        return setting;
    }

    private JButton setting;
    private JTextField textLetter;
    private JButton contact1Button;
    private JButton contact4Button;
    private JButton contact3Button;
    private JButton contact2Button;
    private JButton Send;
    private BufferedImage background;
    private JLabel maskBlue;
    private JLabel logo;
    private JPanel contacts;
    private JButton newContact;
    private JButton editContact;
    private JPanel activChat;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private MyFrame myFrame;
    //private ContactList contactList;

    public SettingsProfileForm getSettingsProfileForm() {
        return settingsProfileForm;
    }

    private SettingsProfileForm settingsProfileForm = new SettingsProfileForm();

    public AddContact getAddContact() {
        return addContact;
    }

    private AddContact addContact;


    public JPanel getPanelContacts() {
        return panelContacts;
    }

    public JButton getHide() {
        return hide;
    }

    public JButton getExit() {
        return exit;
    }


    public ContactList() throws IOException {

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(1);
            }
        });

        textLetter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    public boolean addActionListenerForSettings(ActionListener actionListener) {
        setting.addActionListener(actionListener);
        return false;
    }

    public boolean addActionListenerForEditContact(ActionListener actionListener) {
        editContact.addActionListener(actionListener);
        return false;
    }

    public boolean addActionListenerForAddContact(ActionListener actionListener) {
        newContact.addActionListener(actionListener);
        return false;
    }

    public boolean settingIs() {
        return addActionListenerForSettings(actionListener);
    }

    public boolean editContactIs() {
        return addActionListenerForEditContact(actionListener);
    }

    public boolean addContactIs() {
        return addActionListenerForAddContact(actionListener);
    }


    private void createUIComponents() {
        activChat = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 179, 230));
                g.drawLine(148, 0, 148, 45);
                g.drawLine(147, 0, 147, 45);
                g.drawLine(146, 0, 146, 45);

                g.setColor(new Color(156, 156, 156));
                g.drawLine(0, 0, 150, 0);
            }
        };
        panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(156, 156, 156));
                g.drawLine(0, 0, 150, 0);
                g.drawLine(0, 40, 150, 40);
                g.drawLine(149, 0, 149, 45);
            }
        };
        panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(156, 156, 156));
                g.drawLine(0, 0, 150, 0);
                g.drawLine(149, 0, 149, 45);
            }
        };
        panel3 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(156, 156, 156));
                g.drawLine(0, 0, 150, 0);
                g.drawLine(0, 45, 150, 45);
                g.drawLine(149, 0, 149, 45);
            }
        };

    }
}


