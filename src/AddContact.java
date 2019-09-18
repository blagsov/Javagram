import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddContact {

    private JButton hide;
    private JButton exit;
    private JTextField name;
    private JTextField surname;

    public JButton getBack() {
        return back;
    }

    private JButton back;
    private JButton add;
    private JTextField number;
    private JPanel panelAddContact;
    private JPanel numberPanel;
    private ContactList contactList;

    public AddContact() {
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        surname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        number.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(1);
            }
        });
    }

    public JPanel getPanelAddContact() {
        return panelAddContact;
    }

    public JButton getHide() {
        return hide;
    }

    private void createUIComponents() {
        panelAddContact = new JPanel();
        Color color = new Color(0, 0, 0, 194);
        panelAddContact.setBackground(color);

        numberPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 42, 252, 42);
            }
        };
        name = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 42, 250, 42);
            }
        };
        surname = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 42, 250, 42);
            }
        };
    }

    public void addActionListenerBackToMain(ActionListener actionListener) {
        back.addActionListener(actionListener);
    }
}
