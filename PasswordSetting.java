package finalProject;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;


class PasswordSetting  extends JFrame
{
        String std_name;
        String std_id ;
        char[] password;
        PasswordSetting() throws EmptyFieldsException
        {
            PasswordSetting currentFrame = null;
            setTitle("Setting Student Login Name and Password");

            JPanel panel = new JPanel();

            JLabel std_label = new JLabel("Student Name:");
            JLabel std_id_label = new JLabel("Student ID:");
            JTextField std_tf = new JTextField(20);
            JTextField std_id_tf= new JTextField(20);

            std_label.setLabelFor(std_tf);
            std_id_label.setLabelFor(std_id_tf);

            JLabel lblPassword = new JLabel("Password:");
            final JPasswordField pfPassword = new JPasswordField(20);

            lblPassword.setLabelFor(pfPassword);

            JButton btnGet = new JButton("Confirm Password");
            btnGet.addActionListener(
                    new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String password = new String(pfPassword.getPassword());
                            JOptionPane.showMessageDialog(currentFrame, "Your Password is " + password);
                        }
                    });

            JButton btnLogin = new JButton("Login");
            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    try
                    {
                        std_id = std_id_tf.getText();
                        std_name = std_tf.getText();
                        password = pfPassword.getPassword();

                        if(std_name.length() == 0 || password.length==0 || std_id.length()== 0)
                        {
                            throw new EmptyFieldsException();
                        }

                        if(password.length < 8)
                        {
                            throw new passwordException();
                        }
                        /*
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");

                            // here library_managment_system is MYSQL database name, root is username and maadi192000 is password

                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","maadi192000");


                        //    This code is for Inserting record in MySql DataBase

                            String query = "INSERT INTO `library_managment_system`.`accounts` (`student_name`, `password`, 'student_id') VALUES ('" + std_name  + "' , '" + password + "' , '" + std_id + "');" ;
                            Statement statement = con.createStatement();

                            int count = statement.executeUpdate(query);
                            if(count > 0)
                            {
                                JOptionPane.showMessageDialog(null , "Thanks for creating New Account!!! \n Your account saved in our Database");
                            }

                            con.close();
                        }


                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "This exception is in JDBC Connection.");
                        }

                         */


                        setVisible(false);
                        new StudentLogin().setVisible(true);
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

            });


            panel.setLayout(new SpringLayout());
            panel.add(std_id_label) ;
            panel.add(std_id_tf) ;
            panel.add(std_label);
            panel.add(std_tf);
            panel.add(lblPassword);
            panel.add(pfPassword);
            panel.add(btnLogin);
            panel.add(btnGet);

            SpringUtilities.makeCompactGrid(panel,
                    4, 2, //rows, cols
                    6, 6, //initX, initY
                    6, 6); //xPad, yPad

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(375, 200);
            getContentPane().add(panel);
            setLocationRelativeTo(null);
            setVisible(true);
        }
}