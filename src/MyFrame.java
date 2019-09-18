import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/*
 * code written
 * by Zoya Klocheva
 */

class MyFrame extends JFrame {
    private MyFrame myFrame = this;
    private InputNumber inputNumber = new InputNumber();
    private InputCode inputCode = new InputCode();
    private ContactList contactList = new ContactList();
    private SettingsProfileForm settingsProfileForm = new SettingsProfileForm();
    private EditContact editContact = new EditContact();
    private AddContact addContact = new AddContact();
    private Registration registration = new Registration();

    {
        setContentPane(inputNumber.getRoolPanel());
        //setContentPane(registration.getPanelRegistration()); //для проверки, через кнопки выхода на эту панель нет

        inputNumber.addActionListenerForSwitchAction(e -> switchInputNumber());
        inputCode.addActionListenerForSwitchAction(e -> switchInputCode());
        contactList.addActionListenerForSettings(e -> toProfileSettings());
        contactList.addActionListenerForEditContact(e -> toEditContact());
        contactList.addActionListenerForAddContact(e -> toAddContact());
        settingsProfileForm.addActionListenerBackToMain(e -> returnContactList());
        addContact.addActionListenerBackToMain(e -> returnContactList());
        editContact.addActionListenerBackToMain(e -> returnContactList());

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK, false), "switchForms");

        getRootPane().getActionMap()
                .put("switchForms", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switchForm();
                    }
                });


        inputNumber.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(Frame.ICONIFIED);
            }
        });
        inputCode.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(Frame.ICONIFIED);
            }
        });
        contactList.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });

        settingsProfileForm.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        addContact.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        editContact.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        registration.getHide().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                myFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
    }

    public MyFrame() throws IOException {
    }

    protected void switchInputNumber() {
        setContentPanel(inputCode.getPanelCode());
    }

    protected void switchInputCode() {
        setContentPanel(contactList.getPanelContacts());
    }

    protected void toProfileSettings() {
        setContentPanel(settingsProfileForm.getPanelSettingsProfile());
    }

    protected void toEditContact() {
        setContentPanel(editContact.getPanelEditContact());
    }

    protected void toAddContact() {
        setContentPanel(addContact.getPanelAddContact());
    }

    protected void returnContactList() {
        setContentPanel(contactList.getPanelContacts());
    }


    protected void switchForm() {
        if (getContentPane() == inputNumber.getRoolPanel())
            switchInputNumber();
        else if (getContentPane() == inputCode.getPanelCode())
            switchInputCode();
        else if (contactList.settingIs())
            toProfileSettings();
        else if (contactList.editContactIs())
            toEditContact();
        else if (contactList.addContactIs())
            toAddContact();
        else if (getContentPane() == settingsProfileForm.getPanelSettingsProfile())
            returnContactList();
        else if (getContentPane() == addContact.getPanelAddContact())
            returnContactList();
        else if (getContentPane() == editContact.getPanelEditContact())
            returnContactList();
        else
            throw new IllegalStateException();
    }

    protected void setContentPanel(Container container) {
        setContentPane(container);
        getContentPane().revalidate();
        getContentPane().repaint();

    }

}
