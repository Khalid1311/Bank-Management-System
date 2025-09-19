package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class My_Account implements ActionListener {

    JFrame frame;
    Container C;
    JLabel detail, personal, guardian, nominee, address, namelb, fnamelb, mnamelb, accnumlb, phonelb, emaillb, pinlb,
            genderlb, nidlb, doblb, nationalitylb, religionlb, maritallb, occulb, divisionlb, distlb, postlb, thanalb,
            villlb, accTypelb, branchlb, nominamelb, nomirelationlb, nomicontactlb, nomidivisionlb, nomidistrictlb,
            nomipostOfficelb, nomiupazilalb, nomivillagelb, registrationlb;
    JTextField nametf, fnametf, mnametf, accnumtf, phonetf, emailtf, gendertf, nidtf, nationalitytf, maritaltf,
            religiontf, dobField, divisiontf, disttf, posttf, thanatf, villtf, occtf, accTypetf, branchtf, nominametf,
            nomirelationtf, nomicontacttf, nomidivisiontf, nomidistricttf, nomipostOfficetf, nomiupazilatf, nomivillagetf,
            registrationdate;
    JPasswordField pinpf;
    JButton changePin, edit, update, back;
    JToggleButton show;
    JSeparator separator1, separator2;

    String HolderName, AccountNumber, Father, Mother, Birth, Nid, Gender, Phone, Email, Pin, Nationality, Religion,
            Marital, Occupation, Division, District, PostOffice, Upazila, Village, AccountType, Branch, Balance, NomiName,
            NomiRelation, NomiContact, NomiDivision, NomiDistrict, NomiPostOffice, NomiUpazila, NomiVillage, RegistrationDate;

    My_Account(String AccountNumber, String PinNumber) {

        this.AccountNumber = AccountNumber;
        this.Pin = PinNumber;
        AccountDetail();

        frame = new JFrame();
        frame.setSize(1250, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        C = frame.getContentPane();
        C.setBackground(new Color(236, 240, 245));
        C.setLayout(null);

        detail = new JLabel("My Account");
        detail.setBounds(540, 10, 300, 30);
        detail.setFont(new Font("Segoe UI", Font.BOLD, 24));
        detail.setForeground(new Color(40, 55, 71));

        personal = new JLabel("Personal", JLabel.CENTER);
        personal.setBounds(50, 45, 290, 30);
        personal.setFont(new Font("Segoe UI", Font.BOLD, 20));
        personal.setForeground(new Color(128, 0, 128));

        namelb = new JLabel("Holder Name");
        namelb.setBounds(30, 90, 150, 25);
        namelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nametf = new JTextField(HolderName);
        nametf.setBounds(190, 90, 200, 28);
        nametf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nametf.setEditable(false);

        accnumlb = new JLabel("Account Number");
        accnumlb.setBounds(30, 125, 150, 25);
        accnumlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        accnumtf = new JTextField(AccountNumber);
        accnumtf.setBounds(190, 125, 200, 28);
        accnumtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        accnumtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        accnumtf.setEditable(false);

        accTypelb = new JLabel("Account Type");
        accTypelb.setBounds(30, 160, 150, 25);
        accTypelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        accTypetf = new JTextField(AccountType);
        accTypetf.setBounds(190, 160, 200, 28);
        accTypetf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        accTypetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        accTypetf.setEditable(false);

        branchlb = new JLabel("Branch");
        branchlb.setBounds(30, 195, 150, 25);
        branchlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        branchtf = new JTextField(Branch);
        branchtf.setBounds(190, 195, 200, 28);
        branchtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        branchtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        branchtf.setEditable(false);

        phonelb = new JLabel("Phone");
        phonelb.setBounds(30, 230, 150, 25);
        phonelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        phonetf = new JTextField(Phone);
        phonetf.setBounds(190, 230, 200, 28);
        phonetf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        phonetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        phonetf.setEditable(false);

        emaillb = new JLabel("E-mail");
        emaillb.setBounds(30, 265, 150, 25);
        emaillb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        emailtf = new JTextField(Email);
        emailtf.setBounds(190, 265, 200, 28);
        emailtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        emailtf.setEditable(false);

        pinlb = new JLabel("PIN");
        pinlb.setBounds(30, 300, 150, 25);
        pinlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        pinpf = new JPasswordField(Pin);
        pinpf.setBounds(190, 300, 200, 28);
        pinpf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pinpf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        pinpf.setEditable(false);

        changePin = new JButton("Change PIN");
        changePin.setBounds(190, 335, 90, 20);
        changePin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        changePin.setBackground(new Color(52, 73, 94));
        changePin.setForeground(Color.WHITE);
        changePin.setFocusPainted(false);
        changePin.setBorder(null);
        changePin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePin.addActionListener(this);

        show = new JToggleButton("Show Pin");
        show.setBounds(290, 335, 99, 20);
        show.setFont(new Font("Segoe UI", Font.BOLD, 14));
        show.setBackground(new Color(52, 152, 219));
        show.setForeground(Color.WHITE);
        show.setFocusPainted(false);
        show.setBorder(null);
        show.setCursor(new Cursor(Cursor.HAND_CURSOR));
        show.addActionListener(this);

        nidlb = new JLabel("NID / Passport");
        nidlb.setBounds(30, 370, 150, 25);
        nidlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nidtf = new JTextField(Nid);
        nidtf.setBounds(190, 370, 200, 28);
        nidtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nidtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nidtf.setEditable(false);

        genderlb = new JLabel("Gender");
        genderlb.setBounds(30, 405, 150, 25);
        genderlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        gendertf = new JTextField(Gender);
        gendertf.setBounds(190, 405, 200, 28);
        gendertf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        gendertf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        gendertf.setEditable(false);

        doblb = new JLabel("Date of Birth");
        doblb.setBounds(30, 440, 440, 25);
        doblb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        dobField = new JTextField(Birth);
        dobField.setBounds(190, 440, 200, 28);
        dobField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        dobField.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        dobField.setEditable(false);

        maritallb = new JLabel("Marital Status");
        maritallb.setBounds(30, 475, 150, 25);
        maritallb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        maritaltf = new JTextField(Marital);
        maritaltf.setBounds(190, 475, 200, 28);
        maritaltf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        maritaltf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        maritaltf.setEditable(false);

        registrationlb = new JLabel("Registration Date");
        registrationlb.setBounds(30, 510, 150, 25);
        registrationlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        registrationdate = new JTextField(RegistrationDate);
        registrationdate.setBounds(190, 510, 200, 28);
        registrationdate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        registrationdate.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        registrationdate.setEditable(false);

        separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setBounds(410, 90, 3, 450);
        separator1.setBackground(Color.DARK_GRAY);

        occulb = new JLabel("Occupation");
        occulb.setBounds(420, 90, 150, 25);
        occulb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        occtf = new JTextField(Occupation);
        occtf.setBounds(580, 90, 200, 28);
        occtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        occtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        occtf.setEditable(false);

        nationalitylb = new JLabel("Nationality");
        nationalitylb.setBounds(420, 125, 150, 25);
        nationalitylb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nationalitytf = new JTextField(Nationality);
        nationalitytf.setBounds(580, 125, 200, 28);
        nationalitytf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nationalitytf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nationalitytf.setEditable(false);

        religionlb = new JLabel("Religion");
        religionlb.setBounds(420, 160, 150, 25);
        religionlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        religiontf = new JTextField(Religion);
        religiontf.setBounds(580, 160, 200, 28);
        religiontf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        religiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        religiontf.setEditable(false);

        guardian = new JLabel("Guardian", JLabel.CENTER);
        guardian.setBounds(450, 195, 290, 30);
        guardian.setFont(new Font("Segoe UI", Font.BOLD, 20));
        guardian.setForeground(new Color(128, 0, 128));

        fnamelb = new JLabel("Father Name");
        fnamelb.setBounds(420, 230, 150, 25);
        fnamelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        fnametf = new JTextField(Father);
        fnametf.setBounds(580, 230, 200, 28);
        fnametf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        fnametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        fnametf.setEditable(false);

        mnamelb = new JLabel("Mother Name");
        mnamelb.setBounds(420, 265, 150, 25);
        mnamelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        mnametf = new JTextField(Mother);
        mnametf.setBounds(580, 265, 200, 28);
        mnametf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mnametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        mnametf.setEditable(false);

        address = new JLabel("Address", JLabel.CENTER);
        address.setBounds(450, 300, 290, 30);
        address.setFont(new Font("Segoe UI", Font.BOLD, 20));
        address.setForeground(new Color(128, 0, 128));

        divisionlb = new JLabel("Division");
        divisionlb.setBounds(420, 340, 150, 25);
        divisionlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        divisiontf = new JTextField(Division);
        divisiontf.setBounds(580, 340, 200, 28);
        divisiontf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        divisiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        divisiontf.setEditable(false);

        distlb = new JLabel("District");
        distlb.setBounds(420, 375, 150, 25);
        distlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        disttf = new JTextField(District);
        disttf.setBounds(580, 375, 200, 28);
        disttf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        disttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        disttf.setEditable(false);

        postlb = new JLabel("Post Office");
        postlb.setBounds(420, 410, 150, 25);
        postlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        posttf = new JTextField(PostOffice);
        posttf.setBounds(580, 410, 200, 28);
        posttf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        posttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        posttf.setEditable(false);

        thanalb = new JLabel("Upazila");
        thanalb.setBounds(420, 445, 150, 25);
        thanalb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        thanatf = new JTextField(Upazila);
        thanatf.setBounds(580, 445, 200, 28);
        thanatf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        thanatf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        thanatf.setEditable(false);

        villlb = new JLabel("Village");
        villlb.setBounds(420, 480, 150, 25);
        villlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        villtf = new JTextField(Village);
        villtf.setBounds(580, 480, 200, 28);
        villtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        villtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        villtf.setEditable(false);

        separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setBounds(800, 90, 3, 450);
        separator2.setBackground(Color.DARK_GRAY);

        nominee = new JLabel("Nominee / Guardian", JLabel.CENTER);
        nominee.setBounds(870, 45, 290, 30);
        nominee.setFont(new Font("Segoe UI", Font.BOLD, 20));
        nominee.setForeground(new Color(128, 0, 128));

        nominamelb = new JLabel("Nominee Name");
        nominamelb.setBounds(810, 90, 150, 25);
        nominamelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nominametf = new JTextField(NomiName);
        nominametf.setBounds(970, 90, 200, 28);
        nominametf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nominametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nominametf.setEditable(false);

        nomirelationlb = new JLabel("Relation");
        nomirelationlb.setBounds(810, 125, 150, 25);
        nomirelationlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomirelationtf = new JTextField(NomiRelation);
        nomirelationtf.setBounds(970, 125, 200, 28);
        nomirelationtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomirelationtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomirelationtf.setEditable(false);

        nomicontactlb = new JLabel("Nominee Contact");
        nomicontactlb.setBounds(810, 160, 150, 25);
        nomicontactlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomicontacttf = new JTextField(NomiContact);
        nomicontacttf.setBounds(970, 160, 200, 28);
        nomicontacttf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomicontacttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomicontacttf.setEditable(false);

        nomidivisionlb = new JLabel("Division");
        nomidivisionlb.setBounds(810, 195, 150, 25);
        nomidivisionlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomidivisiontf = new JTextField(NomiDivision);
        nomidivisiontf.setBounds(970, 195, 200, 28);
        nomidivisiontf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomidivisiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomidivisiontf.setEditable(false);

        nomidistrictlb = new JLabel("District");
        nomidistrictlb.setBounds(810, 230, 150, 25);
        nomidistrictlb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomidistricttf = new JTextField(NomiDistrict);
        nomidistricttf.setBounds(970, 230, 200, 28);
        nomidistricttf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomidistricttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomidistricttf.setEditable(false);

        nomipostOfficelb = new JLabel("Post Office");
        nomipostOfficelb.setBounds(810, 265, 150, 25);
        nomipostOfficelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomipostOfficetf = new JTextField(NomiPostOffice);
        nomipostOfficetf.setBounds(970, 265, 200, 28);
        nomipostOfficetf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomipostOfficetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomipostOfficetf.setEditable(false);

        nomiupazilalb = new JLabel("Upazila");
        nomiupazilalb.setBounds(810, 300, 150, 25);
        nomiupazilalb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomiupazilatf = new JTextField(NomiUpazila);
        nomiupazilatf.setBounds(970, 300, 200, 28);
        nomiupazilatf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomiupazilatf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomiupazilatf.setEditable(false);

        nomivillagelb = new JLabel("Village");
        nomivillagelb.setBounds(810, 335, 150, 25);
        nomivillagelb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomivillagetf = new JTextField(NomiVillage);
        nomivillagetf.setBounds(970, 335, 200, 28);
        nomivillagetf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nomivillagetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        nomivillagetf.setEditable(false);

        edit = new JButton("Edit");
        edit.setBounds(880, 450, 100, 30);
        edit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        edit.setBackground(new Color(39, 174, 96));
        edit.setForeground(Color.WHITE);
        edit.setFocusPainted(false);
        edit.setBorder(null);
        edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        edit.addActionListener(this);

        update = new JButton("Update");
        update.setBounds(880, 450, 100, 30);
        update.setFont(new Font("Segoe UI", Font.BOLD, 15));
        update.setBackground(new Color(230, 126, 34));
        update.setForeground(Color.WHITE);
        update.setFocusPainted(false);
        update.setBorder(null);
        update.setEnabled(false);
        update.setVisible(false);
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        update.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(1000, 450, 100, 30);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setBackground(new Color(192, 57, 43));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(null);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        C.add(detail);
        C.add(personal);
        C.add(namelb);
        C.add(nametf);
        C.add(accnumlb);
        C.add(accnumtf);
        C.add(phonelb);
        C.add(phonetf);
        C.add(emaillb);
        C.add(emailtf);
        C.add(pinlb);
        C.add(pinpf);
        C.add(show);
        C.add(changePin);
        C.add(nidlb);
        C.add(nidtf);
        C.add(genderlb);
        C.add(branchlb);
        C.add(branchtf);
        C.add(gendertf);
        C.add(doblb);
        C.add(dobField);
        C.add(separator1);
        C.add(guardian);
        C.add(fnamelb);
        C.add(fnametf);
        C.add(mnamelb);
        C.add(mnametf);
        C.add(address);
        C.add(divisionlb);
        C.add(divisiontf);
        C.add(nomidistrictlb);
        C.add(nomidistricttf);
        C.add(nomiupazilalb);
        C.add(nomiupazilatf);
        C.add(nomivillagelb);
        C.add(nomivillagetf);
        C.add(distlb);
        C.add(disttf);
        C.add(postlb);
        C.add(posttf);
        C.add(thanalb);
        C.add(thanatf);
        C.add(villlb);
        C.add(villtf);
        C.add(separator2);
        C.add(nominee);
        C.add(nomipostOfficelb);
        C.add(nomipostOfficetf);
        C.add(nationalitylb);
        C.add(nationalitytf);
        C.add(nomidivisionlb);
        C.add(nomidivisiontf);
        C.add(religionlb);
        C.add(religiontf);
        C.add(maritallb);
        C.add(maritaltf);
        C.add(occulb);
        C.add(occtf);
        C.add(accTypelb);
        C.add(accTypetf);
        C.add(nominamelb);
        C.add(nominametf);
        C.add(nomirelationlb);
        C.add(nomirelationtf);
        C.add(nomicontactlb);
        C.add(nomicontacttf);
        C.add(registrationlb);
        C.add(registrationdate);
        C.add(edit);
        C.add(update);
        C.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new CustomerHome(AccountNumber, Pin);
            frame.dispose();
        } else if (e.getSource() == edit) {
            nametf.setEditable(true);
            nametf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            phonetf.setEditable(true);
            phonetf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            emailtf.setEditable(true);
            emailtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            dobField.setEditable(true);
            dobField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nidtf.setEditable(true);
            nidtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            gendertf.setEditable(true);
            gendertf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            fnametf.setEditable(true);
            fnametf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            mnametf.setEditable(true);
            mnametf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            divisiontf.setEditable(true);
            divisiontf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            disttf.setEditable(true);
            disttf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            posttf.setEditable(true);
            posttf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            thanatf.setEditable(true);
            thanatf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            villtf.setEditable(true);
            villtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nationalitytf.setEditable(true);
            nationalitytf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            religiontf.setEditable(true);
            religiontf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            maritaltf.setEditable(true);
            maritaltf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            occtf.setEditable(true);
            occtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            accTypetf.setEditable(true);
            accTypetf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            branchtf.setEditable(true);
            branchtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nominametf.setEditable(true);
            nominametf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomirelationtf.setEditable(true);
            nomirelationtf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomicontacttf.setEditable(true);
            nomicontacttf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomidivisiontf.setEditable(true);
            nomidivisiontf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomidistricttf.setEditable(true);
            nomidistricttf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomipostOfficetf.setEditable(true);
            nomipostOfficetf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomiupazilatf.setEditable(true);
            nomiupazilatf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            nomivillagetf.setEditable(true);
            nomivillagetf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

            update.setVisible(true);
            update.setEnabled(true);
            edit.setVisible(false);
            edit.setEnabled(false);
        } else if (e.getSource() == update) {
            UpdateAccountDetail();

            nametf.setEditable(false);
            nametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            phonetf.setEditable(false);
            phonetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            emailtf.setEditable(false);
            emailtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            dobField.setEditable(false);
            dobField.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nidtf.setEditable(false);
            nidtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            gendertf.setEditable(false);
            gendertf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            fnametf.setEditable(false);
            fnametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            mnametf.setEditable(false);
            mnametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            divisiontf.setEditable(false);
            divisiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            disttf.setEditable(false);
            disttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            posttf.setEditable(false);
            posttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            thanatf.setEditable(false);
            thanatf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            villtf.setEditable(false);
            villtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nationalitytf.setEditable(false);
            nationalitytf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            religiontf.setEditable(false);
            religiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            maritaltf.setEditable(false);
            maritaltf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            occtf.setEditable(false);
            occtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            accTypetf.setEditable(false);
            accTypetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            branchtf.setEditable(false);
            branchtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nominametf.setEditable(false);
            nominametf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomirelationtf.setEditable(false);
            nomirelationtf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomicontacttf.setEditable(false);
            nomicontacttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomidivisiontf.setEditable(false);
            nomidivisiontf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomidistricttf.setEditable(false);
            nomidistricttf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomipostOfficetf.setEditable(false);
            nomipostOfficetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomiupazilatf.setEditable(false);
            nomiupazilatf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
            nomivillagetf.setEditable(false);
            nomivillagetf.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));

            update.setVisible(false);
            update.setEnabled(false);
            edit.setVisible(true);
            edit.setEnabled(true);
        } else if (e.getSource() == changePin) {
            new ChangePin(AccountNumber, Pin);
            frame.dispose();
        } else if (e.getSource() == show) {
            if (show.isSelected()) {
                pinpf.setEchoChar((char) (0));
                show.setText("Hide Pin");
            } else {
                pinpf.setEchoChar('\u2022');
                show.setText("Show Pin");
            }
        }
    }

    void AccountDetail() {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Customer_Account WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, AccountNumber);
            ResultSet rs = preparedstatement.executeQuery();
            while (rs.next()) {
                HolderName = rs.getString("Name");
                Father = rs.getString("Father");
                Mother = rs.getString("Mother");
                Phone = rs.getString("Phone");
                Email = rs.getString("Email");
                Birth = rs.getString("Birth");
                Nid = rs.getString("Nid");
                Gender = rs.getString("Gender");
                Nationality = rs.getString("Nationality");
                Religion = rs.getString("Religion");
                Marital = rs.getString("Marital");
                Occupation = rs.getString("Occupation");
                Division = rs.getString("Division");
                District = rs.getString("District");
                PostOffice = rs.getString("Post_Office");
                Upazila = rs.getString("Upazila");
                Village = rs.getString("Village");
                Balance = rs.getString("Balance");
                AccountType = rs.getString("Account_Type");
                Branch = rs.getString("Branch");
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
            rs.close();
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void UpdateAccountDetail() {
        DBConnection connection = new DBConnection();
        String query = "UPDATE Customer_Account SET Name = ?,Father = ?,Mother = ?,Birth = ?,Nid = ?,Gender = ?,"
                + "Phone = ?,Email = ?,Nationality = ?,Religion = ?,Marital = ?,Occupation = ?,Division = ?,"
                + "District = ?,Post_Office = ?,Upazila = ?,Village = ?,Account_Type = ?,Branch = ?,Nominee_Name = ?,"
                + "Nominee_Relation = ?,Nominee_Contract = ?,Nominee_Division = ?,Nominee_District = ?,"
                + "Nominee_PostOffice = ?,Nominee_Upazila = ?,Nominee_Village = ? "
                + "WHERE account_number = ?";

        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, nametf.getText());
            preparedstatement.setString(2, fnametf.getText());
            preparedstatement.setString(3, mnametf.getText());
            preparedstatement.setString(4, dobField.getText());
            preparedstatement.setString(5, nidtf.getText());
            preparedstatement.setString(6, gendertf.getText());
            preparedstatement.setString(7, phonetf.getText());
            preparedstatement.setString(8, emailtf.getText());
            preparedstatement.setString(9, nationalitytf.getText());
            preparedstatement.setString(10, religiontf.getText());
            preparedstatement.setString(11, maritaltf.getText());
            preparedstatement.setString(12, occtf.getText());
            preparedstatement.setString(13, divisiontf.getText());
            preparedstatement.setString(14, disttf.getText());
            preparedstatement.setString(15, posttf.getText());
            preparedstatement.setString(16, thanatf.getText());
            preparedstatement.setString(17, villtf.getText());
            preparedstatement.setString(18, accTypetf.getText());
            preparedstatement.setString(19, branchtf.getText());
            preparedstatement.setString(20, nominametf.getText());
            preparedstatement.setString(21, nomirelationtf.getText());
            preparedstatement.setString(22, nomicontacttf.getText());
            preparedstatement.setString(23, nomidivisiontf.getText());
            preparedstatement.setString(24, nomidistricttf.getText());
            preparedstatement.setString(25, nomipostOfficetf.getText());
            preparedstatement.setString(26, nomiupazilatf.getText());
            preparedstatement.setString(27, nomivillagetf.getText());
            preparedstatement.setString(28, AccountNumber);

            int update = preparedstatement.executeUpdate();
            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Account Updated Successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Account Not Found!");
            }
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
