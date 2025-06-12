package hms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame {

    room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,740);
        panel.setBackground(new Color(0x702A0B));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,90,630,500);
        table.setBackground(new Color(0x702A0B));
        table.setForeground(Color.white);
        panel.add(table);

        JLabel roomsInformation = new JLabel("Rooms Information");
        roomsInformation.setBounds(250,15,280,20);
        roomsInformation.setForeground(Color.white);
        roomsInformation.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        panel.add(roomsInformation);

        JLabel ava = new JLabel("Availability");
        ava.setBounds(155,72,100,19);
        ava.setForeground(Color.white);
        ava.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(ava);

        JLabel Roomno = new JLabel("Room No");
        Roomno.setBounds(55,72,80,19);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Roomno);

        JLabel Clean = new JLabel("Clean Status");
        Clean.setBounds(285,72,110,19);
        Clean.setForeground(Color.white);
        Clean.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Clean);

        JLabel Price = new JLabel("Price");
        Price.setBounds(430,72,90,19);
        Price.setForeground(Color.white);
        Price.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Price);

        JLabel Bedtype = new JLabel("Bed Type");
        Bedtype.setBounds(550,72,90,19);
        Bedtype.setForeground(Color.white);
        Bedtype.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Bedtype);

        try {
            con c = new con();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image i12 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(i12);
        JLabel label = new JLabel(ic1);
        label.setBounds(675,250,250 ,250);
        panel.add(label);

        JButton close = new JButton("CLOSE");
        close.setBounds(100,650,100,33);
        close.setForeground(Color.white);
        close.setBackground(Color.black);
        close.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        panel.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setBounds(408,55,1000,750);
        setVisible(true);
    }

    public static void main(String[] args) {
        new room();
    }
}
