package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class adminlog extends JFrame implements ActionListener  {

    JButton b1,b2,b3;
    JPasswordField p;
    JTextField u;


    adminlog(){

        super("Book My Stay");

        ImageIcon trial= new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image trial1 =trial.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT);
        ImageIcon triall = new ImageIcon(trial1);
        JLabel label = new JLabel(triall);
        label.setBounds(330,25,230,230);
        add(label);

        JLabel uu = new JLabel("ID :");
        uu.setBounds(20,20,50,30);
        uu.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        uu.setForeground(Color.black);
        add(uu);

        JLabel pp = new JLabel("Password :");
        pp.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        pp.setBounds(20, 75, 150,30);
        pp.setForeground(Color.black);
        add(pp);

        u = new JTextField();
        u.setBounds(120,20,170,30);
        u.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        u.setBackground(Color.cyan);
        add(u);

        p = new JPasswordField();
        p.setBounds(120,75,170,30);
        p.setBackground(Color.cyan);
        add(p);


        b1 = new JButton("Login");
        b1.setBounds(40,180,100,30);
        b1.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(120,220,100,30);
        b2.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(200,180,100,30);
        b3.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        add(b3);


        setLayout(null);
        getContentPane().setBackground(Color.blue);
        setBounds(500,270,600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                con c = new con();
                String user = u.getText();
                String ukey = p.getText();

                String query ="select * from adlog where user = '"+user+"' and ukey = '"+ukey+"'";
                ResultSet resultSet = c.statement.executeQuery(query);
                if(resultSet.next()){
                    new admin();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }



            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==b3) {
            new Dash();
            setVisible(false);
        }else {
            System.exit(405);
        }


    }

    public static void main(String[] args) {
        new adminlog();
    }
}
