import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    GUI(String title){
        super(title);
        try {
            ImageIcon img = new ImageIcon("src/Lighting.png");
            setIconImage(img.getImage());
        } catch (Exception e){
            e.printStackTrace();
        }
        getContentPane().setBackground(Color.pink);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }
}
