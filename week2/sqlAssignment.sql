-- Andrew Valancius
-- SQL Assignment Due 7/30 5pm




--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM ALBUM ORDER BY TITLE;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY FIRSTNAME DESC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table 

INSERT INTO GENRE(GENRE.GENREID, NAME)
VALUES(50,'Technical Deathcore');
INSERT INTO GENRE(GENRE.GENREID, NAME)
VALUES(51,'Metalcore');

--Task – Insert two new records into Employee table

INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,
FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL )
VALUES(20,'Jenkins','Tim','Sr. Developer',1,'13-FEB-89','15-OCT-10','233 Main St','Calgary','AB','Canada',
'T2P 5M5','+1 (403) 433-1234','+1 (403) 675-5678','timJenkins@gmail.com');

INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,
FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL )
VALUES(21,'James','Kevin','Jr. Developer',20,'13-JUL-93','09-JUL-10','15 Green Bvld','Calgary','AB','Canada',
'T2P 5G3','+1 (403) 113-4991','+1 (403) 555-9876','kevinJames@gmail.com');

--Task – Insert two new records into Customer table
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(50,'Gerald','Hart',NULL,'32 Gem St','Edmonton','AB','Canada','T5K 2N1','+1 (780) 842-9876',NULL,'geraldHart@gmail.com',3);

INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(51,'Hank','Roper',NULL,'567 32nd Str','Edmonton','AB','Canada','T5K 2N1','+1 (780) 887-6453',NULL,'hankRoper@gmail.com',4);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER
SET LASTNAME='Walter' 
WHERE CUSTOMERID=32;
UPDATE CUSTOMER
SET FIRSTNAME='Robert' 
WHERE CUSTOMERID=32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
SELECT * FROM ARTIST;
UPDATE ARTIST
SET ARTIST.NAME='CCR'
WHERE ARTISTID=76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM INVOICE WHERE TOTAL >15 AND TOTAL<50;

SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND'01-MAR-04';

--DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).


DELETE FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of name in MEDIATYPE table
SET SERVEROUT ON;

-- TODO add function header
BEGIN
dbms_output.put_line(SYSTIMESTAMP);
END;
/


SELECT LENGTH(NAME) FROM MEDIATYPE;

-- 3.2 System Defined Aggregate Functions 
-- Task – Create a function that returns the average total of all invoices 
-- Task – Create a function that returns the most expensive track

-- Task 1
SELECT AVG(total) FROM INVOICE;

--Task 2
CREATE OR REPLACE FUNCTION get_most_expensive_track
    RETURN NUMBER
    IS max_price NUMBER(10,2);
    BEGIN
        SELECT MAX(TRACK.unitprice)INTO max_price FROM TRACK;
        RETURN(max_price);
    END;
/

SELECT name, unitprice FROM TRACK WHERE UNITPRICE=get_most_expensive_track;

 
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION averagePrice
    RETURN NUMBER AS
    avgPrice NUMBER(10,2);
    totalPrice NUMBER(10,2);
    numLines NUMBER;
    BEGIN
        SELECT SUM(UNITPRICE) INTO TOTALPRICE
        FROM INVOICELINE;
        SELECT COUNT(UNITPRICE) INTO numLines FROM INVOICELINE;
        SELECT (totalPrice/numLines) INTO avgPrice FROM DUAL;
        RETURN avgPrice;
        END;
    /




-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE employee_row AS OBJECT
(
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);

CREATE TYPE employee_set AS TABLE OF employee_row;


CREATE OR REPLACE FUNCTION employees_born_after_1968
    RETURN employee_set
    AS
        e_ret employee_set;
    number_of_rows NUMBER;
    BEGIN
        SELECT COUNT(*) INTO number_of_rows FROM employee WHERE birthdate > DATE'31-DEC-1968'; 
        e_ret := employee_set(number_of_rows);
        e_ret := SELECT * FROM employee WHERE birthdate > DATE'31-DEC-1968'
        --e_ret.extend;
        --e_ret(e_ret.count) := employee_row
        --RETURN SELECT * FROM employee WHERE birthdate > DATE'31-DEC-1968';
        RETURN e_ret;
    END;
/



-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE getEmployeeNames
    (S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
fName EMPLOYEE.FIRSTNAME%TYPE;
lName EMPLOYEE.LASTNAME%TYPE;
BEGIN
getEmployeeNames(S);
    LOOP
    FETCH S INTO fName, lName;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(fName||' '||lName);
    END LOOP;
CLOSE S;
END;
/


-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE updateEmployeeInfo
    (eId IN NUMBER, fName IN VARCHAR2, lName IN VARCHAR2, phone IN VARCHAR2, email IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE 
    SET EMPLOYEE.FIRSTNAME=fName, EMPLOYEE.LASTNAME=lName, EMPLOYEE.PHONE=phone, EMPLOYEE.EMAIL=email
    WHERE EMPLOYEE.EMPLOYEEID=eId;
END;
/

EXECUTE updateEmployeeInfo(21, 'Steven', 'Durkis', '+1 (315) 842-2898', 'stevenDurkis@gmail.com');

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE printManagerName
    (eId IN NUMBER)
IS
fName VARCHAR2(20);
lName VARCHAR2(20);
mId NUMBER;
BEGIN
    SELECT REPORTSTO INTO mId FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = eId;
    
    IF mId IS NOT NULL THEN    
        SELECT FIRSTNAME, LASTNAME INTO fName, lName FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = mId;
        DBMS_OUTPUT.PUT_LINE(fName||' '||lName);
    ELSE
        DBMS_OUTPUT.PUT_LINE('The manager does not report to anyone.');
    END IF;
END;
/

EXECUTE printmanagername(1);




-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE printCustomerInfo
    (cId IN NUMBER)
IS
fName VARCHAR2(40);
lName VARCHAR2(20);
companyName VARCHAR2(80);
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO fName, lName, companyName FROM CUSTOMER WHERE CUSTOMERID = cId;
    DBMS_OUTPUT.PUT_LINE(fName||' '||lName||' '||companyName);
END;
/

EXECUTE printcustomerinfo(1);





-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

ALTER TABLE INVOICELINE
   DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
   ADD CONSTRAINT FK_INVOICELINEINVOICEID
   FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;


CREATE OR REPLACE PROCEDURE deleteInvoice
    (invId IN NUMBER)
IS
BEGIN
    DELETE FROM INVOICE WHERE INVOICEID = invId;
    COMMIT;
END;
/

EXECUTE deleteInvoice(123);




-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE SEQUENCE CUSTOMERSEQ
MINVALUE 100
MAXVALUE 10000
START WITH 100
INCREMENT BY 1
CACHE 20;


CREATE OR REPLACE PROCEDURE insertNewCustomer
(
FIRSTN IN VARCHAR2,
LASTN IN VARCHAR2,THISCOMPANY IN VARCHAR2,
THISADDRESS IN VARCHAR2,THISCITY IN VARCHAR2,
THISSTATE IN VARCHAR2,THISCOUNTRY IN VARCHAR2,
THISPOSTALCODE IN VARCHAR2,THISPHONE IN VARCHAR2,
THISFAX IN VARCHAR2,THISEMAIL IN VARCHAR2,THISSUPPORTREPID IN NUMBER
)
IS
BEGIN
    INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
        VALUES(CUSTOMERSEQ.NEXTVAL,FIRSTN,LASTN,THISCOMPANY,THISADDRESS,THISCITY,THISSTATE,THISCOUNTRY,THISPOSTALCODE,THISPHONE,THISFAX,THISEMAIL,THISSUPPORTREPID); 
END;
/

EXECUTE insertnewcustomer('Gene','Simmons','EVGA Corp','52 62nd Str','Edmonton','AB','Canada','T5K 2N1','+1 (654) 111-6453',NULL,'geneSimmons@gmail.com',4);



-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.


CREATE OR REPLACE TRIGGER printNewEmployee
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
-- writing "for each row" causes this to be a row-level trigger, which allows us to use the ":NEW" pseudorecord
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new employee named '||:NEW.firstName||' '||:NEW.lastName||' was just added.');
END;
/


INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,
FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL )
VALUES(30,'Thompson','Tim','Jr. Developer',20,'13-FEB-89','14-OCT-10','233 Main St','Calgary','AB','Canada',
'T2P 5M5','+1 (403) 433-1234','+1 (403) 675-5678','timtom@gmail.com');

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table.

CREATE OR REPLACE TRIGGER printUpdatedAlbum
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An album was just updated');
    DBMS_OUTPUT.PUT_LINE('Old record - AlbumID: '||:OLD.ALBUMID||' Title: '||:OLD.TITLE||' ArtistID: '||:OLD.ARTISTID);
    DBMS_OUTPUT.PUT_LINE('New record - AlbumID: '||:NEW.ALBUMID||' Title: '||:NEW.TITLE||' ArtistID: '||:NEW.ARTISTID);
END;
/

UPDATE ALBUM SET TITLE = 'New Levels, New Devils' WHERE ALBUMID = 147;
-- i don't like men at work

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER printDeletedCustomer
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A customer named '||:OLD.firstName||' '||:OLD.lastName||' was just deleted.');
END;
/

DELETE FROM CUSTOMER WHERE CUSTOMERID=102;





-- 7.0 JOINS
-- In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.customerID = INVOICE.customerid;



-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT CUSTOMER.customerId, firstname, lastname, invoiceId, total
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.customerID = INVOICE.customerID;


-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.title AS "Album Name", ARTIST.name AS "Artist Name"
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;


-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.title AS "Album Name", ARTIST.name AS "Artist Name"
FROM ARTIST
CROSS JOIN ALBUM
ORDER BY NAME ASC;



-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.employeeId, E1.firstName, E1.lastName, E2.firstName, E2.lastName
FROM EMPLOYEE E1
INNER JOIN EMPLOYEE E2
ON E1.employeeId = E2.reportsTo;



