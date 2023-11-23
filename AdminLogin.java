import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminLogin extends GUI implements ActionListener {

    private final JTextField adminUser;
    private final JPasswordField adminPassword;

    private final JButton adlogin,back;

    AdminLogin(){
        super("Admin login");
        JLabel user1 = new JLabel("Admin Username:");
        user1.setBounds(400,320,200,20);
        user1.setFont(new Font("New Times Roman",Font.BOLD,20));
        add(user1);

        adminUser = new JTextField();
        adminUser.setBounds(650,320,150,30);
        add(adminUser);

        JLabel pass =new JLabel("Password");
        pass.setBounds(420,460,100,20);
        pass.setFont(new Font("New Times Roman",Font.BOLD,20));
        add(pass);

        adminPassword = new JPasswordField();
        adminPassword.setBounds(650,460,150,30);
        add(adminPassword);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("admin.png"));
        Image i= i1.getImage().getScaledInstance(150,140,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(600,70,300,300);
        add(image);

        ImageIcon icon5 = new ImageIcon("src/login.png");
        Image image5 =icon5.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        adlogin = new JButton("Login",new ImageIcon(image5));
        adlogin.setBounds(550,550,150,75);
        adlogin.addActionListener(this);
        adlogin.setBackground(Color.lightGray);
        add(adlogin);

        ImageIcon icon6 = new ImageIcon("src/return.png");
        Image image6 = icon6.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        back = new JButton("Return",new ImageIcon(image6)); //return to the previous screen
        back.setBounds(750,550,150,75);
        back.addActionListener(this);
        back.setBackground(Color.lightGray);
        add(back);

        setVisible(true);
    }
    private boolean userVerify(String adminuser, String adminpass) {
        try (BufferedReader br = new BufferedReader(new FileReader("admin.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] admin = line.split(",");
                //check all 2 info is there
                if (admin.length >= 1) {
                    String storedUserName = admin[0].trim(); //username
                    String storedPassword = admin[1].trim(); //password

                    if (storedUserName.equalsIgnoreCase(adminuser) && storedPassword.equals(adminpass)) {
                        System.out.println("Authentication successful");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Main().setVisible(true);
            setVisible(false);
        }
        if (e.getSource() == adlogin) {
            String adminuser = adminUser.getText();
            String adminpass = new String(adminPassword.getPassword());
            if (userVerify(adminuser, adminpass)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();
            AdminCustomerDetails adminCustomerDetails = new AdminCustomerDetails();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            }
        }
    }
}
