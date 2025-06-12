package hms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1075,450);
        panel.setBackground(new Color(0x302DA2));
        panel.setLayout(null);
        add(panel);

        JLabel dinfo = new JLabel("Department Information");
        dinfo.setBounds(200,20,360,22);
        dinfo.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        dinfo.setForeground(Color.white);
        panel.add(dinfo);

        JTable table = new JTable();
        table.setBounds(10,90,330,200);
        table.setBackground(new Color(0x302DA2));
        table.setForeground(Color.white);
        panel.add(table);

        JLabel name = new JLabel("Department Name");
        name.setBounds(25,72,180,19);
        name.setForeground(Color.white);
        name.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(name);

        JLabel bud = new JLabel("Budget");
        bud.setBounds(200,72,100,19);
        bud.setForeground(Color.white);
        bud.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        panel.add(bud);


        try {
            con c = new con();
            String q = "select * from dept";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(280,280,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(600,60,280,280);
        panel.add(jLabel);

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

        setUndecorated(true);
        setLayout(null);
        setBounds(245,280,1090,460);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
