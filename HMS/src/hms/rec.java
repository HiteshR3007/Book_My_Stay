package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rec extends JFrame implements ActionListener{

    JButton bac;
    rec(){
        super("Book my Stay");


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(0x702A0B));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(0x302DA2));
        add(panel1);

        JButton b1= new JButton("New Customer ");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b1.setBounds(50,50,200,30);
        panel1.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCust();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("Room Info");
        b2.setBounds(50,90,200,30);
        b2.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        panel1.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new room();

                }catch (Exception E2){
                    E2.printStackTrace();
                }
            }
        });

        JButton b3 = new JButton("Customer Info ");
        b3.setBounds(50,130,200,30);
        b3.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        panel1.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustInfo();
                }catch (Exception E3){
                    E3.printStackTrace();
                }
            }
        });

        JButton b4 = new JButton("Update Room Status ");
        b4.setBounds(50,170,200,30);
        b4.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        panel1.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }catch (Exception E3){
                    E3.printStackTrace();
                }
            }
        });

        JButton b5 = new JButton("Checkout");
        b5.setBounds(50,250,200,30);
        b5.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        panel1.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Checkout();
                }catch (Exception E3){
                    E3.printStackTrace();
                }
            }
        });

        JButton b6 = new JButton("Update Check-In");
        b6.setBounds(50,210,200,30);
        b6.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        panel1.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheckIn();
                }catch (Exception E4){
                    E4.printStackTrace();
                }
            }
        });

        bac = new JButton("Back");
        bac.setBounds(100,725,120,30);
        bac.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        bac.setBackground(Color.black);
        bac.setForeground(Color.white);
        panel1.add(bac);
        bac.addActionListener(this);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bmsgifvid.gif"));
        Image i12 = i1.getImage().getScaledInstance(1000,750, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(i12);
        JLabel label = new JLabel(ic1);
        label.setBounds(120,20,1000,750);
        panel.add(label);


        ImageIcon i2 = new ImageIcon((ClassLoader.getSystemResource("icon/logobms.jpg")));
        Image i22 = i2.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i22);
        JLabel label1 = new JLabel(ic2);
        label1.setBounds(10,450,250,250);
        panel1.add(label1);

        getContentPane().setBackground(Color.WHITE);
        setSize(1950,1090);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bac){
            new Dash();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new rec();
    }
}
