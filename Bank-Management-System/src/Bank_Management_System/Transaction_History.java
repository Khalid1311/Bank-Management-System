package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Transaction_History implements ActionListener {

    JFrame frame;
    Container C;
    JLabel lb1, lb2, lb3;
    JScrollPane scroll;
    JTable table;
    DefaultTableModel modelTable;
    JTableHeader header;
    JButton back;

    String[] col = {"TX-Id", "Type", "Balance", "Purpose", "Status", "Request Time-Date", "Time-Date"};
    String[] row = new String[7];

    String AccountNumber, PinNumber;

    Transaction_History(String AccountNumber, String PinNumber) {

        this.AccountNumber = AccountNumber;
        this.PinNumber = PinNumber;

        frame = new JFrame();
        frame.setSize(1200, 430);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        C = frame.getContentPane();
        C.setBackground(new Color(240, 245, 250));
        C.setLayout(null);

        lb1 = new JLabel("Transaction History", JLabel.CENTER);
        lb1.setBounds(200, 10, 820, 35);
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lb1.setForeground(new Color(0, 51, 102));

        lb2 = new JLabel("Account Number : ");
        lb2.setBounds(420, 55, 180, 25);
        lb2.setFont(new Font("Cambria", Font.BOLD, 18));
        lb2.setForeground(new Color(50, 50, 50));

        lb3 = new JLabel(AccountNumber, JLabel.CENTER);
        lb3.setBounds(600, 55, 180, 25);
        lb3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lb3.setOpaque(true);
        lb3.setBackground(Color.WHITE);
        lb3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(col);

        table = new JTable(modelTable);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(new Color(173, 216, 230));
        table.setBackground(Color.WHITE);

        DefaultTableCellRenderer centreTable = new DefaultTableCellRenderer();
        centreTable.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centreTable);
        }

        header = table.getTableHeader();
        header.setBackground(new Color(0, 51, 102));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));

        scroll = new JScrollPane(table);
        scroll.setBounds(20, 95, 1150, 260);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));

        back = new JButton("Back");
        back.setBounds(1050, 20, 120, 35);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setBackground(new Color(192, 57, 43));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        C.add(lb1);
        C.add(lb2);
        C.add(lb3);
        C.add(scroll);
        C.add(back);

        TransactionHistory();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new CustomerHome(AccountNumber, PinNumber);
            frame.dispose();
        }
    }

    void TransactionHistory() {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Transaction_History WHERE account_number = '" + AccountNumber + "'";
        modelTable.setRowCount(0);
        try {
            Statement statement = connection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                row[0] = rs.getString("TX_Id");
                row[1] = rs.getString("Type");
                row[2] = rs.getString("Balance");
                row[3] = rs.getString("Purpose");
                row[4] = rs.getString("Status");
                row[5] = rs.getString("Request_Time_Date");
                row[6] = rs.getString("Time_Date");
                modelTable.addRow(row);
            }
            rs.close();
            statement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
