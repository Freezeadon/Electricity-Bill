import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    GUI(String title){
        super(title);
        getContentPane().setBackground(Color.pink);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
