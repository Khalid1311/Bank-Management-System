package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Message implements ActionListener {

    JFrame frame;
    Container C;
    JLabel lb1, lb2, nameLabel, lb3, lb4, accountLabel, lb5, pinLabel, lb6, lb7, lb8, lb9, lb10;
    JButton ok;
    String Name, Account, Pin;

    Message() {

        loadLatestAccountInfo();

        frame = new JFrame();
        frame.setSize(650, 420);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(240, 245, 250));
        C.setLayout(null);

        lb1 = new JLabel("Registration Completed Successfully", JLabel.CENTER);
        lb1.setBounds(50, 20, 550, 30);
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lb1.setForeground(new Color(0, 51, 102));

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(50, 70, 550, 260);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 220), 2, true));

        lb2 = new JLabel("Dear Customer,");
        lb2.setBounds(40, 20, 150, 25);
        lb2.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        nameLabel = new JLabel(Name);
        nameLabel.setBounds(180, 20, 300, 25);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
        nameLabel.setForeground(new Color(0, 102, 204));

        lb3 = new JLabel("Your new account has been created.");
        lb3.setBounds(40, 50, 350, 25);
        lb3.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        lb4 = new JLabel("Account Number : ");
        lb4.setBounds(40, 90, 150, 25);
        lb4.setFont(new Font("Segoe UI", Font.BOLD, 15));

        accountLabel = new JLabel(Account);
        accountLabel.setBounds(200, 90, 300, 25);
        accountLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        accountLabel.setForeground(new Color(0, 102, 0));

        lb5 = new JLabel("PIN Number : ");
        lb5.setBounds(40, 120, 150, 25);
        lb5.setFont(new Font("Segoe UI", Font.BOLD, 15));

        pinLabel = new JLabel(Pin);
        pinLabel.setBounds(200, 120, 300, 25);
        pinLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pinLabel.setForeground(new Color(204, 0, 0));

        lb6 = new JLabel("Kindly secure your PIN and never share it with anyone.");
        lb6.setBounds(40, 150, 460, 25);
        lb6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lb6.setForeground(Color.RED);

        lb7 = new JLabel("Note :");
        lb7.setBounds(40, 180, 50, 25);
        lb7.setFont(new Font("Segoe UI", Font.BOLD, 15));

        lb8 = new JLabel("Your account is pending verification and requires admin approval.");
        lb8.setBounds(100, 180, 430, 25);
        lb8.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        lb9 = new JLabel("You will be able to access full banking services once approved.");
        lb9.setBounds(100, 200, 430, 25);
        lb9.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        lb10 = new JLabel("Thank you for choosing our bank.", JLabel.CENTER);
        lb10.setBounds(100, 230, 350, 25);
        lb10.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lb10.setForeground(new Color(0, 51, 102));

        card.add(lb2);
        card.add(nameLabel);
        card.add(lb3);
        card.add(lb4);
        card.add(accountLabel);
        card.add(lb5);
        card.add(pinLabel);
        card.add(lb6);
        card.add(lb7);
        card.add(lb8);
        card.add(lb9);
        card.add(lb10);

        ok = new JButton("OK");
        ok.setBounds(270, 340, 100, 30);
        ok.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ok.setBackground(new Color(0, 102, 204));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setBorder(BorderFactory.createEmptyBorder());
        ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ok.addActionListener(this);

        C.add(lb1);
        C.add(card);
        C.add(ok);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void loadLatestAccountInfo() {
        DBConnection connection = new DBConnection();
        String query = "SELECT account_number, Name, Pin FROM Registration ORDER BY account_number DESC LIMIT 1";
        try {
            Statement statement = connection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Name = rs.getString("Name");
                Account = rs.getString("account_number");
                Pin = rs.getString("Pin");
            }
            rs.close();
            statement.close();
            connection.connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        new SignIn();
        frame.dispose();
    }   
}
