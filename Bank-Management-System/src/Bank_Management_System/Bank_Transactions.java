package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Bank_Transactions implements ActionListener {

    JFrame frame;
    Container C;
    JPanel panel1;
    JLabel namelb, balancelb, HoldName, Balancelb, amountlb, headline;
    JTextField amountTf;
    JButton confirm, clear, back;

    String AccountNumber, HolderName, PinNumber, Balance;
    static String TimeDate;

    Bank_Transactions(String AccountNumber, String HolderName, String PinNumber, String Balance) {

        this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.PinNumber = PinNumber;
        this.Balance = Balance;

        frame = new JFrame();
        frame.setSize(750, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(240, 245, 250));
        C.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 280, 370);
        panel1.setBackground(new Color(0, 51, 102));
        panel1.setLayout(null);

        namelb = new JLabel("Holder Name");
        namelb.setBounds(20, 40, 200, 25);
        namelb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        namelb.setForeground(Color.WHITE);

        HoldName = new JLabel(HolderName);
        HoldName.setBounds(20, 70, 240, 25);
        HoldName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        HoldName.setForeground(Color.WHITE);

        balancelb = new JLabel("Balance ");
        balancelb.setBounds(20, 100, 150, 25);
        balancelb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        balancelb.setForeground(Color.WHITE);

        Balancelb = new JLabel(Balance);
        Balancelb.setBounds(20, 135, 150, 25);
        Balancelb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Balancelb.setForeground(Color.WHITE);

        back = new JButton("Back");
        back.setBounds(70, 250, 140, 35);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(0, 51, 102));
        back.setFocusPainted(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        headline = new JLabel(CustomerHome.transactions + " Balance");
        headline.setBounds(430, 15, 470, 35);
        headline.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headline.setForeground(new Color(0, 51, 102));

        amountlb = new JLabel("Enter Amount");
        amountlb.setBounds(340, 100, 200, 25);
        amountlb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        amountlb.setForeground(new Color(40, 40, 40));

        amountTf = new JTextField();
        amountTf.setBounds(340, 130, 250, 30);
        amountTf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        amountTf.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));

        confirm = new JButton(CustomerHome.transactions);
        confirm.setBounds(320, 250, 140, 35);
        confirm.setFont(new Font("Segoe UI", Font.BOLD, 16));
        confirm.setBackground(new Color(0, 153, 76));
        confirm.setForeground(Color.WHITE);
        confirm.setFocusPainted(false);
        confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirm.setBorder(null);
        confirm.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(490, 250, 140, 35);
        clear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        clear.setBackground(new Color(204, 0, 0));
        clear.setForeground(Color.WHITE);
        clear.setFocusPainted(false);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clear.setBorder(null);
        clear.addActionListener(this);

        panel1.add(namelb);
        panel1.add(HoldName);
        panel1.add(balancelb);
        panel1.add(Balancelb);
        panel1.add(back);

        C.add(headline);
        C.add(panel1);
        C.add(amountlb);
        C.add(amountTf);
        C.add(confirm);
        C.add(clear);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            amountTf.setText("");
        } else if (e.getSource() == back) {
            new CustomerHome(AccountNumber, PinNumber);
            frame.dispose();
        } else if (e.getSource() == confirm) {
            String pin = JOptionPane.showInputDialog(null, "Enter Your Pin Number : ");
            if (PinNumber.equals(pin)) {
                try {
                    int CurentBalance = Integer.parseInt(Balance);
                    int Amount = Integer.parseInt(amountTf.getText());
                    String Tx_id, type = "", purpose = "", money = "";

                    if (CustomerHome.transactions.equals("Deposit")) {
                        CurentBalance += Amount;
                        money = "+" + String.valueOf(Amount);
                        purpose = "Cash deposit";
                    } else if (CustomerHome.transactions.equals("Withdraw")) {
                        if (Amount <= CurentBalance) {
                            CurentBalance -= Amount;
                            money = "-" + String.valueOf(Amount);
                            purpose = "Cash withdrawal";
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                            amountTf.setText("");
                            return;
                        }
                    } else if (CustomerHome.transactions.equals("Loan")) {
                        purpose = "Personal use";
                        money = "+" + String.valueOf(Amount);
                    }
                    type = CustomerHome.transactions;
                    Tx_id = Transaction_Id();
                    History(AccountNumber, Tx_id, type, money, purpose);

                    Balance = String.valueOf(CurentBalance);
                    if (BalanceUpdate() && !CustomerHome.transactions.equals("Loan")) {
                        Balancelb.setText(Balance);
                    } else if (CustomerHome.transactions.equals("Loan")) {
                        LoanrequestAdd(money, purpose);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers only.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pin Number Incorrect.");
            }
            amountTf.setText("");
        }
    }

    boolean BalanceUpdate() {
        DBConnection connection = new DBConnection();
        String query = "UPDATE Customer_Account SET Balance = ? WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, Balance);
            preparedstatement.setString(2, AccountNumber);
            int update = preparedstatement.executeUpdate();

            if (update > 0) {
                JOptionPane.showMessageDialog(null, CustomerHome.transactions + " Successful");
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public static String Transaction_Id() {
        String id = "";
        SimpleDateFormat format = new SimpleDateFormat("yyddss");
        String date = format.format(new Date());

        Random rand = new Random();
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 4; i++) {
            int index = rand.nextInt(character.length());
            id += String.valueOf(character.charAt(index));
        }
        return "T" + date + id;
    }

    void LoanrequestAdd(String amount, String Purpose) {
        DBConnection connection = new DBConnection();
        String query = "INSERT INTO Loan_Request(account_number,Name,Loan_Balance,Purpose,Request_Time_Date)"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, AccountNumber);
            preparedstatement.setString(2, HolderName);          
            preparedstatement.setString(3, amount);
            preparedstatement.setString(4, Purpose);
            preparedstatement.setString(5, TimeDate);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void History(String account, String Tx_id, String type, String amount, String purpose) {
        DBConnection connection = new DBConnection();
        String query = "INSERT INTO Transaction_History (account_number,TX_Id,Type,Balance,Purpose,Status,Request_Time_Date,Time_Date)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss a");
        String time = format1.format(new Date());
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format2.format(new Date());
        TimeDate = time + " | " + date;

        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, account);
            preparedstatement.setString(2, Tx_id);
            preparedstatement.setString(3, type);
            preparedstatement.setString(4, amount);
            preparedstatement.setString(5, purpose);
            if (CustomerHome.transactions.equals("Loan")) {
                preparedstatement.setString(6, "Pending");
                preparedstatement.setString(7, TimeDate);
                preparedstatement.setString(8, "---");
            } else {
                preparedstatement.setString(6,"Successful");
                preparedstatement.setString(7, "---");
                preparedstatement.setString(8, TimeDate);
            }
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
