"# Bank-Management-System" 

## Database
- SQL scripts are in the `SQL/` folder.
- Tables: Registration, customer_account,Transaction_History, Loan_Request

  # Registration Table :
  CREATE TABLE Registration 
(
account_number BIGINT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50) ,Father VARCHAR(50) ,Mother VARCHAR(50) ,Birth VARCHAR(50) ,Nid VARCHAR(50) ,Gender VARCHAR(15) ,Phone VARCHAR(20) ,Email VARCHAR(50) ,Pin VARCHAR(10) ,
Nationality VARCHAR(25) ,Religion VARCHAR(15) ,Marital VARCHAR(15) ,Occupation VARCHAR(25) ,Division VARCHAR(25) ,District VARCHAR(25) ,Post_Office VARCHAR(25) ,Upazila VARCHAR(25) ,Village VARCHAR(25) ,DepBalance VARCHAR(25) ,Account_Type VARCHAR(50),Branch VARCHAR(50),Nominee_Name VARCHAR(50),Nominee_Relation VARCHAR(30),
Nominee_Contract VARCHAR(20),Nominee_Division VARCHAR(20),Nominee_District VARCHAR(25),Nominee_PostOffice VARCHAR(25),Nominee_Upazila VARCHAR(25),Nominee_Village VARCHAR(25),
Registration VARCHAR(50)
)AUTO_INCREMENT = 5520250001;

# customer_account Table :
CREATE TABLE customer_account
(
 Srial_No INT AUTO_INCREMENT PRIMARY KEY,account_number BIGINT,Name VARCHAR(50) ,Father VARCHAR(50) ,Mother VARCHAR(50) ,Birth VARCHAR(50) ,Nid VARCHAR(50) ,
Gender VARCHAR(15) ,Phone VARCHAR(20) ,Email VARCHAR(50) ,Pin VARCHAR(10) ,Nationality VARCHAR(25) ,Religion VARCHAR(15) ,Marital varchar(15) ,Occupation varchar(25) ,
Division VARCHAR(25) ,District VARCHAR(25) ,Post_Office VARCHAR(25) ,Upazila VARCHAR(25) ,Village VARCHAR(25) ,Balance VARCHAR(25) ,Account_Type VARCHAR(50),Branch VARCHAR(50),Nominee_Name VARCHAR(50),Nominee_Relation VARCHAR(30),Nominee_Contract VARCHAR(20),Nominee_Division VARCHAR(20),Nominee_District VARCHAR(25),Nominee_PostOffice VARCHAR(25),Nominee_Upazila VARCHAR(25),Nominee_Village VARCHAR(25),Registration VARCHAR(50)
);

# Transaction_History Table : 
CREATE TABLE Transaction_History
(
 ID INT AUTO_INCREMENT PRIMARY KEY,account_number BIGINT, TX_Id VARCHAR(20) ,Type varchar(30),Balance varchar(50),Purpose VARCHAR(50),Status VARCHAR(20),
Request_Time_Date VARCHAR(80),Time_Date VARCHAR(80)
);

# Loan_Request Table : 
CREATE TABLE Loan_Request
(
ID INT AUTO_INCREMENT PRIMARY KEY,account_number BIGINT,Name VARCHAR(50), Loan_Balance VARCHAR(50),Purpose VARCHAR(100),Request_Time_Date VARCHAR(80)
);

