-------------------Configure Settings-------------------------
--Lets the system print to console
SET SERVEROUT ON;

-------------------2.1 SELECT-------------------------
--Selects all records from the Employee table
SELECT *
FROM employee;

--Selects all employees with the last name "King"
SELECT *
FROM employee
WHERE lastname = 'King';

--Selects all employees with the first name "Andrew" & Null reportsto
SELECT *
FROM employee
WHERE firstname = 'Andrew' 
    and REPORTSTO is NULL;


-------------------2.2 ORDER BY-------------------------
--Selects all albums and displays in descending order
SELECT *
FROM album
ORDER BY title DESC;

--Selects all customers and displays in ascending order accoring to city
SELECT firstname
FROM customer
ORDER BY city ASC;


-------------------2.3 INSERT INTO-------------------------
--Shows both ways to insert into the genre table 
--Writing out each column vs just specifying the table name
INSERT INTO genre (genreid, name) VALUES (26, 'Country');
INSERT INTO genre VALUES (27, 'Folk Pop');

--Shows both ways to insert into the employee table 
--Writing out each column vs just specifying the table name
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, 
                      address, city, state, country, postalcode, phone, fax, email)
              VALUES (9 ,'Barker', 'Billy', 'IT Staff', 6, '30-APR-88', '05-DEC-02', 
                      '423 Jasper Ave', 'AR', 'PA', 'United States', '67283', '+1 (555) 930-0192', 
                      '+1 (555) 672-6792', 'BBarker@chinookcorp.com');
                       
INSERT INTO employee VALUES (10, 'Prime', 'Tanner', 'Sales Manager', 1, '30-APR-88', '05-DEC-02', 
                      '674 West James Street', 'Seatle', 'WA', 'United States', '89322', '+1 (555) 983-0411', 
                      '+1 (555) 423-0217', 'T.Prime12@chinookcorp.com');
              
--Shows both ways to insert into the customer table 
--Writing out each column vs just specifying the table name
INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, 
                      phone, fax, email, supportrepid)
              VALUES (60, 'Charles', 'West', 'Apple Inc.','321 Eastern Hara Street', 'Richmond', 'VA', 'United States', '90231', 
                      '+1 (555) 832-0671', '+1 (555) 629-8293', 'CWesting021@chinookcorp.com', 5);
                      
INSERT INTO customer VALUES (61, 'Nick', 'Abraham', 'Telus','801 Marion Ave', 'Dallas', 'TX', 'United States', '53821', 
                      '+1 (555) 772-0381', '+1 (555) 126-6539', 'Nick.Abraham@chinookcorp.com', 2);
                      
                      
-------------------2.4 UPDATE-------------------------
--Updates a customer with a new name
UPDATE customer
	SET firstname = 'Robert',
        lastname = 'Walter'
    WHERE firstname = 'Aaron' 
        AND lastname = 'Mitchell';
        
--Updates an artist with an abbreviated name
UPDATE artist
	SET name = 'CCR'
    WHERE name = 'Creedence Clearwater Revival';


-------------------2.5 LIKE-------------------------
--Selects all invoices that have an address beginning with "T"
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';


-------------------2.6 BETWEEN-------------------------
--Selects all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

--Selects all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';


-------------------2.7 DELETE-------------------------
--Delete the customer "Robert Walker" and all its dependencies
DELETE FROM invoiceline
WHERE invoiceid = 50
      OR invoiceid = 61
      OR invoiceid = 116
      OR invoiceid = 245
      OR invoiceid = 268
      OR invoiceid = 290
      OR invoiceid = 342;
                  
DELETE FROM invoice
WHERE customerid = (SELECT customerid FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter');

DELETE FROM customer
WHERE firstname = 'Robert'
      AND lastname = 'Walter';


-------------------3.1 System Defined Functions-------------------------
--Returns the current time
SELECT CURRENT_TIMESTAMP FROM DUAL;

--Returns the name length of each media
SELECT LENGTH(mediatype.name)
FROM mediatype;


-------------------3.2 System Defined Aggregate Functions-------------------------
--Returns average of all invoice totals
SELECT AVG(invoice.total)
FROM invoice;

--Returns the one of the most expensive tracks
SELECT MIN(Track), MAX(Price)
FROM (SELECT track.name AS Track, track.unitprice as Price
      FROM track);


-------------------3.3 User Defined Scalar Functions-------------------------
--Returns the average price of invoiceline items
SELECT invoiceline.invoiceid, AVG(invoiceline.unitprice)
FROM invoiceline
GROUP BY invoiceline.invoiceid;


-------------------3.4 User Defined Scalar Functions-------------------------
--Returns all employees born after 1968
SELECT employee.firstname||' '||employee.lastname
FROM employee
WHERE birthdate >= '01-JAN-1969';


-------------------4.1 Basic Stored Procedure-------------------------
--Creates a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE employee_names
(names OUT SYS_REFCURSOR) 
AS 
BEGIN
OPEN names FOR 
    SELECT firstname, lastname
    FROM employee;
END;
/

DECLARE names SYS_REFCURSOR; 
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;
BEGIN
    employee_names(names);
    LOOP
    FETCH names into firstname, lastname;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname||' '||lastname);
    END LOOP;
    CLOSE names;
END;
/


-------------------4.2 Stored Procedure Input Parameters-------------------------
--Creates a stored procedure to update employee information
CREATE OR REPLACE PROCEDURE update_employee
(employee_id IN NUMBER, employee_email IN VARCHAR2)
AS
BEGIN
    UPDATE employee SET email = employee_email WHERE employeeid = employee_id;
END;
/
EXECUTE update_employee(10, 'Tanner.Prime@chinook.com');


--Creates a stored procedure that shows the managers of emplyees
CREATE OR REPLACE PROCEDURE get_managers
(managers OUT SYS_REFCURSOR)
AS
BEGIN
OPEN managers FOR
    SELECT firstname, reportsto
    FROM employee;
END;
/

DECLARE managers SYS_REFCURSOR; 
firstname employee.firstname%TYPE;
reportsto employee.reportsto%TYPE;
BEGIN
    get_managers(managers);
    LOOP
    FETCH managers into firstname, reportsto;
    EXIT WHEN managers%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname||' reports to manager: '||reportsto);
    END LOOP;
    CLOSE managers;
END;
/


-------------------4.3 Stored Procedure Input Parameters-------------------------
--Creates a procedure to return the name of a customer and company
CREATE OR REPLACE PROCEDURE get_customer_company
(names OUT SYS_REFCURSOR)
AS
BEGIN
OPEN names FOR
    SELECT firstname, lastname, company
    FROM customer;
END;
/

DECLARE names SYS_REFCURSOR; 
firstname customer.firstname%TYPE;
lastname customer.lastname%TYPE;
company customer.company%TYPE;
BEGIN
    get_customer_company(names);
    LOOP
    FETCH names into firstname, lastname, company;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname||' '||lastname||' works for '||company);
    END LOOP;
    CLOSE names;
END;
/


-------------------5.1 Transactions-------------------------
--Deleting invoices
CREATE OR REPLACE PROCEDURE delete_invoice
(invoice_id IN invoice.invoiceid%TYPE)
IS
BEGIN
  DELETE FROM invoiceline WHERE invoiceid=invoice_id;
  DELETE FROM invoice WHERE invoice.invoiceid=invoice_id;
  COMMIT;
END;
/
EXECUTE delete_invoice(410);


--Inserts into customer table
CREATE OR REPLACE PROCEDURE insert_customer
(customer_id IN customer.customerid%TYPE, 
firstname IN customer.firstname%TYPE,
lastname IN customer.lastname%TYPE, 
company IN customer.company%TYPE,
address IN customer.address%TYPE, 
city IN customer.city%TYPE,
customer_state IN customer.state%TYPE, 
country IN customer.country%TYPE,
post IN customer.postalcode%TYPE, 
phone IN customer.phone%TYPE,
fax IN customer.fax%TYPE, 
email IN customer.email%TYPE,
supportrepid IN customer.supportrepid%TYPE)
IS
BEGIN
  INSERT INTO customer VALUES(customer_id, firstname, lastname, company, address, city, customer_state, 
                              country, post, phone, fax, email, supportrepid);
  COMMIT;
END;
/


-------------------6.1 TRIGGERS-------------------------
--Creates a trigger that prints after a row is added to employee
CREATE OR REPLACE TRIGGER insert_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have successfully inserted a row into employee');
END;
/
INSERT INTO employee (employeeid, firstname, lastname) VALUES(23,'Ron','Ackerman');

--Creates a trigger that prints after a row is updated in album
CREATE OR REPLACE TRIGGER update_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have successfully updated a row in album');
END;
/
INSERT INTO album (albumid, title, artistid) VALUES(348,'Rock','1');

UPDATE album
SET title = 'Rock of Ages'
WHERE albumid = 348;

--Creates a trigger that prints after a row is deleted from customer
CREATE OR REPLACE TRIGGER delete_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have successfully deleted a row from customer');
END;
/
INSERT INTO customer (customerid, firstname, lastname, email) VALUES(66,' Alfred', 'Allens', 'AAL@chinook.com');
DELETE FROM customer WHERE customerid = 66;


-------------------7.1 INNER JOIN-------------------------
--Inner joins customers and orders
SELECT customer.firstname || ' ' || customer.lastname AS Customer_Name, invoice.invoiceid
FROM customer 
INNER JOIN invoice ON customer.customerid = invoice.customerid;


-------------------7.2 OUTER JOIN-------------------------
--Full outer joins customers and invoices
SELECT customer.customerid, customer.firstname || ' ' || customer.lastname AS Customer_Name, invoice.invoiceid, invoice.total 
FROM customer
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;


-------------------7.3 RIGHT JOIN-------------------------
--Right joins artists and albums
SELECT artist.name AS Artist, album.title AS Album
FROM artist
RIGHT OUTER JOIN album ON artist.artistid = album.artistid;


-------------------7.4 CROSS JOIN-------------------------
--Cross joins artists and albums
SELECT artist.name AS Artist, album.title AS Album
FROM artist
CROSS JOIN album
ORDER BY artist ASC; 


-------------------7.5 SELF JOIN-------------------------
--Self joins employees
SELECT e1.firstname||' works for '||e2.firstname 
"Employees and Their Managers"
FROM employee e1, employee e2
WHERE e1.reportsto = e2.employeeid;
