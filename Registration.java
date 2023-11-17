import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Registration extends JFrame implements ActionListener {

    private JLabel regLabel1, regLabel2, regLabel3, regLabel4, regLabel5, regLabel6, regLabel7, regLabel8;
    private JTextField regUsername, firstNameField, lastNameField, addressField, postalCodeField, phoneNumberField;
    private JPasswordField regPassword, confirmPasswordField;
    private JButton registerButton, showPasswordButton;
    private JPanel regPanel;
    private Main loginPage; // instance of the login page to go back to after registering

    Registration(Main loginPage) {
        super("Registration");
        this.loginPage = loginPage;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        regLabel1 = new JLabel("New User Name");
        regLabel2 = new JLabel("New Password");
        regLabel3 = new JLabel("Confirm Password");
        regLabel4 = new JLabel("First Name");
        regLabel5 = new JLabel("Last Name");
        regLabel6 = new JLabel("Address");
        regLabel7 = new JLabel("Postal Code");
        regLabel8 = new JLabel("Phone Number");

        regUsername = new JTextField(10);
        regPassword = new JPasswordField(10);
        confirmPasswordField = new JPasswordField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        addressField = new JTextField(10);
        postalCodeField = new JTextField(10);
        phoneNumberField = new JTextField(10);

        registerButton = new JButton("Register");
        showPasswordButton = new JButton("Show Password");

        registerButton.addActionListener(this);
        showPasswordButton.addActionListener(this);

        regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(9, 2));
        regPanel.add(regLabel1);
        regPanel.add(regUsername);
        regPanel.add(regLabel2);
        regPanel.add(regPassword);
        regPanel.add(regLabel3);
        regPanel.add(confirmPasswordField);
        regPanel.add(regLabel4);
        regPanel.add(firstNameField);
        regPanel.add(regLabel5);
        regPanel.add(lastNameField);
        regPanel.add(regLabel6);
        regPanel.add(addressField);
        regPanel.add(regLabel7);
        regPanel.add(postalCodeField); 
        regPanel.add(regLabel8);
        regPanel.add(phoneNumberField);
        regPanel.add(registerButton);
        regPanel.add(showPasswordButton);

        add(regPanel);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //method to check if username already exists in the database
    private boolean usernameVerify(String usernameCheck) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 2) {
                    String storedUsername = userData[1].trim();
                    if (storedUsername.equalsIgnoreCase(usernameCheck)) {
                        return true; // if true username exists
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // if false username does not exist
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String newUsername = regUsername.getText();
            String newPass = new String(regPassword.getPassword());
            String confirmPass = new String(confirmPasswordField.getPassword());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String phoneNumber = phoneNumberField.getText();

            if (usernameVerify(newUsername)) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
            } else if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            } else {
                // Generate a unique customer ID and store it in the CSV file
                int randomCustomerId = generateRandomCustomerId();
                writeUserDataToCSV(randomCustomerId, newUsername, newPass, firstName, lastName, address, postalCode, phoneNumber);

                JOptionPane.showMessageDialog(this, "Registration Successful");
                this.dispose();
                //return to login page
                loginPage.setVisible(true);
            }
        } else if (e.getSource() == showPasswordButton) {
            //logic to show password
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

    private int generateRandomCustomerId() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Generate a random 5-digit customer ID
    }

    //writing to CSV file
    private void writeUserDataToCSV(int customerId, String username, String password, String firstName, String lastName, String address,
            String postalCode, String phoneNumber) {
        try (FileWriter fileWriter = new FileWriter("user_data.csv", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            // add user data to the CSV file
            printWriter.println(customerId + "," + username + "," + password + "," +
                    firstName + "," + lastName + "," + address + "," +
                    postalCode + "," + phoneNumber);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
