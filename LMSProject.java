package finalProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LMSProject extends Frame
{
    JSeparator separator1 , separator2 ;
    JLabel label ;
    JLabel background ;
    ImageIcon icon ;
    JLabel l1;
    JButton bA = new JButton("New Account"),bL = new JButton("Login Account");
    LMSProject currentFrame = this;

    public LMSProject()
    {
        l1 = new JLabel("\"Library Managment System\"");
        l1.setLayout(null);

        label = new JLabel();
        label.setText("If you are new student you must create your account before login\n else click on Login Button");
        label.setForeground(Color.BLACK);
        label.setBounds(475,425,500,100);
        label.setFont(new Font("Aerial",Font.BOLD,14));
        label.setLayout(null);

        separator1 = new JSeparator() ;
        separator1.setBounds(475,500,480,100);
        separator1.setBackground(Color.WHITE);

        separator2 = new JSeparator() ;
        separator2.setBounds(475,450,480,100);
        separator2.setBackground(Color.WHITE);



        // this code is for setting the BackGround.
        icon = new ImageIcon("background.jpg") ;
        background = new JLabel(icon) ;
        background.setBounds(0 , 0 , 1350,850);
        background.setVisible(true);


        l1.setBounds(375,50,700,60);
        bA.setBounds(500,350,150,60);
        bL.setBounds(750,350,150,60);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        bA.setBorder(border);
        bL.setBorder(border);

        bA.setBackground(Color.WHITE);
        bL.setBackground(Color.WHITE);

        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Serif",Font.BOLD + Font.PLAIN,50));
        bA.setFont(new Font("Aerial",Font.BOLD,17));
        bL.setFont(new Font("Aerial",Font.BOLD,17));

        bA.addActionListener(new actions());
        bL.addActionListener(new actions());

        // add(backgroud);
        background.add(l1) ;
        background.add(bA) ;
        background.add(bL);
        background.add(separator1) ;
        background.add(label) ;
        background.add(separator2) ;
        add(background);

        /*
        add(l1);
        add(bA);
        add(bL);
        */


        setLayout(null);
        setTitle("Library Managment System");
        setSize(1350,850);
        setVisible(true);

        addWindowListener(new MyWindow());
    }

    private class actions implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            if(ae.getSource()==bA)
            {
                currentFrame.setVisible(false);
                new CreateAccountFrame();
            }
            else if(ae.getSource() == bL)
            {
                currentFrame.setVisible(false);
                new StudentLogin();
            }
        }
    }

    public static void main(String args[])
    {
        new LMSProject();
    }
}

