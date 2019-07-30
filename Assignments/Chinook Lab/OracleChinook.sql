/*2.1 SELECT*/
/*2.1 Task 1*/
SELECT * FROM employee;
/*2.1 Task 2*/
SELECT * FROM employee WHERE lastname='King';
/*2.1 Task 3*/
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto=null;

/*2.2 ORDER BY*/
/*2.2 Task 1*/
SELECT * FROM album ORDER BY title DESC;
/*2.1 Task 2*/
SELECT firstname FROM customer ORDER BY city ASC;

/*2.3 INSERT INTO*/
/*2.3 Task 1*/
INSERT INTO genre VALUES(26,'Test');
INSERT INTO genre VALUES(27,'Test2');
--SELECT * FROM genre; --Use This To Check genre Table
/*2.3 Task 2*/
INSERT INTO employee VALUES(9, 'Kolstad', 'Kyle', 'Software Engineer', 6, DATE'1989-12-28', DATE'1936-1-20', '111 Somplace Ave', 'The Moon', 'Mn', 'The Universe', '234234', '+1 (555) 123-4321', '+1 (555) 234-5432', 'kylekolstad@gmail.com');
INSERT INTO employee VALUES(10, 'Bobbington', 'Bob', 'Security', 6, DATE'2019-7-8', DATE'2019-7-9', '321 Anywhere Rd', 'Marshfield', 'WI', 'USA', '657453', '+1 (545) 123-4626', '+1 (545) 254-5434', 'BO@gmail.com');
--SELECT * FROM employee; --Use This To Check employee Table
/*2.3 Task 3*/
INSERT INTO customer VALUES(60, 'Amy', 'Clamshell', 'ShamWow', '1 lake dr', 'Tampa', 'FL', 'USA', 'mailbox', '+1 (657) 123-4567', '+1 (657) 123-4567', 'amy@gmail.com', 5);
INSERT INTO customer VALUES(61, 'Ron', 'Swanson', 'Parks and Recreation', 'I dont want to be bothered', 'none of your business', 'I plead the fifth', 'wherever I want', 'No', 'I dont have one', 'dont need', 'I use a typewriter', 3);
--SELECT * FROM customer; --Use This To Check customer Table

/*2.4 UPDATE*/
/*2.4 Task 1*/
UPDATE customer SET firstname='Robert', lastname='Walker' WHERE firstname='Aaraon' AND lastname='Mitchell';
/*2.4 Task 2*/
UPDATE artist SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

/*2.5 LIKE*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN*/
/*2.6 Task 1*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/*2.6 Task 2*/
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-06-2003', 'DD-MM-YYYY') AND TO_DATE('01-03-2004', 'DD-MM-YYYY');

/*2.7 DELETE*/
-------------------------------------------------------***********************

/*3.1 System Defined Functions*/
/*3.1 Task 1*/
SELECT LOCALTIMESTAMP "CURRENT TIME" FROM DUAL;
--JUST FOR FUN HERE IS A USER DEFINED FUNCTION
CREATE OR REPLACE FUNCTION CURRENT_TIME
RETURN TIMESTAMP AS
CURRTIME TIMESTAMP;
BEGIN
SELECT CURRENT_TIMESTAMP
INTO CURRTIME
FROM DUAL;
RETURN CURRTIME;
END;
/

SELECT CURRENT_TIME "CURRENT TIME" FROM DUAL;

/*3.1 Task 2*/
SELECT LENGTH('MEDIATYPE') "LENGTH" FROM DUAL;

/*3.2 Sytem Defined Functions*/
/*3.2 Task 1*/
SELECT AVG(UNITPRICE) "AVERAGE TOTAL" FROM INVOICELINE;
/*3.2 Task 2*/
SELECT MAX(UNITPRICE) "MOST EXPENSIVE TRACK" FROM TRACK;
--IF WE WANT TO SEE THE TRACK NAME AS WELL 
SELECT "NAME" "TRACK NAME", UNITPRICE "MOST EXPENSIVE TRACK" FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

/*3.3 User Defined Scalar Functions*/
CREATE OR REPLACE FUNCTION AVERAGE_PRICE
RETURN NUMBER AS
AVGPRICE NUMBER(10,2);
BEGIN
SELECT AVG(UNITPRICE)
INTO AVGPRICE
FROM INVOICELINE;
RETURN AVGPRICE;
END;
/

SELECT AVERAGE_PRICE "AVERAGE PRICE" FROM DUAL;

/*3.4 User Defined Table Valued Functions*/
SELECT FIRSTNAME, LASTNAME, BIRTHDATE 
FROM EMPLOYEE
WHERE BIRTHDATE > TO_DATE('31-12-1968', 'DD-MM-YYYY');

/*CREATE OR REPLACE FUNCTION EMPLOYEES_AFTER1986
RETURN DATE AS
RESULTS DATE('DD-MM-YYYY');
BEGIN
SELECT BIRTHDATE 
INTO RESULTS
FROM EMPLOYEE
WHERE BIRTHDATE > TO_DATE('31-12-1968', 'DD-MM-YYYY');
RETURN RESULTS;
END;
/*/
--SELECT EMPLOYEES_AFTER1986 "EMPLOYEES BORN AFTER 1986" FROM DUAL;

/*4.1 Basic Stored Procedure*********************WHY WONT THIS WORK?*****************/
CREATE OR REPLACE PROCEDURE DISPLAY_NAME
AS
BEGIN
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE;
END;
/

SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE;

EXECUTE DISPLAY_NAME;

/*4.2 Stored Procedure Input Parameters*/
/*4.2 Task 1*/
CREATE OR REPLACE PROCEDURE UPDATE_INFO
(EID NUMBER, "ADD" IN VARCHAR2, CTY IN VARCHAR2, ST IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE SET ADDRESS ="ADD",CITY=CTY,"STATE"=ST
WHERE EMPLOYEEID=EID;
COMMIT;
END;
/
EXECUTE UPDATE_INFO(9,'TEST','TEST','TEST');
/*4.2 Task 2*******************************************************************************/
CREATE OR REPLACE PROCEDURE GET_MANAGERS
(EMPID NUMBER)
AS
BEGIN
SELECT REPORTSTO 
FROM EMPLOYEE
WHERE EMPLOYEEID=EMPID;
END;
/
EXECUTE UPDATE_INFO(9);

/*4.3 Stored Procedure Output Parameters*/

/*5.0 Transactions*/
/*5.0 Task 1*/
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(IVOICEID NUMBER)
AS
BEGIN
DELETE FROM INVOICELINE WHERE INVOICEID=IVOICEID;
DELETE FROM INVOICE WHERE INVOICEID=IVOICEID;
COMMIT;
END;
/

/*5.0 Task 2*/
--INSTEAD OF PASSING IN CUSTOMERID AS A VALUE IT CAN BE GENERATED USING A SEQUENCE
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER
(CID NUMBER, FNAME VARCHAR2, LNAME VARCHAR2, CMPNY VARCHAR2, ADRSS VARCHAR2, CTY VARCHAR2, ST VARCHAR2, CNTRY VARCHAR2, POSTCD VARCHAR2, PHONENUM VARCHAR2, FAXNUM VARCHAR2, CUSEMAIL VARCHAR2, SUPPID NUMBER)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(CID, FNAME, LNAME, CMPNY, ADRSS, CTY, ST, CNTRY, POSTCD, PHONENUM, FAXNUM, CUSEMAIL, SUPPID);
COMMIT;
END;
/
--EXECUTE NEW_CUSTOMER(60, 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 5);

/*6.1 AFTER/FOR*/
/*6.1 Task 1*/
CREATE OR REPLACE TRIGGER AFTER_EMPLOYEE_INSERT
AFTER INSERT ON EMPLOYEE
BEGIN
UPDATE EMPLOYEE SET TITLE='TEST' WHERE TITLE='New';
COMMIT;
END;
/
INSERT INTO employee VALUES(15, 'Bobbington', 'Bob', 'New', 6, DATE'2019-7-8', DATE'2019-7-9', '321 Anywhere Rd', 'Marshfield', 'WI', 'USA', '657453', '+1 (545) 123-4626', '+1 (545) 254-5434', 'BO@gmail.com');
/*6.1 Task 2*/
--CREATE OR REPLACE TRIGGER AFTER_ALBUM_UPDATE
--AFTER UPDATE ON ALBUM
--BEGIN
--...NOT SURE WHAT TO PUT HERE...
--END;
--/
/*6.1 Task 3*/
CREATE TABLE CUSTOMERCOUNT(
CUSTOMERID NUMBER PRIMARY KEY,
"COUNT" NUMBER);
INSERT INTO CUSTOMERCOUNT VALUES(1, 100); --TEST COUNT!

CREATE OR REPLACE TRIGGER AFTER_CUSTOMER_DELETE
AFTER DELETE ON CUSTOMER
BEGIN
UPDATE CUSTOMERCOUNT SET "COUNT"="COUNT" - 1;
COMMIT;
END;
/

/*7.1 INNER*/
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMER.FIRSTNAME;

/*7.2 OUTTER*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMER.FIRSTNAME;

/*7.3 RIGHT*/
SELECT ARTIST."NAME", ALBUM.TITLE
FROM ALBUM
RIGHT OUTER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST."NAME";

/*7.4 CROSS*/
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/*7.5 SELF*/
SELECT a.EMPLOYEEID "EMPLOYEE ID", a.FIRSTNAME "EMPLOYEE", b.EMPLOYEEID "EMPLOYEE ID", b.FIRSTNAME "REPORTED TO"
FROM EMPLOYEE a, EMPLOYEE b 
WHERE a.REPORTSTO = b.EMPLOYEEID
ORDER BY a.EMPLOYEEID;
