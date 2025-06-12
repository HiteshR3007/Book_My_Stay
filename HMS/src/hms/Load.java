package hms;

import javax.swing.*;
import java.awt.*;

public class Load extends JFrame {

    Load(){
        super("Book My Stay");
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/loadani.gif"));
        Image ic1 = ic.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(ic);
        label.setBounds(0,0,1000,600);
        add(label);
        setLayout(null);
        setLocation(300,80);
        setSize(1000,600);
        setVisible(true);

        try{
            Thread.sleep(4000);
            setVisible(false);
            new login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Load();
    }
}
