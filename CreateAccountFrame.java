package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateAccountFrame extends Frame
{

    CreateAccountFrame currentFrame = this;

    JLabel l1, label_Std_ID, std_name_label, program_label ,semester_label, batch_label;

    JTextField tf = new JTextField(20);
    JTextField tf1 = new JTextField(20);
    JTextField tf2=new JTextField(20);
    JTextField tf3=new JTextField(20);
    JTextField tf4=new JTextField(20);


    JButton back = new JButton("BACK"), submit = new JButton("SUBMIT"),next = new JButton("NEXT");
    // final JPasswordField pF = new JPasswordField(20);
    JSeparator separator = new JSeparator() ;
    String std_ID, std_name, program, semester, batch ;
    JLabel background ;
    ImageIcon icon ;

    public CreateAccountFrame()
    {

        setLayout(null);
        l1 = new JLabel("CREATE NEW ACCOUNT");
        std_name_label = new JLabel("Student Name :",Label.LEFT);
        label_Std_ID = new JLabel("Student ID :",Label.RIGHT);
        program_label = new JLabel("Program :",Label.LEFT);
        semester_label=new JLabel("Current Semester : ",Label.LEFT);
        batch_label=new JLabel("Batch Year :",Label.LEFT);


        // this code is for setting the BackGround.
        icon = new ImageIcon("D:\\BSSE-IV\\DB Theory\\DBProject\\LMSApp (1)\\LMSApp\\src\\finalProject\\back1.jpg") ;
        background = new JLabel(icon) ;
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

        background.add(l1);
        background.add(separator) ;
        background.add(std_name_label);
        background.add(label_Std_ID);
        background.add(program_label);
        background.add(semester_label);
        background.add(batch_label);
        background.add(tf);
        background.add(tf1);
        background.add(tf4);
        background.add(tf2);
        background.add(tf3);
        background.add(back);
        background.add(submit);
        background.add(next);

        add(background) ;


        back.addActionListener(new actions());
        submit.addActionListener(new actions());
        next.addActionListener(new actions());
        addWindowListener(new MyWindow());

        l1.setBounds(480 ,50,400,50);

        tf.setBounds(650 ,190,250,40); // student Id field
        tf1.setBounds(650 ,260,250,40); // student name field
        tf4.setBounds(650 ,320,250,40); // Program field
        tf3.setBounds(650 ,390,250,40); // semester field
        tf2.setBounds(650 ,450,250,40); // Batch Year field



        label_Std_ID.setBounds(450,155,200,110);
        std_name_label.setBounds(410,260,200,50);
        program_label.setBounds(400,290,200,110);
        semester_label.setBounds(425,360,200,110);
        batch_label.setBounds(410,450,200,50);

        back.setBounds(350,600,120,50);
        submit.setBounds(650,600,120,50);
        next.setBounds(900,600,120,50);
        separator.setBounds(0, 120 ,1350,50 );

        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);

        back.setBorder(border);
        submit.setBorder(border);
        next.setBorder(border);


        l1.setForeground(Color.BLACK);
        std_name_label.setForeground(Color.BLACK);
        label_Std_ID.setForeground(Color.BLACK);
        program_label.setForeground(Color.BLACK);

        semester_label.setForeground(Color.BLACK);
        batch_label.setForeground(Color.BLACK);


        back.setBackground(Color.BLACK);
        submit.setBackground(Color.BLACK);
        next.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);

        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        std_name_label.setFont(new Font("Aerial",Font.BOLD,19));
        label_Std_ID.setFont(new Font("Aerial",Font.BOLD,19));
        program_label.setFont(new Font("Aerial",Font.BOLD,19));
        semester_label.setFont(new Font("Arrial",Font.BOLD,19));
        batch_label.setFont(new Font("Arial",Font.BOLD,19));
        tf.setFont(new Font("Aerial",Font.PLAIN,17));
        tf1.setFont(new Font("Aerial",Font.PLAIN,17));
        tf2.setFont(new Font("Arrial",Font.PLAIN,17));
        tf3.setFont(new Font("Arrial",Font.PLAIN,17));
        tf4.setFont(new Font("Aerial",Font.PLAIN,17));
        back.setFont(new Font("Aerial",Font.BOLD,14));
        submit.setFont(new Font("Aerial",Font.BOLD,14));
        next.setFont(new Font("Aerial",Font.BOLD,14));

        setSize(1280,850);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                currentFrame.setVisible(false);
                new LMSProject().setVisible(true);
            }

            else if(ae.getSource()==next)
            {
                try
                {
                    /*
                    tf.setBounds(650 ,190,250,40); // account ID field
                    tf1.setBounds(650 ,260,250,40); // student name field
                    pF.setBounds(650 ,320,250,40); // password field
                    tf3.setBounds(650 ,390,250,40); // reserve books field
                    tf2.setBounds(650 ,450,250,40); // student Id field

                     */

                    std_ID = tf.getText();
                    std_name = tf1.getText();
                    program = tf4.getText();
                    semester = tf3.getText();
                    batch = tf2.getText();



                    if(std_ID.length()==0 || std_name.length()==0 || program.length()==0 || semester.length()==0 || batch.length()==0)
                    {
                        throw new EmptyFieldsException();
                    }

                    for(int i = 0 ; i < std_name.length() ; i++)
                    {
                        if((std_name.charAt(i)<='A' && std_name.charAt(i)>='Z') || (std_name.charAt(i)<='a' && std_name.charAt(i) >= 'z'))
                        {
                            throw new NameException();
                        }
                    }

                    for(int i = 0 ; i < std_ID.length() ; i++)
                    {
                        if((std_ID.charAt(i) >= 'A' && std_ID.charAt(i)<='Z') || (std_ID.charAt(i)>='a' && std_ID.charAt(i)<='z') || (std_ID.charAt(i)>='0' && std_ID.charAt(i)<='9') || (std_ID.charAt(i) == '-') || (std_ID.charAt(i) =='_') || (std_ID.charAt(i) =='@') || (std_ID.charAt(i) =='.'))
                        {

                        }
                        else if((std_ID.charAt(0)=='-') || (std_ID.charAt(0)=='_') || (std_ID.charAt(std_ID.length()-1)=='-') || (std_ID.charAt(std_ID.length()-1)=='_'))
                        {
                            // function of this Exception here.
                            throw new IDException();
                        }
                        else
                        {
                            throw new IDException();
                        }
                    }

                    /*
                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }
                    */
                    JOptionPane.showMessageDialog(null , "Next Button reached you to the Menu");
                    currentFrame.setEnabled(false);
                    new PasswordSetting().setVisible(true);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            // this logic is for Submit button.
            else
            {
                try
                {
                    // bookRecords[index][0] = Integer.toString(rs.getInt(1));
                    std_ID = tf.getText();
                    std_name = tf1.getText();
                    program = tf4.getText();
                    semester = tf3.getText();
                    batch = tf2.getText();

                    if(std_ID.length()==0 || std_name.length()==0 ||program.length()==0 || semester.length()==0 || batch.length()==0)
                    {
                        throw new EmptyFieldsException();
                    }


                    for(int i = 0 ; i < std_name.length() ; i++)
                    {
                        if((std_name.charAt(i)<='A' && std_name.charAt(i)>='Z') || (std_name.charAt(i)<='a' && std_name.charAt(i)>='z'))
                        {
                            throw new NameException();
                        }
                    }

                    for(int i=0;i<std_ID.length();i++)
                    {
                        if((std_ID.charAt(i)>='A' && std_ID.charAt(i)<='Z') || (std_ID.charAt(i)>='a' && std_ID.charAt(i)<='z') || (std_ID.charAt(i)>='0' && std_ID.charAt(i)<='9') || (std_ID.charAt(i) == '-') || (std_ID.charAt(i) =='_'))
                        {

                        }
                        else if((std_ID.charAt(0)=='-') || (std_ID.charAt(0)=='_') || (std_ID.charAt(std_ID.length()-1)=='-') || (std_ID.charAt(std_ID.length()-1)=='_'))
                        {
                            throw new IDException();
                        }
                        else
                        {
                            throw new IDException();
                        }
                    }

                    /*
                    if(password.length()<8)
                    {
                        throw new passwordException();
                    }

                     */


                    
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");

                        // here library_managment_system is MYSQL database name, root is username and maadi192000 is password

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");


                        //    This code is for Inserting record in MySql DataBase

                        String query = "INSERT INTO `library_managment_system`.`students` (`student_id`, `student_name`, `program`, `semester`, `batch`) VALUES ('" + Integer.parseInt(std_ID) + "' , '" + std_name + "' , '" + program + "' , '"+ semester + "', '" + batch + "' );" ;
                        Statement statement = con.createStatement();

                        int count = statement.executeUpdate(query);
                        if(count > 0)
                        {
                            JOptionPane.showMessageDialog(null , "Now you Set Your Password that is used for your Login");
                        }

                        con.close();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null , "Still Your account is not saved in our Database");
                        // JOptionPane.showMessageDialog(null , e.getMessage());
                    }

                    

                }


                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }

                currentFrame.setVisible(false);
                try {
                    new PasswordSetting().setVisible(true);
                } catch (EmptyFieldsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
