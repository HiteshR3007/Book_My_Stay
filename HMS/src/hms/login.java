package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField jt1;
    JPasswordField jt2;
    JButton b1,b2;
    login(){
        super("Book My Stay");
        JLabel label_login= new JLabel("Username");
        label_login.setBounds(40,20,100,30);
        label_login.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        label_login.setForeground(Color.white);
        add(label_login);

        JLabel label1= new JLabel("Password");
        label1.setBounds(40,70,100,30);
        label1.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        add(label1);

        jt1 = new JTextField();
        jt1.setBounds(150 ,20,150,30);
        jt1.setForeground(Color.white);
        jt1.setBackground(new Color(40, 36, 161));
        jt1.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        add(jt1);

        jt2 = new JPasswordField();
        jt2.setBounds(150 ,70,150,30);
        jt2.setForeground(Color.white);
        jt2.setBackground(new Color(40, 36, 161));
        add(jt2);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icon/logobms.jpg"));
        Image i1 = ic.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label= new JLabel(ic);
        label.setBounds(330,5,250,250);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,200,120,30);
        b1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(180,200,120,30);
        b2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(0, 75, 165));
        setLayout(null);
        setBounds(500,250,600,300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
               con c = new con();
               String user = jt1.getText();
               String pass= jt2.getText();

               String q= "select * from login where username = '"+user+"' and password = '"+pass+"'";
               ResultSet resultSet = c.statement.executeQuery(q);
               if (resultSet.next()){
                   new Dash();
                   setVisible(false);
               }else {
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password");
               }

            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else {
            System.exit(404);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
