package finalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.Border;

import static java.awt.image.ImageObserver.ALLBITS;

class BookIssuance extends JFrame implements ActionListener
{

    private JFrame frame;
    private JLabel book_issuance_label,footer_label,librarian_id_label,book_id_label, student_id_label ;
    private JPanel header,footer,center;
    private Font font1,font2,font3,font4, font5;
    private Container c;

    private JMenuBar mb;
    private JMenu home,student_profile,show_books,librarian,book_issuance,help,about,logout ;
    private JMenuItem logIn, create_account,show_student_profile,avaialabe_books,librarian_pro,books,contact_us,description_LMS,confirm,no;
    private JTextField librarian_id,book_id, student_id;
    private JButton issue;

    String b_id, lib_id, std_id;

    BookIssuance()
    {

        frame=new JFrame();
        font1=new Font("Arial", ALLBITS, 16);

        font2=new Font("Matura MT Script Capitals",ALLBITS,28);
        font3=new Font("Arial",ALLBITS,14);
        font4=new Font("Maura MT Script Capitals",ALLBITS,22);
        font5=new Font("Arial",ALLBITS,20);

        c = frame.getContentPane();

        book_issuance_label=new JLabel("Book Issuance");

        book_issuance_label.setFont(font2);
        book_issuance_label.setForeground(Color.black);

        librarian_id_label=new JLabel("Librarian ID:");
        librarian_id_label.setFont(font4);
        librarian_id_label.setForeground(Color.black);


        student_id_label=new JLabel("Student ID:");
        student_id_label.setFont(font4);
        student_id_label.setForeground(Color.black);

        book_id_label=new JLabel("Book ID:");
        book_id_label.setFont(font4);
        book_id_label.setForeground(Color.black);

        issue=new JButton("ISSUE");

        footer_label=new JLabel("This LMS is Developed By Hammad and Akram");
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //icon = Toolkit.getDefaultToolkit().getImage("LMS.png");
        book_id=new JTextField();
        librarian_id=new JTextField();
        student_id=new JTextField();

        header=new JPanel();
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

        //adding JMenu on MenuBar objects namely as mb
        mb.add(home);
        mb.add(student_profile);
        mb.add(show_books);
        mb.add(librarian);
        mb.add(book_issuance);
        mb.add(help);
        mb.add(about);
        var add = mb.add(logout);


        //apply action listener on login JMenuItem by Lambda Expression
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new LogoutConfirmation() ;

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
                    new LogoutConfirmation();
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
                    new StudentProfile();
                } catch (Exception ex) {

                }
                // frame.dispose();
            }
        });

        // This is not available Before
        avaialabe_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new BooksInfo();
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
                    new BookIssuance();
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
                    new LibrarianProfile();
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
                    new ContactUs();
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
                    new AboutLMS();
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
                    new LogoutConfirmation();
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
        // Action listener page
        issue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Here is the BACK-end logic starts for the BOOK Issuance (Connection with MySQL DATABASE)

                        b_id = book_id.getText() ;
                        lib_id = librarian_id.getText() ;
                        std_id = student_id.getText() ;

                        if (b_id.length() == 0 || lib_id.length() == 0 || std_id.length() == 0)
                        {
                            throw new EmptyFieldsException();
                        }



                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // here plms is MYSQL database name, root is username and maadi192000 is password
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");

                        // ResultSet rs = stmt.executeQuery("SELECT * FROM `library_managment_system`.`students` INNER JOIN `library_managment_system`.`books_details`");
                        String query1 = "INSERT INTO `library_managment_system`.`books_details` (`return_date`, `book_id`, `librarian_id`, `student_id`) VALUES (DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 7 DAY), '" + Integer.parseInt(b_id) + "' , '" + Integer.parseInt(lib_id) + "' , '" + Integer.parseInt(std_id) + "');";
                        String query2 = "UPDATE `library_managment_system`.`accounts` SET reserved_books = reserved_books+1 WHERE student_name='"+ StudentLogin.name+"';" ;

                        Statement statement = con.createStatement();

                        int count = statement.executeUpdate(query1); // this executeUpdate is for Issuaing a new book by a specific student account
                        if (count > 0) {
                            JOptionPane.showMessageDialog(null, "Your book Has been issued!!! \n If you want to save changes then \n you again login to your acount \n with your Name and password");
                            // JOptionPane.showMessageDialog(null, "If you want to save changes then \n you again login to your acount \n with your Name and password");
                            statement.executeUpdate(query2) ; // this execute is for updating the books reserved by specific student account

                            new LogoutConfirmation() ;
                        }
                        con.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
                frame.dispose();
            }
        });


        header.setBackground(new Color(244,247,191));
        //setting bounds for header panel to aj just lable student profile
        header.setBounds(1,5,1080,50);
        header.add(book_issuance_label);

        book_id.setBounds(280 ,109,250,30); // book id TextField
        librarian_id.setBounds(280 ,159,250,30); // librarian TextField
        student_id.setBounds(280 ,209,250,30); // student id textfield

        book_id.setFont(font1);
        librarian_id.setFont(font1);
        student_id.setFont(font1);
        // tf3.setBounds(650 ,390,250,40);

        book_id_label.setBounds(150,70,200,110);
        librarian_id_label.setBounds(150,150,200,50);
        student_id_label.setBounds(150,200,200,50);


        Border border2 = BorderFactory.createLineBorder(Color.WHITE ,3);
        issue.setBounds(250,290,100,40);
        issue.setFont(font5);
        issue.setForeground(Color.white);
        issue.setBackground(Color.black);



        center.add(book_id_label);
        center.add(book_id);
        center.add(librarian_id_label);
        center.add(librarian_id);
        center.add(student_id_label) ;
        center.add(student_id) ;
        center.add(issue);


        center.setLayout(null);

        footer.setBounds(1,50,1080,100);

        footer.add(footer_label);
        footer.setFont(font3);
        footer.setBackground(new Color(244,247,191));

        // c.add(header,BorderLayout.NORTH);
        c.add(header,BorderLayout.NORTH);
        c.add(center,BorderLayout.CENTER);
        c.add(footer,BorderLayout.SOUTH);
        //c.add(center,BorderLayout.CENTER);
        //c.add(footer,BorderLayout.SOUTH);
        //c.setBackground(Color.gray);


        // c.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        // c.setLayout(new GridLayout(4, 1));
        frame.setVisible(true);
        frame.setJMenuBar(mb);
        frame.setSize(700,500);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Book Issuance");
        frame.setLocationRelativeTo(null);

    }

    //private ImageIcon createImageIcon(String iconjpg, String a_pretty_but_meaningless_splat) {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    /*public static void main(String args[]){
        new BookIssuance();
    }*/

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

