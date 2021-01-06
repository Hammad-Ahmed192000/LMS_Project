package finalProject;

import netscape.javascript.JSException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class StudentLogin extends Frame
{
    JLabel background ;
    ImageIcon icon ;
    StudentLogin currentFrame = this;
    JLabel lN , lP , l1 , label ;
    public static JTextField tf = new JTextField(20);
    JButton back = new JButton("BACK"), submit = new JButton("SUBMIT"),next = new JButton("NEXT");
    public static JPasswordField pF = new JPasswordField(20);
    JSeparator separator = new JSeparator() ;
    public static String name, password;
    boolean done = false;
    boolean register = true ;


    public StudentLogin()
    {

        setLayout(null);
        lN = new JLabel("Student Name :",Label.LEFT);
        lP = new JLabel("Password :",Label.LEFT);
        l1 = new JLabel("Student Login Account");



        JSeparator separator1 = new JSeparator() ;
        separator1.setBounds(400,530,500,100);
        separator1.setBackground(Color.BLACK);

        label = new JLabel();
        label.setText("(: You only Login when you are already Registered in this Library :)");
        label.setForeground(Color.BLACK);
        label.setBounds(415,455,800,100);
        label.setFont(new Font("Aerial",Font.BOLD,14));
        label.setLayout(null);

        JSeparator separator2 = new JSeparator() ;
        separator2.setBounds(400,480,500,100);
        separator2.setBackground(Color.BLACK);
/*
        // this code is for setting the BackGround.
        icon = new ImageIcon("background.jpg") ;
        JLabel background = new JLabel(icon);
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

 */

        l1.setBounds(390 ,50,800,50);
        tf.setBounds(630 ,300,250,40);
        pF.setBounds(630 ,400,250,40);
        lN.setBounds(420,300,160,50);
        lP.setBounds(425,370,120,110);
        back.setBounds(350,600,120,50);
        submit.setBounds(650,600,120,50);
        next.setBounds(900,600,120,50);
        separator.setBounds(0, 120 ,1350,50 );


        Border border = BorderFactory.createLineBorder(Color.BLACK ,3);

        back.setBorder(border);
        submit.setBorder(border);
        next.setBorder(border);


        l1.setForeground(Color.BLACK);
        lN.setForeground(Color.BLACK);
        lP.setForeground(Color.BLACK);


        back.setBackground(Color.BLACK);
        submit.setBackground(Color.BLACK);
        next.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);


        l1.setFont(new Font("Matura MT Script Capitals",Font.BOLD + Font.PLAIN,40));
        lN.setFont(new Font("Aerial",Font.BOLD,19));
        lP.setFont(new Font("Aerial",Font.BOLD,19));
        tf.setFont(new Font("Aerial",Font.PLAIN,17));
        pF.setFont(new Font("Aerial",Font.PLAIN,17));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        submit.setFont(new Font("Aerial",Font.BOLD,14));
        next.setFont(new Font("Aerial",Font.BOLD,14));


        add(l1);
        add(separator) ;
        add(lN);
        add(lP);
        add(tf);
        add(pF);
        add(separator1) ;
        add(label) ;
        add(separator2) ;


        add(back);
        add(submit);
        add(next);

        // add(background) ;


        back.addActionListener(new actions());
        submit.addActionListener(new actions());
        next.addActionListener(new actions());
        // addWindowListener(new MyWindow());


        setBackground(new Color(153, 153, 153));
        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);

        addWindowListener(new MyWindow());

    }
    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                currentFrame.dispose();
                new LMSProject();
            }

            else if(ae.getSource()==next)
            {
                try
                {

                    StudentLogin.name = tf.getText();
                    StudentLogin.password = new String(pF.getPassword());

                    if(name.length()==0 || password.length()==0)
                    {
                        throw new EmptyFieldsException();
                    }

                    for(int i=0;i<name.length();i++)
                    {
                        if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || name.charAt(i)==' ')
                        {

                        }
                        else
                        {
                            throw new NameException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                    try
                    {
                        JOptionPane.showMessageDialog(null, "Now you press the submit button");

                    }

                    catch(Exception e)
                    {
                        // JOptionPane.showMessageDialog(null, "This exception is in JDBC Connection.");
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }


                }


                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"There is some Problem With Login");
                }
            }

            else
            {
                try
                {
                    StudentLogin.name = tf.getText();
                    StudentLogin.password = new String(pF.getPassword());

                    if(name.length()==0 || password.length()==0)
                    {
                        throw new EmptyFieldsException();
                    }

                    for(int i=0;i<name.length();i++)
                    {
                        if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || name.charAt(i)==' ')
                        {

                        }
                        else
                        {
                            throw new NameException();
                        }
                    }

                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                    try
                    {

                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // here library_managment_system is MYSQL database name, root is username and maadi192000 is password

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");


                        //    This code is for Inserting record in MySql DataBase
                        PreparedStatement preparedStatement ;
                        ResultSet resultSet ;

                        String query = "Select  * from `library_managment_system`.`accounts` WHERE `student_name` = ? AND `password` = ?;" ;
                        // Statement statement = con.createStatement();

                        preparedStatement = con.prepareStatement(query) ;

                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, password);

                        resultSet = preparedStatement.executeQuery();

                        // int count = statement.executeUpdate(query);
                        if(resultSet.next()) // true
                        {
                            // All the Next Operation that are after Login we will put Here...
                            if(register== true)
                            {
                                JOptionPane.showMessageDialog(null , "Thank You for Loging In :)");
                                currentFrame.dispose();
                                StudentLogin.name = tf.getText();
                                StudentLogin.password = new String(pF.getPassword());
                                new StudentProfile();
                            }
                            // JOptionPane.showMessageDialog(null , "Here We put the code  for Student Profile page ");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null , "You are not Registered in this Library. \n Please First Register Yourself!!");
                            register = false ;
                            currentFrame.dispose();
                            new StudentLogin() ;
                        }

                        con.close();

                    }

                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "This exception is in JDBC Connection.");
                        JOptionPane.showMessageDialog(null, e);
                    }

                }

                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"There is a problem in Login.");
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
    }
}



