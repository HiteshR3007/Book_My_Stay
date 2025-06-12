package hms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;

public class NewCust extends JFrame {


    NewCust(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,740);
        panel.setBackground(new Color(0x702A0B));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(675,250,250 ,250);
        panel.add(imglabel);

        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(250,40,380,30);
        labelName.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 100, 200, 19);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(labelID);

        JComboBox cb = new JComboBox(new String[]{"Passport","Aadhar Card", "Voter Id", "Driving License"});
        cb.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        cb.setBounds(271, 100, 200, 30);
        cb.setForeground(Color.black);
        cb.setBackground(new Color(0x813114));
        panel.add(cb);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 150, 200, 30);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(labelNumber);

        JTextField textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 150, 200, 30);
        textFieldNumber.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        textFieldNumber.setBackground(Color.BLACK);
        textFieldNumber.setBackground(new Color(0x813114));
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35, 200, 200, 30);
        labelname.setForeground(Color.WHITE);
        labelname.setBackground(new Color(0x813114));
        labelname.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(labelname);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(271, 200, 200, 30);
        textFieldName.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        textFieldName.setBackground(Color.BLACK);
        textFieldName.setBackground(new Color(0x813114));
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 250, 200, 20);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(labelGender);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(0x702A0B));
        r1.setBounds(271, 250, 80, 20);
        panel.add(r1);
        JRadioButton r2 = new JRadioButton("Female");
        r2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(0x702A0B));
        r2.setBounds(360, 250, 180, 20);
        panel.add(r2);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35, 300, 200, 30);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(labelCountry);

        JTextField TextCountry = new JTextField();
        TextCountry.setBounds(271, 300, 200, 30);
        TextCountry.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        TextCountry.setForeground(Color.BLACK);
        TextCountry.setBackground(new Color(0x813114));
        panel.add(TextCountry);

        JLabel labelRoom = new JLabel("Allocated RoomNo :");
        labelRoom.setBounds(35, 350, 200, 20);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(labelRoom);

        Choice c1 = new Choice();
        try {
            con c = new con();
            ResultSet rs = c.statement.executeQuery("select * from room");
            while(rs.next()) {
                c1.add(rs.getString("roomno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271, 350, 200, 30);
        c1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        c1.setForeground(Color.BLACK);
        c1.setBackground(new Color(0x813114));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35, 400, 200, 20);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(labelCIS);

        Date date1 = new Date();

        JLabel date = new JLabel(""+date1);
        date.setBounds(271, 400, 250, 20);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        panel.add(date);

        JLabel labelDep = new JLabel("Deposit :");
        labelDep.setBounds(35, 450, 200, 22);
        labelDep.setForeground(Color.WHITE);
        labelDep.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(labelDep);

        JTextField dep = new JTextField();
        dep.setBounds(271, 450, 200, 30);
        dep.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        dep.setForeground(Color.BLACK);
        dep.setBackground(new Color(0x813114));
        panel.add(dep);

        JButton b1 = new JButton("ADD");
        b1.setBounds(64,650,100,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c = new con();
                    String radioBTn = null;
                    if (r1.isSelected()) {
                        radioBTn = "Male";
                    } else if (r2.isSelected()) {
                        radioBTn = "Female";
                    }
                    String s1 = (String)cb.getSelectedItem();
                    String s2 = textFieldNumber.getText();
                    String s3 = textFieldName.getText();
                    String s4 = radioBTn;
                    String s5 = TextCountry.getText();
                    String s6 = c1.getSelectedItem();
                    String s7 = date.getText();
                    String s8 = dep.getText();

                    String q = "insert into customer values ('" + s1 + "', '" + s2 + "','" + s3 + "','" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')";
                    String q1 = "update room set avail = 'Occupied' where roomno = " + s6;
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Successfully Added");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
                setVisible(false);
            }
        });





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



        setUndecorated(true);
        setLayout(null);
        setBounds(408,55,1000,750);
        setVisible(true);

    }


    public static void main(String[] args) {
        new NewCust();
    }
}
