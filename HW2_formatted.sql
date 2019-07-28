--2.1

SELECT *
FROM employee;

--use single quotes

SELECT *
FROM employee
WHERE lastname='King';


SELECT *
FROM employee
WHERE firstname='Andrew'
  AND reportsto IS NULL;

--2.2

SELECT *
FROM album
ORDER BY title DESC;

--Don't need to specify ASC below, but explicit is always better

SELECT firstname
FROM customer
ORDER BY city ASC;

--2.3
--Don't need to specify column names below, but explicit is always better

INSERT INTO genre (genreid, name) 
VALUES (26, 'IDK1');


INSERT INTO genre (genreid, name)
VALUES (27, 'IDK2');

--Leave everything that I can null;

INSERT INTO employee (employeeid, lastname, firstname)
VALUES (9, 'Perez', 'Lori');


INSERT INTO employee (employeeid, lastname, firstname)
VALUES (10, 'Hollander', 'Ben');


INSERT INTO customer (customerid, firstname, lastname, email)
VALUES (60, 'Lori', 'Perez', 'allan_ritch@gmail.com');


INSERT INTO customer (customerid, firstname, lastname, email)
VALUES (61, 'Ben', 'Hollander', 'whaddayathink@example.com');

--2.4
--Aaron Mitchell to Robert Walter

UPDATE customer
SET firstname='Robert',
    lastname='Walter'
WHERE firstname='Aaron'
  AND lastname='Mitchell';

--Creedence Clearwater Revival to CCR

UPDATE artist
SET name='CCR'
WHERE name='Creedence Clearwater Revival';

--2.5

SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6

SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

--NEED TO CONVERT STRING TO DATE HERE & PASS IN HOW THE DATE IS FORMATTED

SELECT *
FROM employee
WHERE hiredate BETWEEN to_date('06/01/2003', 'MM/DD/YYYY') AND to_date('03/01/2004', 'MM/DD/YYYY');

--2.7
--childrecord found constraint
--FIRST DELETE RECORDS THAT ARE REFERENCED
--GET CUSTOMERID IN NESTED QUERIES

DELETE
FROM invoiceline
WHERE invoiceid IN
    (SELECT customerid
     FROM customer
     WHERE firstname='Robert'
       AND lastname='Walter');


DELETE
FROM invoice
WHERE customerid IN
    (SELECT customerid
     FROM customer
     WHERE firstname='Robert'
       AND lastname='Walter');

--THEN

DELETE
FROM customer
WHERE firstname='Robert'
  AND lastname='Walter';

--3.1
/*
 *GETS DATE OF OS THAT DB IS ON
 *RETURNS DATE IN FORM OF
 * 11:52:22 PM
 * "NOW" IS THE COLUMN NAME FOR THE RETURN
 * DUAL IS THE DEFAULT TABLE
 */
SELECT to_char (sysdate, 'HH12:MI:SS AM') "NOW"
FROM dual;


SELECT length(name)
FROM mediatype;

--3.2

SELECT avg(total)
FROM invoice;

/*
 *USED SUBQUERY OF MAX TO RETURN ENTIRE RECORD
 *ROWNUM LIMITS THE NUMBER OF ROWS RETURNED
 */
SELECT *
FROM track
WHERE unitprice =
    (SELECT max(unitprice)
     FROM track)
  AND ROWNUM=1;

--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--NOT SCALAR

SELECT avg(unitprice)
FROM invoiceline;

--3.4

SELECT *
FROM employee
WHERE extract(YEAR FROM employee.birthdate) > 1968;

--4.1

CREATE OR REPLACE PROCEDURE empfullname
(s OUT sys_refcursor)
IS
BEGIN
  OPEN s FOR
SELECT firstname, lastname
FROM employee; END empfullname;
--DELIMITER CAUSES ISSUES ON MY COMPUTER
--EXECUTE, WON'T DISPLAY ON MY COMPUTER
SET serverout ON; 
  DECLARE s sys_refcursor; fname employee.firstname%TYPE; lname employee.lastname%TYPE;
  BEGIN empfullname(s); --Call procedure with parameters
    LOOP FETCH s INTO fname, lname;
    exit WHEN s%NOTFOUND;
  END LOOP;
  CLOSE s;
  END;

--4.2
--PART 1

CREATE OR REPLACE PROCEDURE q4_2_1
(id IN employee.employeeid%TYPE, v IN employee.firstname%TYPE)
IS
BEGIN
  UPDATE employee SET firstname=v 
  WHERE employee.employeeid=id;
END q4_2_1;
--EXECUTE
EXECUTE q4_2_1(1, 'Andy');

--PART 2

CREATE OR REPLACE PROCEDURE q4_2_2
(id IN employee.employeeid%TYPE, s OUT sys_refcursor)
IS
BEGIN
  OPEN s FOR
  SELECT reportsto FROM employee WHERE employee.employeeid=id;
END q4_2_2;
--EXECUTE
SET serverout ON;
DECLARE s sys_refcursor; manager employee.reportsto%TYPE;
BEGIN q4_2_2(2, s);
  FETCH s INTO manager;
  CLOSE s;
END;

--4.3

CREATE OR REPLACE PROCEDURE q4_3
(c IN customer.customerid%TYPE, s OUT sys_refcursor)
IS
BEGIN
  OPEN s FOR
  SELECT firstname, lastname, company FROM customer 
  WHERE customer.customerid=c;
END q4_3;
--EXECUTE
SET serverout ON;
DECLARE s sys_refcursor;
BEGIN
  q4_3(1, s); --Call procedure with parameters
  CLOSE s;
END;

--5.1

CREATE OR REPLACE PROCEDURE q5_1
(i IN invoice.invoiceid%TYPE)
IS
BEGIN
  DELETE FROM invoiceline WHERE invoiceid=i;
  DELETE FROM invoice WHERE invoice.invoiceid=i;
END q5_1;

--EXECUTE
EXECUTE q5_1(324);

--5.2

CREATE OR REPLACE PROCEDURE q5_2 
(i IN customer.customerid%TYPE, fname IN customer.firstname%TYPE, lname IN customer.lastname%TYPE, email IN customer.email%TYPE)
IS
BEGIN 
  INSERT INTO customer(customerid, firstname, lastname, email)
  VALUES (i, fname, lname, email);
END;
--EXECUTE
EXECUTE q5_2(60, 'FNAME', 'LNAME', 'FNAME.LNAME@example.com');
--6.1
--I KEPT GETTING A BAD BIND VARIABLE DOING
--SELECT 'TRUE' INTO:NEW.C_ID FROM DUAL;
--SO I USED DBMS OUTPUT

CREATE OR REPLACE TRIGGER q6_1
AFTER INSERT ON employee
BEGIN
  dbms_output.put_line('TRIGGER 6.1 RAN');
END;
--6.2.1

CREATE OR REPLACE TRIGGER q6_2_1
AFTER INSERT ON album
BEGIN
  dbms_output.put_line('TRIGGER 6.2.1 RAN');
  UPDATE album SET albumid=1 WHERE albumid=1;
END

--6.2.2

CREATE OR REPLACE TRIGGER q6_2_2
AFTER UPDATE ON album
BEGIN 
  dbms_output.put_line('TRIGGER 6.2.2 RAN');
END;
--6.3

CREATE OR REPLACE TRIGGER q6_3
AFTER DELETE ON customer
BEGIN
dbms_output.put_line('TRIGGER 6.3 RAN');
END;

--7.1

SELECT customer.firstname,customer.lastname,invoice.invoiceid
FROM customer
INNER JOIN invoice ON customer.customerid=invoice.customerid;

--7.2
SELECT customer.customerid, customer.firstname, customer.lastname,
      invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice ON customer.customerid=invoice.customerid;

--7.3

SELECT album.title, artist.name
FROM album
RIGHT OUTER JOIN artist ON album.artistid=album.artistid; --7.4
--https://docs.oracle.com/javadb/10.8.3.0/ref/rrefsqljcrossjoin.html#rrefsqljcrossjoin

SELECT * FROM album, artist ORDER BY artist.name;

--7.5
--use distinct to prevent duplicates, essentially gets rid of the person who reports to null

SELECT DISTINCT r1.employeeid, r1.firstname, r1.lastname, r2.reportsto
FROM employee r1
JOIN employee r2 ON r1.reportsto=r2.reportsto;