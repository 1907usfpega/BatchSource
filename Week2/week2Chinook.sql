select * from invoice;

--2.1
--Task1
select * from employee;
--Task2
select * from employee
where lastname ='King';
--Task3
select * from employee
where firstname = 'Andrew' and reportsto is null;
--2.2
--Task1
select * from album
order by Title desc;
--Task2
select firstname from customer
order by city asc;
--2.3
--Task  Insert two new records into Genre table 


insert into genre (genreid,name) values (26, 'New Rock');
insert into genre (genreid,name) values (27, 'Anime OST');


--Task  Insert two new records into Employee table

insert into employee values('9','hua','justin','IT staff',1,'1/jan/10','7/jan/19','1111 main st','tampa','fl','US','t1h 2n1','+1(111)111-1111','+1(111)111-1111','just.in@revature.com');
insert into employee values('10','justin','bustin','manager',1,'1/jan/10','7/jan/19','1111 main st','tampa','fl','US','t1h 2n1','+1(111)111-1111','+1(111)111-1111','just.in@revature.com');

--Task  Insert two new records into Customer table

insert into customer (customerId, firstname, lastname, address, city, country, postalcode, phone, email, supportrepid) 
values (60, 'Justin', 'Hua', '10 1st st', 'Tampa', 'US', '11111', '+1 (222) 222-2222', 'jhua@revature.com', 3);
insert into customer (customerId, firstname, lastname, address, city, country, postalcode, phone, email, supportrepid) 
values (61, 'Bustin', 'Chops', '11 2nd St', 'Tampa', 'US', '11111', '+1 (222) 333-3333', 'bchops@revature.com', 5);

--2.4 UPDATE
--Task  Update Aaron Mitchell in Customer table to Robert Walter

update customer set firstname ='Robert',lastname= 'Walter'
where firstname='Aaron' and lastname='Mitchell'; 
--Task  Update name of artist in the Artist table Creedence Clearwater Revival to CCR	

update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task  Select all invoices with a billing address like T% 
select * from invoice
where billingaddress like 'T%';
--2.6 BETWEEN
--Task  Select all invoices that have a total between 15 and 50
select * from invoice
where total BETWEEN 15 and 50;

--Task  Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee
where hiredate between '1/Jun/2003' and '1/mar/2004';

--2.7 
--DELETE
--Task  Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

delete from customer where firstname= 'Robert' and lastname= 'Walker';

--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions

--Task  Create a function that returns the current time.
create or replace function current_timestamp 
return TIMESTAMP as
begin
  return current_timestamp;
end;
/

select current_timestamp from dual;

--Task  create a function that returns the length of name in MEDIATYPE table


--3.2 System Defined Aggregate Functions
--Task  Create a function that returns the average total of all invoices 
--Task  Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task  Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task  Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task  Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task  Create a stored procedure that updates the personal information of an employee.
--Task  Create a stored procedure that returns the managers of an employee .
--4.3 Stored Procedure Output Parameters
--Task  Create a stored procedure that returns the name and company of a customer.
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task  Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task  Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task  Create an after update trigger on the album table that fires after a row is inserted in the table
--Task  Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task  Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.2 OUTER
--Task  Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task  Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task  Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task  Perform a self-join on the employee table, joining on the reportsto column.
--
--
--
--
