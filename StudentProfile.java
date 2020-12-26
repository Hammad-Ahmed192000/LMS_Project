package finalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

import static java.awt.image.ImageObserver.ALLBITS;

class StudentProfile extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel student_pro_label,footer_label;
    private JPanel header,footer,center;
    private Font font1,font2,font3;
    private Container c;
    private JMenuBar mb;
    private JMenu home,show_books,librarian,book_issuance,help,about,logout ;
    private JMenuItem logIn, create_account,avaialabe_books,librarian_pro,books,contact_us,description_LMS,confirm,no;
    private JScrollPane scrollPane ;
    private JTable students ;
    StudentProfile()
    {

        frame=new JFrame();
        font1=new Font("Arial", ALLBITS, 16);

        font2=new Font("Matura MT Script Capitals",ALLBITS,28);
        font3=new Font("Arial",ALLBITS,14);


        c = frame.getContentPane();

        student_pro_label=new JLabel("Student Profile");

        student_pro_label.setFont(font2);
        student_pro_label.setForeground(Color.black);

        footer_label=new JLabel("This LMS is Developed By Hammad and Akram");
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //icon = Toolkit.getDefaultToolkit().getImage("LMS.png");

        header=new JPanel();
        center=new JPanel();
        footer=new JPanel();
        mb=new JMenuBar();
        home=new JMenu("Home");
        show_books=new JMenu("Show Books");
        librarian=new JMenu("Librarian");
        book_issuance=new JMenu("Book Issuance");
        help=new JMenu("Help");
        about=new JMenu("About");
        logout=new JMenu("Logout");

        logIn = new JMenuItem("login");
        create_account=new JMenuItem("Create Account");

        avaialabe_books=new JMenuItem("Available Books");
        librarian_pro=new JMenuItem("Librarian Profile");
        books=new JMenuItem("Books for Issuance");
        contact_us=new JMenuItem("Contact Us ");
        description_LMS=new JMenuItem("Description about LMS");
        confirm=new JMenuItem("Confirm");
        no=new JMenuItem("No");

        //adding JMenuItems on JMenu objects
        home.add(logIn);
        home.add(create_account);
        show_books.add(avaialabe_books);
        librarian.add(librarian_pro);
        book_issuance.add(books);
        help.add(contact_us);
        about.add(description_LMS);
        logout.add(confirm);
        logout.add(no);

        //adding JMenu on MenuBar objects namely as mb
        mb.add(home);
        mb.add(show_books);
        mb.add(librarian);
        mb.add(book_issuance);
        mb.add(help);
        mb.add(about);
        var add = mb.add(logout);


        //apply action listener on login JMenuItem by Anonymously calling Actionlistener class inside addActionListener method
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call StudentLogin class here
                    //new StudentLogin();

                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        create_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call CreateAccountFrame class here
                    //new CreateAccountFrame();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call BooksInfo class here
                    // new BooksInfo();

                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        librarian_pro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //  call LibrarianProfile class here ;
                    //new LibrarianProfile();
                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });
        contact_us.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call ContactUS class
                    //new ContactUs();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        description_LMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call AboutLMS class to see the description about LMS
                    //new AboutLMS();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call LogoutConfirmation class
                    //new LogoutConfirmation();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call same class StudentProfile in order to stay here
                    new StudentProfile();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        // For Adding table logic begin from here JDBC
        int dim1 = 0 ;
        String columns [] = {"student_id" , "students_name" , "program" , "semester", "batch"};

        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // here plms is MYSQL database name, root is username and maadi192000 is password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");
            Statement stmt = con.createStatement();

            //Retrieving the data from plms.students table
            ResultSet rs = stmt.executeQuery("Select  * from `library_managment_system`.`students`;");

            while(rs.next())
            {
                ++dim1 ;
            }

            String studentsRecords [][] = new String[dim1][5] ;

            rs = stmt.executeQuery("Select  * from `library_managment_system`.`students`;");

            int index = 0 ;
            while (rs.next())
            {
                studentsRecords[index][0] = Integer.toString(rs.getInt(1));
                studentsRecords[index][1] = rs.getString(2) ;
                studentsRecords[index][2] = rs.getString(3) ;
                studentsRecords[index][3] = rs.getString(4) ;
                studentsRecords[index][4] = rs.getString(5) ;
                ++index ;
            }

            students = new JTable(studentsRecords , columns) ;
            students.setBounds(200 , 200 , 400 , 500);

            Border border2 = BorderFactory.createLineBorder(Color.BLACK ,3);
            scrollPane = new JScrollPane(students) ;
            scrollPane.setSize(700,500);
            scrollPane.setLocation(350,100);
            scrollPane.setBorder(border2);
            // scrollPane.setBounds(200 , 200 , 400 , 500);
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , e);
        }




        String studentsRecords [][] = new String[dim1][5] ;
        students = new JTable(studentsRecords , columns) ;
        students.setBounds(200 , 200 , 400 , 500);


        Border border2 = BorderFactory.createLineBorder(Color.BLACK ,3);
        scrollPane = new JScrollPane(students) ;
        scrollPane.setSize(700,500);
        scrollPane.setLocation(350,100);


        scrollPane.setBorder(border2);


        header.add(student_pro_label);
        header.setBackground(new Color(111,120,185));

        center.setLayout(new FlowLayout());
        center.add(scrollPane);

        footer.add(footer_label);
        footer.setFont(font3);
        footer.setBackground(new Color(111,120,185));

        c.add(header,BorderLayout.NORTH);
        c.add(center,BorderLayout.CENTER);
        c.add(footer,BorderLayout.SOUTH);
        //c.setBackground(Color.gray);


        // c.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        // c.setLayout(new GridLayout(4, 1));
        frame.setVisible(true);
        frame.setJMenuBar(mb);
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Profile");

    }

    //public static void main(String args[]){
     //new StudentProfile();
     //}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void actionPerformed2(ActionEvent e) {
        try {
            // new AboutLMS();
        } catch (Exception ignored) {

        }
        frame.dispose();
    }

}
