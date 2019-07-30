-- Creation/Manipulation of Tables & Data for JDBC Bank App assignment.

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER mdm
IDENTIFIED BY m0neY
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to mdm;
GRANT resource to mdm;
GRANT create session TO mdm;
GRANT create table TO mdm;
GRANT create view TO mdm;



conn mdm/m0neY

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE ACCOUNT
(
    ACCOUNTID NUMBER PRIMARY KEY,
    USERID NUMBER NOT NULL,
    BALANCE NUMBER NOT NULL,
    ACCOUNT_TYPE VARCHAR2(160) DEFAULT 'checking'
);

CREATE TABLE CUSTOMER
(
    CUSTOMERID NUMBER PRIMARY KEY,
    FIRSTNAME VARCHAR2(99),
    LASTNAME VARCHAR2(99) NOT NULL,
    EMAIL VARCHAR2(99),
    ADDRESS VARCHAR2(99),
    CITY VARCHAR2(99),
    STATE VARCHAR2(99),
    USERNAME VARCHAR2(99) UNIQUE NOT NULL,
    PASSWORD VARCHAR2(99) NOT NULL
);

CREATE TABLE EMPLOYEE
(
    EMPLOYEEID NUMBER PRIMARY KEY,
    FIRSTNAME VARCHAR2(99),
    LASTNAME VARCHAR2(99) NOT NULL,
    EMAIL VARCHAR2(99),
    ADDRESS VARCHAR2(99),
    CITY VARCHAR2(99),
    STATE VARCHAR2(99),
    USERNAME VARCHAR2(99) UNIQUE NOT NULL,
    PASSWORD VARCHAR2(99) NOT NULL,
    EMPLOYEE_TYPE VARCHAR2(99) DEFAULT 'employee' -- Set to admin for access to admin functions.
);

-- TRANSACTION TABLE TO RECORD TRANSACTIONS & DATE.
CREATE TABLE TRANSACTION
(
    TRANSACTIONID NUMBER PRIMARY KEY,
    ACCOUNTID NUMBER NOT NULL,
    AMOUNT NUMBER NOT NULL,
    TRANSACTION_DATE DATE
);


/*******************************************************************************
   Constraints & Sequences
********************************************************************************/
ALTER TABLE ACCOUNT
ADD CONSTRAINT FK_ACCOUNT_CUSTOMERID
FOREIGN KEY(USERID) REFERENCES CUSTOMER(CUSTOMERID);

ALTER TABLE TRANSACTION
ADD CONSTRAINT FK_TRANSACTION_ACCOUNTID
FOREIGN KEY(ACCOUNTID) REFERENCES ACCOUNT(ACCOUNTID);

CREATE SEQUENCE USERID_INC
MINVALUE 1000
MAXVALUE 100000
START WITH 1000
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE ACCOUNTID_INC
MINVALUE 100000
MAXVALUE 1000000
START WITH 100000
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE EMPLOYEEID_INC
MINVALUE 1
MAXVALUE 10000
START WITH 1
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE TRANSACTIONID_INC
MINVALUE 1
MAXVALUE 10000000
START WITH 1
INCREMENT BY 1
CACHE 20;

/*******************************************************************************
   Triggers, Functions, & Procedures
********************************************************************************/

CREATE TRIGGER BAL_UPDATE
AFTER UPDATE ON ACCOUNT.BALANCE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('New balance for ' || ACCOUNTID || ': ' || BALANCE);
END;
/

-- Creates new customer. Should be executed from Java.
CREATE OR REPLACE PROCEDURE add_customer
(FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2, EMAIL IN VARCHAR2, ADDRESS IN VARCHAR2, 
CITY IN VARCHAR2, STATE IN VARCHAR2, USERNAME IN VARCHAR2, PASSWORD IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(USERID_INC.NEXTVAL,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,CITY,STATE,USERNAME,PASSWORD);
COMMIT;
END;
/

-- Tester for add_customer
EXECUTE add_customer('Ted','Dibiase','money@gmail.com','123 Seasonal Residences','Miami','FL','milliondollarman','MONEY');
SELECT * FROM CUSTOMER;


-- Creates new account. Should be executed from Java.
CREATE OR REPLACE PROCEDURE add_account
(USERID IN NUMBER, BALANCE IN NUMBER, ACCT_TYPE IN VARCHAR2)
AS
BEGIN
INSERT INTO ACCOUNT VALUES(ACCOUNTID_INC.NEXTVAL,USERID,BALANCE,ACCT_TYPE);
COMMIT;
END;
/

-- Tester for add_account
EXECUTE add_account(1000,500000.00,'savings');
SELECT * FROM ACCOUNT;

-- Creates new employee. Should be executed from Java. Be sure to check admin.
CREATE OR REPLACE PROCEDURE add_employee
(FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2, EMAIL IN VARCHAR2, ADDRESS IN VARCHAR2, 
CITY IN VARCHAR2, STATE IN VARCHAR2, USERNAME IN VARCHAR2, PASSWORD IN VARCHAR2, EMPLOYEE_TYPE IN VARCHAR2)
AS
BEGIN
INSERT INTO EMPLOYEE VALUES(EMPLOYEEID_INC.NEXTVAL,FIRST_NAME,LAST_NAME,EMAIL,ADDRESS,CITY,STATE,USERNAME,PASSWORD, EMPLOYEE_TYPE);
COMMIT;
END;
/

-- Tester for add_employee.
EXECUTE add_employee('Matt','Jackson','youngbucks@bank.com','123 Superkick Drive','Reseda','CA','matt_jackson','Th33lit3','admin');
EXECUTE add_employee('Nick','Jackson','bucksofyouth@bank.com','124 Superkick Drive','Reseda','CA','nick_jackson','BigBuck$', 'employee');
SELECT * FROM EMPLOYEE;

-- Allows retrieving balance of a user account.
CREATE OR REPLACE PROCEDURE get_balance
(S OUT SYS_REFCURSOR, USER_ID IN NUMBER)
AS
BEGIN
OPEN S FOR
SELECT ACCOUNTID, BALANCE, ACCOUNT_TYPE FROM ACCOUNT
WHERE USERID = USER_ID;
END;
/
-- "Borrowing" template from assignment to work on this. <3
-- TODO: Fool around with displaying in Java.
SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
ACCT_NO ACCOUNT.ACCOUNTID%TYPE;
CURRENT_BAL ACCOUNT.BALANCE%TYPE;
ACCT_TYPE ACCOUNT.ACCOUNT_TYPE%TYPE;
BEGIN
    get_balance(S, 1000);
    LOOP
    FETCH S INTO ACCT_NO, CURRENT_BAL, ACCT_TYPE;
    EXIT WHEN S%NOTFOUND; -- BREAKS OUT OF LOOP WHEN NO MORE ROWS AVAILABLE.
    DBMS_OUTPUT.PUT_LINE(ACCT_TYPE || ' account #' || ACCT_NO || ': $' || CURRENT_BAL);
    END LOOP;
CLOSE S;
END;
/

-- Tester of get_balance.
EXECUTE get_balance(1000);

-- Procedure for updating balance in accounts. To be used for deposits & withdrawals. Also inserts into TRANSACTION.
CREATE OR REPLACE PROCEDURE make_transaction
(ACCOUNT_ID IN NUMBER, AMOUNT IN NUMBER)
AS
BEGIN

UPDATE ACCOUNT
SET BALANCE = BALANCE + AMOUNT
WHERE ACCOUNTID = ACCOUNT_ID;

INSERT INTO TRANSACTION VALUES(TRANSACTIONID_INC.NEXTVAL, ACCOUNT_ID, AMOUNT, CURRENT_DATE);
COMMIT;
END;
/

-- Tester for make_transaction
EXECUTE make_transaction(100000, 5000);
SELECT * FROM ACCOUNT;
SELECT * FROM TRANSACTION;


-- Allows deletion of account (from Customer, IFF balance is 0.00)
CREATE OR REPLACE PROCEDURE delete_account
(ACCOUNT_ID IN NUMBER)
AS
BEGIN
DELETE FROM ACCOUNT
WHERE ACCOUNTID = ACCOUNT_ID;
COMMIT;
DBMS_OUTPUT.PUT_LINE(' account #' || ACCOUNT_ID || ' has been DELETED!');
END;
/

-- Tester for delete_account
-- TODO: CREATE TESTER

-- Updates user account info.
CREATE OR REPLACE PROCEDURE update_customer
(CUSTOMER_ID IN NUMBER, FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2, EMAIL_ADD IN VARCHAR2, ADDR IN VARCHAR2, 
CITY_N IN VARCHAR2, STATE_N IN VARCHAR2, PW IN VARCHAR2)
AS
BEGIN
UPDATE CUSTOMER
SET FIRSTNAME = FIRST_NAME, LASTNAME = LAST_NAME, EMAIL = EMAIL_ADD, ADDRESS = ADDR, CITY = CITY_N, STATE = STATE_N,PASSWORD = PW
WHERE CUSTOMERID = CUSTOMER_ID;
COMMIT;
END;
/