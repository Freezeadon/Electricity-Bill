import javax.swing.*;
import java.awt.*;

public abstract class GUI extends JFrame {

    GUI(String title){
        super(title);
        try {
            ImageIcon img = new ImageIcon("src/Lighting.png");
            setIconImage(img.getImage());
        } catch (Exception e){
            e.printStackTrace();
        }
        getContentPane().setBackground(new Color(173, 216, 230));
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1300, 1000);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    protected abstract void initializeComponents();
}
