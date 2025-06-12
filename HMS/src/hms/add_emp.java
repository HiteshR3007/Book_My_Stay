package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_emp extends JFrame {


    add_emp(){
        super("Book My Stay");

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1080,450);
        panel.setBackground(new Color(0x302DA2));
        panel.setLayout(null);
        add(panel);

        JLabel addRoom = new JLabel("Add Employee Details");
        addRoom.setBounds(450,20,300,22);
        addRoom.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        addRoom.setForeground(Color.white);
        panel.add(addRoom);

        JLabel name = new JLabel("Name");
        name.setBounds(64,60, 200, 30);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        name.setForeground(Color.white);
        panel.add(name);

        JTextField name_text = new JTextField();
        name_text.setBounds(250,60,150,30);
        name_text.setForeground(Color.black);
        name_text.setBackground(new Color(73, 70, 217));
        name_text.setFont(new Font("Comics Sans MC",Font.BOLD,20));
        panel.add(name_text);

        JLabel age = new JLabel("Age");
        age.setBounds(64,100, 200, 30);
        age.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        age.setForeground(Color.white);
        panel.add(age);

        JTextField age_text = new JTextField();
        age_text.setBounds(250,100,150,30);
        age_text.setForeground(Color.black);
        age_text.setBackground(new Color(73, 70, 217));
        age_text.setFont(new Font("Comics Sans MC",Font.BOLD,20));
        panel.add(age_text);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(64,140, 200, 30);
        gender.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        gender.setForeground(Color.white);
        panel.add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(250,140,80,30);
        male.setForeground(Color.black);
        male.setBackground(new Color(0x302DA2));
        male.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(370,140,140,30);
        female.setForeground(Color.black);
        female.setBackground(new Color(0x302DA2));
        female.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(female);

        JLabel job = new JLabel("Job");
        job.setBounds(64,180,150,30);
        job.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        job.setForeground(Color.white);
        panel.add(job);

        JComboBox job_field = new JComboBox(new String[]{"Front Desk", "House Keeping", "Kitchen Staff ",
        "Room Service", "Manager", "Accountant", "Chef"});
        job_field.setBounds(250,180,150,30);
        job_field.setBackground(new Color(73, 70, 217));
        job_field.setForeground(Color.black);
        job_field.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        panel.add(job_field);

        JLabel Salary = new JLabel("Salary");
        Salary.setBounds(64,220,150,30);
        Salary.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        Salary.setForeground(Color.white);
        panel.add(Salary);

        JTextField Salary_Text = new JTextField();
        Salary_Text.setBounds(250,220,150,30);
        Salary_Text.setForeground(Color.black);
        Salary_Text.setBackground(new Color(73, 70, 217));
        Salary_Text.setFont(new Font("Comics Sans MS",Font.BOLD,20));
        panel.add(Salary_Text);

        JLabel Phone = new JLabel("Mobile");
        Phone.setBounds(64,260,150,30);
        Phone.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        Phone.setForeground(Color.white);
        panel.add(Phone);

        JTextField Phone_text = new JTextField();
        Phone_text.setBounds(250,260,150,30);
        Phone_text.setForeground(Color.black);
        Phone_text.setBackground(new Color(73, 70, 217));
        Phone_text.setFont(new Font("Comics Sans MS",Font.BOLD,20));
        panel.add(Phone_text);

        JLabel Aadhar = new JLabel("Aadhar");
        Aadhar.setBounds(64,300,150,30);
        Aadhar.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        Aadhar.setForeground(Color.white);
        panel.add(Aadhar);

        JTextField Aadhar_Text = new JTextField();
        Aadhar_Text.setBounds(250,300,150,30);
        Aadhar_Text.setForeground(Color.black);
        Aadhar_Text.setBackground(new Color(73, 70, 217));
        Aadhar_Text.setFont(new Font("Comics Sans MS",Font.BOLD,20));
        panel.add(Aadhar_Text);

        JLabel Email = new JLabel("Email");
        Email.setBounds(64,340,150,30);
        Email.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        Email.setForeground(Color.white);
        panel.add(Email);

        JTextField Email_Text = new JTextField();
        Email_Text.setBounds(250,340,150,30);
        Email_Text.setForeground(Color.black);
        Email_Text.setBackground(new Color(73, 70, 217));
        Email_Text.setFont(new Font("Comics Sans MS",Font.BOLD,20));
        panel.add(Email_Text);

        JButton add = new JButton("ADD");
        add.setBounds(70,400,100,33);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        panel.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_text.getText();
                String age = age_text.getText();
                String Salary = Salary_Text.getText();
                String Phone = Phone_text.getText();
                String Email = Email_Text.getText();
                String Aadhar = Aadhar_Text.getText();
                String job = (String) job_field.getSelectedItem();
                String gender = null;
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected())
                    gender = "Female";

                try {
                    con c = new con();

                    String q = "insert into emp values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + Salary + "', '" + Phone + "','" + Aadhar + "', '" + Email + "')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        });

        JButton close = new JButton("CLOSE");
        close.setBounds(200,400,100,33);
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

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image = imageIcon.getImage().getScaledInstance(280,280,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(600,100,280,280);
        panel.add(jLabel);

        setUndecorated(true);
        setLayout(null);
        setBounds(245,280,1090,460);
        setVisible(true);


    }

    public static void main(String[] args) {
        new add_emp();
    }
}
