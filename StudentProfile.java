import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.*;

import static java.awt.Label.*;

public class StudentProfile extends Frame{


    JMenu home,show_books,librarian,book_issuance,help,logout ;
    JMenuItem logIn, create_account;
    Container container;
    JLabel student_profile,background;
    ImageIcon icon;
    
    StudentProfile()
    {
        JFrame f= new JFrame("Student Profile");

        student_profile = new JLabel("Student Profile");
        student_profile.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        student_profile.setForeground(Color.BLACK);
        //Component add2 = f.add(student_profile, SwingConstants.CENTER);

        JMenuBar mb=new JMenuBar();
        home=new JMenu("Home");
        show_books=new JMenu("Show Books");
        librarian=new JMenu("Librarian");
        book_issuance=new JMenu("Book Issuance");
        help=new JMenu("Help");
        logout=new JMenu("Logout");

        logIn = new JMenuItem("login");
        create_account=new JMenuItem("Create Account");

        home.add(logIn);
        home.add(create_account);


        mb.add(home);
        mb.add(show_books);
        mb.add(librarian);
        mb.add(book_issuance);
        mb.add(help);
        var add = mb.add(logout);

        f.setJMenuBar(mb);
        
        // Here Action listeners will also be added to these JMenus
        
        
        
        //f.add(add2);
        //Component add1 = f.add(student_profile);

        // this code is for setting the BackGround.
        icon = new ImageIcon("background.png") ;
        background = new JLabel(icon) ;
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);

        background.add(student_profile);
        //background.add(separator) ;
        var add1 = f.add(background);

    // Here Table for student profile will be added 
        
        
        f.setSize(1280,850);
        f.setLayout(null);
        f.setVisible(true);

    }
   /* public static void main(String args[])
    {
        new StudentProfile();
    }
}*/
