package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import java.sql.*;

public class CustomerDetails implements ActionListener {

    JFrame frame;
    Container C;
    JLabel tittle1, tittle2, personal, address, nominee, searchlb, name, namef, account, accountf, balance, balancef,
            acctype, acctypef, father, fatherf, mother, motherf, phone, phonef, email, emailf, nid, nidf, dofb, dofbf,
            gender, genderf, nationality, nationalityf, religion, religionf, marital, maritalf, occp, occpf, division,
            divisionf, district, districtf, postoffice, postofficef, thana, thanaf, village, villagef, registrationdate,
            nominame, nominamef, nomirelation, nomirelationf, nomicontact, nomicontactf, nomidivision, nomidivisionf,
            nomidistrict, nomidistrictf, nomipostoffice, nomipostofficef, nomiupazila, nomiupazilaf, nomivillage,
            nomivillagef, registrationdatef;
    JTextField searchtf;
    JPanel panel1, panel2;
    JTable table;
    DefaultTableModel modelTable;
    JTableHeader header;
    JScrollPane scroll;
    JButton back, search;

    String[] col = {"TX-Id", "Type", "Balance", "Purpose", "Status", "Request Time-Date", "Time-Date"};
    String[] row = new String[7];
    String HolderName, AccountNumber, Father, Mother, Birth, Nid, Gender, Phone, Email, Pin, Nationality, Religion,
            Marital, Occupation, Division, District, PostOffice, Upazila, Village, AccountType, Branch, Balance, NomiName,
            NomiRelation, NomiContact, NomiDivision, NomiDistrict, NomiPostOffice, NomiUpazila, NomiVillage, RegistrationDate;

    CustomerDetails(String AccountNumber) {

        this.AccountNumber = AccountNumber;

        frame = new JFrame();
        frame.setSize(1260, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        C = frame.getContentPane();
        C.setBackground(new Color(245, 247, 250));
        C.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(20, 5, 1210, 330);
        panel1.setBackground(new Color(230, 240, 250));
        panel1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        panel1.setLayout(null);

        tittle1 = new JLabel("Customer Detail");
        tittle1.setBounds(540, 10, 200, 25);
        tittle1.setFont(new Font("Segoe UI", Font.BOLD, 24));

        personal = new JLabel("Personal Information");
        personal.setBounds(20, 50, 250, 25);
        personal.setFont(new Font("SansSerif", Font.BOLD, 14));
        personal.setForeground(new Color(30, 80, 130));

        name = new JLabel("Holder name");
        name.setBounds(20, 80, 150, 25);
        name.setFont(new Font("Segoe UI", Font.BOLD, 16));

        namef = new JLabel();
        namef.setBounds(160, 80, 150, 25);
        namef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        namef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        account = new JLabel("Account Number");
        account.setBounds(20, 110, 150, 25);
        account.setFont(new Font("Segoe UI", Font.BOLD, 16));

        accountf = new JLabel();
        accountf.setBounds(160, 110, 150, 25);
        accountf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        accountf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        balance = new JLabel("Balance");
        balance.setBounds(20, 140, 150, 25);
        balance.setFont(new Font("Segoe UI", Font.BOLD, 16));

        balancef = new JLabel();
        balancef.setBounds(160, 140, 150, 25);
        balancef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        balancef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        acctype = new JLabel("Account Type");
        acctype.setBounds(20, 170, 150, 25);
        acctype.setFont(new Font("Segoe UI", Font.BOLD, 16));

        acctypef = new JLabel();
        acctypef.setBounds(160, 170, 150, 25);
        acctypef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        acctypef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        father = new JLabel("Father Name");
        father.setBounds(20, 200, 150, 25);
        father.setFont(new Font("Segoe UI", Font.BOLD, 16));

        fatherf = new JLabel();
        fatherf.setBounds(160, 200, 150, 25);
        fatherf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        fatherf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        mother = new JLabel("Mother Name");
        mother.setBounds(20, 230, 150, 25);
        mother.setFont(new Font("Segoe UI", Font.BOLD, 16));

        motherf = new JLabel();
        motherf.setBounds(160, 230, 150, 25);
        motherf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        motherf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        phone = new JLabel("Phone");
        phone.setBounds(20, 260, 150, 25);
        phone.setFont(new Font("Segoe UI", Font.BOLD, 16));

        phonef = new JLabel();
        phonef.setBounds(160, 260, 150, 25);
        phonef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        phonef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        email = new JLabel("E-mail");
        email.setBounds(20, 290, 150, 25);
        email.setFont(new Font("Segoe UI", Font.BOLD, 16));

        emailf = new JLabel();
        emailf.setBounds(160, 290, 150, 25);
        emailf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        emailf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nid = new JLabel("NID");
        nid.setBounds(325, 80, 150, 25);
        nid.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nidf = new JLabel();
        nidf.setBounds(460, 80, 150, 25);
        nidf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nidf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        dofb = new JLabel("Date of Birth");
        dofb.setBounds(325, 110, 150, 25);
        dofb.setFont(new Font("Segoe UI", Font.BOLD, 16));

        dofbf = new JLabel();
        dofbf.setBounds(460, 110, 150, 25);
        dofbf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        dofbf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        gender = new JLabel("Gender");
        gender.setBounds(325, 140, 150, 25);
        gender.setFont(new Font("Segoe UI", Font.BOLD, 16));

        genderf = new JLabel();
        genderf.setBounds(460, 140, 150, 25);
        genderf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        genderf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        religion = new JLabel("Religion");
        religion.setBounds(325, 170, 150, 25);
        religion.setFont(new Font("Segoe UI", Font.BOLD, 16));

        religionf = new JLabel();
        religionf.setBounds(460, 170, 150, 25);
        religionf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        religionf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nationality = new JLabel("Nationality");
        nationality.setBounds(325, 200, 150, 25);
        nationality.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nationalityf = new JLabel();
        nationalityf.setBounds(460, 200, 150, 25);
        nationalityf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nationalityf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        marital = new JLabel("Marital Status");
        marital.setBounds(325, 230, 150, 25);
        marital.setFont(new Font("Segoe UI", Font.BOLD, 16));

        maritalf = new JLabel();
        maritalf.setBounds(460, 230, 150, 25);
        maritalf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        maritalf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        occp = new JLabel("Occupation");
        occp.setBounds(325, 260, 150, 25);
        occp.setFont(new Font("Segoe UI", Font.BOLD, 16));

        occpf = new JLabel();
        occpf.setBounds(460, 260, 150, 25);
        occpf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        occpf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        registrationdate = new JLabel("Join Date");
        registrationdate.setBounds(325, 290, 150, 25);
        registrationdate.setFont(new Font("Segoe UI", Font.BOLD, 16));

        registrationdatef = new JLabel();
        registrationdatef.setBounds(460, 290, 150, 25);
        registrationdatef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        registrationdatef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        address = new JLabel("Address Information");
        address.setBounds(625, 50, 250, 25);
        address.setFont(new Font("SansSerif", Font.BOLD, 14));
        address.setForeground(new Color(30, 80, 130));

        division = new JLabel("Division");
        division.setBounds(625, 80, 150, 25);
        division.setFont(new Font("Segoe UI", Font.BOLD, 16));

        divisionf = new JLabel();
        divisionf.setBounds(725, 80, 150, 25);
        divisionf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        divisionf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        district = new JLabel("District");
        district.setBounds(625, 110, 150, 25);
        district.setFont(new Font("Segoe UI", Font.BOLD, 16));

        districtf = new JLabel();
        districtf.setBounds(725, 110, 150, 25);
        districtf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        districtf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        postoffice = new JLabel("Post Office");
        postoffice.setBounds(625, 140, 150, 25);
        postoffice.setFont(new Font("Segoe UI", Font.BOLD, 16));

        postofficef = new JLabel();
        postofficef.setBounds(725, 140, 150, 25);
        postofficef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        postofficef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        thana = new JLabel("Upazila");
        thana.setBounds(625, 170, 150, 25);
        thana.setFont(new Font("Segoe UI", Font.BOLD, 16));

        thanaf = new JLabel();
        thanaf.setBounds(725, 170, 150, 25);
        thanaf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        thanaf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        village = new JLabel("Village");
        village.setBounds(625, 200, 150, 25);
        village.setFont(new Font("Segoe UI", Font.BOLD, 16));

        villagef = new JLabel();
        villagef.setBounds(725, 200, 150, 25);
        villagef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        villagef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nominee = new JLabel("Nominee / Guardian Information");
        nominee.setBounds(900, 50, 250, 25);
        nominee.setFont(new Font("SansSerif", Font.BOLD, 14));
        nominee.setForeground(new Color(30, 80, 130));

        nominame = new JLabel("Nominee Name");
        nominame.setBounds(900, 80, 150, 25);
        nominame.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nominamef = new JLabel();
        nominamef.setBounds(1045, 80, 150, 25);
        nominamef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nominamef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomirelation = new JLabel("Nominee Relation");
        nomirelation.setBounds(900, 110, 150, 25);
        nomirelation.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomirelationf = new JLabel();
        nomirelationf.setBounds(1045, 110, 150, 25);
        nomirelationf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomirelationf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomicontact = new JLabel("Nominee Contact");
        nomicontact.setBounds(900, 140, 150, 25);
        nomicontact.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomicontactf = new JLabel();
        nomicontactf.setBounds(1045, 140, 150, 25);
        nomicontactf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomicontactf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomidivision = new JLabel("Division");
        nomidivision.setBounds(900, 170, 150, 25);
        nomidivision.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomidivisionf = new JLabel();
        nomidivisionf.setBounds(1045, 170, 150, 25);
        nomidivisionf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomidivisionf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomidistrict = new JLabel("District");
        nomidistrict.setBounds(900, 200, 150, 25);
        nomidistrict.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomidistrictf = new JLabel();
        nomidistrictf.setBounds(1045, 200, 150, 25);
        nomidistrictf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomidistrictf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomipostoffice = new JLabel("Post Office");
        nomipostoffice.setBounds(900, 230, 150, 25);
        nomipostoffice.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomipostofficef = new JLabel();
        nomipostofficef.setBounds(1045, 230, 150, 25);
        nomipostofficef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomipostofficef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomiupazila = new JLabel("Upazila");
        nomiupazila.setBounds(900, 260, 150, 25);
        nomiupazila.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomiupazilaf = new JLabel();
        nomiupazilaf.setBounds(1045, 260, 150, 25);
        nomiupazilaf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomiupazilaf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        nomivillage = new JLabel("Village");
        nomivillage.setBounds(900, 290, 150, 25);
        nomivillage.setFont(new Font("Segoe UI", Font.BOLD, 16));

        nomivillagef = new JLabel();
        nomivillagef.setBounds(1045, 290, 150, 25);
        nomivillagef.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nomivillagef.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        panel2 = new JPanel();
        panel2.setBounds(40, 350, 1170, 230);
        panel2.setBackground(new Color(230, 240, 250));
        panel2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        panel2.setLayout(null);

        tittle2 = new JLabel("Transaction Detail");
        tittle2.setBounds(520, 10, 250, 25);
        tittle2.setFont(new Font("Segoe UI", Font.BOLD, 24));

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
        scroll.setBounds(10, 50, 1150, 170);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));

        searchlb = new JLabel("Search Account");
        searchlb.setBounds(20, 20, 150, 25);
        searchlb.setFont(new Font("Segoe UI", Font.BOLD, 18));

        searchtf = new JTextField();
        searchtf.setBounds(160, 20, 200, 25);
        searchtf.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        search = new JButton("Search");
        search.setBounds(365, 20, 100, 25);
        search.setBackground(new Color(0, 51, 102));
        search.setForeground(Color.WHITE);
        search.setFocusPainted(false);
        search.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        search.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(1090, 20, 100, 30);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setFocusPainted(false);
        back.setBackground(new Color(192, 57, 43));
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        panel1.add(personal);
        panel1.add(address);
        panel1.add(nominee);
        panel1.add(tittle1);
        panel1.add(name);
        panel1.add(nominame);
        panel1.add(nominamef);
        panel1.add(namef);
        panel1.add(account);
        panel1.add(accountf);
        panel1.add(balance);
        panel1.add(balancef);
        panel1.add(nomirelation);
        panel1.add(nomirelationf);
        panel1.add(acctype);
        panel1.add(acctypef);
        panel1.add(father);
        panel1.add(fatherf);
        panel1.add(mother);
        panel1.add(nomicontact);
        panel1.add(nomicontactf);
        panel1.add(motherf);
        panel1.add(phone);
        panel1.add(phonef);
        panel1.add(email);
        panel1.add(emailf);
        panel1.add(nid);
        panel1.add(nidf);
        panel1.add(dofb);
        panel1.add(dofbf);
        panel1.add(gender);
        panel1.add(genderf);
        panel1.add(nationality);
        panel1.add(nationalityf);
        panel1.add(religion);
        panel1.add(religionf);
        panel1.add(marital);
        panel1.add(maritalf);
        panel1.add(occp);
        panel1.add(occpf);
        panel1.add(division);
        panel1.add(divisionf);
        panel1.add(district);
        panel1.add(districtf);
        panel1.add(postoffice);
        panel1.add(postofficef);
        panel1.add(thana);
        panel1.add(thanaf);
        panel1.add(village);
        panel1.add(villagef);
        panel1.add(nomidivision);
        panel1.add(nomidivisionf);
        panel1.add(nomidistrict);
        panel1.add(nomidistrictf);
        panel1.add(nomipostoffice);
        panel1.add(nomipostofficef);
        panel1.add(nomiupazila);
        panel1.add(nomiupazilaf);
        panel1.add(nomivillage);
        panel1.add(nomivillagef);
        panel1.add(registrationdate);
        panel1.add(registrationdatef);
        panel1.add(searchlb);
        panel1.add(searchtf);
        panel1.add(search);
        panel1.add(back);
        panel2.add(tittle2);
        panel2.add(scroll);
        C.add(panel1);
        C.add(panel2);

        CustomerDetail(AccountNumber);
        TransactionSetail(AccountNumber);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Admin_Panel();
            frame.dispose();
        } else if (e.getSource() == search) {
            String number = searchtf.getText();
            CustomerDetail(number);
            TransactionSetail(number);
        }
    }

    void CustomerDetail(String Account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM customer_account WHERE account_number = ?";
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, Account);
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
            SetDetails(Account);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void TransactionSetail(String Account) {
        DBConnection connection = new DBConnection();
        String query = "SELECT * FROM Transaction_History WHERE account_number = ?";
        modelTable.setRowCount(0);
        try {
            PreparedStatement preparedstatement = connection.connection.prepareStatement(query);
            preparedstatement.setString(1, Account);
            ResultSet rs = preparedstatement.executeQuery();

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
            preparedstatement.close();
            connection.connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    void SetDetails(String number) {
        namef.setText(HolderName);
        accountf.setText(number);
        balancef.setText(Balance);
        acctypef.setText(AccountType);
        fatherf.setText(Father);
        motherf.setText(Mother);
        phonef.setText(Phone);
        emailf.setText(Email);
        nidf.setText(Nid);
        dofbf.setText(Birth);
        genderf.setText(Gender);
        religionf.setText(Religion);
        nationalityf.setText(Nationality);
        maritalf.setText(Marital);
        occpf.setText(Occupation);
        divisionf.setText(Division);
        districtf.setText(District);
        postofficef.setText(PostOffice);
        thanaf.setText(Upazila);
        villagef.setText(Village);
        nominamef.setText(NomiName);
        nomirelationf.setText(NomiRelation);
        nomidivisionf.setText(NomiDivision);
        nomicontactf.setText(NomiContact);
        nomidistrictf.setText(NomiDistrict);
        nomiupazilaf.setText(NomiUpazila);
        nomivillagef.setText(NomiVillage);
        registrationdatef.setText(RegistrationDate);
        nomipostofficef.setText(NomiPostOffice);
    }
}
