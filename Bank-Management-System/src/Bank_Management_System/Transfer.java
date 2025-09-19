package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transfer implements ActionListener {

    JFrame frame;
    Container C;
    JPanel panel1;
    JLabel headline, namelb, HoldName, accNumlb, accNumber, balancelb, balance, amountlb, transferaccNum;
    JButton home, confirm, clear;
    JTextField amountTf, transferNumber;

    String AccountNumber, HolderName, PinNumber, Balance, OtherBalance;

    Transfer(String AccountNumber, String HolderName, String PinNumber, String Balance) {

        this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.PinNumber = PinNumber;
        this.Balance = Balance;

        frame = new JFrame();
        frame.setSize(750, 370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setLayout(null);
        C.setBackground(new Color(240, 245, 250));

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 280, 370);
        panel1.setBackground(new Color(0, 51, 102));
        panel1.setLayout(null);

        headline = new JLabel("Transfer Balance", JLabel.CENTER);
        headline.setBounds(280, 15, 470, 35);
        headline.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headline.setForeground(new Color(0, 51, 102));

        namelb = new JLabel("Holder Name");
        namelb.setBounds(20, 40, 200, 25);
        namelb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        namelb.setForeground(Color.WHITE);

        HoldName = new JLabel(HolderName);
        HoldName.setBounds(20, 70, 240, 25);
        HoldName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        HoldName.setForeground(Color.WHITE);

        accNumlb = new JLabel("Account Number");
        accNumlb.setBounds(20, 110, 200, 25);
        accNumlb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        accNumlb.setForeground(Color.WHITE);

        accNumber = new JLabel(AccountNumber);
        accNumber.setBounds(20, 140, 240, 25);
        accNumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        accNumber.setForeground(Color.WHITE);

        balancelb = new JLabel("Balance");
        balancelb.setBounds(20, 180, 200, 25);
        balancelb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        balancelb.setForeground(Color.WHITE);

        balance = new JLabel(Balance);
        balance.setBounds(20, 210, 240, 25);
        balance.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        balance.setForeground(Color.WHITE);

        home = new JButton("Home");
        home.setBounds(70, 270, 140, 35);
        home.setFont(new Font("Segoe UI", Font.BOLD, 16));
        home.setBackground(Color.WHITE);
        home.setForeground(new Color(0, 51, 102));
        home.setFocusPainted(false);
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addActionListener(this);

        transferaccNum = new JLabel("Receiver Account");
        transferaccNum.setBounds(340, 80, 200, 25);
        transferaccNum.setFont(new Font("Segoe UI", Font.BOLD, 18));
        transferaccNum.setForeground(new Color(40, 40, 40));

        transferNumber = new JTextField();
        transferNumber.setBounds(340, 110, 250, 30);
        transferNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        transferNumber.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));

        amountlb = new JLabel("Enter Amount");
        amountlb.setBounds(340, 160, 200, 25);
        amountlb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        amountlb.setForeground(new Color(40, 40, 40));

        amountTf = new JTextField();
        amountTf.setBounds(340, 190, 250, 30);
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
        panel1.add(accNumlb);
        panel1.add(accNumber);
        panel1.add(balancelb);
        panel1.add(balance);
        panel1.add(home);

        C.add(headline);
        C.add(panel1);
        C.add(transferaccNum);
        C.add(transferNumber);
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
            transferNumber.setText("");
        } else if (e.getSource() == home) {
            new CustomerHome(AccountNumber, PinNumber);
            frame.dispose();
        } else if (e.getSource() == confirm) {
            String pin = JOptionPane.showInputDialog(null, "Enter Your Pin Number : ");
            String OtherAccount = transferNumber.getText();
            String Tx_id1, Tx_id2, type = "", purpose1 = "", purpose2 = "", money1 = "", money2 = "";

            if (PinNumber.equals(pin)) {
                if (CheckAccount(OtherAccount)) {
                    try {
                        int CurentBalance = Integer.parseInt(Balance);
                        int CurentOtherBalance = Integer.parseInt(OtherBalance);
                        int Amount = Integer.parseInt(amountTf.getText());

                        if (Amount <= CurentBalance) {
                            CurentBalance -= Amount;
                            CurentOtherBalance += Amount;
                            type = "Transfer";
                            purpose1 = "To Acc " + AccountNumber;
                            purpose2 = "From Acc " + OtherAccount;
                            money1 = "-" + String.valueOf(Amount);
                            money2 = "+" + String.valueOf(Amount);
                            Tx_id1 = Bank_Transactions.Transaction_Id();
                            Tx_id2 = Bank_Transactions.Transaction_Id();
                            Balance = String.valueOf(CurentBalance);
                            OtherBalance = String.valueOf(CurentOtherBalance);

                            boolean selfUpdate = BalanceUpdate(AccountNumber, Balance);
                            boolean otherUpdate = BalanceUpdate(OtherAccount, OtherBalance);
                            Bank_Transactions.History(OtherAccount, Tx_id1, type, money1, purpose1);
                            Bank_Transactions.History(AccountNumber, Tx_id2, type, money2, purpose2);
                            
                            if (selfUpdate && otherUpdate) {
                                balance.setText(Balance);
                                JOptionPane.showMessageDialog(null, "Balance Transfer Successful");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers only.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There are no account with this Number : " + OtherAccount);
                }
                amountTf.setText("");
                transferNumber.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Pin!");
            }
        }
    }

    boolean CheckAccount(String account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT Balance FROM customer_account WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, account);
            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                OtherBalance = rs.getString("Balance");
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

    public boolean BalanceUpdate(String Account, String Balance) {
        DBConnection connection = new DBConnection();
        String query = "UPDATE customer_account SET Balance = ? WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, Balance);
            preparedstatement.setString(2, Account);
            int update = preparedstatement.executeUpdate();
            preparedstatement.close();
            connection.connection.close();
            if (update > 0) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
}
