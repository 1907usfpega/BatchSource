-- 2 SQL Queries
-- 2.1 Select Statements
select * from employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO is NULL;

-- 2.2 Ordering
SELECT * from ALBUM ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city;

-- 2.3 Insert Into
INSERT INTO genre (GenreID, Name) Values (27, 'Punk');
Insert into genre (genreID, name) Values(28, 'additional genre');

insert into employee(EmployeeID, firstname, lastname, title, reportsto) Values (10, 'Alex', 'Robertson','IT Staff',1);
insert into employee (EmployeeID, firstname, lastname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode) Values(11, 'Meghan', 'Callahan', 'Sales Support Agent', 1, TO_DATE('1997-6-11','yyyy-mm-dd'),TO_DATE('2019-7-15','yyyy-mm-dd'),'22107 Bruce B','Tampa','FL','USA',33016);

insert into customer (CustomerID, firstname, lastname, address, city, state, country,email) Values(61, 'John','Doe','1234 Anywhere Lane', 'Nowhere','MT','USA','johndoe@gmail.com');
insert into customer (CustomerID, firstname, lastname, email) Values (62, 'Huge','Ackman','huge.ackman@gmail.com');


-- 2.4 Update
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer set firstname = 'Robert', lastname = 'Walter' WHERE (firstname = 'Aaron' AND lastname = 'Mitchell');
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set artist.name = 'CCR' where name = 'Creedence Clearwater Revival';

-- 2.5 Like
select * from invoice where billingAddress like 'T%';

-- 2.6 Between
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between TO_DATE('2003-6-01','yyyy-mm-dd') and TO_DATE('2004-3-01','yyyy-mm-dd');

-- 2.7 Delete
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid) REFERENCES customer (customerid)
    ON DELETE CASCADE;

ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) 
    ON DELETE CASCADE;

delete customer where firstname = 'Robert' and lastname = 'Walter';

-- 3 SQL functions
-- 3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
RETURN VARCHAR2 AS current_time VARCHAR2(10);
BEGIN
SELECT to_char(current_timestamp, 'HH:MI:SS') INTO current_time FROM dual;
RETURN current_time;
END;
/

SELECT current_time() FROM dual;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION name_length (mediatype_name IN VARCHAR2)
RETURN NUMBER AS namelength NUMBER;
BEGIN
SELECT LENGTH(mediatype.NAME) INTO namelength FROM mediatype WHERE mediatype.NAME = mediatype_name;
RETURN namelength;
END;
/

SELECT NAME, name_length(mediatype.NAME) FROM mediatype;

-- 3.2 System Defined Aggregate Functions (you don't actually have to make a function. use the system defined ones.)
--Task – Create a function that returns the average total of all invoices 
SELECT AVG(total) FROM invoice;

--Task – Create a function that returns the most expensive track
-- this will return all tracks that are equally most expensive
SELECT track.name, unitprice FROM track WHERE unitprice IN (SELECT MAX(unitprice) FROM track);
--this will only return the first one that comes up with the highest price
SELECT track.name, unitprice FROM track WHERE unitprice IN (SELECT MAX(unitprice) FROM track) fetch first row only;

-- 3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_price 
RETURN NUMBER AS avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/

SELECT average_price FROM dual;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.

select * from employee where birthdate > to_date('12/31/1968','MM/DD/YYYY');

-- 4 Stored Procedures
-- 4.1 Basic Stored Procedures
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE full_name
(S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR 
SELECT firstname, lastname FROM employee;
END;
/

SET SERVEROUT ON;

DECLARE
S SYS_REFCURSOR;
fname employee.firstname%TYPE;
lname employee.lastname%TYPE;
BEGIN
    full_name(S);
    LOOP
        FETCH S INTO fname, lname;
        EXIT WHEN S%notfound;
        dbms_output.put_line(fname||' '||lname);
    END LOOP;
    CLOSE S;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE rename_employee
(e_id IN NUMBER, e_first_name IN VARCHAR2, e_last_name IN VARCHAR2)
AS
BEGIN
UPDATE employee SET firstname = e_first_name, lastname = e_last_name WHERE employeeid = e_id;
END;
/

EXECUTE rename_employee(11,'Jane','Foster');

-- Task – Create a stored procedure that returns the managers of an employee 
--this makes more sense as a function
CREATE OR REPLACE FUNCTION managerof
(e_id IN NUMBER)
RETURN VARCHAR2  AS emp_man VARCHAR2(41);
BEGIN
SELECT b.firstname||' '||b.lastname INTO emp_man 
    FROM employee a JOIN employee b ON a.reportsto = b.employeeid WHERE a.employeeid = e_id;
RETURN emp_man;
END;
/

SELECT firstname, lastname, managerof(employeeid) AS manager FROM employee;

-- 4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
select firstname||' '||lastname as name, company from customer;



-- 5 Transactions -- ("just do the thing and then commit afterward" - Matt.)
--Task – Create a transaction that given a invoiceId will delete that invoice 
------- (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure del_invoice (invoice_ID in number)
as
begin
delete from invoice where invoiceID = invoice_ID;
commit;
end;
/


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure insert_Customer 
(C_ID in number, C_fname in varchar2, C_lname in varchar2, C_email in varchar2)
as
begin
insert into customer (customerID, firstname, lastname, email) values (C_ID, C_fname, C_lname, C_email);
commit;
end;
/

-- 6 Triggers

-- 6.1 After/For
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER new_emp
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('Congrats! You''ve added an employee!');
END;
/
INSERT INTO employee (employeeID, firstname, lastname) VALUES (112, 'Loius', 'Griffith');

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER new_album
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    dbms_output.put_line('I notice you''ve updated an album.');
END;
/

UPDATE album SET title = 'Black Light Syndrome [1997]' WHERE albumid = 208;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER remover_cust
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
dbms_output.put_line('Oh. You deleted a customer. Well, okay then.');
END;
/

INSERT INTO customer (customerid, firstname, lastname, email) VALUES (240,'Jon','Dough','example@email.com');
DELETE FROM customer WHERE customerid = 240;

-- 7 Joins
-- 7.1 Inner
-- Task – Create an inner join that joins customers and 
--------- orders and specifies the name of the customer and the invoiceId.
select customer.firstname||' '||customer.lastname as name, invoice.invoiceId 
    from customer join invoice on customer.customerID = invoice.customerID;

-- 7.2 Outer
--Task – Create an outer join that joins the customer and invoice table,
-------- specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerID, customer.firstname, customer.lastname, invoiceID, total
    from customer full outer join invoice on customer.customerID = invoice.customerID;

-- 7.3 Right
--Task – Create a right join that joins album and artist specifying artist name and title.
select artist.name, album.title from album right join artist on album.artistID = artist.artistID;

-- 7.4 Cross
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album cross join artist order by artist.name;

-- 7.5 Self
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select * from employee;
select A.firstname||' '||A.lastname as employee, B.firstname||' '||B.lastname as boss
    from employee A join employee B on A.reportsto = B.employeeID;
