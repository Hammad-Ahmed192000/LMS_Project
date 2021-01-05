package finalProject;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import static java.awt.image.ImageObserver.ALLBITS;

class IssuedBooksRecord extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel student_pro_label,footer_label;
    private JPanel header,middle,footer,center;
    private Font font1,font2,font3;
    private Container c;
    private JMenuBar mb;
    private JMenu home,student_profile,show_books,librarian,book_issuance,help,about,logout,issued_books ;
    private JMenuItem logIn, create_account,show_student_profile,avaialabe_books,librarian_pro,books,contact_us,description_LMS,confirm,no,issue_book_item;
    private JScrollPane scrollPane ;
    private JTable students;


    IssuedBooksRecord()
    {

        frame=new JFrame();
        font1=new Font("Arial", ALLBITS, 16);

        font2=new Font("Matura MT Script Capitals",ALLBITS,28);
        font3=new Font("Arial",ALLBITS,14);


        c = frame.getContentPane();

        student_pro_label=new JLabel("Records of Issued Books");

        student_pro_label.setFont(font2);
        student_pro_label.setForeground(Color.black);

        //header_label_issued_books_record=new JLabel("Details of Issued Books");

        //header_label_issued_books_record.setFont(font2);
        //header_label_issued_books_record.setForeground(Color.black);

        footer_label=new JLabel("This LMS is Developed By Hammad and Akram");
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //icon = Toolkit.getDefaultToolkit().getImage("LMS.png");

        header=new JPanel();
        //middle=new JPanel();
        center=new JPanel();
        footer=new JPanel();
        mb=new JMenuBar();
        home=new JMenu("Home");
        student_profile=new JMenu("Student");
        show_books=new JMenu("Books");
        librarian=new JMenu("Librarian");
        book_issuance=new JMenu("Issuance");
        help=new JMenu("Help");
        about=new JMenu("About");
        logout=new JMenu("Logout");

        issued_books=new JMenu("Issued_Books");
        //issued_books.add(Box.createHorizontalGlue());
        //issued_books.setAlignmentX(Box.RIGHT_ALIGNMENT);

        logIn = new JMenuItem("login");
        create_account=new JMenuItem("Create Account");
        show_student_profile=new JMenuItem("Student Profile");

        avaialabe_books=new JMenuItem("Available Books");
        librarian_pro=new JMenuItem("Librarian Profile");
        books=new JMenuItem("Books for Issuance");
        contact_us=new JMenuItem("Contact Us ");
        description_LMS=new JMenuItem("Description about LMS");
        confirm=new JMenuItem("Confirm");
        no=new JMenuItem("No");
        issue_book_item=new JMenuItem("Issued_Books_Record");

        //issue_book_item.add(Box.createHorizontalGlue());

        //adding JMenuItems on JMenu objects
        home.add(logIn);
        home.add(create_account);
        student_profile.add(show_student_profile);
        show_books.add(avaialabe_books);
        librarian.add(librarian_pro);
        book_issuance.add(books);
        help.add(contact_us);
        about.add(description_LMS);
        logout.add(confirm);
        logout.add(no);

        issued_books.add(Box.createHorizontalGlue());
        issued_books.add(issue_book_item);
        issued_books.setMnemonic(KeyEvent.VK_I);

        //
        issued_books.revalidate();

        //adding JMenu on MenuBar objects namely as mb
        mb.add(home);
        mb.add(student_profile);
        mb.add(show_books);
        mb.add(librarian);
        mb.add(book_issuance);
        mb.add(help);
        mb.add(about);
        var add = mb.add(logout);
        //issued_books.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mb.add(issued_books);
        //mb.add(Box.createHorizontalGlue());


        //apply action listener on login JMenuItem by Lambda Expression
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    //new LogoutConfirmation() ;

                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        create_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    //new AboutLMS();
                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });

        show_student_profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call StudentProfile here
                    //new StudentProfile();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        // This is not available Before
        avaialabe_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    //new BooksInfo();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        // Here We add/CAll the Issuance_Book Table
        books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    //new BooksInfo();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        librarian_pro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //  call show books class here ;
                    //new LibrarianProfile();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        contact_us.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call ContactUs here
                    //new ContactUs();
                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });
        description_LMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call AboutLMS here
                    //new AboutLMS();
                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call LogoutConfirmation here
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
                    // call login page

                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });

        issue_book_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // call login page

                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });


        int dim1 = 0 ;
        String columns [] = {"student_name" , "books_details_id" , "book_name" , "book_ISBN", "issue_date", "return_date" , "librarian_name"};

        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);


        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // here plms is MYSQL database name, root is username and maadi192000 is password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");
            Statement stmt = con.createStatement();


            //     Here the Modification Starts For Specific Student Profile


            //Retrieving the data from library_managment_system.students table
            ResultSet rs = stmt.executeQuery("SELECT * FROM `library_managment_system`.`books_details` bd INNER JOIN books b USING (book_id) INNER JOIN librarian USING (librarian_id) INNER JOIN students USING (student_id);");

            while(rs.next())
            {
                dim1++ ;
            }



            String studentsRecords [][] = new String[dim1][7] ;

            // StudentLogin.name = StudentLogin.tf.getText();
            // StudentLogin.password = new String(StudentLogin.pF.getPassword());


            String Studentname = StudentLogin.name ;
            // String Studentpassword = StudentLogin.password ;

            // rs = stmt.executeQuery("Select  * from `library_managment_system`.`students`;");
            // rs = stmt.executeQuery("SELECT * FROM `library_managment_system`.`students` INNER JOIN `library_managment_system`.`accounts` USING (student_id, student_name);");
            rs = stmt.executeQuery("SELECT std.student_name, bd.books_details_id, b.book_name, b.book_ISBN, bd.issue_date, bd.return_date, l.librarian_name FROM `library_managment_system`.`books_details` bd INNER JOIN `library_managment_system`.`books` b USING (book_id) INNER JOIN `library_managment_system`.`librarian` l USING (librarian_id) INNER JOIN `library_managment_system`.`students` std ON bd.student_id = std.student_id AND std.student_name = '"+ Studentname +"';");
            int index = 0 ;
            while (rs.next())
            {
                // String columns [] = {"student_name" , "books_details_id" , "book_name" , "book_ISBN", "issue_date", "return_date" , "librarian_name"};
                studentsRecords[index][0] = rs.getString(1);
                studentsRecords[index][1] = Integer.toString(rs.getInt(2)); ;
                studentsRecords[index][2] = rs.getString(3) ;
                studentsRecords[index][3] = rs.getString(4) ;
                studentsRecords[index][4] = String.valueOf(rs.getTimestamp(5));
                studentsRecords[index][5] = String.valueOf(rs.getTimestamp(6));
                studentsRecords[index][6] = rs.getString(7) ;
                ++index ;
            }

            students = new JTable(studentsRecords , columns) ;
            students.setBounds(200 , 200, 600 , 500);
            students.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            Font font = new Font("Verdana", Font.PLAIN, 12);
            students.setFont(font);
            students.setRowHeight(30);



            Font headerFont = new Font("Calibri", Font.PLAIN, 18);

            JTableHeader tableHeader = students.getTableHeader();

            tableHeader.setFont(headerFont);
            tableHeader.setBackground(Color.black);
            tableHeader.setForeground(Color.white);


            // Border border2 = BorderFactory.createLineBorder(Color.BLACK ,3);
            //scrollPane = new JScrollPane(students) ;
            // scrollPane.setSize(1000,600);
            // scrollPane.setLocation(350,100);

            Border border2 = BorderFactory.createLineBorder(Color.WHITE ,100);
            scrollPane = new JScrollPane(students) ;
            scrollPane.setBorder(border2);


            // scrollPane.setBounds(200 , 200 , 400 , 500);

            stmt.close();
            con.close();

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , e);
        }

        header.setBackground(new Color(165,231,192));
        //setting bounds for header panel to aj just lable student profile
        header.setBounds(1,5,1400,50);
        header.add(student_pro_label);




        center.add(scrollPane);

        //middle.setBackground(new Color(111,120,185));
        //middle.setBounds(1,275,1080,60);
        //middle.add(header_label_issued_books_record);

        center.setLayout(new GridLayout(1,1));
        // Adding header_label for Issued-Books Record
        //header_label_issued_books_record.setBackground(new Color(111,120,185));
        //setting bounds for header panel to aj just lable student profile
        //header.setBounds(1,5,1080,50);
        //header_label_issued_books_record.setBounds(1,5,1080,50);

        //center.add(header);
        //center.add(middle);
        //adding new scrollPane
        //center.add(scrollPane1);

        footer.setBounds(1,50,1080,30);
        footer.add(footer_label);
        footer.setFont(font3);
        footer.setBackground(new Color(165,231,192));

        // c.add(header,BorderLayout.NORTH);
        c.add(header);

        //c.add(middle,BorderLayout.CENTER);

        c.add(center,BorderLayout.CENTER);
        c.add(footer,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setJMenuBar(mb);
        frame.setSize(1280,720);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Profile");

    }


    /*public static void main(String args[]){
        new IssuedBooksRecord();
    }

     */

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void actionPerformed2(ActionEvent e) {
        try {
            // new AboutLMS();
            //JOptionPane.showMessageDialog(null,"This is Desktop Application for Library Management System");
        } catch (Exception ignored) {

        }
        frame.dispose();
    }

}

