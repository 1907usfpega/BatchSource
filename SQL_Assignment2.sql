-- 2.1 SELECT tests.
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE (LASTNAME = 'King');

SELECT * FROM EMPLOYEE WHERE (FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL);

-- 2.2 ORDER BY tests.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;


-- 2.3 INSERT INTO tests.
SELECT * FROM GENRE;
INSERT INTO GENRE VALUES(26, 'Trap');
INSERT INTO GENRE VALUES(27, 'Dub');

DESC EMPLOYEE;
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES(9,'Chesnut','Jared','Code Monkey',null,'13-JUN-87','24-JUL-19',null,'Birmingham','AL','USA',null,
'1+ (205) 123-1234',null,'red.chesnut@yahoo.com');
INSERT INTO EMPLOYEE VALUES(10,'Robertson','Bobert','Robber',2,'06-DEC-76','11-JAN-11','123 Rob Lowe Lane','Atlanta','GA','USA',null,
'1+ (205) 123-1234',null,'rob.rob@gmail.com');

DESC CUSTOMER;
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER VALUES(60, 'Bob','Loblaw','Bob Loblaw''s Law Blog','121 Drury Lane','Phoenix','AZ','USA',null,null,null,
'loblaw.bob@loblawlawblog.com', null);
INSERT INTO CUSTOMER VALUES(61, 'Bolo','Yeung','','','','','Mongolia',14200,'+976 4812-7799',null,
'bloodsport.fan@gmail.com', 1);

-- 2.4 UPDATE tests.
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE tests
---- Returns all Billing addresses that start with T. % is a wildcard for rest of VARCHAR.
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN tests
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE tests.
---- Child record found. Possible issue in Invoice. Would need to remove from InvoiceLine first?
DELETE FROM INVOICELINE
    WHERE INVOICEID IN(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert'
    AND LASTNAME = 'Walter'));

DELETE FROM INVOICE
    WHERE CUSTOMERID IN(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

---- Proof that customer has been removed.
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.0 FUNCTIONS
-- 3.1 - System Defined Functions
---- Returns date/time. Thx Oracle.
SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;

---- Returns length of elements in MEDIATYPE.     
SELECT NAME, LENGTH(NAME) FROM MEDIATYPE; 

-- 3.2 - System Defined Aggregate Functions
SELECT AVG(TOTAL) FROM INVOICE;

---- Returns tracks with highest cost.
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

-- 3.3 - User Defined Scalar Functions
---- Returns average price of InvoiceLine items in InvoiceLine table for each invoice. General purpose, not per invoiceID.
SELECT * FROM INVOICELINE;
DESC INVOICELINE;
---- Biggest headache is figuring out how to aggregate/increment.
SELECT AVG(UNITPRICE) FROM INVOICELINE A, INVOICELINE B HAVING A.INVOICEID = B.INVOICEID;

-- 3.4 - User Defined Table Valued Functions

---- Return all employees born after 1968.
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';

-- 4.0 STORED PROCEDURES
-- 4.1 - Basic Stored Procedure

---- Stored Procedure that selects the first & last name of all employees. Try to use Stored Procedure.
CREATE OR REPLACE PROCEDURE get_names
(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
-- "Borrowing" template from assignment to work on this. <3

SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    get_names(S);
    LOOP
    FETCH S INTO FIRST_NAME, LAST_NAME;
    EXIT WHEN S%NOTFOUND; -- BREAKS OUT OF LOOP WHEN NO MORE ROWS AVAILABLE.
    DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME || ' IS AN EMPLOYEE.');
    END LOOP;
CLOSE S;
END;
/

-- 4.2 - Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee
(EMPLOYEE_ID IN NUMBER,LAST_NAME IN VARCHAR2, FIRST_NAME IN VARCHAR2, ROLE IN VARCHAR2,REPORTS_TO IN NUMBER, ADDRESS_PLACE IN VARCHAR2, 
CITY_PLACE IN VARCHAR2, STATE_PLACE IN VARCHAR2, COUNTRY_PLACE IN VARCHAR2, POSTAL_CODE IN NUMBER, PHONENO IN VARCHAR2, FAXNO IN VARCHAR2, 
EMAILA IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE
SET FIRSTNAME = FIRST_NAME, LASTNAME = LAST_NAME, TITLE = ROLE, REPORTSTO = REPORTS_TO, ADDRESS = ADDRESS_PLACE, CITY = CITY_PLACE, STATE = STATE_PLACE, COUNTRY = COUNTRY_PLACE, POSTALCODE = POSTAL_CODE, PHONE = PHONENO, FAX = FAXNO, EMAIL = EMAILA
WHERE EMPLOYEEID = EMPLOYEE_ID;
END;
/

EXECUTE update_employee(10,'CHESNUT','JARED','GIGAS MAIN',3,'123 BRUCE B DOWNS DR.', 'TAMPA', 'FL', 'USA', 12345,'1+ (205) 123-1234', NULL, 'RED.CHESNUT@YAHOO.COM');
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 10;

---- Procedure that selects the managers for a given employee. Checks out.
CREATE OR REPLACE PROCEDURE get_managers
(EMPLOYEE_ID IN NUMBER, S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPLOYEE_ID);
END;
/

-- WISHLIST: Have original Employee print out with statement: "EMPLOYEE A's manager is EMPLOYEE B."
SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    get_managers(3, S);
    LOOP
    FETCH S INTO FIRST_NAME, LAST_NAME;
    EXIT WHEN S%NOTFOUND; -- BREAKS OUT OF LOOP WHEN NO MORE ROWS AVAILABLE.
    DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME || ' IS THE MANAGER.');
    END LOOP;
CLOSE S;
END;
/

-- 4.3 - Create a stored procedure that returns the name and company of a customer. TODO: WORK ON THIS.
CREATE OR REPLACE PROCEDURE cust_company_log
(CUST_ID IN NUMBER, S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
WHERE CUSTOMERID = CUST_ID;
END;
/

SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
COMPANY_NAME CUSTOMER.COMPANY%TYPE;
BEGIN
    cust_company_log(5, S);
    LOOP
    FETCH S INTO FIRST_NAME, LAST_NAME, COMPANY_NAME;
    EXIT WHEN S%NOTFOUND; -- BREAKS OUT OF LOOP WHEN NO MORE ROWS AVAILABLE.
    DBMS_OUTPUT.PUT_LINE('Name: ' || FIRST_NAME || ' ' || LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('Company: ' || COMPANY_NAME);
    END LOOP;
CLOSE S;
END;
/

-- 5.0 TRANSACTIONS
-- 5.1 - Create a transaction that given a invoiceId will delete that invoice. Need to remove reference in INVOICELINE.
CREATE OR REPLACE PROCEDURE remove_invoice
(INVOICE_ID IN NUMBER)
AS
BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID = INVOICE_ID;

DELETE FROM INVOICE
WHERE INVOICEID = INVOICE_ID;
DBMS_OUTPUT.PUT_LINE('Invoice #' || INVOICE_ID || ' has been DELETED!');
END;
/

COMMIT;
ROLLBACK;

EXECUTE remove_invoice(22);

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE add_customer
(CUST_ID IN NUMBER,FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2, COMPANY IN VARCHAR2, ADDRESS IN VARCHAR2, 
CITY IN VARCHAR2, STATE IN VARCHAR2, COUNTRY IN VARCHAR2, POSTAL_CODE IN NUMBER, PHONENO IN VARCHAR2, FAXNO IN VARCHAR2, 
EMAIL IN VARCHAR2,SUPPORTREPID IN NUMBER)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(CUST_ID,FIRST_NAME,LAST_NAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTAL_CODE,PHONENO,FAXNO,EMAIL,SUPPORTREPID);
END;
/

EXECUTE add_customer(999,'DIEGO','MARADONA','BOCA JUNIORS','123 CHUPA ARGENTINA LN.','BUENOS AIRES',NULL,'ARGENTINA',45567,'1234-5678','5678-1234','NO.HANDS@FIFA.COM',NULL);
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 999;

-- 6.0 TRIGGERS
-- 6.1 - AFTER/FOR -  Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE TRIGGER new_employee_record
AFTER INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('New Employee has been added!');
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table. Will that print?
CREATE TRIGGER update_album_trig
AFTER UPDATE ON ALBUM
BEGIN
DBMS_OUTPUT.PUT_LINE('Row has been altered!');
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE TRIGGER customer_record_removed
AFTER DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('Row has been DELETED!');
END;
/


-- 7.0 JOINS
-- 7.1 - INNER JOIN
---- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT A.FIRSTNAME, A.LASTNAME, B.INVOICEID FROM CUSTOMER A INNER JOIN INVOICE B ON A.CUSTOMERID = B.CUSTOMERID;

-- 7.2 - OUTER JOIN
---- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT A.CUSTOMERID, A.FIRSTNAME, A.LASTNAME, B.INVOICEID, B.TOTAL
    FROM CUSTOMER A FULL OUTER JOIN INVOICE B ON A.CUSTOMERID=B.CUSTOMERID;
    
-- 7.3 - RIGHT JOIN
---- Create a right join that joins album and artist specifying artist name and title
SELECT B.NAME, A.TITLE FROM ALBUM A RIGHT JOIN ARTIST B ON A.ARTISTID = B.ARTISTID;

-- 7.4 - CROSS JOIN
---- Create a cross join that joins album and artist and sorts by artist name in ascending order. Unsure this is working
---- 100%. May be due to return value?
SELECT * FROM ALBUM A CROSS JOIN ARTIST B ORDER BY B.NAME ASC;

-- 7.5 - SELF JOIN
---- Perform a self-join on the employee table, joining on the reportsto column
SELECT * FROM EMPLOYEE A, EMPLOYEE B WHERE A.REPORTSTO = B.REPORTSTO;
