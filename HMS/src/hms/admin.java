package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame {
    JButton add_room,modify_room,logout;

    admin(){
        super("Book my Stay");

        JButton addemp = new JButton("Add Employee");
        addemp.setBounds(250,480,200,30);
        addemp.setBackground(Color.white);
        addemp.setForeground(Color.black);
        addemp.setFont(new Font("Comic Sans MC",Font.BOLD,15));
        add(addemp);
        addemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new add_emp();
            }
        });

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(275,275,150,150);
        add(jLabel);



        JButton add_room = new JButton("Add Rooms");
        add_room.setBounds(650,480,200,30);
        add_room.setBackground(Color.white);
        add_room.setForeground(Color.black);
        add_room.setFont(new Font("Comic Sans MC",Font.BOLD,15));
        add(add_room);
        add_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new add_room();

            }
        });

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image1 = imageIcon1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image1);
        JLabel jLabel1 = new JLabel(imageIcon11);
        jLabel1.setBounds(665,275,170,170);
        add(jLabel1);

        JButton modify_room = new JButton("Departments");
        modify_room.setBounds(1050,480,200,30);
        modify_room.setBackground(Color.white);
        modify_room.setForeground(Color.black);
        modify_room.setFont(new Font("Comic Sans MC",Font.BOLD,15));
        add(modify_room);
        modify_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        ImageIcon imageIco1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image imag1 = imageIco1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
        ImageIcon imageIcn11 = new ImageIcon(imag1);
        JLabel jLabl1 = new JLabel(imageIcn11);
        jLabl1.setBounds(1065,275,170,170);
        add(jLabl1);

        JButton b = new JButton("Back");
        b.setBounds(100,700,100,30);
        b.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dash();
                setVisible(false);
            }
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(1350,700,100,30);
        logout.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(404);

            }
        });

        ImageIcon imageIc1 = new ImageIcon(ClassLoader.getSystemResource("icon/logobms.jpg"));
        Image ima1 = imageIc1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIc11 = new ImageIcon(ima1);
        JLabel jLbl1 = new JLabel(imageIc11);
        jLbl1.setBounds(650,25,200,200);
        add(jLbl1);


        getContentPane().setBackground(new Color(0x2824A1));
        setSize(2000,1090);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new admin();
    }
}
