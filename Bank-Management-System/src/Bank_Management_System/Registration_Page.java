package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class Registration_Page implements ActionListener {

    JFrame frame;
    Container C;
    JLabel tittle, personal, namelb, fatherlb, motherlb, birthlb, nidlb, genderlb, nationalitylb, religionlb, maritallb, occupationlb,
            contact, phonelb, emaillb, pinlb, conpinlb, address, divisionlb, districtlb, postOfficelb, upazilalb, villagelb, identity, accTypelb,
            branchlb, iniDepositlb, nominee, nomiNamelb, nomiRelationlb, nomiContactlb, nomiAddress, nomidivisionlb, nomidistrictlb,
            nomipostOfficelb, nomiupazilalb, nomivillagelb, notice1, notice2, notice3;
    JTextField nametf, fathertf, mothertf, nationalitytf, occupationtf, phonetf, emailtf, districttf,
            postOfficetf, upazilatf, villagetf, nidtf, iniDeposittf, nomiNametf, nomiRelationtf, nomiContacttf,
            nomidistricttf, nomipostOfficetf, nomiupazilatf, nomivillagetf;
    JPasswordField pinpf, conpinpf;
    JComboBox accTypecb, branchcb, religioncb, divisioncb, nomidivisioncb;
    JToggleButton show1, show2;
    JDateChooser birthtf;
    JRadioButton male, female, other1, single, married, other2;
    ButtonGroup grp1, grp2;
    JSeparator separator1, separator2;
    JButton back, registration;
    JPanel panel;

    String appName, Father, Mother, Birth, Nid, Gender, Phone, Email, Pin, Nationality, Religion, Marital, Occupation,
            Division, District, PostOffice, Upazila, Village, AccountType, Branch, IniDeposit, NomiName,
            NomiRelation, NomiContact, NomiDivision, NomiDistrict, NomiPostOffice, NomiUpazila, NomiVillage, RegistrationDate;

    Registration_Page() {

        frame = new JFrame();
        frame.setSize(1100, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(240, 245, 250));
        C.setLayout(null);

        tittle = new JLabel("Registration Form");
        tittle.setBounds(450, 10, 250, 30);
        tittle.setFont(new Font("Segoe UI", Font.BOLD, 24));

        personal = new JLabel("Personal Information");
        personal.setBounds(20, 60, 200, 25);
        personal.setFont(new Font("SansSerif", Font.BOLD, 14));
        personal.setForeground(new Color(30, 80, 130));

        namelb = new JLabel("Full Name");
        namelb.setBounds(20, 90, 120, 25);
        namelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nametf = new JTextField();
        nametf.setBounds(140, 90, 200, 25);
        nametf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        fatherlb = new JLabel("Father's Name");
        fatherlb.setBounds(20, 120, 120, 20);
        fatherlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        fathertf = new JTextField();
        fathertf.setBounds(140, 120, 200, 25);
        fathertf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        motherlb = new JLabel("Mother's Name");
        motherlb.setBounds(20, 150, 120, 25);
        motherlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        mothertf = new JTextField();
        mothertf.setBounds(140, 150, 200, 25);
        mothertf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        birthlb = new JLabel("Date of Birth");
        birthlb.setBounds(20, 180, 120, 25);
        birthlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        birthtf = new JDateChooser();
        birthtf.setBounds(140, 180, 200, 25);
        birthtf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nidlb = new JLabel("NID / Passport");
        nidlb.setBounds(20, 210, 120, 25);
        nidlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nidtf = new JTextField();
        nidtf.setBounds(140, 210, 200, 25);
        nidtf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        genderlb = new JLabel("Gender");
        genderlb.setBounds(20, 240, 120, 25);
        genderlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        male = new JRadioButton("Male");
        male.setBounds(140, 240, 60, 20);
        male.setFont(new Font("Segoe UI", Font.BOLD, 14));

        female = new JRadioButton("Female");
        female.setBounds(205, 240, 75, 20);
        female.setFont(new Font("Segoe UI", Font.BOLD, 14));

        other1 = new JRadioButton("Other");
        other1.setBounds(285, 240, 63, 20);
        other1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        grp1 = new ButtonGroup();
        grp1.add(male);
        grp1.add(female);
        grp1.add(other1);

        nationalitylb = new JLabel("Nationality");
        nationalitylb.setBounds(20, 270, 120, 25);
        nationalitylb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nationalitytf = new JTextField();
        nationalitytf.setBounds(140, 270, 200, 25);
        nationalitytf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        String[] religion = {"Islam", "Hindu", "Christian", "Buddhist", "Other"};
        religionlb = new JLabel("Religion");
        religionlb.setBounds(20, 300, 120, 25);
        religionlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        religioncb = new JComboBox(religion);
        religioncb.setBounds(140, 300, 200, 25);
        religioncb.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        maritallb = new JLabel("Marital Status");
        maritallb.setBounds(20, 330, 120, 25);
        maritallb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        single = new JRadioButton("Single");
        single.setBounds(140, 330, 70, 20);
        single.setFont(new Font("Segoe UI", Font.BOLD, 14));

        married = new JRadioButton("Married");
        married.setBounds(208, 330, 80, 20);
        married.setFont(new Font("Segoe UI", Font.BOLD, 14));

        grp2 = new ButtonGroup();
        grp2.add(single);
        grp2.add(married);

        occupationlb = new JLabel("Occupation");
        occupationlb.setBounds(20, 360, 120, 25);
        occupationlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        occupationtf = new JTextField();
        occupationtf.setBounds(140, 360, 200, 25);
        occupationtf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        contact = new JLabel("Contact & Security Information");
        contact.setBounds(20, 390, 250, 25);
        contact.setFont(new Font("SansSerif", Font.BOLD, 14));
        contact.setForeground(new Color(30, 80, 130));

        phonelb = new JLabel("Phone");
        phonelb.setBounds(20, 420, 120, 25);
        phonelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        phonetf = new JTextField();
        phonetf.setBounds(140, 420, 200, 25);
        phonetf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        emaillb = new JLabel("Email");
        emaillb.setBounds(20, 450, 120, 25);
        emaillb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        emailtf = new JTextField();
        emailtf.setBounds(140, 450, 200, 25);
        emailtf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        pinlb = new JLabel("PIN (4 Digit)");
        pinlb.setBounds(20, 480, 120, 25);
        pinlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        pinpf = new JPasswordField();
        pinpf.setBounds(140, 480, 120, 25);
        pinpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        show1 = new JToggleButton("Show");
        show1.setBounds(260, 480, 80, 25);
        show1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        show1.setBackground(new Color(52, 152, 219));
        show1.setForeground(Color.WHITE);
        show1.setFocusPainted(false);
        show1.setBorder(null);
        show1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        show1.addActionListener(this);

        conpinlb = new JLabel("Confirm PIN");
        conpinlb.setBounds(20, 510, 120, 25);
        conpinlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        conpinpf = new JPasswordField();
        conpinpf.setBounds(140, 510, 120, 25);
        conpinpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        show2 = new JToggleButton("Show");
        show2.setBounds(260, 510, 80, 25);
        show2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        show2.setBackground(new Color(52, 152, 219));
        show2.setForeground(Color.WHITE);
        show2.setFocusPainted(false);
        show2.setBorder(null);
        show2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        show2.addActionListener(this);

        separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setBounds(350, 90, 3, 450);
        separator1.setBackground(Color.DARK_GRAY);

        address = new JLabel("Address Information");
        address.setBounds(360, 60, 200, 25);
        address.setFont(new Font("SansSerif", Font.BOLD, 14));
        address.setForeground(new Color(30, 80, 130));

        String[] division = {"Dhaka", "Chattogram", "Khulna", "Rajshahi", "Barishal", "Sylhet", "Rangpur", "Mymensingh"};
        divisionlb = new JLabel("Division");
        divisionlb.setBounds(360, 90, 120, 25);
        divisionlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        divisioncb = new JComboBox(division);
        divisioncb.setBounds(480, 90, 200, 25);
        divisioncb.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        districtlb = new JLabel("District");
        districtlb.setBounds(360, 120, 120, 25);
        districtlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        districttf = new JTextField();
        districttf.setBounds(480, 120, 200, 25);
        districttf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        postOfficelb = new JLabel("Post Office");
        postOfficelb.setBounds(360, 150, 120, 25);
        postOfficelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        postOfficetf = new JTextField();
        postOfficetf.setBounds(480, 150, 200, 25);
        postOfficetf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        upazilalb = new JLabel("Upazila");
        upazilalb.setBounds(360, 180, 120, 25);
        upazilalb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        upazilatf = new JTextField();
        upazilatf.setBounds(480, 180, 200, 25);
        upazilatf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        villagelb = new JLabel("Village");
        villagelb.setBounds(360, 210, 120, 25);
        villagelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        villagetf = new JTextField();
        villagetf.setBounds(480, 210, 200, 25);
        villagetf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        identity = new JLabel("Account Information");
        identity.setBounds(360, 240, 250, 25);
        identity.setFont(new Font("SansSerif", Font.BOLD, 14));
        identity.setForeground(new Color(30, 80, 130));

        String[] accountType = {"Savings Account", "Fixed Account", "Current Account", "Student Account"};
        accTypelb = new JLabel("Account Type");
        accTypelb.setBounds(360, 270, 120, 25);
        accTypelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        accTypecb = new JComboBox(accountType);
        accTypecb.setBounds(480, 270, 200, 25);
        accTypecb.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        String[] branch = {"Dhaka", "Chattogram Agrabad", "Khulna", "Rajshahi", "Barishal", "Sylhet", "Rangpur", "Mymensingh"};
        branchlb = new JLabel("Branch");
        branchlb.setBounds(360, 300, 120, 25);
        branchlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        branchcb = new JComboBox(branch);
        branchcb.setBounds(480, 300, 200, 25);
        branchcb.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        iniDepositlb = new JLabel("Initial Deposit");
        iniDepositlb.setBounds(360, 330, 120, 25);
        iniDepositlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        iniDeposittf = new JTextField();
        iniDeposittf.setBounds(480, 330, 200, 25);
        iniDeposittf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nominee = new JLabel("Nominee / Guardian Information");
        nominee.setBounds(360, 360, 250, 25);
        nominee.setFont(new Font("SansSerif", Font.BOLD, 14));
        nominee.setForeground(new Color(30, 80, 130));

        nomiNamelb = new JLabel("Nominee Name");
        nomiNamelb.setBounds(360, 390, 120, 25);
        nomiNamelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomiNametf = new JTextField();
        nomiNametf.setBounds(480, 390, 200, 25);
        nomiNametf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomiRelationlb = new JLabel("Relation");
        nomiRelationlb.setBounds(360, 420, 120, 25);
        nomiRelationlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomiRelationtf = new JTextField();
        nomiRelationtf.setBounds(480, 420, 200, 25);
        nomiRelationtf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomiContactlb = new JLabel("Nominee Phone");
        nomiContactlb.setBounds(360, 450, 120, 25);
        nomiContactlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomiContacttf = new JTextField();
        nomiContacttf.setBounds(480, 450, 200, 25);
        nomiContacttf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setBounds(690, 90, 3, 450);
        separator2.setBackground(Color.DARK_GRAY);

        nomiAddress = new JLabel("Nominee Address Information");
        nomiAddress.setBounds(700, 60, 200, 25);
        nomiAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
        nomiAddress.setForeground(new Color(30, 80, 130));

        nomidivisionlb = new JLabel("Division");
        nomidivisionlb.setBounds(700, 90, 120, 25);
        nomidivisionlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomidivisioncb = new JComboBox(division);
        nomidivisioncb.setBounds(810, 90, 200, 25);
        nomidivisioncb.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomidistrictlb = new JLabel("District");
        nomidistrictlb.setBounds(700, 120, 120, 25);
        nomidistrictlb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomidistricttf = new JTextField();
        nomidistricttf.setBounds(810, 120, 200, 25);
        nomidistricttf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomipostOfficelb = new JLabel("Post Office");
        nomipostOfficelb.setBounds(700, 150, 120, 25);
        nomipostOfficelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomipostOfficetf = new JTextField();
        nomipostOfficetf.setBounds(810, 150, 200, 25);
        nomipostOfficetf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomiupazilalb = new JLabel("Upazila");
        nomiupazilalb.setBounds(700, 180, 120, 25);
        nomiupazilalb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomiupazilatf = new JTextField();
        nomiupazilatf.setBounds(810, 180, 200, 25);
        nomiupazilatf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        nomivillagelb = new JLabel("Village");
        nomivillagelb.setBounds(700, 210, 120, 25);
        nomivillagelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomivillagetf = new JTextField();
        nomivillagetf.setBounds(810, 210, 200, 25);
        nomivillagetf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        panel = new JPanel();
        panel.setBounds(700, 250, 370, 150);
        panel.setBackground(new Color(230, 240, 250));
        panel.setBorder(BorderFactory.createTitledBorder("Notice"));
        panel.setLayout(null);

        notice1 = new JLabel("Please provide accurate information.");
        notice1.setBounds(15, 50, 300, 15);
        notice1.setFont(new Font("Arial", Font.PLAIN, 13));
        notice1.setForeground(new Color(0, 51, 102));

        notice2 = new JLabel("Your data will be kept strictly confidential.");
        notice2.setBounds(15, 70, 300, 15);
        notice2.setFont(new Font("Arial", Font.PLAIN, 13));
        notice2.setForeground(new Color(0, 51, 102));

        notice3 = new JLabel("By registering, you agree to the bank’s terms & conditions");
        notice3.setBounds(15, 90, 370, 15);
        notice3.setFont(new Font("Arial", Font.PLAIN, 13));
        notice3.setForeground(new Color(0, 51, 102));

        back = new JButton("Back");
        back.setBounds(750, 450, 100, 35);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setBackground(new Color(192, 57, 43));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        registration = new JButton("Registration");
        registration.setBounds(900, 450, 150, 35);
        registration.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registration.setBackground(new Color(0, 51, 102));
        registration.setForeground(Color.WHITE);
        registration.setFocusPainted(false);
        registration.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        registration.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registration.addActionListener(this);

        panel.add(notice1);
        panel.add(notice2);
        panel.add(notice3);

        C.add(panel);
        C.add(tittle);
        C.add(personal);
        C.add(namelb);
        C.add(nametf);
        C.add(fatherlb);
        C.add(fathertf);
        C.add(motherlb);
        C.add(mothertf);
        C.add(birthlb);
        C.add(birthtf);
        C.add(genderlb);
        C.add(male);
        C.add(female);
        C.add(other1);
        C.add(nationalitylb);
        C.add(nationalitytf);
        C.add(religionlb);
        C.add(religioncb);
        C.add(maritallb);
        C.add(single);
        C.add(married);
        C.add(occupationlb);
        C.add(occupationtf);
        C.add(contact);
        C.add(phonelb);
        C.add(phonetf);
        C.add(emaillb);
        C.add(emailtf);
        C.add(pinlb);
        C.add(pinpf);
        C.add(show1);
        C.add(conpinlb);
        C.add(conpinpf);
        C.add(show2);
        C.add(divisionlb);
        C.add(divisioncb);
        C.add(districtlb);
        C.add(districttf);
        C.add(postOfficelb);
        C.add(postOfficetf);
        C.add(separator1);
        C.add(address);
        C.add(upazilalb);
        C.add(upazilatf);
        C.add(villagelb);
        C.add(villagetf);
        C.add(identity);
        C.add(nidlb);
        C.add(nidtf);
        C.add(accTypelb);
        C.add(accTypecb);
        C.add(branchlb);
        C.add(branchcb);
        C.add(iniDepositlb);
        C.add(iniDeposittf);
        C.add(nominee);
        C.add(nomiNametf);
        C.add(nomiAddress);
        C.add(nomiRelationlb);
        C.add(nomiRelationtf);
        C.add(nomiContactlb);
        C.add(nomiContacttf);
        C.add(separator2);
        C.add(nomivillagetf);
        C.add(nomidivisionlb);
        C.add(nomidivisioncb);
        C.add(nomidistrictlb);
        C.add(back);
        C.add(nomidistricttf);
        C.add(nomipostOfficetf);
        C.add(nomiupazilalb);
        C.add(nomiupazilatf);
        C.add(nomivillagelb);
        C.add(registration);
        C.add(nomiNamelb);
        C.add(nomipostOfficelb);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        boolean isFillUp = !nametf.getText().isEmpty() && !fathertf.getText().isEmpty() && !mothertf.getText().isEmpty()
                && !nidtf.getText().isEmpty() && !nationalitytf.getText().isEmpty() && !occupationtf.getText().isEmpty()
                && !phonetf.getText().isEmpty() && !emailtf.getText().isEmpty() && pinpf.getPassword().length > 0
                && !districttf.getText().isEmpty() && !postOfficetf.getText().isEmpty() && conpinpf.getPassword().length > 0
                && !upazilatf.getText().isEmpty() && !villagetf.getText().isEmpty() && !iniDeposittf.getText().isEmpty()
                && !nomiNametf.getText().isEmpty() && !nomiRelationtf.getText().isEmpty() && !nomiContacttf.getText().isEmpty()
                && !nomidistricttf.getText().isEmpty() && !nomipostOfficetf.getText().isEmpty()
                && !nomiupazilatf.getText().isEmpty() && !nomivillagetf.getText().isEmpty();

        if (e.getSource() == back) {
            new SignIn();
            frame.dispose();
        } else if (e.getSource() == registration) {
            if (isFillUp) {
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                RegistrationDate = format.format(date);
                Pin = String.valueOf(pinpf.getPassword());
                String ConPin = String.valueOf(conpinpf.getPassword());

                if (Pin.equals(ConPin)) {
                    appName = nametf.getText();
                    Father = fathertf.getText();
                    Mother = mothertf.getText();
                    Birth = ((JTextField) birthtf.getDateEditor().getUiComponent()).getText();
                    Nid = nidtf.getText();
                    Gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Other";
                    Nationality = nationalitytf.getText();
                    Religion = religioncb.getSelectedItem().toString();
                    Marital = single.isSelected() ? "Single" : "Married";
                    Occupation = occupationtf.getText();
                    Phone = phonetf.getText();
                    Email = emailtf.getText();
                    Division = divisioncb.getSelectedItem().toString();
                    District = districttf.getText();
                    PostOffice = postOfficetf.getText();
                    Upazila = upazilatf.getText();
                    Village = villagetf.getText();
                    AccountType = accTypecb.getSelectedItem().toString();
                    Branch = branchcb.getSelectedItem().toString();
                    IniDeposit = iniDeposittf.getText();
                    NomiName = nomiNametf.getText();
                    NomiRelation = nomiRelationtf.getText();
                    NomiContact = nomiContacttf.getText();
                    NomiDivision = nomidivisioncb.getSelectedItem().toString();
                    NomiDistrict = nomidistricttf.getText();
                    NomiPostOffice = nomipostOfficetf.getText();
                    NomiUpazila = nomiupazilatf.getText();
                    NomiVillage = nomivillagetf.getText();
                    RegistrationUpdate();
                } else {
                    JOptionPane.showMessageDialog(null, "Pin & Confirm pin do not match");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter all the information correctly", null, JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == show1) {
            if (show1.isSelected()) {
                pinpf.setEchoChar((char) 0);
                show1.setText("Hide");
            } else {
                pinpf.setEchoChar('\u2022');
                show1.setText("Show");
            }
        } else if (e.getSource() == show2) {
            if (show2.isSelected()) {
                conpinpf.setEchoChar((char) 0);
                show2.setText("Hide");
            } else {
                conpinpf.setEchoChar('\u2022');
                show2.setText("Show");
            }
        }
    }

    void RegistrationUpdate() {
        DBConnection connection = new DBConnection();
        String query = "INSERT INTO Registration (Name,Father,Mother,Birth,Nid,Gender,Phone,Email,Pin,Nationality,"
                + "Religion,Marital,Occupation,Division,District,Post_Office,Upazila,Village,DepBalance,Account_Type,"
                + "Branch,Nominee_Name,Nominee_Relation,Nominee_Contract,Nominee_Division,Nominee_District,Nominee_PostOffice,"
                + "Nominee_Upazila,Nominee_Village,Registration) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, appName);
            preparedstatement.setString(2, Father);
            preparedstatement.setString(3, Mother);
            preparedstatement.setString(4, Birth);
            preparedstatement.setString(5, Nid);
            preparedstatement.setString(6, Gender);
            preparedstatement.setString(7, Phone);
            preparedstatement.setString(8, Email);
            preparedstatement.setString(9, Pin);
            preparedstatement.setString(10, Nationality);
            preparedstatement.setString(11, Religion);
            preparedstatement.setString(12, Marital);
            preparedstatement.setString(13, Occupation);
            preparedstatement.setString(14, Division);
            preparedstatement.setString(15, District);
            preparedstatement.setString(16, PostOffice);
            preparedstatement.setString(17, Upazila);
            preparedstatement.setString(18, Village);
            preparedstatement.setString(19, IniDeposit);
            preparedstatement.setString(20, AccountType);
            preparedstatement.setString(21, Branch);
            preparedstatement.setString(22, NomiName);
            preparedstatement.setString(23, NomiRelation);
            preparedstatement.setString(24, NomiContact);
            preparedstatement.setString(25, NomiDivision);
            preparedstatement.setString(26, NomiDistrict);
            preparedstatement.setString(27, NomiPostOffice);
            preparedstatement.setString(28, NomiUpazila);
            preparedstatement.setString(29, NomiVillage);
            preparedstatement.setString(30, RegistrationDate);

            int insert = preparedstatement.executeUpdate();
            preparedstatement.close();
            connection.connection.close();
            if (insert > 0) {
                new Message();
                frame.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
