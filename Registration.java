import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Registration extends JFrame implements ActionListener {

    private JLabel regLabel0, regLabel1, regLabel2, regLabel3, regLabel4, regLabel5, regLabel6, regLabel7, regLabel8,regLabel9;
    private JTextField regUsername, firstNameField, lastNameField, addressField, postalCodeField, phoneNumberField, regEmail;
    private JPasswordField regPassword, confirmPasswordField;
    private JButton registerButton, showPasswordButton, backButton;
    private JPanel regPanel;
    private Main loginPage; // instance of the login page to go back to after registering
    private JComboBox<String> plans;

    Registration(Main loginPage) {
        super("Registration");
        this.loginPage = loginPage;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        regLabel0 = new JLabel("Email Address");
        regLabel1 = new JLabel("New User Name");
        regLabel2 = new JLabel("New Password");
        regLabel3 = new JLabel("Confirm Password");
        regLabel4 = new JLabel("First Name");
        regLabel5 = new JLabel("Last Name");
        regLabel6 = new JLabel("Address");
        regLabel7 = new JLabel("Postal Code");
        regLabel8 = new JLabel("Phone Number");
        regLabel9 = new JLabel("Membership Option");

        regEmail = new JTextField(10);
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
        backButton = new JButton("Back");

        // font for labels
        Font newLabelFont = new Font("SansSerif", Font.BOLD, 15);
        regLabel0.setFont(newLabelFont);
        regLabel1.setFont(newLabelFont);
        regLabel2.setFont(newLabelFont);
        regLabel3.setFont(newLabelFont);
        regLabel4.setFont(newLabelFont);
        regLabel5.setFont(newLabelFont);
        regLabel6.setFont(newLabelFont);
        regLabel7.setFont(newLabelFont);
        regLabel8.setFont(newLabelFont);
        regLabel9.setFont(newLabelFont);

        String[] options = { "Bronze", "Silver", "Gold" };
        plans = new JComboBox<>(options);

        // font for textfields
        Font newFieldFont = new Font("SansSerif", Font.PLAIN, 14);
        regEmail.setFont(newFieldFont);
        regUsername.setFont(newFieldFont);
        regPassword.setFont(newFieldFont);
        confirmPasswordField.setFont(newFieldFont);
        firstNameField.setFont(newFieldFont);
        lastNameField.setFont(newFieldFont);
        addressField.setFont(newFieldFont);
        postalCodeField.setFont(newFieldFont);
        phoneNumberField.setFont(newFieldFont);
        plans.setFont(newFieldFont);

        // font for buttons
        Font newButtonFont = new Font("SansSerif", Font.BOLD, 15);
        registerButton.setFont(newButtonFont);
        showPasswordButton.setFont(newButtonFont);
        backButton.setFont(newButtonFont);

        registerButton.addActionListener(this);
        showPasswordButton.addActionListener(this);
        backButton.addActionListener(this);
        plans.setSelectedIndex(0);

        regPanel = new JPanel();
        regPanel.setLayout(null);
        regPanel.setBackground(Color.PINK); // set background color to pink

        // Auto sets x and y for all labels and text fields, gap is used as something
        // that will be added to y to make a gap for the next set of labels and text
        // fields
        int labelX = 130; // x value fo regLabels
        int textFieldX = 300; // x value for textfields
        int textFieldWidth = 200; // width value for text fields
        int y = 50; // y value for both regLabels and textfields
        int gap = 30;

        regLabel0.setBounds(labelX, y, 150, 30);
        regEmail.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap; // changes y value onwards

        regLabel1.setBounds(labelX, y, 150, 30);
        regUsername.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel2.setBounds(labelX, y, 150, 30);
        regPassword.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel3.setBounds(labelX, y, 150, 30);
        confirmPasswordField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel4.setBounds(labelX, y, 150, 30);
        firstNameField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel5.setBounds(labelX, y, 150, 30);
        lastNameField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel6.setBounds(labelX, y, 150, 30);
        addressField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel7.setBounds(labelX, y, 150, 30);
        postalCodeField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel8.setBounds(labelX, y, 150, 30);
        phoneNumberField.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap;

        regLabel9.setBounds(labelX, y, 150, 30);
        plans = new JComboBox<>(new String[] { "Bronze", "Silver", "Gold" });
        plans.setFont(newFieldFont);
        plans.setBounds(textFieldX, y, textFieldWidth, 30);
        y += gap * 1.5;

        registerButton.setBounds(130, y, 150, 30);
        showPasswordButton.setBounds(300, y, 200, 30);

        backButton.setBounds(250, y + 40, 100, 30);

        regPanel.add(regLabel0);
        regPanel.add(regEmail);
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
        regPanel.add(regLabel9);
        regPanel.add(plans);
        regPanel.add(registerButton);
        regPanel.add(showPasswordButton);
        regPanel.add(backButton);

        add(regPanel);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // method to check if username already exists in the database
    private boolean usernameVerify(String usernameCheck) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 2) {
                    String storedUsername = userData[1].trim();
                    if (storedUsername.equalsIgnoreCase(usernameCheck)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // method to check if email already exists in the database
    private boolean emailVerify(String emailCheck) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 9) {
                    String storedEmail = userData[8].trim();
                    if (storedEmail.equalsIgnoreCase(emailCheck)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int generateRandomCustomerId() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Generate a random 5-digit customer ID
    }

    // writing to CSV file
    private void writeUserDataToCSV(int customerId, String username, String password, String firstName, String lastName,
            String address, String postalCode, String phoneNumber, String emailAddress, String plan,
            int offPeakTime, int midPeakTime, int onPeakTime) {
        try (FileWriter fileWriter = new FileWriter("user_data.csv", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            // Add user data and random times to the CSV file
            printWriter.println(customerId + "," + username + "," + password + "," +
                    firstName + "," + lastName + "," + address + "," +
                    postalCode + "," + phoneNumber + "," + emailAddress + "," + plan + "," +
                    offPeakTime + "," + midPeakTime + "," + onPeakTime);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int hoursUsed() {
        return new Random().nextInt(1001); // Generates a random number between 0 (inclusive) and 1000 (exclusive)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            if (regEmail.getText().isEmpty() || regUsername.getText().isEmpty() ||
                    new String(regPassword.getPassword()).isEmpty() ||
                    new String(confirmPasswordField.getPassword()).isEmpty() ||
                    firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                    addressField.getText().isEmpty() || postalCodeField.getText().isEmpty() ||
                    phoneNumberField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                return; // Exit the method if any field is empty
            }
            String emailAddress = regEmail.getText();
            String newUsername = regUsername.getText();
            String newPass = new String(regPassword.getPassword());
            String confirmPass = new String(confirmPasswordField.getPassword());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String phoneNumber = phoneNumberField.getText();
            String options = (String) plans.getSelectedItem();

            if (usernameVerify(newUsername)) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
            } else if (emailVerify(emailAddress)) {
                JOptionPane.showMessageDialog(this,
                        "Email is associated with another user. Please choose a different email.");
            } else if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            } else {
                // Generate a unique customer ID and store it in the CSV file
                int randomCustomerId = generateRandomCustomerId();
                int offPeakTime = hoursUsed();
                int midPeakTime = hoursUsed();
                int onPeakTime = hoursUsed();
                writeUserDataToCSV(randomCustomerId, newUsername, newPass, firstName, lastName,
                        address, postalCode, phoneNumber, emailAddress, options,
                        offPeakTime, midPeakTime, onPeakTime);
                JOptionPane.showMessageDialog(this, "Registration Successful");
                this.dispose();
                // return to login page
                loginPage.setVisible(true);
            }

        } else if (e.getSource() == showPasswordButton) {
            // logic to show password
            if (showPasswordButton.getText().equals("Show Password")) {
                regPassword.setEchoChar((char) 0);
                confirmPasswordField.setEchoChar((char) 0);
                showPasswordButton.setText("Hide Password");
            } else {
                regPassword.setEchoChar('\u2022');
                confirmPasswordField.setEchoChar('\u2022');
                showPasswordButton.setText("Show Password");
            }

        } else if (e.getSource() == backButton) {
            // Dispose of the current registration frame
            dispose();
            // Make the login page visible
            loginPage.setVisible(true);
        }
    }

}
