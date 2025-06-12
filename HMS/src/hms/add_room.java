package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class add_room extends JFrame {
    add_room(){
        super("Book My Stay");

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1075,450);
        panel.setBackground(new Color(0x302DA2));
        panel.setLayout(null);
        add(panel);

        JLabel addRoom = new JLabel("Add Room");
        addRoom.setBounds(200,20,160,22);
        addRoom.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        addRoom.setForeground(Color.white);
        panel.add(addRoom);

        JLabel room_no = new JLabel("Room No");
        room_no.setBounds(64,60, 200, 30);
        room_no.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        room_no.setForeground(Color.white);
        panel.add(room_no);

        JTextField t1 = new JTextField();
        t1.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        t1.setBounds(200,60,200,30);
        t1.setForeground(Color.black);
        t1.setBackground(new Color(73, 70, 217));
        panel.add(t1);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(64,110,152,22);
        availability.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        availability.setForeground(Color.white);
        panel.add(availability);

        JComboBox t2 = new JComboBox(new String[] {"Available", "Occupied"});
        t2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        t2.setBounds(200, 110, 200, 30);
        t2.setForeground(Color.black);
        t2.setBackground(new Color(73, 70, 217));
        panel.add(t2);

        JLabel price = new JLabel("Price");
        price.setBounds(64,160,152,22);
        price.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        price.setForeground(Color.white);
        panel.add(price);

        JTextField t3 = new JTextField();
        t3.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        t3.setBounds(200,160,200,30);
        t3.setForeground(Color.black);
        t3.setBackground(new Color(73, 70, 217));
        panel.add(t3);

        JLabel status = new JLabel("Cleaning Status ");
        status.setBounds(64,210,152,22);
        status.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        status.setForeground(Color.white);
        panel.add(status);

        JComboBox t4 = new JComboBox(new String[]{"Cleaned","Dirty"});
        t4.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        t4.setBounds(200,210,200,30);
        t4.setForeground(Color.black);
        t4.setBackground(new Color(73, 70, 217));
        panel.add(t4);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(64,260,152,22);
        bed.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        bed.setForeground(Color.white);
        panel.add(bed);

        JComboBox t5 = new JComboBox(new String[]{"Single Bed","Double Bed","Twin"});
        t5.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        t5.setBounds(200,260,200,30);
        t5.setForeground(Color.black);
        t5.setBackground(new Color(73, 70, 217));
        panel.add(t5);

        JButton b1 = new JButton("ADD");
        b1.setBounds(64,321,100,33);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c = new con();
                    String room = t1.getText();
                    String ava = (String) t2.getSelectedItem();
                    String stat = (String) t4.getSelectedItem();
                    String price = t3.getText();
                    String bed = (String) t5.getSelectedItem();

                    String q= "insert into room values ('"+room+"','"+ava+"','"+stat+"','"+price+"','"+bed+"')";
                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,"Room Successfully Added");
                    setVisible(false);



                }catch (Exception E){
                    E.printStackTrace();
                }
                setVisible(false);
            }
        });

        JButton b2 = new JButton("CLOSE");
        b2.setBounds(200,321,100,33);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(280,280,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(600,60,280,280);
        panel.add(jLabel);
        

        setUndecorated(true);
        setLayout(null);
        setBounds(245,280,1090,460);
        setVisible(true);
    }

    public static void main(String[] args) {
        new add_room();
    }
}
