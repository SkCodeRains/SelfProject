
System cls;
drop databas
if exists BankOperations;
create database BankOperations;
use BankOperations;
Create table users
(
    userID varchar(30) NOT null primary key,
    pswd varchar(30),
    usernm varchar(30),
    usertype varchar(30) DEFAULT 'Customer',
    userstatus varchar(30) DEFAULT 'active'
);
INSERT into users
values('ss', 'ss', 'kashif khan', 'manager', 'active');
INSERT into users
values('aa', 'aa', 'kashif khan', 'Cashier', 'active');
create table accounts
(
    accno VARCHAR(30) NOT null primary key,
    accnm varchar(30),
    acctype varchar(30),
    balance FLOAT check(balance>=0),
    opendate DATE
);
create TABLE acctransactions
(
    transno VARCHAR(30) not null primary key,
    transdt date,
    accno VARCHAR(30),
    transactiontype varchar(30),
    amount FLOAT,
    tofor VARCHAR(30) DEFAULT'self',
    FOREIGN key (accno)REFERENCES accounts(accno)
);
CREATE TABLE acchistory
(
    acno VARCHAR(30),
    acnm varchar(30),
    actype varchar(20),
    pswd varchar(30)
);
DELIMITER //
CREATE PROCEDURE NEWACCOUNT(accnos varchar
(30), PASSWORDs varchar
(30), uname varchar
(30), utype varchar
(30), ustatus varchar
(30), bal float)
BEGIN
    INSERT INTO users
    VALUES(accnos, PASSWORDs, uname, DEFAULT , ustatus);

    INSERT INTO accounts
    VALUES(accnos, uname, utype, bal, NOW());
END
//
CREATE PROCEDURE transaction(t1 varchar
(30),t2 varchar
(30),ID VARCHAR
(30),ID2 VARCHAR
(30),amt FLOAT)
BEGIN
    update accounts set balance=balance-amt where accno=t1;
    update accounts set balance=balance+amt where accno=t2;
    INSERT INTO acctransactions
    VALUES(ID, NOW(), t1, 'Withdraw', amt, t2);
    INSERT INTO acctransactions
    VALUES(ID2, NOW(), t2, 'Deposite', amt, t1);
END
//
CREATE PROCEDURE billpay(t1 varchar
(30),t2 varchar
(30),ID VARCHAR
(30),ID2 VARCHAR
(30),amt FLOAT
,fors VARCHAR
(30)
)
BEGIN
    update accounts set balance=balance-amt where accno=t1;
    update accounts set balance=balance+amt where accno=t2;
    INSERT INTO acctransactions
    VALUES(ID, NOW(), t1, fors, amt, t2);
    INSERT INTO acctransactions
    VALUES(ID2, NOW(), t2, "deposit", amt, t1);
END
//
CREATE PROCEDURE withdrawDesposit(t1 varchar
(30),ID VARCHAR
(30),ttype VARCHAR
(30),amt FLOAT)
BEGIN
    update accounts set balance=balance+amt where accno=t1;
    INSERT INTO acctransactions
    VALUES(ID, NOW(), t1, ttype, amt, DEFAULT);
END
//
CREATE PROCEDURE search()
BEGIN
    SELECT accounts.*, users.userstatus
    FROM accounts
        LEFT OUTER JOIN
        users on users.userID=accounts.accno
    where accounts.acctype<>"ltm";
end
//
CREATE PROCEDURE deletes(Acno varchar
(30))
BEGIN
    DELETE FROM acctransactions where accno=Acno;

    DELETE FROM accounts where accno=Acno;

    DELETE FROM users where userID=Acno;

end
//
CREATE PROCEDURE   searchUpd(ID varchar
(30))
BEGIN
    SELECT accounts.*, users.userstatus, users.pswd
    FROM accounts
        LEFT OUTER JOIN
        users on users.userID=accounts.accno
    where accounts.accno=ID;
end
//
CREATE PROCEDURE UPDATEacc(accnos VARCHAR
(30), PASSWORDs varchar
(30), uname varchar
(30), utype varchar
(30), ustatus varchar
(30))
BEGIN
    UPDATE accounts SET accnm=uname,acctype=utype WHERE accno=accnos;
    UPDATE users set pswd=PASSWORDs,usernm=uname,usertype=DEFAULT,userstatus=ustatus where userID=accnos;
END
//
CREATE PROCEDURE todaysRecords()
BEGIN
    select *
    from acctransactions
    where transdt=DATE(NOW());
END
//
    DELIMITER ;


    
    call NEWACCOUNT
('Vodafone','Vodafone','Vodafone','ltm','active',1000);

    call NEWACCOUNT
('Airtel','Airtel','Airtel','ltm','active',1000);

    call NEWACCOUNT
('DishTV','DishTV','DishTV','ltm','active',1000);

    call NEWACCOUNT
('Vitran','Vitran','Vitran','ltm','active',1000);

    call NEWACCOUNT
('MahaSk','MahaSk','MahaSk','ltm','active',1000);

    
    call NEWACCOUNT
('sas','ss','ss','fixed','active',1000);

