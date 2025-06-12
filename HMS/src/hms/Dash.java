package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dash extends JFrame implements ActionListener {
    JButton adm,rec;
    Dash(){
        super("Book My Stay");

        rec = new JButton("Reception");
        rec.setBounds(60,100,100,30);
        rec.setFont(new Font("Comic Sans MS", Font.PLAIN,14));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.white);
        rec.addActionListener(this);
        add(rec);

        adm = new JButton("Admin");
        adm.setBounds(300,100,100,30);
        adm.setFont(new Font("Comic Sans MS", Font.PLAIN,14));
        adm.setBackground(new Color(255,98,0));
        adm.setForeground(Color.white);
        adm.addActionListener(this);
        add(adm);

        JButton bac = new JButton("Back");
        bac.setBounds(180,180,100,30);
        bac.setFont(new Font("Comic Sans MS",Font.PLAIN, 16));
        bac.setBackground(Color.black);
        bac.setForeground(Color.white);
        add(bac);
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });

        ImageIcon iboss= new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image ib= iboss.getImage().getScaledInstance(51,51,Image.SCALE_DEFAULT);
        ImageIcon iboss1=new ImageIcon(ib);
        JLabel labelb = new JLabel(iboss1);
        labelb.setBounds(320,50,51,51);
        add(labelb);

        ImageIcon irec= new ImageIcon(ClassLoader.getSystemResource("icon/rec.png"));
        Image ir= irec.getImage().getScaledInstance(51,51,Image.SCALE_DEFAULT);
        ImageIcon irec1=new ImageIcon(ir);
        JLabel labelr = new JLabel(irec1);
        labelr.setBounds(80,50,51,51);
        add(labelr);

        ImageIcon ic= new ImageIcon(ClassLoader.getSystemResource("icon/Dash.gif"));
        Image i1= ic.getImage().getScaledInstance(480,288,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(i1);
        JLabel label = new JLabel(ic1);
        label.setBounds(0,0,480,288);
        add(label);


        setSize(480,288);
        setLayout(null);
        setVisible(true);
        setLocation(500,250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new rec();
            setVisible(false);
        }else if(e.getSource()==adm){
            new admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dash();
    }
}
