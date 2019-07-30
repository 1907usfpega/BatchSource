
--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM CHINOOK.employee;
SELECT * FROM CHINOOK.employee WHERE LASTNAME='King';
SELECT * FROM CHINOOK.employee WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE;
SELECT FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY FIRSTNAME DESC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table 

INSERT INTO CHINOOK.GENRE(CHINOOK.GENRE.GENREID, NAME)
VALUES(33,'Horror');
INSERT INTO CHINOOK.GENRE(CHINOOK.GENRE.GENREID, NAME)
VALUES(34,'KEN');

--Task – Insert two new records into Employee table

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID,LASTNAME,
FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL )
VALUES(11,'John','Sean','Boss',1,'18-FEB-66','05-DEC-09','226 6TH STREET','New Orleans','LA','UNITED STATES',
'33701','+1 (504) 443-4321','+1 (343) 333-4352','kenmcoding@gmail.com');

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID,LASTNAME,
FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL )
VALUES(10,'Booker','Bill','Tech',1,'12-FEB-68','05-JAN-09','226 6TH STREET','New Orleans','LA','UNITED STATES',
'33701','+1 (504) 443-4321','+1 (343) 333-4352','kenmcoding@gmail.com');

--Task – Insert two new records into Customer table
SELECT * FROM CHINOOK.CUSTOMER;
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(60,'Bill','Baggins',NULL,'336 6TH STREET','New Orleans','La','USA','33701','+1 504 443-2345',NULL,'KENMCODING@GMAIL.COM',3);

INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(61,'Tim','Baggins',NULL,'336 6TH STREET','New Orleans','La','USA','33701','+1 504 443-2345',NULL,'KENMCODING@GMAIL.COM',3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
SELECT * FROM CHINOOK.CUSTOMER;
UPDATE CHINOOK.CUSTOMER
SET LASTNAME='Walter' 
WHERE CUSTOMERID=32;
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME='Robert' 
WHERE CUSTOMERID=32;

SELECT * FROM CHINOOK.ARTIST;
UPDATE CHINOOK.ARTIST
SET CHINOOK.ARTIST.NAME='CCR'
WHERE ARTISTID=76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM CHINOOK.INVOICE;
SELECT * FROM CHINOOK.INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM CHINOOK.INVOICE
WHERE TOTAL >15 AND TOTAL<50;

SELECT * FROM CHINOOK.EMPLOYEE;

SELECT * FROM CHINOOK.EMPLOYEE WHERE HIREDATE
BETWEEN '01-JUN-03' AND'01-MAR-04';

--DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

SELECT * FROM  CHINOOK.CUSTOMER;

DELETE FROM CHINOOK.CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of name in MEDIATYPE table


SELECT CURRENT_TIMESTAMP from dual;
select sysdate from dual;

SELECT LENGTH('1234567') "Length in characters"
  FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track

SELECT * FROM INVOICE;
SELECT AVG(TOTAL) AS AverageTOTAL FROM INVOICE;
SELECT MAX(TOTAL) AS MOSTEXPENSIVE FROM INVOICE;

--3.3 User Defined Scalar Functions
--ask – Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT * FROM INVOICELINE;
--SELECT AVG(UNITPRICE) AS AveragePrice FROM INVOICELINE;

CREATE OR REPLACE FUNCTION avgPrice
Return Number IS
 total Number(8):=0;
 P_Sum Number(8):=0;
 Avg_Price Number(2):=0;
 Begin
 SELECT COUNT(*) INTO total FROM INVOICELINE;
 SELECT SUM(UNITPRICE) INTO P_SUM FROM INVOICELINE;
 Avg_Price :=P_Sum/total;
 RETURN Avg_Price;
 END;
/

DECLARE
 c NUMBER(8);
 BEGIN
 C:=avgPrice();
 DBMS_OUTPUT.PUT_LINE('The average total price is: '||c);
 END;
 /

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

SELECT * FROM EMPLOYEE
WHERE BIRTHDATE >  to_date('31-12-1968', 'dd-MM-yyyy');


--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure emp_names is
    begin
      dbms_output.put_line('------------------------');     
      dbms_output.put_line(' First Name| Last Name|');
      dbms_output.put_line('------------------------');
      for i in( select * from employee )
      loop
        dbms_output.put(i.FIRSTNAME||' ');
        dbms_output.put_line(i.LASTNAME );
      end loop;
      dbms_output.put_line('------------------------------');
    end;
    /
    show errors;
    set serveroutput on;
    execute emp_names;


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee .

CREATE OR REPLACE PROCEDURE emplUpdatee(EMP_ID NUMBER, a VARCHAR2,b VARCHAR2,c VARCHAR2, d VARCHAR2,e VARCHAR2,f VARCHAR2,g VARCHAR2,h VARCHAR2) IS
BEGIN
UPDATE EMPLOYEE
SET ADDRESS=a,CITY=b,STATE=c,COUNTRY=d,POSTALCODE=e,PHONE=f,FAX=g,EMAIL=h
WHERE EMPLOYEEID=EMP_ID;
END;
/
execute emplUpdatee(1,'226 6TH STREET','ST PETE','FL','USA','33701','1 727 309 3033','1 727 309 3099','KENMCODING@GMAIL.COM');
SELECT * FROM EMPLOYEE;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--Task – Create a stored procedure that returns the managers of an employee .
CREATE OR REPLACE PROCEDURE emplManager IS
BEGIN
SELECT emp.EMPLOYEEID,emp.FIRSTNAME,emp.LASTNAME,mgr.FIRSTNAME,mgr.LASTNAME
FROM EMPLOYEE emp
LEFT JOIN EMPLOYEE mgr ON emp.REPORTSTO=mgr.EMPLOYEEID;
END;
/
EXECUTE emplManager();


CREATE OR REPLACE PROCEDURE custCOMPANY(f_name VARCHAR2,l_name VARCHAR2) IS
BEGIN
dbms_output.put_line();

END;
/
--Task – Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteTHIS(invoice

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
@InvoiceID int
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;
    -- This reclaims inventory to the Article table
    WITH R AS (
      SELECT ArticleID, SUM(Quantity) ReclaimedQuantity
      FROM InvoiceLine
      WHERE InvoiceID = @InvoiceID
      GROUP BY ArticleID
    )
    UPDATE Article
    SET Quantity = Quantity + R.ReclaimedQuantity
    FROM Article INNER JOIN
         R ON Article.ArticleID = R.ArticleID;
    -- Removes invoice line items
    DELETE FROM InvoiceLine
    WHERE InvoiceID = @InvoiceID;
    -- Removes the invoice header item
    DELETE FROM Invoice
    WHERE InvoiceID = @InvoiceID;
    COMMIT TRANSACTION;
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
  END CATCH
END


---------------------------------------------------------------------------------------------------------------
--6.1
--NOT ALLOWED TO MAKE THE SEQUENCE 
CREATE SEQUENCE EMPLOYEE_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE TABLE  "SUPPLIERS"   
   (    "SUPPLIER_ID" NUMBER,   
    "SUPPLIER_NAME" VARCHAR2(4000),   
    "SUPPLIER_ADDRESS" VARCHAR2(4000)  
   )  
/  
CREATE OR REPLACE TRIGGER  "SUPPLIERS_T2"   
AFTER  
insert or update or delete on "SUPPLIERS"  
for each row  
begin  
when the person performs insert/update/delete operations into the table.  
end;  
/  
ALTER TRIGGER  "SUPPLIERS_T2" ENABLE  
/  









CREATE [ OR REPLACE ] TRIGGER trigger_name  
AFTER INSERT or UPDATE or DELETE  
 ON EMPLOYEE  
  [ FOR EACH ROW ]  
DECLARE  
   -- 
BEGIN  
   -- trigger code  
EXCEPTION  
   WHEN ...  
   -- exception handling  
END;  






CREATE OR REPLACE TRIGGER TR_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    SELECT EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEEID FROM DUAL;
END; 
/
CREATE SEQUENCE SQ_ALBUM_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER TR_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    SELECT SQ_ALBUM_PK.NEXTVAL INTO :NEW.ALBUMID FROM DUAL;
END;
/
CREATE SEQUENCE SQ_CUSTOMER_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER TR_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    SELECT SQ_CUSTOMER_PK.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
END;
/
 

7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT CUSTOMER.FIRSTNAME,LASTNAME,INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.
Select customer.CUSTOMERID, customer.FIRSTNAME,customer.LASTNAME, invoice.invoiceid, invoice.total
from customer, invoice
where CUSTOMER.customerID=INVOICE.CUSTOMERID;
7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
Select name, title
from album
right join artist
on album.artistid=artist.artistid;



7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--select *from album;
--select *from artist;
select artist.artistid, album.title,artist.name
from artist cross join album
order by name asc;
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column
SELECT
concat(e.firstname, e.lastname) employee,
concat(e.firstname, e.lastname) manager
from 
employee e
inner join 
employee m on m.employeeid = e.reportsto;








