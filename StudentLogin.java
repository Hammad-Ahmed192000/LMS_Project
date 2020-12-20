package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class StudentLogin extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel studentLabel = new JLabel("STUDENT NAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField studentTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");




    StudentLogin() {
        setLayoutManager();
        //StudentLogin frame = new StudentLogin();
        setTitle("Student Login");
        setVisible(true);
        setSize(1350,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        studentLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        studentTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(studentLabel);
        container.add(passwordLabel);
        container.add(studentTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String studentText;
            String pwdText;
            studentText = studentTextField.getText();
            pwdText = passwordField.getText();
            if (studentText.equalsIgnoreCase("AKRAM") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Student name or Password");
            }

        }
        if (e.getSource() == resetButton) {
            studentTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
