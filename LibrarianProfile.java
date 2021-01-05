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
import javax.swing.table.JTableHeader;

import static java.awt.image.ImageObserver.ALLBITS;

class LibrarianProfile extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel student_pro_label,footer_label;
    private JPanel header,footer,center;
    private Font font1,font2,font3;
    private Container c;
    private JMenuBar mb;
    private JMenu home,student_profile,show_books,librarianMenu,book_issuance,help,about,logout ;
    private JMenuItem logIn, create_account,show_student_profile,avaialabe_books,librarian_pro,books,contact_us,description_LMS,confirm,no;
    private JScrollPane scrollPane ;
    private JTable librarian ;
    LibrarianProfile()
    {

        frame=new JFrame();
        font1=new Font("Arial", ALLBITS, 16);

        font2=new Font("Matura MT Script Capitals",ALLBITS,28);
        font3=new Font("Arial",ALLBITS,14);


        c = frame.getContentPane();

        student_pro_label=new JLabel("Librarian Profile");

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
        student_profile = new JMenu("Student");
        show_books=new JMenu("Show Books");
        librarianMenu=new JMenu("Librarian");
        book_issuance=new JMenu("Book Issuance");
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
        librarianMenu.add(librarian_pro);
        book_issuance.add(books);
        help.add(contact_us);
        about.add(description_LMS);
        logout.add(confirm);
        logout.add(no);

        //adding JMenu on MenuBar objects namely as mb
        mb.add(home);
        mb.add(student_profile);
        mb.add(show_books);
        mb.add(librarianMenu);
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
                    new LogoutConfirmation() ;
                    // new StudentLogin();

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
                    new CreateAccountFrame();
                } catch (Exception ex) {

                }
                frame.dispose();
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
                frame.dispose();
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
                    // call BooksInfo class here
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
                    //  call LibrarianProfile class here ;
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
                    // call ContactUS class
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
                    // call AboutLMS class to see the description about LMS
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
                    // call LogoutConfirmation class
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
                    // call same class LibrarianProfile in order to stay here
                    // new LibrarianProfile();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        // For Adding table logic begin from here JDBC
        int dim1 = 0 ;
        String columns [] = {"librarian_id" , "librarian_name" , "salary" , "timings"};

        Border border = BorderFactory.createLineBorder(Color.WHITE ,3);
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            // here plms is MYSQL database name, root is username and maadi192000 is password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment_system","root","maadi192000");
            Statement stmt = con.createStatement();

            //Retrieving the data from plms.students table
            ResultSet rs = stmt.executeQuery("Select  * from `library_managment_system`.`librarian`;");

            while(rs.next())
            {
                ++dim1 ;
            }

            String librarianRecords [][] = new String[dim1][4] ;

            rs = stmt.executeQuery("Select  * from `library_managment_system`.`librarian`;");

            int index = 0 ;
            while (rs.next())
            {
                librarianRecords[index][0] = Integer.toString(rs.getInt(1));
                librarianRecords[index][1] = rs.getString(2) ;
                librarianRecords[index][2] = rs.getString(3) ;
                librarianRecords[index][3] = String.valueOf(rs.getTime(4));
                ++index ;
            }

            librarian = new JTable(librarianRecords , columns) ;
            librarian.setBounds(200 , 200 , 400 , 500);

            librarian.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            librarian.setBounds(200 , 200 , 400 , 500);

            Font font = new Font("Verdana", Font.PLAIN, 12);
            librarian.setFont(font);
            librarian.setRowHeight(30);


            Font headerFont = new Font("Calibri", Font.PLAIN, 18);

            JTableHeader tableHeader = librarian.getTableHeader();

            tableHeader.setFont(headerFont);
            tableHeader.setBackground(Color.black);
            tableHeader.setForeground(Color.white);

            Border border2 = BorderFactory.createLineBorder(Color.GRAY ,120);
            scrollPane = new JScrollPane(librarian) ;
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

        /*

        String librarianRecords [][] = new String[dim1][5] ;
        librarian = new JTable(librarianRecords , columns) ;
        librarian.setBounds(200 , 200 , 400 , 500);


        Border border2 = BorderFactory.createLineBorder(Color.BLACK ,3);
        scrollPane = new JScrollPane(librarian) ;
        //scrollPane.setSize(2100,1900);
        //scrollPane.setLocation(1750,200);

        scrollPane.setBorder(border2);

         */


        header.setBackground(new Color(154,189,106));
        //setting bounds for header panel to aj just lable student profile
        header.setBounds(1,5,1280,50);
        header.add(student_pro_label);

        center.add(scrollPane);
        center.setLayout(new GridLayout(1,1));

        footer.setBounds(1,50,1080,30);
        footer.add(footer_label);
        footer.setFont(font3);
        footer.setBackground(new Color(154,189,106));

        // c.add(header,BorderLayout.NORTH);
        c.add(header);
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
        frame.setTitle("Librarian Profile");

    }

    /*
    public static void main(String args[]) throws Exception
    {
        new LibrarianProfile();
    }

     */

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
