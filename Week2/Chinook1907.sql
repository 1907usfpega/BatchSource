SET SERVEROUT ON;
--2.1

--2.1.1
--selects all the records in the employee table
SELECT * FROM employee;
--2.1.2
--returns any row in the employee table that contains a person with the last name King
SELECT * FROM employee WHERE (lastname = 'King');
--2.1.3
--selects any row in the employee table that contains a person with the first name Andrew and does not report to anyone
SELECT * FROM employee WHERE (firstname = 'Andrew' AND reportsto = NULL);

--2.2

--2.2.1
--returns all albums in order from numbers z-a
SELECT * FROM album ORDER BY title DESC;
--2.2.2
--returns the first name of every customer orders the results by the city they are in from a-z
SELECT firstname FROM customer ORDER BY city ASC;

--2.3

--2.3.1
--inserts two new rows into genre table
INSERT INTO genre VALUES (26,'Country');
INSERT INTO genre VALUES (27,'Bee Bop');
--2.3.2
--inserts two new rows into employee table
INSERT INTO employee(employeeid,lastname,firstname,title) VALUES (9,'Kilpatrick', 'Deonta','Associate');
INSERT INTO employee(employeeid,lastname,firstname,title) VALUES (10,'Knighten', 'Matt','Trainer');
--2.3.3
--inserts two new rows into customer table
INSERT INTO customer(customerid, firstname, lastname) VALUES(60, 'Deonta','Kilpatrick');
INSERT INTO customer(customerid, firstname, lastname) VALUES(61, 'Matt','Knighten');

--2.4

--2.4.1
--changes a customer's name
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE (firstname = 'Aaron' AND lastname = 'Mitchell');
--2.4.2
--changes an artist's name
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5

--2.5.1
--returns all invoices with a billing address that starts with T
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6

--2.6.1
--returns all invoices with a total between the following values
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
--2.6.2
--returns all employees hired between certain dates (*so we can fire them all*)
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('06/01/2003', 'mm/dd/yyyy') AND TO_DATE('03/01/2004', 'mm/dd/yyyy');


--2.7

--2.7.1
--changing the constraint on child tables to add the functionality of being deleted when the corresponding customer is deleted
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid) REFERENCES customer (customerid)
    ON DELETE CASCADE;
    
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid)
    ON DELETE CASCADE;
    
DELETE FROM customer WHERE (firstname = 'Robert' AND lastname = 'Walter');

--3.1

--3.1.1
--SELECT CURRENT_TIMESTAMP FROM SYS.dual;
/*
THE ABOVE DOES WHAT THE FUNCTION DOES
*/
CREATE OR REPLACE FUNCTION get_time
    RETURN DATE IS
        curr_time DATE;
    
    BEGIN
    SELECT CURRENT_TIMESTAMP  
        INTO curr_time
        FROM SYS.dual;
        RETURN curr_time;
    END get_time;
  
DECLARE
    curr DATE;
BEGIN
    curr := get_time();
    DBMS_OUTPUT.PUT_LINE('It is ' || curr);
END;
/

--3.1.2 
--SELECT LENGTH('DEONTA') FROM DUAL;
CREATE OR REPLACE FUNCTION get_length(a  VARCHAR2)
    RETURN NUMBER DETERMINISTIC IS
        num NUMBER;
        
    BEGIN
        SELECT LENGTH(a) INTO num FROM DUAL;
        RETURN (num);
    END get_length;
    
DECLARE
    len NUMBER;
    TYPE publicname IS record (medianame mediatype.name%TYPE);
    media_name publicname;  
BEGIN
    SELECT mediatype.name INTO media_name FROM mediatype WHERE mediatypeid = 1;
    SELECT get_length(media_name.medianame) INTO len FROM DUAL;
    DBMS_OUTPUT.PUT_LINE('Media type name is ' || media_name.medianame || '. Length is ' || len || '.');
END;
/

--3.2

--3.2.1
--returns the average total for the list of invoices
CREATE OR REPLACE FUNCTION get_avgtotal
    RETURN NUMBER IS
        avg_total NUMBER;
    
    BEGIN
    SELECT AVG(total)  
        INTO avg_total
        FROM invoice;
        RETURN avg_total;
    END get_avgtotal;
  
DECLARE
    avg_total NUMBER(10,2);
BEGIN
    avg_total := get_avgtotal();
    DBMS_OUTPUT.PUT_LINE('The average price of invoices is ' || avg_total);
END;
/

--3.2.2
--selects the track with the minimum trackid from a list of tracks withh the maximum unit price
CREATE OR REPLACE FUNCTION get_maxtrack
    RETURN track%ROWTYPE IS
        maxed_priced track%ROWTYPE;
    
BEGIN
    SELECT TRACKID ,
            NAME ,
            ALBUMID ,
            MEDIATYPEID ,
            GENREID ,
            COMPOSER ,
            MILLISECONDS ,
            BYTES ,
            UNITPRICE
    INTO maxed_priced 
    FROM track 
    WHERE trackid =
        (SELECT (MIN(trackid)) 
        FROM (SELECT *
                FROM track
                WHERE(
                    unitprice = (
                        SELECT MAX(unitprice)
                        FROM track
                    ) 
                )
            )
        );
    RETURN maxed_priced;
END get_maxtrack;

DECLARE
    max_priced track%ROWTYPE;
BEGIN
    max_priced := get_maxtrack();
    DBMS_OUTPUT.PUT_LINE( 'Track Id: '|| max_priced.trackid || '. Name: ' || max_priced.name || '. Album Id: '
    || max_priced.albumid || '. Mediatype Id: ' || max_priced.mediatypeid 
    || '. Genre Id: ' || max_priced.genreid || '. Composer: ' || max_priced.composer
    || '. Milliseconds: ' || max_priced.milliseconds || '. Bytes: ' || max_priced.bytes || '. Unit Price: ' || max_priced.unitprice);
END;
/

--3.3

--3.3.1
--the specifications were for an aggregate function so...
CREATE OR REPLACE FUNCTION avgprice
RETURN NUMBER IS
priced NUMBER(10,2);
BEGIN
SELECT AVG(unitprice) INTO priced FROM invoiceline;
RETURN priced;
END avgprice;

DECLARE
avgpriced NUMBER := avgprice();

BEGIN
DBMS_OUTPUT.PUT_LINE('The average price for an invoiceline item is ' || avgpriced);
END;
/
--3.4

--3.4.1
--gets employees that are old using an opened cursor as param
CREATE OR REPLACE FUNCTION get_names(names IN SYS_REFCURSOR)
RETURN NUMBER IS

employeeid employee.employeeid%TYPE;
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;

BEGIN
    LOOP
    FETCH names INTO employeeid,firstname,lastname;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(employeeid || ' ' || firstname || ' ' || lastname);
    END LOOP;
    CLOSE names;
    RETURN 1;
END get_names;

DECLARE
    names SYS_REFCURSOR;
    returned NUMBER;
    
BEGIN
   OPEN names FOR SELECT employeeid ,firstname, lastname FROM employee
        WHERE birthdate >= TO_DATE('01/01/1969','MM/DD/YYYY');
    
    SELECT get_names(names) INTO returned FROM DUAL;
END;
/

--4.1
--4.1.1
--basically same as before without age restriction in procedure form
CREATE OR REPLACE PROCEDURE get_employees(names IN SYS_REFCURSOR)
IS
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;


BEGIN
    LOOP
    FETCH names INTO firstname,lastname;
    EXIT WHEN names%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    END LOOP;
    CLOSE names;
END get_employees;

DECLARE
    names SYS_REFCURSOR;
    
BEGIN
   OPEN names FOR SELECT firstname, lastname FROM employee;
    
    get_employees(names);
END;
/

--4.2

--4.2.1
--changes employee info
CREATE OR REPLACE PROCEDURE personal_info
(pro_employeeid NUMBER, pro_lastname VARCHAR2, pro_firstname VARCHAR2, 
pro_address VARCHAR2, pro_city VARCHAR2,
pro_state VARCHAR2, pro_country VARCHAR2, pro_postalcode VARCHAR2, 
pro_phone VARCHAR2, pro_fax VARCHAR2, pro_email VARCHAR2)
IS
BEGIN
    UPDATE employee SET employee.lastname = pro_lastname,
    employee.firstname = pro_firstname,
    employee.address = pro_address,
    employee.city = pro_city,
    employee.state =pro_state,
    employee.country = pro_country,
    employee.postalcode = pro_postalcode,
    employee.phone = pro_phone,
    employee.fax = pro_fax,
    employee.email = pro_email
    WHERE employee.employeeid = pro_employeeid;
    --COMMIT;
END personal_info;
    
    
BEGIN
    personal_info(1, 'Kilpatrick', 'Deonta', '3070 Claudine Cv.', 'Memphis', 'TN',
    'USA', '38127', '9012209641', '6012074964', 'deonta.kilpatrick@gmail.com');
END;
/

--4.2.2
--returns the manager of an employee
CREATE OR REPLACE PROCEDURE get_managers(manager SYS_REFCURSOR)
IS

managerid employee.employeeid%TYPE;
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;

BEGIN
    LOOP
    FETCH manager INTO managerid,firstname,lastname;
    EXIT WHEN manager%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(managerid || ' ' || firstname || ' ' || lastname);
    END LOOP;
    CLOSE manager;
END get_managers;

DECLARE 
    manager SYS_REFCURSOR;
    pro_employeeid NUMBER := 7;
BEGIN
    OPEN manager FOR 
        SELECT employeeid ,firstname, lastname FROM employee WHERE employeeid = (
            SELECT reportsto from employee WHERE employeeid = pro_employeeid);
    get_managers(manager);
END;
/

--4.3

--4.3.1
--returns a customer name and company
CREATE OR REPLACE PROCEDURE get_customers(pro_customer SYS_REFCURSOR)
IS

firstname customer.firstname%TYPE;
lastname customer.lastname%TYPE;
company customer.company%TYPE;

BEGIN
    LOOP
    FETCH pro_customer INTO firstname,lastname,company;
    EXIT WHEN pro_customer%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname || ' ' || company);
    END LOOP;
    CLOSE pro_customer;
END get_customers;

DECLARE 
    pro_customer SYS_REFCURSOR;
    pro_customerid NUMBER := 1;
BEGIN
    OPEN pro_customer FOR 
        SELECT firstname, lastname, company FROM customer WHERE customerid = pro_customerid;
    get_customers(pro_customer);
END;
/

--5.0

--5.0.1

--THE FK OF INVOICEID HAS ALREADY BEEN ALTERED TO CASCADE ON DELETE
DECLARE
    pro_id NUMBER;
BEGIN

    SELECT invoiceid INTO pro_id FROM invoiceline WHERE invoicelineid = 977;
    --SAVEPOINT do_delete;
    DELETE FROM invoice WHERE invoiceid = pro_id;
    /*IF pro_id IS NOT OF invoiceline.invoiceid%TYPE THEN
      RAISE INVALID_NUMBER;  -- raise predefined exception
    END IF;
    DELETE FROM invoice WHERE invoiceid = pro_id;
EXCEPTION
    WHEN INVALID_NUMBER THEN
    ROLLBACK TO do_delete;
    DBMS_OUTPUT.PUT_LINE('Delete has been rolled back');*/
END;
COMMIT;

--5.0.2
--MAKE A SEQUENCE TO REMOVE ID PARAM
CREATE OR REPLACE PROCEDURE insert_customer(cust_id NUMBER, f_name VARCHAR2, l_name VARCHAR2, cust_email VARCHAR2)
IS
    repid NUMBER;
    
BEGIN

    SELECT employeeid INTO repid FROM EMPLOYEE WHERE employeeid = 1;
    INSERT INTO customer(customerid, firstname, lastname,email,supportrepid) VALUES(cust_id, f_name,l_name,cust_email,repid);
    --commit;
END insert_customer;

DECLARE
   cust_id NUMBER := 60;
   f_name VARCHAR2(40 BYTE) := 'Deonta';
   l_name VARCHAR2(20 BYTE) := 'Kilpatrick';
   cust_email VARCHAR2(60 BYTE) := 'deontak@gmail.com';
BEGIN
    insert_customer(cust_id, f_name,l_name,cust_email);
END;
/
    
--6.1

--6.1.1
CREATE OR REPLACE TRIGGER insert_employee AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have inserted an employee.');
END insert_employee;

--6.1.2
CREATE OR REPLACE TRIGGER update_album AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have updated an album.');
END update_album;

--6.1.3
CREATE OR REPLACE TRIGGER delete_customer AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You have deleted a customer.');
END delete_customer;

--7.1
SELECT customer.firstname, customer.lastname,invoice.invoiceid
FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2
SELECT customer.customerid,customer.firstname, customer.lastname,invoice.invoiceid,invoice.total
FROM customer FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3
SELECT artist.name, album.title
FROM album RIGHT OUTER JOIN artist
ON album.artistid = artist.artistid;

--7.4
SELECT title, name
FROM album CROSS JOIN artist
ORDER BY name ASC;

--7.5
SELECT e1.lastname "Worker", e2.lastname "Manager"
FROM employee e1 JOIN employee e2
ON e1.reportsto = e2.employeeid;


rollback;
commit;