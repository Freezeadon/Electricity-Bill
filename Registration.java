import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Could you not just go import javax.swing.*; to import all?

public class Registration extends JFrame implements ActionListener  {

   private JLabel regLabel1, regLabel2, regLabel3;
    private JTextField regUsername;
    private JPasswordField regPassword, confirmPasswordField;
    private JButton registerButton, showPasswordButton;
    private JPanel regPanel;
    private HashMap<String, String> userCredentials;

    Registration(HashMap<String, String> userCredentials){
        super("Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.userCredentials = userCredentials;

        regLabel1 = new JLabel("New User Name");
        regLabel2 = new JLabel("New Password");
        regLabel3 = new JLabel("Confirm Passowrd");
        regUsername = new JTextField(10);
        regPassword = new JPasswordField(10);
        confirmPasswordField = new JPasswordField(10);
        registerButton = new JButton("Register");
        showPasswordButton = new JButton("Show Password");

        registerButton.addActionListener(this);
        showPasswordButton.addActionListener(this);

        regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(4,2));
        regPanel.add(regLabel1);
        regPanel.add(regUsername);
        regPanel.add(regLabel2);
        regPanel.add(regPassword);
        regPanel.add(regLabel3);
        regPanel.add(confirmPasswordField);
        regPanel.add(registerButton);
        regPanel.add(showPasswordButton);

        add(regPanel);

        setSize(500, 400);
        setLocation(600, 400);
        setVisible(true);
    }



   @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {
            String newUsername = regUsername.getText();
            String newPass = new String(regPassword.getPassword());
            String confirmPass = new String(confirmPasswordField.getPassword());

            if (newUsername.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a username.");
            } else if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            } else if (!userCredentials.containsKey(newUsername)) {
                userCredentials.put(newUsername, newPass);
                JOptionPane.showMessageDialog(this, "Registration Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists");
            }
        } else if (e.getSource() == showPasswordButton) {
            if (showPasswordButton.getText().equals("Show Password")) {
                regPassword.setEchoChar((char) 0);
                confirmPasswordField.setEchoChar((char) 0);
                showPasswordButton.setText("Hide Password");
            } else {
                regPassword.setEchoChar('\u2022');
                confirmPasswordField.setEchoChar('\u2022');
                showPasswordButton.setText("Show Password");
            }
        }

    }
    
}
