import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminCustomerDetails extends JFrame implements ActionListener {

    private JTable table;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem signout, quit;

    public AdminCustomerDetails() {
        super("Customer Details");

        // Initialize components
        initializeComponents();

        // Read data from CSV and populate the table
        populateTableFromCSV("user_data.csv");

        // Create a panel to center the table
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(new JScrollPane(table));
        panel.add(Box.createHorizontalGlue());
        panel.setBackground(Color.PINK);

        // Add the panel to the frame
        add(panel);

        // Set preferred size to ensure the frame has a reasonable size
        setPreferredSize(new Dimension(800, 600));

        // Center the JFrame on the screen
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void initializeComponents() {
        // Creating a menubar
        menuBar = new JMenuBar();
        file = new JMenu("File");

        signout = new JMenuItem("Sign Out");
        quit = new JMenuItem("Quit");

        signout.addActionListener(this);
        quit.addActionListener(this);

        file.add(signout);
        file.add(quit);

        menuBar.add(file);
        setJMenuBar(menuBar);

        // Create the table with an empty model
        table = new JTable(new DefaultTableModel());
        table.setDefaultEditor(Object.class, null); // Make the JTable uneditable
    }

    private void populateTableFromCSV(String inputFileName) {
        File inputFile = new File(inputFileName);
        Vector<Vector<String>> vectorVectorStringsData = new Vector<>();
        Vector<String> vectorColumnIdentifiers = new Vector<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try (FileReader fr = new FileReader(inputFile);
             BufferedReader br = new BufferedReader(fr)) {

            // Read and set headers
            String[] columnIdentifiers = {"Account Number", "Username", "Password", "First Name", "Last Name", "Address", "Phone Number", "Email", "Plan"};
            vectorColumnIdentifiers.addAll(Arrays.asList(columnIdentifiers));

            int columnRemove = vectorColumnIdentifiers.indexOf("Password");

            // Read data rows
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                // Remove the column you want to hide (e.g., "Password")
                int columnIndexToHide = Arrays.asList(columnIdentifiers).indexOf("Password");
                if (columnIndexToHide >= 0 && columnIndexToHide < dataRow.length) {
                    // Remove the element at the specified index
                    dataRow = removeElement(dataRow, columnIndexToHide);
                    vectorColumnIdentifiers.remove(columnRemove);
                }
                vectorVectorStringsData.add(new Vector<>(Arrays.asList(dataRow)));
            }
            
            // Set the data and column identifiers to the table model
            model.setDataVector(vectorVectorStringsData, vectorColumnIdentifiers);

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
    private String[] removeElement(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signout) {
            int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?");
            if (confirmed == JOptionPane.YES_OPTION) {
                AdminLogin adminLogin = new AdminLogin();
                dispose();
            }
        } else if (e.getSource() == quit) { //Exit from Program
            System.exit(0);
        }
    }

}


