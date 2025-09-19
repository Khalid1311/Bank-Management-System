package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import java.sql.*;

public class Admin_Panel implements ActionListener {

    JFrame frame;
    Container C;
    JPanel btnpanel, mainPanel, regPanel, custPanel, loanPanel;
    JLabel dashlb, regLb, cusLb, loanLb;
    JButton detail1, add1, delete1, detail2, delete2, add3, delete3;
    JButton[] btn = new JButton[4];
    JTable table1, table2, table3;
    DefaultTableModel tableModel1, tableModel2, tableModel3;
    JTableHeader tbHeader1, tbHeader2, tbHeader3;
    JScrollPane scroll1, scroll2, scroll3;
    CardLayout layout;

    String[] collum1 = {"Account Number", "Holder Name", "Phone", "Account Type", "Balance", "Date"};
    String[] row1 = new String[6];
    String[] collum2 = {"Account Number", "Holder Name", "Phone", "Balance", "Division"};
    String[] row2 = new String[5];
    String[] collum3 = {"Account Number", "Holder Name", "Loan Balance", "Purpose", "Time-Date"};
    String[] row3 = new String[5];

    String HolderName, AccountNumber, Father, Mother, Birth, Nid, Gender, Phone, Email, Pin, Nationality, Religion,
            Marital, Occupation, Division, District, PostOffice, Upazila, Village, AccountType, Branch, Balance, NomiName,
            NomiRelation, NomiContact, NomiDivision, NomiDistrict, NomiPostOffice, NomiUpazila, NomiVillage, RegistrationDate,
            deleteOPtion;

    Admin_Panel() {

        frame = new JFrame();
        frame.setSize(1160, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setLayout(null);
        C.setBackground(new Color(34, 45, 65));

        dashlb = new JLabel("DashBoard");
        dashlb.setBounds(20, 5, 150, 25);
        dashlb.setFont(new Font("Verdana", Font.BOLD, 18));
        dashlb.setForeground(Color.WHITE);

        btnpanel = new JPanel();
        btnpanel.setBounds(0, 40, 150, 330);
        btnpanel.setBackground(new Color(50, 50, 70));
        btnpanel.setLayout(new GridLayout(5, 1, 5, 5));

        String[] button = {"New Register", "Customer List", "Loan", "Log Out"};
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton(button[i]);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2, true));
            btn[i].setFocusPainted(false);
            btn[i].setBackground(new Color(50, 50, 70));
            btn[i].setForeground(Color.MAGENTA);
            btn[i].setFont(new Font("Cambria", Font.BOLD, 16));
            btnpanel.add(btn[i]);
            btn[i].addActionListener(this);
            btn[i].addMouseListener(new MouseHandler());
        }

        regPanel = new JPanel();
        regPanel.setBounds(150, 0, 1150, 400);
        regPanel.setBackground(new Color(84, 127, 60));
        regPanel.setLayout(null);
        regPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        regLb = new JLabel("Registration List");
        regLb.setBounds(380, 2, 200, 25);
        regLb.setFont(new Font("System", Font.BOLD, 20));
        regLb.setForeground(Color.WHITE);

        tableModel1 = new DefaultTableModel();
        tableModel1.setColumnIdentifiers(collum1);

        table1 = new JTable(tableModel1);
        table1.setBackground(new Color(245, 245, 245));
        table1.setForeground(Color.BLACK);
        table1.setRowHeight(25);
        table1.setGridColor(Color.LIGHT_GRAY);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table1.getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tbHeader1 = table1.getTableHeader();
        tbHeader1.setBackground(new Color(219, 228, 241));
        tbHeader1.setFont(new Font("Arial", Font.BOLD, 15));

        scroll1 = new JScrollPane(table1);
        scroll1.setBounds(0, 40, 1000, 260);

        detail1 = new JButton("Detail");
        detail1.setBounds(240, 315, 100, 30);
        detail1.setFont(new Font("Cambria", Font.BOLD, 18));
        detail1.setBackground(Color.BLACK);
        detail1.setForeground(Color.WHITE);
        detail1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        detail1.addActionListener(this);

        add1 = new JButton("Add");
        add1.setBounds(370, 315, 100, 30);
        add1.setFont(new Font("Cambria", Font.BOLD, 18));
        add1.setBackground(Color.BLACK);
        add1.setForeground(Color.WHITE);
        add1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        add1.addActionListener(this);

        delete1 = new JButton("Delete");
        delete1.setBounds(500, 315, 100, 30);
        delete1.setFont(new Font("Cambria", Font.BOLD, 18));
        delete1.setBackground(Color.BLACK);
        delete1.setForeground(Color.WHITE);
        delete1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        delete1.addActionListener(this);

        custPanel = new JPanel();
        custPanel.setBounds(150, 0, 1100, 400);
        custPanel.setBackground(new Color(84, 127, 60));
        custPanel.setLayout(null);

        cusLb = new JLabel("Customer List");
        cusLb.setBounds(380, 2, 200, 25);
        cusLb.setFont(new Font("System", Font.BOLD, 20));
        cusLb.setForeground(Color.WHITE);

        tableModel2 = new DefaultTableModel();
        tableModel2.setColumnIdentifiers(collum2);

        table2 = new JTable(tableModel2);
        table2.setBackground(new Color(245, 245, 245));
        table2.setForeground(Color.BLACK);
        table2.setRowHeight(25);
        table2.setGridColor(Color.LIGHT_GRAY);
        for (int i = 0; i < table2.getColumnCount(); i++) {
            table2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tbHeader2 = table2.getTableHeader();
        tbHeader2.setBackground(new Color(219, 228, 241));
        tbHeader2.setFont(new Font("Arial", Font.BOLD, 15));

        scroll2 = new JScrollPane(table2);
        scroll2.setBounds(0, 40, 1000, 260);

        detail2 = new JButton("Detail");
        detail2.setBounds(370, 315, 100, 30);
        detail2.setFont(new Font("Cambria", Font.BOLD, 18));
        detail2.setBackground(Color.BLACK);
        detail2.setForeground(Color.WHITE);
        detail2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        detail2.addActionListener(this);

        delete2 = new JButton("Delete");
        delete2.setBounds(500, 315, 100, 30);
        delete2.setFont(new Font("Cambria", Font.BOLD, 18));
        delete2.setBackground(Color.BLACK);
        delete2.setForeground(Color.WHITE);
        delete2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        delete2.addActionListener(this);

        loanPanel = new JPanel();
        loanPanel.setBounds(150, 0, 1200, 400);
        loanPanel.setBackground(new Color(84, 127, 60));
        loanPanel.setLayout(null);

        loanLb = new JLabel("Loan List");
        loanLb.setBounds(380, 2, 200, 25);
        loanLb.setFont(new Font("System", Font.BOLD, 20));
        loanLb.setForeground(Color.WHITE);

        tableModel3 = new DefaultTableModel();
        tableModel3.setColumnIdentifiers(collum3);

        table3 = new JTable(tableModel3);
        table3.setBackground(new Color(245, 245, 245));
        table3.setForeground(Color.BLACK);
        table3.setRowHeight(25);
        table3.setGridColor(Color.LIGHT_GRAY);
        for (int i = 0; i < table3.getColumnCount(); i++) {
            table3.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tbHeader3 = table3.getTableHeader();
        tbHeader3.setBackground(new Color(219, 228, 241));
        tbHeader3.setFont(new Font("Arial", Font.BOLD, 15));

        scroll3 = new JScrollPane(table3);
        scroll3.setBounds(0, 40, 1000, 260);

        add3 = new JButton("Add");
        add3.setBounds(370, 315, 100, 30);
        add3.setFont(new Font("Cambria", Font.BOLD, 18));
        add3.setBackground(Color.BLACK);
        add3.setForeground(Color.WHITE);
        add3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        add3.addActionListener(this);

        delete3 = new JButton("Delete");
        delete3.setBounds(500, 315, 100, 30);
        delete3.setFont(new Font("Cambria", Font.BOLD, 18));
        delete3.setBackground(Color.BLACK);
        delete3.setForeground(Color.WHITE);
        delete3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        delete3.addActionListener(this);

        regPanel.add(regLb);
        regPanel.add(scroll1);
        regPanel.add(detail1);
        regPanel.add(add1);
        regPanel.add(delete1);

        custPanel.add(cusLb);
        custPanel.add(scroll2);
        custPanel.add(detail2);
        custPanel.add(delete2);

        loanPanel.add(loanLb);
        loanPanel.add(scroll3);
        loanPanel.add(add3);
        loanPanel.add(delete3);

        layout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setBounds(150, 0, 1050, 400);
        mainPanel.setBackground(new Color(26, 73, 100));
        mainPanel.setLayout(layout);

        mainPanel.add(regPanel, "Registration");
        mainPanel.add(custPanel, "Customer");
        mainPanel.add(loanPanel, "Loan");

        C.add(mainPanel);
        C.add(btnpanel);
        C.add(dashlb);

        RegistrationAccount();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {
            RegistrationAccount();
            layout.show(mainPanel, "Registration");
        } else if (e.getSource() == btn[1]) {
            CustomerAccount();
            layout.show(mainPanel, "Customer");
        } else if (e.getSource() == btn[2]) {
            LoanRequest();
            layout.show(mainPanel, "Loan");
        } else if (e.getSource() == btn[3]) {
            new SignIn();
            frame.dispose();
        }

        if (e.getSource() == delete1) {
            deleteOPtion = "tableModel1";
            DeleteAccount();
        } else if (e.getSource() == delete2) {
            deleteOPtion = "tableModel2";
            DeleteAccount();
        } else if (e.getSource() == delete3) {
            deleteOPtion = "tableModel3";
            DeleteAccount();
        }

        if (e.getSource() == add1) {
            CustomerAdd();
        } else if (e.getSource() == add3) {
            LoanSetUp();
        }

        if (e.getSource() == detail1) {
            int NumberOfRow = table1.getSelectedRow();
            if (NumberOfRow >= 0) {
                String accountNumber = tableModel1.getValueAt(NumberOfRow, 0).toString();
                new New_CustomerDetails(accountNumber);
            } else {
                JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
            }
        } else if (e.getSource() == detail2) {
            int NumberOfRow = table2.getSelectedRow();
            if (NumberOfRow >= 0) {
                String accountNumber = tableModel2.getValueAt(NumberOfRow, 0).toString();
                new CustomerDetails(accountNumber);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
            }
        }
    }

    class MouseHandler extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.CYAN);
        }

        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(new Color(50, 50, 70));
        }
    }

    void RegistrationAccount() {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Registration";
        tableModel1.setRowCount(0);
        try {
            Statement statement = connection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                row1[0] = rs.getString("account_number");
                row1[1] = rs.getString("Name");
                row1[2] = rs.getString("Phone");
                row1[3] = rs.getString("Account_Type");
                row1[4] = rs.getString("DepBalance");
                row1[5] = rs.getString("Registration");
                tableModel1.addRow(row1);
            }
            rs.close();
            statement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void CustomerAdd() {
        DBConnection connection = new DBConnection();
        String query1 = "SELECT * FROM Registration WHERE account_number = ?";
        String query2 = "INSERT INTO customer_account (account_number,Name,Father,Mother,Birth,Nid,Gender,Phone,Email,Pin,Nationality,"
                + "Religion,Marital,Occupation,Division,District,Post_Office,Upazila,Village,Balance,Account_Type,"
                + "Branch,Nominee_Name,Nominee_Relation,Nominee_Contract,Nominee_Division,Nominee_District,Nominee_PostOffice,"
                + "Nominee_Upazila,Nominee_Village,Registration) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?) ";

        int NumberOfRow = table1.getSelectedRow();
        if (NumberOfRow < 0) {
            JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
            return;
        }

        String accountNumber = tableModel1.getValueAt(NumberOfRow, 0).toString();
        try {
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query1);
            preparedStatement.setString(1, accountNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                HolderName = rs.getString("Name");
                AccountNumber = rs.getString("account_number");
                Father = rs.getString("Father");
                Mother = rs.getString("Mother");
                Phone = rs.getString("Phone");
                Email = rs.getString("Email");
                Pin = rs.getString("Pin");
                Birth = rs.getString("Birth");
                Nid = rs.getString("Nid");
                Gender = rs.getString("Gender");
                Marital = rs.getString("Marital");
                Nationality = rs.getString("Nationality");
                Religion = rs.getString("Religion");
                Occupation = rs.getString("Occupation");
                Division = rs.getString("Division");
                District = rs.getString("District");
                PostOffice = rs.getString("Post_Office");
                Upazila = rs.getString("Upazila");
                Village = rs.getString("Village");
                AccountType = rs.getString("Account_Type");
                Branch = rs.getString("Branch");
                Balance = rs.getString("DepBalance");
                NomiName = rs.getString("Nominee_Name");
                NomiRelation = rs.getString("Nominee_Relation");
                NomiContact = rs.getString("Nominee_Contract");
                NomiDivision = rs.getString("Nominee_Division");
                NomiDistrict = rs.getString("Nominee_District");
                NomiPostOffice = rs.getString("Nominee_PostOffice");
                NomiUpazila = rs.getString("Nominee_Upazila");
                NomiVillage = rs.getString("Nominee_Village");
                RegistrationDate = rs.getString("Registration");
            }
            preparedStatement = connection.connection.prepareStatement(query2);
            preparedStatement.setString(1, AccountNumber);
            preparedStatement.setString(2, HolderName);
            preparedStatement.setString(3, Father);
            preparedStatement.setString(4, Mother);
            preparedStatement.setString(5, Birth);
            preparedStatement.setString(6, Nid);
            preparedStatement.setString(7, Gender);
            preparedStatement.setString(8, Phone);
            preparedStatement.setString(9, Email);
            preparedStatement.setString(10, Pin);
            preparedStatement.setString(11, Nationality);
            preparedStatement.setString(12, Religion);
            preparedStatement.setString(13, Marital);
            preparedStatement.setString(14, Occupation);
            preparedStatement.setString(15, Division);
            preparedStatement.setString(16, District);
            preparedStatement.setString(17, PostOffice);
            preparedStatement.setString(18, Upazila);
            preparedStatement.setString(19, Village);
            preparedStatement.setString(20, Balance);
            preparedStatement.setString(21, AccountType);
            preparedStatement.setString(22, Branch);
            preparedStatement.setString(23, NomiName);
            preparedStatement.setString(24, NomiRelation);
            preparedStatement.setString(25, NomiContact);
            preparedStatement.setString(26, NomiDivision);
            preparedStatement.setString(27, NomiDistrict);
            preparedStatement.setString(28, NomiPostOffice);
            preparedStatement.setString(29, NomiUpazila);
            preparedStatement.setString(30, NomiVillage);
            preparedStatement.setString(31, RegistrationDate);
            preparedStatement.executeUpdate();

            rs.close();
            preparedStatement.close();
            deleteOPtion = "tableModel1";
            DeleteAccount();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }

    void CustomerAccount() {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Customer_Account";
        tableModel2.setRowCount(0);
        try {
            Statement statement = connection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                row2[0] = String.valueOf(rs.getString("account_number"));
                row2[1] = rs.getString("Name");
                row2[2] = rs.getString("Phone");
                row2[3] = rs.getString("Balance");
                row2[4] = rs.getString("Division");
                tableModel2.addRow(row2);
            }
            rs.close();
            statement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    String CustomerBalance(String account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT Balance FROM customer_account WHERE account_number = ?";
        String balance = "0";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, account);
            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                balance = rs.getString("Balance");
            }
            rs.close();
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return balance;
    }

    void LoanRequest() {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Loan_Request";
        tableModel3.setRowCount(0);
        try {
            Statement statement = connection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                row3[0] = String.valueOf(rs.getString("account_number"));
                row3[1] = rs.getString("Name");
                row3[2] = rs.getString("Loan_Balance");
                row3[3] = rs.getString("Purpose");
                row3[4] = rs.getString("Request_Time_Date");
                tableModel3.addRow(row3);
            }
            rs.close();
            statement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void LoanSetUp() {
        DBConnection connection = new DBConnection();
        String query = "SELECT TX_Id FROM Transaction_History WHERE account_number = ? AND Request_Time_Date = ?";
        int NumberOfRow = table3.getSelectedRow();
        if (NumberOfRow < 0) {
            JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
            return;
        }

        String accountNumber = tableModel3.getValueAt(NumberOfRow, 0).toString();
        String balance = tableModel3.getValueAt(NumberOfRow, 2).toString();
        String timedate = tableModel3.getValueAt(NumberOfRow, 4).toString();
        String Tx_id = "";

        String MainBalance = CustomerBalance(accountNumber);
        int Balance1 = Integer.parseInt(MainBalance);
        int Balance2 = Integer.parseInt(balance);
        Balance1 += Balance2;
        balance = String.valueOf(Balance1);
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, accountNumber);
            preparedstatement.setString(2, timedate);
            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                Tx_id = rs.getString("TX_Id");
            }
            rs.close();
            preparedstatement.close();
            LoanBalanceUpdate(accountNumber, balance);
            LoanTransactionUpdate(accountNumber, Tx_id, timedate);
            deleteOPtion = "tableModel3";
            DeleteAccount();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void LoanBalanceUpdate(String account, String balance) {
        DBConnection connection = new DBConnection();
        String query = "UPDATE Customer_Account SET Balance = ? WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, balance);
            preparedstatement.setString(2, account);
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void LoanTransactionUpdate(String account, String Tx_id, String timedate) {
        DBConnection connection = new DBConnection();
        String query = "UPDATE Transaction_History SET Status = ?,Time_Date = ? WHERE account_number = ? AND TX_Id = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, "Approved");
            preparedstatement.setString(2, timedate);
            preparedstatement.setString(3, account);
            preparedstatement.setString(4, Tx_id);
            preparedstatement.executeUpdate();
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void DeleteAccount() {
        DBConnection connection = new DBConnection();
        String query = "";
        int NumberOfRow = -1;
        String accountNumber = "";

        if (deleteOPtion.equals("tableModel1")) {
            NumberOfRow = table1.getSelectedRow();
            if (NumberOfRow >= 0) {
                accountNumber = tableModel1.getValueAt(NumberOfRow, 0).toString();
                query = "DELETE FROM Registration WHERE account_number = ?";
            } else {
                JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
                return;
            }
        } else if (deleteOPtion.equals("tableModel2")) {
            NumberOfRow = table2.getSelectedRow();
            if (NumberOfRow >= 0) {
                accountNumber = tableModel2.getValueAt(NumberOfRow, 0).toString();
                query = "DELETE FROM customer_account WHERE account_number = ?";
            } else {
                JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
                return;
            }
        } else if (deleteOPtion.equals("tableModel3")) {
            NumberOfRow = table3.getSelectedRow();
            if (NumberOfRow >= 0) {
                accountNumber = tableModel3.getValueAt(NumberOfRow, 0).toString();
                query = "DELETE FROM Loan_Request WHERE account_number = ?";
            } else {
                JOptionPane.showMessageDialog(null, "No row selected! Please choose a record.");
                return;
            }
        }
        try {
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.connection.close();

            if (deleteOPtion.equals("tableModel1")) {
                tableModel1.removeRow(NumberOfRow);
                RegistrationAccount();
            } else if (deleteOPtion.equals("tableModel2")) {
                tableModel2.removeRow(NumberOfRow);
                CustomerAccount();
            } else if (deleteOPtion.equals("tableModel3")) {
                tableModel3.removeRow(NumberOfRow);
                LoanRequest();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
