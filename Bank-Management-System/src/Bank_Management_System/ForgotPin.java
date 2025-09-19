package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class ForgotPin implements ActionListener {

    JFrame frame;
    Container C;
    JLabel title, newpinlb, conpinlb, captchaLabel, captchaText, enterCaptchaLb;
    JPasswordField newpinField, conpinField;
    JToggleButton show1, show2;
    JTextField captchaField;
    JButton confirm, back;

    String AccountNumber, value, captcha = "";
    Random rand;

    ForgotPin(String AccountNumber) {
        this.AccountNumber = AccountNumber;

        frame = new JFrame();
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(230, 240, 250));
        C.setLayout(null);

        title = new JLabel("Reset Your Pin", JLabel.CENTER);
        title.setBounds(150, 20, 250, 35);
        title.setFont(new Font("Cambria", Font.BOLD, 24));
        title.setForeground(new Color(30, 30, 30));

        newpinlb = new JLabel("New Pin");
        newpinlb.setBounds(90, 90, 150, 25);
        newpinlb.setFont(new Font("Cambria", Font.PLAIN, 18));

        newpinField = new JPasswordField();
        newpinField.setBounds(220, 90, 180, 28);
        newpinField.setFont(new Font("Cambria", Font.PLAIN, 18));

        show1 = new JToggleButton("Show");
        show1.setBounds(410, 90, 80, 28);
        show1.setFocusPainted(false);
        show1.setBackground(new Color(200, 200, 200));
        show1.addActionListener(this);

        conpinlb = new JLabel("Confirm Pin");
        conpinlb.setBounds(90, 140, 150, 25);
        conpinlb.setFont(new Font("Cambria", Font.PLAIN, 18));

        conpinField = new JPasswordField();
        conpinField.setBounds(220, 140, 180, 28);
        conpinField.setFont(new Font("Cambria", Font.PLAIN, 18));

        show2 = new JToggleButton("Show");
        show2.setBounds(410, 140, 80, 28);
        show2.setFocusPainted(false);
        show2.setBackground(new Color(200, 200, 200));
        show2.addActionListener(this);

        rand = new Random();
        value = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(value.length());
            captcha += value.charAt(index);
        }

        captchaLabel = new JLabel("Captcha");
        captchaLabel.setBounds(90, 190, 150, 25);
        captchaLabel.setFont(new Font("Cambria", Font.PLAIN, 18));

        captchaText = new JLabel(captcha, JLabel.CENTER);
        captchaText.setBounds(220, 190, 180, 28);
        captchaText.setOpaque(true);
        captchaText.setBackground(Color.WHITE);
        captchaText.setFont(new Font("Cambria", Font.BOLD, 18));
        captchaText.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        enterCaptchaLb = new JLabel("Enter Captcha");
        enterCaptchaLb.setBounds(90, 240, 150, 25);
        enterCaptchaLb.setFont(new Font("Cambria", Font.PLAIN, 18));

        captchaField = new JTextField();
        captchaField.setBounds(220, 240, 180, 28);
        captchaField.setFont(new Font("Cambria", Font.PLAIN, 18));

        confirm = new JButton("Confirm");
        confirm.setBounds(300, 300, 120, 35);
        confirm.setFont(new Font("Cambria", Font.BOLD, 18));
        confirm.setBackground(new Color(40, 40, 40));
        confirm.setForeground(Color.WHITE);
        confirm.setFocusPainted(false);
        confirm.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(120, 300, 120, 35);
        back.setFont(new Font("Cambria", Font.BOLD, 18));
        back.setBackground(new Color(120, 120, 120));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);

        C.add(title);
        C.add(newpinlb);
        C.add(newpinField);
        C.add(show1);
        C.add(conpinlb);
        C.add(conpinField);
        C.add(show2);
        C.add(captchaLabel);
        C.add(captchaText);
        C.add(enterCaptchaLb);
        C.add(captchaField);
        C.add(confirm);
        C.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show1) {
            if (show1.isSelected()) {
                newpinField.setEchoChar((char) 0);
                show1.setText("Hide");
            } else {
                newpinField.setEchoChar('\u2022');
                show1.setText("Show");
            }
        } else if (e.getSource() == show2) {
            if (show2.isSelected()) {
                conpinField.setEchoChar((char) 0);
                show2.setText("Hide");
            } else {
                conpinField.setEchoChar('\u2022');
                show2.setText("Show");
            }
        } else if (e.getSource() == confirm) {
            String code = captchaField.getText();
            String pin1 = String.valueOf(newpinField.getPassword());
            String pin2 = String.valueOf(conpinField.getPassword());

            if (!pin1.isEmpty() && !pin2.isEmpty()) {
                if (pin1.equals(pin2)) {
                    if (code.equals(captcha)) {
                        DBConnection connection = new DBConnection();
                        String query = "UPDATE Customer_Account SET Pin = ? WHERE account_number = ?";
                        try {
                            PreparedStatement ps = connection.connection.prepareStatement(query);
                            ps.setString(1, pin1);
                            ps.setString(2, AccountNumber);
                            int update = ps.executeUpdate();
                            if (update > 0) {
                                JOptionPane.showMessageDialog(null, "Pin number reset successfully");
                            } else {
                                JOptionPane.showMessageDialog(null, "Pin number not reset");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Captcha does not match. Please try again");
                        captcha = "";
                        for (int i = 0; i < 5; i++) {
                            int index = rand.nextInt(value.length());
                            captcha += value.charAt(index);
                        }
                        captchaText.setText(captcha);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pin numbers do not match");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter the pin number");
            }
        } else if (e.getSource() == back) {
            new SignIn();
            frame.dispose();
        }
    }
}
