package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerHome implements ActionListener {

    JFrame frame;
    Container C;
    JPanel header;
    JLabel namelb, Holdname, accNumlb, accNumber, balancelb, balance;
    JButton deposite, withdraw, loan, transfer, history, profile, logout;

    public static String transactions;
    String HolderName, AccountNumber, PinNumber, Balance;

    CustomerHome(String AccountNumber, String PinNumber) {

        this.AccountNumber = AccountNumber;
        this.PinNumber = PinNumber;

        SelfDeatil();

        frame = new JFrame("Customer Dashboard");
        frame.setSize(750, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        C = frame.getContentPane();
        C.setLayout(null);
        C.setBackground(new Color(240, 245, 250));

        header = new JPanel();
        header.setBounds(0, 0, 750, 120);
        header.setBackground(new Color(30, 58, 138));
        header.setLayout(null);

        namelb = new JLabel("Holder Name ");
        namelb.setBounds(80, 15, 200, 25);
        namelb.setFont(new Font("Cambria", Font.BOLD, 20));
        namelb.setForeground(Color.WHITE);

        Holdname = new JLabel(HolderName);
        Holdname.setBounds(260, 15, 250, 25);
        Holdname.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Holdname.setForeground(Color.YELLOW);

        accNumlb = new JLabel("Account Number");
        accNumlb.setBounds(80, 45, 200, 25);
        accNumlb.setFont(new Font("Cambria", Font.BOLD, 20));
        accNumlb.setForeground(Color.WHITE);

        accNumber = new JLabel(AccountNumber);
        accNumber.setBounds(260, 45, 250, 25);
        accNumber.setFont(new Font("Segoe UI", Font.BOLD, 20));
        accNumber.setForeground(Color.YELLOW);

        balancelb = new JLabel("Balance");
        balancelb.setBounds(80, 75, 200, 25);
        balancelb.setFont(new Font("Cambria", Font.BOLD, 20));
        balancelb.setForeground(Color.WHITE);

        balance = new JLabel(Balance);
        balance.setBounds(260, 75, 250, 25);
        balance.setFont(new Font("Segoe UI", Font.BOLD, 20));
        balance.setForeground(new Color(144, 238, 144));

        logout = new JButton("Log Out");
        logout.setBounds(620, 15, 100, 30);
        logout.setBackground(new Color(200, 0, 0));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 15));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.addActionListener(this);

        deposite = new JButton("Deposit");
        deposite.setBounds(70, 160, 180, 60);
        deposite.setBackground(new Color(25, 135, 84));
        deposite.setForeground(Color.WHITE);
        deposite.setFont(new Font("Segoe UI", Font.BOLD, 18));
        deposite.setFocusPainted(false);
        deposite.setBorder(BorderFactory.createEmptyBorder());
        deposite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deposite.addActionListener(this);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(280, 160, 180, 60);
        withdraw.setBackground(new Color(220, 53, 69));
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Segoe UI", Font.BOLD, 18));
        withdraw.setFocusPainted(false);
        withdraw.setBorder(BorderFactory.createEmptyBorder());
        withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
        withdraw.addActionListener(this);

        loan = new JButton("Loan");
        loan.setBounds(490, 160, 180, 60);
        loan.setBackground(new Color(255, 193, 7));
        loan.setForeground(Color.WHITE);
        loan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        loan.setFocusPainted(false);
        loan.setBorder(BorderFactory.createEmptyBorder());
        loan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loan.addActionListener(this);

        transfer = new JButton("Transfer");
        transfer.setBounds(70, 260, 180, 60);
        transfer.setBackground(new Color(13, 110, 253));
        transfer.setForeground(Color.WHITE);
        transfer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        transfer.setFocusPainted(false);
        transfer.setBorder(BorderFactory.createEmptyBorder());
        transfer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transfer.addActionListener(this);

        history = new JButton("Transactions");
        history.setBounds(280, 260, 180, 60);
        history.setBackground(new Color(102, 16, 242));
        history.setForeground(Color.WHITE);
        history.setFont(new Font("Segoe UI", Font.BOLD, 18));
        history.setFocusPainted(false);
        history.setBorder(BorderFactory.createEmptyBorder());
        history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        history.addActionListener(this);

        profile = new JButton("Profile");
        profile.setBounds(490, 260, 180, 60);
        profile.setBackground(new Color(111, 66, 193));
        profile.setForeground(Color.WHITE);
        profile.setFont(new Font("Segoe UI", Font.BOLD, 18));
        profile.setFocusPainted(false);
        profile.setBorder(BorderFactory.createEmptyBorder());
        profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profile.addActionListener(this);

        header.add(namelb);
        header.add(Holdname);
        header.add(accNumlb);
        header.add(accNumber);
        header.add(balancelb);
        header.add(balance);
        header.add(logout);
        C.add(header);
        C.add(deposite);
        C.add(withdraw);
        C.add(loan);
        C.add(transfer);
        C.add(history);
        C.add(profile);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposite) {
            transactions = "Deposit";
            new Bank_Transactions(AccountNumber, HolderName, PinNumber, Balance);
            frame.dispose();
        } else if (e.getSource() == withdraw) {
            transactions = "Withdraw";
            new Bank_Transactions(AccountNumber, HolderName, PinNumber, Balance);
            frame.dispose();
        } else if (e.getSource() == loan) {
            transactions = "Loan";
            new Bank_Transactions(AccountNumber, HolderName, PinNumber, Balance);
            frame.dispose();
        } else if (e.getSource() == profile) {
            new My_Account(AccountNumber, PinNumber);
            frame.dispose();
        } else if (e.getSource() == transfer) {
            transactions = "Transfer";
            new Transfer(AccountNumber, HolderName, PinNumber, Balance);
            frame.dispose();
        } else if (e.getSource() == history) {
            new Transaction_History(AccountNumber, PinNumber);
            frame.dispose();
        } else if (e.getSource() == logout) {
            new SignIn();
            frame.dispose();
        }
    }

    void SelfDeatil() {
        DBConnection connection = new DBConnection();
        String quary = "SELECT Name,Balance FROM Customer_Account WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(quary);
            preparedstatement.setString(1, AccountNumber);
            ResultSet rs = preparedstatement.executeQuery();
            while (rs.next()) {
                HolderName = rs.getString("Name");
                Balance = rs.getString("Balance");
            }
            rs.close();
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
