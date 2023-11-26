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
        getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
    }
    protected abstract void initializeComponents();
}
