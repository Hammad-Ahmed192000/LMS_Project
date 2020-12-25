
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class StudentProfile extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel student_pro_label,footer_label,image_label;
    private JPanel header,footer;// center
    private Font font1,font2,font3;
    private Container c;
   // private ImageIcon imgIcon,imgIcon2;
   // private Image img, newimg,icon;
    private JMenuBar mb;
    private JMenu home,show_books,librarian,book_issuance,help,about,logout ;
    private JMenuItem logIn, create_account,avaialabe_books,librarian_pro,books,contact_us,description_LMS,confirm,no;
    // private Insets inset;
    // private Dimension size;

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
        //center=new JPanel();
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


        //apply action listener on login JMenuItem by Lambda Expression
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page

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
                frame.dispose();
            }
        });

        books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page

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
                    new AboutLMS();
                } catch (Exception ex) {

                }
               // frame.dispose();
            }
        });
        contact_us.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new AboutLMS();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        description_LMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new AboutLMS();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new AboutLMS();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // calll login page
                    new AboutLMS();
                } catch (Exception ex) {

                }
                frame.dispose();
            }
        });

        //header.add(label1);
        header.add(student_pro_label);
        header.setBackground(new Color(111,120,185));

        //center.setLayout(new FlowLayout());
       // center.add(table);

        footer.add(footer_label);
        footer.setFont(font3);
        footer.setBackground(new Color(111,120,185));


        c.add(header,BorderLayout.NORTH);
        //c.add(center,BorderLayout.CENTER);
        c.add(footer,BorderLayout.SOUTH);
        //c.setBackground(Color.gray);


        // c.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        // c.setLayout(new GridLayout(4, 1));
        frame.setVisible(true);
        frame.setJMenuBar(mb);
        //frame.setIconImage(icon);
        //frame.pack();
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        //frame.setBounds(200, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Profile");

    }

    //private ImageIcon createImageIcon(String iconjpg, String a_pretty_but_meaningless_splat) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    public static void main(String args[]){
        new StudentProfile();
    }

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
