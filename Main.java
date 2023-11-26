import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends GUI implements ActionListener {

    private JTextField username;
    private JPasswordField password;
    private  JButton login;
    private  JButton quit;
    private  JButton admin;
    private  JButton signup;

    Main() {
        super("Zeus Utilities");
        setLayout(null);
        initializeComponents();
        setSize(1000,1000);
        setLocationRelativeTo(null);
    }
    @Override
    protected void initializeComponents() {
        JLabel user = new JLabel("Username");
        user.setBounds(550, 320, 100, 20);
        user.setFont(new Font("New Times Roman", Font.BOLD, 20));
        add(user);

        username = new JTextField();
        username.setBounds(650, 320, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(550, 360, 100, 20);
        pass.setFont(new Font("New Times Roman", Font.BOLD, 20));
        add(pass);

        password = new JPasswordField();
        password.setBounds(650, 360, 150, 30);
        add(password);
        ImageIcon icon1 = new ImageIcon("src/login.png"); // getting image
        Image image1 = icon1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // scaling the image
        login = new JButton("Login", new ImageIcon(image1)); // adding image and text on button
        login.setBounds(650, 450, 150, 75);
        login.addActionListener(this);
        login.setBackground(Color.lightGray);
        add(login);

        ImageIcon icon2 = new ImageIcon("src/cancel.png");
        Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        quit = new JButton("Quit", new ImageIcon(image2));
        quit.setBounds(650, 650, 150, 75);
        quit.addActionListener(this);
        quit.setBackground(Color.lightGray);
        add(quit);

        ImageIcon icon3 = new ImageIcon("src/admin.png");
        Image image3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        admin = new JButton("Admin Login", new ImageIcon(image3));
        admin.setBounds(850, 550, 150, 75);
        admin.addActionListener(this);
        admin.setBackground(Color.lightGray);
        add(admin);

        ImageIcon icon4 = new ImageIcon("src/newuser.png");
        Image image4 = icon4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        signup = new JButton("New User", new ImageIcon(image4));
        signup.setBounds(450, 550, 150, 75);
        signup.addActionListener(this);
        signup.setBackground(Color.lightGray);
        add(signup);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Electronic.png"));
        Image i = i1.getImage().getScaledInstance(160, 150, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(600, 70, 250, 250);
        add(image);
    }

    // method to verify user exists in database
    private String[] userVerify(String userName, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 8) {
                    String storedUserName = userData[1].trim();
                    String storedPassword = userData[2].trim();

                    if (storedUserName.toLowerCase().equals(userName.toLowerCase())
                            && storedPassword.equals(password)) {
                        System.out.println("Authentication successful");
                        return userData; // return user data if authentication is successful
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Authentication failed");
        return null; // return null if authentication fails
    }

    // Helper method to calculate total charged based on plan
    private float calculateTotalCharged(String plan, int offPeakTime, int midPeakTime, int onPeakTime) {
        float totalCharged = 0;

        switch (plan.toLowerCase()) {
            case "bronze":
                totalCharged = BronzePlan.calculateCost(offPeakTime, midPeakTime, onPeakTime);
                break;
            case "silver":
                totalCharged = SilverPlan.calculateCost(offPeakTime, midPeakTime, onPeakTime);
                break;
            case "gold":
                totalCharged = GoldPlan.calculateCost(offPeakTime, midPeakTime, onPeakTime);
                break;
            default:
                break;
        }

        return totalCharged;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String userName = username.getText();
            String pass = new String(password.getPassword());

            // Authenticate user and get user data
            String[] userData = userVerify(userName, pass);

            if (userData != null) {
                // Extract plan and peak times from CSV data
                String plan = userData[9].trim();
                int offPeakTime = Integer.parseInt(userData[10].trim());
                int midPeakTime = Integer.parseInt(userData[11].trim());
                int onPeakTime = Integer.parseInt(userData[12].trim());

                // Calculate total charged based on the plan
                float totalCharged = calculateTotalCharged(plan, offPeakTime, midPeakTime, onPeakTime);

                // Display customer information
                new CustomerInfo(plan, offPeakTime, midPeakTime, onPeakTime, totalCharged);

                // Dispose of the current login frame
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            }
        } else if (e.getSource() == signup) {
            dispose();
            Registration regFrame = new Registration(this);
        } else if (e.getSource() == quit) {
            System.exit(0);
        } else if (e.getSource() == admin) {
            AdminLogin adminLogin = new AdminLogin();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}
