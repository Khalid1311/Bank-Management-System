package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePin implements ActionListener {

    JFrame frame;
    Container C;
    JLabel lb1, oldpinlb, newpinlb, conpinlb;
    JPasswordField oldpinField, newpinField, conpinField;
    JToggleButton show1, show2, show3;
    JButton confirm, back;

    String AccountNumber, Pin;

    ChangePin(String AccountNumber, String PinNumber) {

        this.AccountNumber = AccountNumber;
        this.Pin = PinNumber;

        frame = new JFrame();
        frame.setSize(520, 340);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(245, 247, 250));
        C.setLayout(null);

        lb1 = new JLabel("Change Your PIN");
        lb1.setBounds(140, 15, 300, 30);
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lb1.setForeground(new Color(40, 53, 85));

        oldpinlb = new JLabel("Old PIN ");
        oldpinlb.setBounds(80, 70, 150, 25);
        oldpinlb.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        oldpinField = new JPasswordField();
        oldpinField.setBounds(190, 70, 150, 28);
        oldpinField.setFont(new Font("Segoe UI", Font.BOLD, 16));

        show1 = new JToggleButton("Show");
        show1.setBounds(350, 70, 80, 28);
        show1.setFocusPainted(false);
        show1.setBackground(new Color(220, 230, 240));
        show1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        show1.addActionListener(this);

        newpinlb = new JLabel("New PIN ");
        newpinlb.setBounds(80, 115, 150, 25);
        newpinlb.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        newpinField = new JPasswordField();
        newpinField.setBounds(190, 115, 150, 28);
        newpinField.setFont(new Font("Segoe UI", Font.BOLD, 16));

        show2 = new JToggleButton("Show");
        show2.setBounds(350, 115, 80, 28);
        show2.setFocusPainted(false);
        show2.setBackground(new Color(220, 230, 240));
        show2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        show2.addActionListener(this);

        conpinlb = new JLabel("Confirm PIN ");
        conpinlb.setBounds(80, 160, 150, 25);
        conpinlb.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        conpinField = new JPasswordField();
        conpinField.setBounds(190, 160, 150, 28);
        conpinField.setFont(new Font("Segoe UI", Font.BOLD, 16));

        show3 = new JToggleButton("Show");
        show3.setBounds(350, 160, 80, 28);
        show3.setFocusPainted(false);
        show3.setBackground(new Color(220, 230, 240));
        show3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        show3.addActionListener(this);

        confirm = new JButton("Confirm");
        confirm.setBounds(260, 230, 130, 35);
        confirm.setFont(new Font("Segoe UI", Font.BOLD, 16));
        confirm.setBackground(new Color(46, 125, 50));
        confirm.setForeground(Color.WHITE);
        confirm.setFocusPainted(false);
        confirm.setBorder(BorderFactory.createEmptyBorder());
        confirm.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(100, 230, 120, 35);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setBackground(new Color(198, 40, 40));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);

        C.add(lb1);
        C.add(oldpinlb);
        C.add(oldpinField);
        C.add(show1);
        C.add(newpinlb);
        C.add(newpinField);
        C.add(show2);
        C.add(conpinlb);
        C.add(conpinField);
        C.add(show3);
        C.add(confirm);
        C.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show1) {
            if (show1.isSelected()) {
                oldpinField.setEchoChar((char) (0));
                show1.setText("Hide");
            } else {
                oldpinField.setEchoChar('\u2022');
                show1.setText("Show");
            }
        } else if (e.getSource() == show2) {
            if (show2.isSelected()) {
                newpinField.setEchoChar((char) (0));
                show2.setText("Hide");
            } else {
                newpinField.setEchoChar('\u2022');
                show2.setText("Show");
            }
        } else if (e.getSource() == show3) {
            if (show3.isSelected()) {
                conpinField.setEchoChar((char) (0));
                show3.setText("Hide");
            } else {
                conpinField.setEchoChar('\u2022');
                show3.setText("Show");
            }
        } else if (e.getSource() == back) {
            new My_Account(AccountNumber, Pin);
            frame.dispose();
        } else if (e.getSource() == confirm) {
            String pin1 = String.valueOf(oldpinField.getPassword());
            String pin2 = String.valueOf(newpinField.getPassword());
            String pin3 = String.valueOf(conpinField.getPassword());

            if (!pin1.isEmpty() && !pin2.isEmpty() && !pin3.isEmpty()) {
                if (pin1.equals(Pin)) {
                    if (pin2.equals(pin3)) {
                        DBConnection connection = new DBConnection();
                        String query = "UPDATE Customer_Account SET Pin = ? WHERE account_number = ?";
                        try {
                            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
                            preparedstatement.setString(1, pin2);
                            preparedstatement.setString(2, AccountNumber);

                            int update = preparedstatement.executeUpdate();
                            if (update > 0) {
                                JOptionPane.showMessageDialog(null, "Pin number changed successfully");
                                Pin = pin2;
                            } else {
                                JOptionPane.showMessageDialog(null, "Pin number not changed");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "New pin & Confirm pin do not match. Please try again");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old pin number does not match. Please try again");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter the pin number");
            }
        }
    }
}
