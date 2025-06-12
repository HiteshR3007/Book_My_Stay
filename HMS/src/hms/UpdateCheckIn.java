package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheckIn extends JFrame {

    UpdateCheckIn(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,740);
        panel.setBackground(new Color(0x702A0B));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Update Check-In");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i12 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(i12);
        JLabel label1 = new JLabel(ic1);
        label1.setBounds(675,250,250 ,250);
        panel.add(label1);

        JLabel label2 = new JLabel("ID : ");
        label2.setBounds(30, 80, 200, 30);
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(250,80,200,30);
        c.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        c.setBackground(new Color(0x813114));
        c.setForeground(Color.black);
        panel.add(c);

        try {
            con c1 = new con();
            ResultSet resultSet = c1.statement.executeQuery("select * from customer ");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No : ");
        label3.setBounds(30, 130, 200, 30);
        label3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(250,130,200,30);
        textField3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textField3.setBackground(new Color(0x813114));
        textField3.setForeground(Color.black);
        panel.add(textField3);

        JLabel label4 = new JLabel("Name: ");
        label4.setBounds(30, 180, 200, 30);
        label4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(250,180,200,30);
        textField4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textField4.setBackground(new Color(0x813114));
        textField4.setForeground(Color.BLACK);
        panel.add(textField4);

        JLabel label5 = new JLabel("Checked-In: ");
        label5.setBounds(30, 230, 200, 30);
        label5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(250,230,200,30);
        textField5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textField5.setBackground(new Color(0x813114));
        textField5.setForeground(Color.BLACK);
        panel.add(textField5);

        JLabel label6 = new JLabel("Amount Paid: ");
        label6.setBounds(30, 280, 200, 30);
        label6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField6 = new JTextField();
        textField6.setBounds(250,280,200,30);
        textField6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textField6.setBackground(new Color(0x813114));
        textField6.setForeground(Color.BLACK);
        panel.add(textField6);

        JLabel label7 = new JLabel("Pending Amount: ");
        label7.setBounds(30, 330, 200, 30);
        label7.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField7 = new JTextField();
        textField7.setBounds(250,330,200,30);
        textField7.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textField7.setBackground(new Color(0x813114));
        textField7.setForeground(Color.BLACK);
        panel.add(textField7);

        JButton update = new JButton("Update");
        update.setBounds(100,525,120,30);
        update.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C = new con();
                    String q = c.getSelectedItem();
                    String room = textField3.getText();
                    String name = textField4.getText();
                    String check = textField5.getText();
                    String amt = textField6.getText();

                    C.statement.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', Checkintime = '"+check+"', Deposit = '"+amt+"' where number = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Succesfully");
                    setVisible(false);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        JButton bac = new JButton("Back");
        bac.setBounds(400,525,120,30);
        bac.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
        bac.setBackground(Color.black);
        bac.setForeground(Color.white);
        panel.add(bac);
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(250,525,120,30);
        check.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '"+id+"'";

                try{
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textField3.setText(resultSet.getString("room"));
                        textField4.setText(resultSet.getString("Name"));
                        textField5.setText(resultSet.getString("Checkintime"));
                        textField6.setText(resultSet.getString("Deposit"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomno = '"+textField3.getText()+"'");

                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amtpaid = Integer.parseInt(price) - Integer.parseInt(textField6.getText());
                        textField7.setText(""+amtpaid);
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
        new UpdateCheckIn();
    }
}
