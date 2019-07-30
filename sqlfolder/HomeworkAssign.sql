--2.1 Select statements
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.lastname='King';

SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.firstname='Andrew'
AND reportsto is null;

--2.2 Order by
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album
ORDER BY Title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer
ORDER BY City ASC;

INSERT INTO Genre VALUES(26, 'Death Metal');
INSERT INTO Genre VALUES(27, 'Ska');

--Task – Insert two new records into Employee table

INSERT INTO Employee VALUES(9, 'DINGDONG', 'SHAMALAMA', 'Instructor', NULL, '19-FEB-89', '24-JAN-17', '14 Bye Drive', 'Reno', 'Nevada', 'USA', 'THC 123', '1(888)454-7777', '1(676)912-3456', 'SHAM@gmail.com') ;
INSERT INTO Employee VALUES(10, 'DINGDONG', 'RAMALAMA', 'Instructor', NULL, '19-FEB-66', '24-JAN-13', '15 Hello Drive', 'Reno', 'Nevada', 'USA', 'THC 123', '1(151)555-7227', '1(676)912-3456', 'ram@gmail.com') ;

--Task – Insert two new records into Customer table
INSERT INTO Customer VALUES(60, 'Jones', 'Steve', 'ABC', '12 STREET', 'Clyo', 'GA', 'USA', '23456', '222-2222', '333-3333', 'huh@yaho.com', 5);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE customer
SET lastname = 'Walter', firstname = 'Robert'
WHERE lastname = 'Mitchell'
AND
firstname='Aaron';



--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE artist
SET name= 'CCR'
WHERE artistid = 76 ;

--2.5 LIKE

--The SQL LIKE clause is used to compare a value to similar values using wildcard operators. 
--There are two wildcards used in conjunction with the LIKE operator.
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';
--selects all billing address starting with T

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM employee 
WHERE hiredate BETWEEN '01-JUN-2003' AND '01-MAR-2004';

/*2.7 
DELETE
Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).
*/
DELETE FROM customer 
WHERE LASTNAME='Walter'
AND FIRSTNAME='Robert';

--integrity constraint (CHINOOK.FK_INVOICECUSTOMERID) violated - child record found
--cascade on delete
--alter table
ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
--drop constraint
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE;
    --table integrity
--integrity constraint (CHINOOK.FK_INVOICELINEINVOICEID) violated - child record found
--*on delete cascade -remove row of the foreign keys that are connected to the deleted party in other tables

ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) 
ON DELETE CASCADE; 




--3.1 System Defined Functions
--Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION cur_time
RETURN DATE AS hammer_time DATE;--what data type to return --similar to constructor
--first DATE belongs to function,2nd belongs to Return variable
BEGIN --the body of the function
SELECT CURRENT_TIMESTAMP
INTO hammer_time --assign current_timestamp (from Dual) to hammer_time
FROM DUAL;
RETURN hammer_time;
END;
/

SELECT TO_CHAR(cur_time, 'HH:MM:SS') FROM DUAL;
--returns time less 20 minutes, don't know why.
--Task – create a function that returns the length of name in MEDIATYPE table (any name? every name)

SELECT NAME, LENGTH(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER AS 
avg_total NUMBER;
BEGIN
    SELECT AVG(total) 
    INTO avg_total 
    FROM invoice;
RETURN avg_total;
END;
/

SELECT avg_total from dual;

--Task – Create a function that returns the most expensive track
SELECT max(unitprice) FROM track;


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION avg_func
RETURN NUMBER AS
my_avg_func NUMBER;
BEGIN
    SELECT AVG(unitprice) 
    INTO my_avg_func 
    FROM invoiceline;
    RETURN my_avg_func;
END;
/
 
SELECT avg_func FROM dual;  
--super!!!!!


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

SELECT * FROM EMPLOYEE
WHERE BIRTHDATE  
BETWEEN '01-JAN-68' AND '01-JUL-2019';

--OR
--alternate solution works as well:

SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '01-JAN-1968';

--**************

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. 
--You will be creating various types of stored procedures that take input and output parameters.
--***************************************************************************************
--4.1 Basic Stored Procedure
--example 

--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE select_first_and_last
(S OUT SYS_REFCURSOR) --points at a number of num of rows in a table 
AS -- is|as the same
BEGIN
OPEN S FOR --command wil be written into S, open the range of rows 
    SELECT FIRSTNAME, LASTNAME --actual column names 
    FROM EMPLOYEE;
END;
/

SET SERVEROUT ON; 
--serverout usually off 


DECLARE S SYS_REFCURSOR; 
fName employee.firstname%TYPE; --name first then datatype
lName employee.lastname%TYPE;
BEGIN
    select_first_and_last(S);
    LOOP
    FETCH S into fName, lName;
    EXIT WHEN S%NOTFOUND; --break out of loop when no more match
    DBMS_OUTPUT.PUT_LINE(fName || ' & '  || lName || ' are the first and last names');  --print statement
    END LOOP;
    CLOSE S;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE change_info
(newFirstName IN VARCHAR2, newLastName IN VARCHAR2, empID IN NUMBER)
AS
BEGIN
    UPDATE employee SET firstname = newFirstName WHERE empID = employeeid;
    UPDATE employee SET lastname = newLastName WHERE empID = employeeid;
    --can combine UPDATE--
END;
/

EXECUTE change_info('BamaLama', 'DingDong', 3);

SELECT * FROM employee WHERE employeeid = 3;



--Task – Create a stored procedure that returns the managers of an employee .

SELECT * FROM EMPLOYEE;
CREATE OR REPLACE PROCEDURE emp_reportsto_name
(
EMPLOYEE_ID IN NUMBER,
MANAGER_ID OUT NUMBER
)
AS
BEGIN
    SELECT REPORTSTO
    INTO MANAGER_ID
    FROM
    EMPLOYEE
    WHERE EMPLOYEE_ID = EMPLOYEEID;
    END;
    
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
SELECT * FROM CUSTOMER;
CREATE OR REPLACE PROCEDURE customer_company_name
(cust_id IN NUMBER, comp_name OUT VARCHAR2, cust_First OUT VARCHAR2, cust_Last OUT VARCHAR2)
AS
BEGIN
    
 SELECT FIRSTNAME, LASTNAME, COMPANY
 INTO cust_First, cust_Last, comp_name
 FROM CUSTOMER
 WHERE CUSTOMERID = cust_id;
 END;
 /
 
DECLARE 
cust_First customer.firstname%TYPE;
cust_Last customer.lastname%TYPE;
comp_name customer.company%TYPE;
BEGIN
     customer_company_name(
     1,
     comp_name,
     cust_Last,
     cust_First
     
    );
    
    
     DBMS_OUTPUT.PUT_LINE('Company name is ' || comp_name);
END;
/
    SET SERVEROUT ON;

--5.0 Transactions
--In this section you will be working with transactions. 
--Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--TCL: Transaction Control Language
--Commit, Rollback, Savepoint

ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;
DELETE FROM invoice WHERE invoiceid = 2;
COMMIT;


ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) 
ON DELETE CASCADE; 


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer 

CREATE OR REPLACE PROCEDURE insert_new_customer
(CUSTOMERID_2 IN NUMBER,
FIRSTNAME_2 IN VARCHAR2,
LASTNAME_2 IN VARCHAR2,
COMPANY_2 IN VARCHAR2,
ADDRESS_2 IN VARCHAR2,
CITY_2 IN VARCHAR2,
STATE_2 IN VARCHAR2,
COUNTRY_2 IN VARCHAR2,
POSTALCODE_2 IN VARCHAR2,
PHONE_2 IN VARCHAR2,
FAX_2 IN VARCHAR2,
EMAIL_2 IN VARCHAR2,
SUPPORTREPID_2 IN NUMBER)
AS
BEGIN
   INSERT INTO customer VALUES(CUSTOMERID_2,
        FIRSTNAME_2,
        LASTNAME_2,
        COMPANY_2,
        ADDRESS_2,
        CITY_2,
        STATE_2,
        COUNTRY_2,
        POSTALCODE_2,
        PHONE_2,
        FAX_2,
        EMAIL_2,
        SUPPORTREPID_2);
COMMIT;
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR

--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER AFTERTRIG
AFTER INSERT ON EMPLOYEE
FOR EACH ROW 
BEGIN
 NULL;
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTERUPDATE
AFTER UPDATE ON ALBUM 
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('Update Complete');
END;
/


--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTERDELETE
AFTER UPDATE ON CUSTOMER 
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('1 Item Delete');
END;
/
 SET SERVEROUT ON;
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT customer.firstname, customer.lastname, invoiceid
    FROM customer
    INNER JOIN invoice
    ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
    FROM customer
    FULL OUTER JOIN invoice
    ON customer.customerid = invoice.customerid;
    
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT album.name, album.title
    FROM album
    RIGHT OUTER JOIN artist
    ON album.artistid = artist.artistid;





--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album
CROSS JOIN artist 
ORDER BY artist.name ASC;



--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee A, employee B
WHERE a.reportsto = b.reportsto;

