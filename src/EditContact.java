import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditContact {
    private JTextField name;
    private JButton save;

    public JButton getBack() {
        return back;
    }
    private JButton back;
    private JButton del;
    private JPanel panelEditContact;

    public JButton getHide() {
        return hide;
    }

    private JButton hide;
    private JButton exit;
    private JPanel editNamePanel;

    public EditContact (){

        name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(1);
            }
        });
    }

    public JPanel getPanelEditContact() {
        return panelEditContact;
    }

    private void createUIComponents() {
        editNamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(0, 52, 250, 52);
            }
        };

        del = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.drawLine(0, 0, 165, 0);
                g.drawLine(0, 25, 165, 25);
                g.drawLine(165, 0, 165, 25);
                g.drawLine(0, 0, 0, 25);
            }
        };

        panelEditContact = new JPanel();
        Color color = new Color(0, 0, 0, 194);
        panelEditContact.setBackground(color);
    }
    public void addActionListenerBackToMain(ActionListener actionListener) {
        back.addActionListener(actionListener);
    }
}
