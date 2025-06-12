package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame {
    Checkout(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,740);
        panel.setBackground(new Color(0x702A0B));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);


        JLabel UserId = new JLabel("Customer Id");
        UserId.setBounds(30, 80, 150, 30);
        UserId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        UserId.setForeground(Color.WHITE);
        panel.add(UserId);

        Choice Customer = new Choice();
        Customer.setBounds(250, 80, 150, 25);
        Customer.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Customer.setBackground(new Color(0x813114));
        Customer.setForeground(Color.black);
        panel.add(Customer);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30, 130, 150, 30);
        roomNum.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        try {
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");

            while(resultSet.next()) {
                Customer.add(resultSet.getString("number"));
            }
        } catch (Exception var15) {
            var15.printStackTrace();
        }

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(250, 130, 250, 30);
        labelRoomnumber.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        labelRoomnumber.setBackground(new Color(0x813114));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);
        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30, 180, 250, 30);
        checkintime.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);
        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(250, 180, 250, 30);
        labelcheckintime.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);


        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30, 230, 200, 30);
        checkouttime.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel("" + String.valueOf(date));
        labelcheckouttime.setBounds(250, 230, 250, 30);
        labelcheckouttime.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);

        JButton b2 = new JButton("CLOSE");
        b2.setBounds(200,650,100,30);
        b2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton checkOut = new JButton(" Check-Out");
        checkOut.setBounds(130, 300, 150, 30);
        checkOut.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con cv = new con();
                    cv.statement.executeUpdate("delete from customer where number = '"+Customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set avail = 'Available' where roomno = '"+labelRoomnumber.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Checked Out Succesfully");
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(350, 300, 150, 30);
        check.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new  con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where Number = '"+Customer.getSelectedItem()+"'");
                    while(resultSet.next()){
                        labelRoomnumber.setText(resultSet.getString("room"));
                        labelcheckintime.setText(resultSet.getString("Checkintime"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        setUndecorated(true);
        setLayout(null);
        setBounds(408,55,1000,750);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
