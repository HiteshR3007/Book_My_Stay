package hms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustInfo extends JFrame {
    CustInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,740);
        panel.setBackground(new Color(0x702A0B));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,90,880,500);
        table.setBackground(new Color(0x702A0B));
        table.setForeground(Color.white);
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomsInformation = new JLabel("Customer Information");
        roomsInformation.setBounds(250,15,280,20);
        roomsInformation.setForeground(Color.white);
        roomsInformation.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        panel.add(roomsInformation);

        JLabel ID = new JLabel("ID");
        ID.setBounds(40,72,100,19);
        ID.setForeground(Color.white);
        ID.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(ID);

        JLabel Number = new JLabel("Number");
        Number.setBounds(150,72,80,19);
        Number.setForeground(Color.white);
        Number.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Number);

        JLabel Name = new JLabel("Name");
        Name.setBounds(260,72,110,19);
        Name.setForeground(Color.white);
        Name.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Name);

        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(370,72,90,19);
        Gender.setForeground(Color.white);
        Gender.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Gender);

        JLabel Country = new JLabel("Country");
        Country.setBounds(480,72,90,19);
        Country.setForeground(Color.white);
        Country.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Country);

        JLabel roomno = new JLabel("Room");
        roomno.setBounds(590,72,90,19);
        roomno.setForeground(Color.white);
        roomno.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(roomno);

        JLabel checkIn = new JLabel("Check In");
        checkIn.setBounds(690,72,90,19);
        checkIn.setForeground(Color.white);
        checkIn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(checkIn);

        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(800,72,90,19);
        Deposit.setForeground(Color.white);
        Deposit.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(Deposit);





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
        new CustInfo();
    }
}
