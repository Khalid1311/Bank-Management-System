package Bank_Management_System;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {

    Connection connection;

    public DBConnection() {
        String url = "jdbc:mysql://localhost:3306/Bank_Management_System";
        String username = "root";
        String password = "khalid1311";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
