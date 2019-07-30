--1.0
--this was just setting up the chinook database

--2.1 select
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2 order by
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;

--2.3 insert
INSERT INTO genre (genreid,NAME) VALUES (26,'Techno');
INSERT INTO genre (genreid,NAME) VALUES (27,'Dance');

INSERT INTO employee VALUES(9,'Diemer','Catherine','IT Staff',6,'29-OCT-96','04-JUN-06','1111 6 Ave SW', 'Calgary','AB','Canada','T2P 5M5','+1 (403) 263-4423','+1 (403) 263-4289','Catherine@chinookcorp.com');
INSERT INTO employee VALUES(10,'Eshem','Hope','IT Staff',6,'13-FEB-94','08-JUL-06','1111 6 Ave SW', 'Calgary','AB','Canada','T2P 5M5','+1 (403) 263-4423','+1 (403) 263-4289','Hope@chinookcorp.com');

INSERT INTO customer VALUES(60,'Marco','Polo',NULL,'Lijnbaansgracht 120bg','Amsterdam','VV','Netherlands','1016','+31 020 6223130',NULL,'marco.polo@gmail.com',5);
INSERT INTO customer(customerid,firstname,lastname,email) VALUES (61,'Joe','Biden','joe.biden@hotmail.com');

--2.4 update
UPDATE customer SET firstname = 'Robert',lastname = 'Walter' WHERE firstname='Aaron' AND lastname='Mitchell';

UPDATE artist SET NAME = 'ccr' WHERE NAME='Creedence Clearwater Revival';

--2.5 like
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 between
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-Mar-04';

--2.7 delete
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid) REFERENCES customer (customerid)  
    ON DELETE CASCADE;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid)  
    ON DELETE CASCADE;
    
DELETE customer WHERE firstname='Robert' AND lastname='Walter';

--3.1 System Defined Functions
CREATE OR REPLACE FUNCTION rettime RETURN TIMESTAMP AS currenttime_1 TIMESTAMP;
BEGIN
SELECT sysdate INTO currenttime_1 FROM dual;
RETURN currenttime_1;
END;
/
SELECT rettime FROM dual;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION namelength (med_name IN VARCHAR2)
RETURN NUMBER AS lon NUMBER;
BEGIN
  SELECT LENGTH(mediatype.NAME) INTO lon FROM mediatype WHERE mediatype.NAME=med_name;
  RETURN lon;
END;
/
SELECT NAME, namelength(mediatype.NAME) FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER AS total_price NUMBER (10,2);
BEGIN
    SELECT AVG(invoice.total) INTO total_price FROM invoice;
    RETURN total_price;
END;
SELECT avg_total FROM dual;

--Task – Create a function that returns the most expensive track
SELECT track.NAME, unitprice FROM track WHERE unitprice IN (SELECT MAX(unitprice) FROM track);

--3.3 User Defined Scalar Functions--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION lineavg 
RETURN NUMBER AS coolmath NUMBER (10,2);
BEGIN
	SELECT AVG(invoiceline.unitprice) INTO coolmath FROM invoiceline;
	RETURN coolmath;
END;
/
SELECT lineavg FROM dual;

--3.4 User Defined Table Valued Functions--Task – Create a function that returns all employees who are born after 1968.
SELECT firstname,lastname, birthdate FROM employee WHERE birthdate>'31-dec-68';

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE peeps
(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT employee.firstname,employee.lastname FROM employee;
COMMIT;
END;
/
DECLARE 
S  SYS_REFCURSOR;
fname employee.firstname%TYPE;
lname employee.lastname%TYPE;
BEGIN
    peeps(S);
    CLOSE S;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE changename
(newfname IN VARCHAR2, newlname IN VARCHAR2, oldfname IN VARCHAR2, oldlname IN VARCHAR2)
AS
BEGIN 
UPDATE employee SET firstname = newfname,lastname = newlname WHERE firstname=oldfname AND lastname=oldlname;
COMMIT;
END;
/
EXECUTE changename('Hann','Lerum','Catherine','Diemer');

--Task – Create a stored procedure that returns the managers of an employee .
CREATE OR REPLACE FUNCTION showmethemanager
(eid IN NUMBER) RETURN VARCHAR2 AS man VARCHAR2(40);
BEGIN
SELECT b.firstname||' '||b.lastname INTO man
FROM employee A JOIN employee b ON A.reportsto=b.employeeid 
WHERE A.employeeid=eid;
RETURN man;
END;
/
SELECT employee.firstname, employee.lastname, showmethemanager(employeeid) AS MANAGER FROM employee;
 
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customerdeets
(fistnaem IN VARCHAR2, lasrnaem IN VARCHAR2, S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT customer.firstname, customer.lastname, customer.company FROM customer WHERE firstname=fistnaem AND lastname=lasrnaem;
COMMIT;
END;
/
DECLARE 
S  SYS_REFCURSOR;
fname customer.firstname%TYPE;
lname customer.lastname%TYPE;
COMPA customer.company%TYPE;
BEGIN
    customerdeets('Luís','Gonçalves',S);
    CLOSE S;
END;
/


--5.0
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--im p sure i accidentally resolved the conflict earlier by adding a cascading delete condition when i had to delete aaron whoever
CREATE OR REPLACE PROCEDURE begoneinvoice
(iid IN NUMBER)
IS
BEGIN
--i dont know why its angry here but not below?
START TRANSACTION
DELETE FROM invoice WHERE invoiceid=iid;
COMMIT;
END;
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--i know you said you went over this and that its simple but honest to god i have no idea what the syntax for this is supposed
--to be much less how to actually make it function
CREATE OR REPLACE PROCEDURE makecust
(fistnaem IN VARCHAR2, lasrnaem IN VARCHAR2)
IS
BEGIN
START TRANSACTION
INSERT INTO customer(customerid, firstname, lastname) VALUES (50, fistname, lastname);
COMMIT;
END;
END;
/


--6.1
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER afterinsertemployee
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    SELECT * FROM employee;--dual is dummy table to fill table
END;
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER afterupdatealbum
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    SELECT * FROM album;
END;
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER afterdeletecustomer
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    SELECT * FROM customer;--dual is dummy table to fill table
END;
--7.1 inner join
SELECT firstname, lastname, invoice.invoiceid FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid;
--7.2 outer join
SELECT firstname, lastname, invoiceid, total FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
--7.3 right
SELECT artist.NAME, title FROM artist RIGHT JOIN album ON artist.artistid=album.artistid;
--7.4 cross
SELECT * FROM artist CROSS JOIN album ORDER BY artist.NAME;
--7.5 self
SELECT A.firstname AS firstname, A.lastname, b.firstname AS firstname2, b.lastname FROM employee A JOIN employee b ON A.reportsto=b.reportsto;


