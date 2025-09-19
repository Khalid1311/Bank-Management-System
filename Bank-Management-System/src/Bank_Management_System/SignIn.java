package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignIn implements ActionListener {

    JFrame frame;
    Container C;
    JPanel panel;
    JLabel lb1, lb2, lb3,lb4,bankname, message, accnumlb, pinlb, adminlb, adminPasslb;
    JTextField accField, adminField;
    JPasswordField pinNum, adminpass;
    JToggleButton show;
    JButton admin, customer, signUp, signIn, clear, forgot;
    JSeparator separator;

    String Pin;

    SignIn() {

        frame = new JFrame();
        frame.setSize(750, 370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setLayout(null);
        C.setBackground(new Color(240, 245, 250));

        panel = new JPanel();
        panel.setBounds(0, 0, 270, 400);
        panel.setBackground(new Color(52, 152, 219));
        panel.setLayout(null);

        lb1 = new JLabel("Welcome to", JLabel.CENTER);
        lb1.setBounds(20, 90, 230, 25);
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lb1.setForeground(Color.WHITE);

        lb2 = new JLabel("Bank Management", JLabel.CENTER);
        lb2.setBounds(20, 120, 230, 30);
        lb2.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lb2.setForeground(Color.WHITE);

        message = new JLabel("If you don’t have an account");
        message.setBounds(40, 230, 200, 20);
        message.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        message.setForeground(Color.WHITE);

        signUp = new JButton("Sign Up");
        signUp.setBounds(80, 260, 110, 30);
        signUp.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signUp.setBackground(new Color(41, 128, 185));
        signUp.setForeground(Color.WHITE);
        signUp.setFocusPainted(false);
        signUp.setBorder(BorderFactory.createEmptyBorder());
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.addActionListener(this);

        bankname = new JLabel("Bank Management System");
        bankname.setBounds(300, 5, 400, 40);
        bankname.setFont(new Font("Segoe UI", Font.BOLD, 24));
        bankname.setForeground(new Color(44, 62, 80));
        
        lb3 = new JLabel("Customer Log In");
        lb3.setBounds(420,60,150, 20);
        lb3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lb3.setForeground(new Color(44, 62, 80));
        
        lb4 = new JLabel("Admin Log In");
        lb4.setBounds(420,60,150, 20);
        lb4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lb4.setForeground(new Color(44, 62, 80));
        lb4.setVisible(false);

        admin = new JButton("Admin");
        admin.setBounds(620, 10, 100, 28);
        admin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        admin.setBackground(new Color(230, 230, 230));
        admin.setFocusPainted(false);
        admin.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        admin.addActionListener(this);

        customer = new JButton("Customer");
        customer.setBounds(620, 10, 100, 28);
        customer.setFont(new Font("Segoe UI", Font.BOLD, 13));
        customer.setBackground(new Color(230, 230, 230));
        customer.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        customer.setVisible(false);
        customer.setEnabled(false);
        customer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        customer.addActionListener(this);

        accnumlb = new JLabel("Account Number");
        accnumlb.setBounds(310, 100, 150, 25);
        accnumlb.setFont(new Font("Segoe UI", Font.BOLD, 15));
        accnumlb.setForeground(new Color(44, 62, 80));

        adminlb = new JLabel("Admin ID");
        adminlb.setBounds(310, 100, 150, 25);
        adminlb.setFont(new Font("Segoe UI", Font.BOLD, 15));
        adminlb.setVisible(false);

        accField = new JTextField();
        accField.setBounds(465, 100, 170, 28);
        accField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accField.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        adminField = new JTextField();
        adminField.setBounds(465, 100, 170, 28);
        adminField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        adminField.setEnabled(false);
        adminField.setVisible(false);
        adminField.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        pinlb = new JLabel("Pin Number");
        pinlb.setBounds(310, 140, 150, 25);
        pinlb.setFont(new Font("Segoe UI", Font.BOLD, 15));
        pinlb.setForeground(new Color(44, 62, 80));

        adminPasslb = new JLabel("Password");
        adminPasslb.setBounds(310, 140, 150, 25);
        adminPasslb.setFont(new Font("Segoe UI", Font.BOLD, 15));
        adminPasslb.setVisible(false);

        pinNum = new JPasswordField();
        pinNum.setBounds(465, 140, 170, 28);
        pinNum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pinNum.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        adminpass = new JPasswordField();
        adminpass.setBounds(465, 140, 170, 28);
        adminpass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        adminpass.setEnabled(false);
        adminpass.setVisible(false);
        adminpass.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));

        show = new JToggleButton("Show");
        show.setBounds(640, 140, 70, 28);
        show.setBackground(new Color(236, 240, 241));
        show.setFocusPainted(false);
        show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        show.addActionListener(this);

        forgot = new JButton("Forgot Pin?");
        forgot.setBounds(290, 165, 120, 20);
        forgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        forgot.setForeground(new Color(41, 128, 185));
        forgot.setContentAreaFilled(false);
        forgot.setBorder(null);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgot.addActionListener(this);

        separator = new JSeparator();
        separator.setBounds(310, 190, 80, 3);
        separator.setForeground(new Color(127, 140, 141));

        signIn = new JButton("Sign In");
        signIn.setBounds(380, 230, 110, 30);
        signIn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        signIn.setBackground(new Color(46, 204, 113));
        signIn.setForeground(Color.WHITE);
        signIn.setFocusPainted(false);
        signIn.setBorder(BorderFactory.createEmptyBorder());
        signIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signIn.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(510, 230, 110, 30);
        clear.setFont(new Font("Segoe UI", Font.BOLD, 15));
        clear.setBackground(new Color(231, 76, 60));
        clear.setForeground(Color.WHITE);
        clear.setFocusPainted(false);
        clear.setBorder(BorderFactory.createEmptyBorder());
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.addActionListener(this);

        panel.add(message);
        panel.add(signUp);
        panel.add(lb1);
        panel.add(lb2);

        C.add(bankname);
        C.add(panel);
        C.add(admin);
        C.add(customer);
        C.add(accnumlb);
        C.add(adminlb);
        C.add(accField);
        C.add(adminField);
        C.add(pinlb);
        C.add(lb3);
        C.add(lb4);
        C.add(adminPasslb);
        C.add(pinNum);
        C.add(adminpass);
        C.add(show);
        C.add(forgot);
        C.add(separator);
        C.add(signIn);
        C.add(clear);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == admin) {
            adminlb.setVisible(true);
            adminPasslb.setVisible(true);
            adminField.setVisible(true);
            adminField.setEnabled(true);
            adminpass.setVisible(true);
            adminpass.setEnabled(true);
            lb4.setVisible(true);
            lb3.setVisible(false);
            accnumlb.setVisible(false);
            accField.setVisible(false);
            accField.setEnabled(false);
            forgot.setEnabled(false);
            forgot.setVisible(false);
            separator.setVisible(false);
            pinlb.setVisible(false);
            pinNum.setVisible(false);
            pinNum.setEnabled(false);
            signUp.setVisible(false);
            message.setVisible(false);
            admin.setVisible(false);
            customer.setVisible(true);
            customer.setEnabled(true);
        } else if (e.getSource() == customer) {
            accnumlb.setVisible(true);
            accField.setVisible(true);
            accField.setEnabled(true);
            pinlb.setVisible(true);
            pinNum.setVisible(true);
            pinNum.setEnabled(true);
            signUp.setVisible(true);
            message.setVisible(true);
            forgot.setEnabled(true);
            forgot.setVisible(true);
            separator.setVisible(true);
            lb4.setVisible(false);
            lb3.setVisible(true);
            adminlb.setVisible(false);
            adminPasslb.setVisible(false);
            adminField.setVisible(false);
            adminField.setEnabled(false);
            adminpass.setVisible(false);
            adminpass.setEnabled(false);
            admin.setVisible(true);
            customer.setVisible(false);
        } else if (e.getSource() == clear) {
            if (!accField.getText().isEmpty() || pinNum.getPassword().length > 0) {
                accField.setText("");
                pinNum.setText("");
            } else if (!adminField.getText().isEmpty() || adminpass.getPassword().length > 0) {
                adminField.setText("");
                adminpass.setText("");
            }
        } else if (e.getSource() == forgot) {
            if (!accField.getText().isEmpty()) {
                String account = accField.getText();
                if (checkUser(account)) {
                    new ForgotPin(account);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry! No account found with this Account Number."
                            + "\nPlease check your Account Number and try again.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter the account number");
            }
        } else if (e.getSource() == show) {
            if (show.isSelected()) {
                pinNum.setEchoChar((char) 0);
                adminpass.setEchoChar((char) 0);
                show.setText("Hide");
            } else {
                pinNum.setEchoChar('\u2022');
                adminpass.setEchoChar('\u2022');
                show.setText("Show");
            }
        } else if (e.getSource() == signUp) {
            new Registration_Page();
            frame.dispose();
        } else if (e.getSource() == signIn) {
            if (adminField.getText().equals("admin1311") && String.valueOf(adminpass.getPassword()).equals("1311")) {
                new Admin_Panel();
                frame.dispose();
                return;
            }

            if (!accField.getText().isEmpty() && pinNum.getPassword().length > 0) {
                String AccountNumber = accField.getText();
                String pin = String.valueOf(pinNum.getPassword());

                if (checkUser(AccountNumber)) {
                    if (pin.equals(Pin)) {
                        new CustomerHome(AccountNumber, Pin);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid PIN", null, JOptionPane.ERROR_MESSAGE);
                    }
                } else if (checkNewUser(AccountNumber)) {
                    JOptionPane.showMessageDialog(null, "Your registration is under review.\nPlease wait for admin approval."
                            + "Pending Approval", null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry! No account found with this Account Number."
                            + "\nPlease check your Account Number and try again.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    boolean checkUser(String account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT account_number,Pin FROM Customer_Account WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, account);
            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                Pin = rs.getString("Pin");
                rs.close();
                preparedstatement.close();
                connection.connection.close();
                return true;
            }
            rs.close();
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    boolean checkNewUser(String account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT account_number FROM Registration WHERE account_number = ?";
        try {
            PreparedStatement ps = connection.connection.prepareStatement(query);
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rs.close();
                ps.close();
                connection.connection.close();
                return true;
            }
            rs.close();
            ps.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        new SignIn();
    }
}
