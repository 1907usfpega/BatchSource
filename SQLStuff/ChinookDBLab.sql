/*2.1 */
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO=null;
/*2.2*/
SELECT * FROM ALBUM ORDER BY title DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;
/*2.3*/
--1
INSERT INTO Genre (GenreID, Name) VALUES (26, 'Vaporwave');
INSERT INTO Genre (GenreID, Name) VALUES (27, 'Hair Metal');
--2
INSERT INTO Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES(9, 'Vinny', 'Vincent');
INSERT INTO Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES(10, 'Benny', 'Benson');

--3
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(62, 'John Jonah', 'Jameson', 'jjj@mail.com');
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(63, 'Peter', 'Parker', 'pparaker@mail.com');

/*2.4*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME =  'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
/*2.5*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/*2.6*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
/*2.7*/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/*3.1*/
--1
SELECT LOCALTIMESTAMP FROM DUAL;

--2
SELECT LENGTH(NAME) FROM MEDIATYPE;

/*3.2*/
--1
SELECT AVG(TOTAL) FROM INVOICE;

--2
SELECT MAX(UNITPRICE) FROM TRACK;

/*3.3*/
--1
CREATE OR REPLACE FUNCTION AVERAGE_PRICE
RETURN NUMBER AS FINAL_AVERAGE NUMBER(10,2);
PRICE_SUM NUMBER(10, 2);
PRICE_COUNT NUMBER(10, 2);
PRICE_AVG NUMBER(10, 2);
BEGIN
    SELECT COUNT(*) INTO PRICE_COUNT FROM INVOICELINE;
    SELECT SUM(UNITPRICE) INTO PRICE_SUM FROM INVOICELINE;
    RETURN PRICE_SUM/PRICE_COUNT;
END;
/

SELECT AVERAGE_PRICE() FROM DUAL;
--SELECT AVG(UNITPRICE) FROM INVOICELINE;
/*3.4*/
SELECT * FROM EMPLOYEE WHERE EMPLOYEE.BIRTHDATE > '01-JAN-1969';
/*4.1*/

SET SERVEROUT ON;

CREATE OR REPLACE PROCEDURE SELECTNAMES(S OUT SYS_REFCURSOR) IS 
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
    S SYS_REFCURSOR;
    empfirstname EMPLOYEE.FIRSTNAME%TYPE;
    emplastname EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SELECTNAMES(S);
    LOOP
    FETCH S INTO empfirstname, emplastname;
    EXIT WHEN S%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE('Employee Name: '||empfirstname||' '||emplastname);
    END LOOP;
    CLOSE S;
END;
/

/*4.2*/
CREATE OR REPLACE PROCEDURE UPDATEINFO(EMPID IN NUMBER, NEW_INFO IN VARCHAR2, CHOICE IN NUMBER) IS 
BEGIN
CASE CHOICE
    WHEN 1 THEN UPDATE EMPLOYEE SET LASTNAME = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 2 THEN UPDATE EMPLOYEE SET FIRSTNAME = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 3 THEN UPDATE EMPLOYEE SET TITLE = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 4 THEN UPDATE EMPLOYEE SET ADDRESS = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 5 THEN UPDATE EMPLOYEE SET CITY = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 6 THEN UPDATE EMPLOYEE SET STATE = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 7 THEN UPDATE EMPLOYEE SET COUNTRY = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 8 THEN UPDATE EMPLOYEE SET POSTALCODE = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 9 THEN UPDATE EMPLOYEE SET PHONE = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 10 THEN UPDATE EMPLOYEE SET FAX = NEW_INFO WHERE EMPLOYEEID = EMPID;
    WHEN 11 THEN UPDATE EMPLOYEE SET EMAIL = NEW_INFO WHERE EMPLOYEEID = EMPID;
END CASE;
END;
/

EXEC UPDATEINFO(2, 'BILL', 2);

--2

CREATE OR REPLACE PROCEDURE SELECTBOSS(EMPID IN NUMBER) IS
bossid EMPLOYEE.REPORTSTO%TYPE;
bossfirstname EMPLOYEE.FIRSTNAME%TYPE;
bosslastname EMPLOYEE.LASTNAME%TYPE;
empfirstname EMPLOYEE.FIRSTNAME%TYPE;
emplastname EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SELECT FIRSTNAME, LASTNAME, REPORTSTO INTO empfirstname, emplastname, bossid FROM EMPLOYEE WHERE EMPLOYEEID = EMPID;
    DBMS_OUTPUT.PUT_LINE('Employee Name: '||empfirstname||' '||emplastname);
    SELECT FIRSTNAME, LASTNAME INTO bossfirstname, bosslastname FROM EMPLOYEE WHERE EMPLOYEEID = bossid;
    DBMS_OUTPUT.PUT_LINE('Boss Name: '||bossfirstname||' '||bosslastname);
END;
/

EXEC SELECTBOSS(4);
/*4.3*/

CREATE OR REPLACE PROCEDURE CUSTNAMEANDCOMPANY(CUSTID IN NUMBER) IS
custfirstname CUSTOMER.FIRSTNAME%TYPE;
custlastname CUSTOMER.LASTNAME%TYPE;
custcompany CUSTOMER.COMPANY%TYPE;
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO custfirstname, custlastname, custcompany FROM CUSTOMER WHERE CUSTOMERID = CUSTID;
    DBMS_OUTPUT.PUT_LINE('Customer Name: '||custfirstname||' '||custlastname);
    DBMS_OUTPUT.PUT_LINE('Customer Company: '||custcompany);
END;
/

EXEC CUSTNAMEANDCOMPANY(11);
/*5.0*/

--1
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INV_ID IN NUMBER) IS
--INVLINE_ID NUMBER;
BEGIN
    --SELECT INVOICELINEID INTO INVLINE_ID FROM INVOICELINE WHERE INVOICEID = INV_ID;
    DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
    DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
END;
/

EXEC DELETE_INVOICE(1);
--2
CREATE SEQUENCE CUSTINCREMENTOR
START WITH 60
INCREMENT BY 1
CACHE 20;
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER AS
BEGIN
    INSERT INTO CUSTOMER(CustomerID, FirstName, LastName, Email) VALUES(CUSTINCREMENTOR.NEXTVAL, 'John', 'Smith', 'jsmith@mail.com');
END;
/

EXEC NEW_CUSTOMER;
/*6.1*/
--1
SET SERVEROUT ON;

CREATE OR REPLACE TRIGGER MYEMPTRIGGER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Employee Inserted');
END;
/
DELETE FROM EMPLOYEE WHERE employeeid = 20 AND FIRSTNAME = 'Jackson' AND LASTNAME = 'Davis';
INSERT INTO EMPLOYEE(employeeid, firstname, lastname, email) VALUES(20, 'Jackson', 'Davis', 'jackdavis7118@gmail.com');
--2
SET SERVEROUT ON;

CREATE OR REPLACE TRIGGER MYALBUMTPRIGGER
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album UPDATED');
END;
/
UPDATE ALBUM SET TITLE = 'Jackson' WHERE ALBUMID = 1;
UPDATE ALBUM SET TITLE = 'For Those About To Rock We Salute You' WHERE ALBUMID = 1;
--3
SET SERVEROUT ON;

CREATE OR REPLACE TRIGGER MYCUSTTRIGGER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer DELETED');
END;
/
DELETE FROM CUSTOMER WHERE CUSTOMERID = 70 AND FIRSTNAME = 'Jackson' AND LASTNAME = 'Davis';
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(70, 'Jackson', 'Davis', 'jackdavis7118@gmail.com');
/*7.1*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.2*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--USE FULL OUTER JOIN

/*7.3*/
SELECT ALBUM.ALBUMID, ALBUM.TITLE, ARTIST.NAME FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

/*7.4*/
SELECT ARTIST.NAME, ALBUM.TITLE FROM ARTIST CROSS JOIN ALBUM ORDER BY ARTIST.NAME;

/*7.5*/
SELECT a.EMPLOYEEID AS "Employee ID", a.FIRSTNAME AS "Employee First Name", a.LASTNAME AS "Employee Last Name",
b.EMPLOYEEID AS "Boss ID", b.FIRSTNAME AS "Boss First Name", b.LASTNAME AS "Boss Last Name"
FROM EMPLOYEE a, EMPLOYEE b WHERE a.REPORTSTO = b.EMPLOYEEID;