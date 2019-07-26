/* 2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM Employee;

SELECT * FROM Employee
WHERE
LASTNAME='King';

SELECT * FROM Employee
WHERE 
FIRSTNAME = 'Andrew' AND REPORTSTO = Null;

/*2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM 
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

/*2.3 INSERT INTO
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
*/
INSERT INTO GENRE (GENREID, NAME)
VALUES (99, 'TAlbum');

INSERT INTO GENRE (GENREID, NAME)
VALUES (919, 'GG_ALBUM');


INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNALE,TITLE,REPORTSTO,BIRTHDAY,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES (999, 'Im', 'Terry','Mr Awesome', 3, 04/04/2012, 07/07/2019, '1234 Adam Street','Tempa','Florida','33221','939-222-3342','444-334-5335','Mr_Awesome@gmail.com');

INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNALE,TITLE,REPORTSTO,BIRTHDAY,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES (999, 'Im', 'Aileen','Mrs Awesome', 2, 03/31/2015, 07/07/2019, '1234 Adam Street','Tempa','Florida','33221','939-222-3342','444-334-5335','Mrs_Awesome@gmail.com');

INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES (322,'TERRY','IM','GOOGLE','333 GOOGLE STREET','TEMPA','FLORIDA','USA','33123','333-444-2234','333-444-2234','TEIM@GMAIL.COM', 1222);

INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES (323,'AILEEN','IM','GOOGLE','333 GOOGLE STREET','TEMPA','FLORIDA','USA','33123','333-444-2234','333-444-2234','AILIM@GMAIL.COM', 1223);

/*2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
UPDATE Customers SET ContactName='Juan' WHERE Country='Mexico';
*/
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron'AND LASTNAME='Mitchell';
UPDATE ARTIST SET NAME ='CCR' WHERE NAME='Creedence Clearwater Revival';

/*2.5 LIKE
Task – Select all invoices with a billing address like “T%” 
SELECT * FROM Customers WHERE CustomerName LIKE 'o%';   --select all customername from the customer tavle that starts with 0.
*/

SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
SELECT * FROM Products
WHERE Price NOT BETWEEN 10 AND 20;
*/
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN 01-JUN-03 AND 01-MAR-04;

DESC EMPLOYEE;

/*
DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
*/
DELETE FROM CUSTOMER 
WHERE FIRSTNAME='Robert' AND LASTNAME ='Walter';



