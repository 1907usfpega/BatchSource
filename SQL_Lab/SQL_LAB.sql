--SQL Lab
--Eddie Heredia

--2.1
SELECT * 
FROM EMPLOYEE;

SELECT * 
FROM EMPLOYEE 
WHERE (lastname = 'King') ;

SELECT * 
FROM EMPLOYEE 
WHERE (firstname = 'Andrew' AND reportsto IS null);

--2.2
SELECT * 
FROM ALBUM 
ORDER BY TITLE DESC; 

SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY FIRSTNAME ASC;

--2.3

INSERT INTO genre VALUES(26, 'Parody');
INSERT INTO genre VALUES(27, 'Chill');

INSERT INTO employee VALUES(9, 'Heredia', 'Eddie', 'IT Staff', 6, '30-MAY-95', '5-FEB-10', 'Mc Cool Street', 'Chillville', 'NJ', 'USA', '08610', '+1 (609) 554-9374', '+1 (890) 839-3772', 'e@gmail.com');
INSERT INTO employee VALUES(10, 'Smith', 'Jack', 'IT Staff', 6, '30-MAY-80', '5-JAN-10', 'Mc Cream Streat', 'Orio', 'PA', 'USA', '21222', '+1 (609) 553-9334', '+1 (899) 839-3172', 'jsmith@gmail.com');

INSERT INTO customer VALUES(60, 'Smith', 'Jack', 'Revature', 'Mc Cream Streat', 'Orio', 'PA', 'USA', '21222', '+1 (609) 553-9334', '+1 (899) 839-3172', 'jsmith@gmail.com', 3);
INSERT INTO customer VALUES(61, 'Heredia', 'Eddie', 'Revature','Mc Cool Street', 'Chillv ille', 'NJ', 'USA', '08610', '+1 (609) 554-9374', '+1 (890) 839-3772', 'e@gmail.com', 2);

--2.4

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5
SELECT *
FROM invoice 
WHERE billingaddress 
LIKE 'T%' ;

--2.6
SELECT *
FROM  invoice
WHERE total >=15 
AND total <=50;

SELECT *
FROM employee
WHERE hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';

--2.7
SELECT * FROM customer;

DELETE 
FROM customer
WHERE customerid = 60;

--3.1--CREATE YOUR OWN
SELECT tzname FROM v$timezone_names; 
--ALTER SESSION SET TIME_ZONE ='America/New_York';
--ALTER SESSION SET nls_date_format = 'HH24:MM:SS';
CREATE OR REPLACE FUNCTION get_time
RETURN TIMESTAMP WITH TIME ZONE
AS currenttime_1 TIMESTAMP WITH TIME ZONE;
BEGIN
    SELECT SYSTIMESTAMP AT TIME ZONE 'America/New_York'
    INTO currenttime_1
    FROM dual;
RETURN currenttime_1;
END;
/
SELECT get_time() FROM dual;
    /*
    @param mediaid IN NUMBER 
    @return length of media_type name length
    */
CREATE OR REPLACE FUNCTION length_of_mediatype_table
(mediaid IN NUMBER)
RETURN NUMBER
AS l_of_media NUMBER;
BEGIN
    SELECT length(mediatype.name)
    INTO l_of_media
    FROM  mediatype
    WHERE mediaid = mediatypeid;

RETURN l_of_media;
END;
/
-- 
SELECT length_of_mediatype_table(3) FROM dual;

--3.2
/*
@RETURN average of invoice total
*/
CREATE OR REPLACE FUNCTION avg_of_invoices
RETURN NUMBER
AS avg_in NUMBER;
BEGIN
    SELECT avg(invoice.total)
    INTO avg_in
    FROM  invoice;

RETURN avg_in;
END;
/

SELECT avg_of_invoices() FROM dual;

--3.2.2

CREATE OR REPLACE FUNCTION max_track
RETURN track%ROWTYPE
IS my_track track%ROWTYPE;
BEGIN
 SELECT * INTO my_track FROM track
        WHERE trackid =
            ( SELECT (min(trackid)) FROM (
                SELECT * FROM track
                    WHERE (unitprice =
                        (SELECT max(unitprice) FROM track)
                    )
                )   
        );
RETURN my_track;   
END;
/
SET SERVEROUTPUT ON; 
DECLARE 
 check_this track%ROWTYPE;
 BEGIN
 check_this := max_track(); 
 dbms_output.put_line(check_this.trackid || ' ' ||
 check_this.name||' ' ||check_this.albumid||' ' ||
 check_this.mediatypeid||' ' || check_this.genreid||' ' ||
 check_this.composer);
 END;
 /
 
  
--3.3
SELECT avg(unitprice) FROM invoiceline; 

--3.4
SELECT * FROM employee WHERE (birthdate > '31 DEC 68');



--4.1  -- 
SET serverout ON;
CREATE OR REPLACE PROCEDURE first_last_em 
(s OUT sys_refcursor)
IS
BEGIN 
OPEN S FOR
SELECT firstname, lastname 
FROM employee;
END;
/
DECLARE S SYS_REFCURSOR;
first_name VARCHAR2(40);
last_name VARCHAR2(40);
BEGIN first_last_em(s); --procedure call
LOOP FETCH S INTO first_name, last_name;
EXIT WHEN S%NOTFOUND;
END LOOP;
DBMS_OUTPUT.PUT_LINE(first_name|| ' ' || last_name);
CLOSE S;
END;
/
--4.2

CREATE OR REPLACE PROCEDURE update_employee(eid IN NUMBER, new_ad IN VARCHAR2, new_ci IN VARCHAR2,
new_state IN VARCHAR2, new_country IN VARCHAR2, 
new_post IN VARCHAR2, new_phone IN VARCHAR2,new_fax IN VARCHAR2, new_email IN VARCHAR2)
AS
BEGIN
UPDATE employee
SET address = new_ad, 
    city = new_ci,
    state = new_state, 
    country = new_country,
    postalcode = new_post,
    phone = new_phone,
    fax = new_fax,
    email = new_email
WHERE (eid = employeeid);
COMMIT;
END;
/

EXEC update_employee(1, 'nice street', 'city city', 'state', 'country', '93093', '393939', '393939', 'email');



CREATE OR REPLACE PROCEDURE get_manager(eid IN NUMBER, S OUT SYS_REFCURSOR)
AS  
BEGIN
OPEN S FOR
SELECT firstname, lastname 
FROM employee 
WHERE employeeid = 
    (SELECT reportsto 
    FROM employee 
    WHERE employeeid = eid);   
END;
/
--execute
DECLARE S SYS_REFCURSOR; 
first_name VARCHAR(40);
last_name VARCHAR(40);
BEGIN get_manager(2,S);
    FETCH S INTO first_name, last_name;
    DBMS_OUTPUT.PUT_LINE(first_name || ' ' ||last_name);
    CLOSE S;
END;
/

--4.3
CREATE OR REPLACE PROCEDURE get_name_company(cid IN NUMBER, S OUT SYS_REFCURSOR)
AS  
BEGIN
OPEN S FOR
SELECT firstname, lastname, company 
FROM customer
WHERE customerid = cid;   
END;
/
--execute
DECLARE S SYS_REFCURSOR; 
first_name VARCHAR(40);
last_name VARCHAR(40);
company_ VARCHAR(40);
BEGIN get_name_company(2,S);
    FETCH S INTO first_name, last_name, company_;
    DBMS_OUTPUT.PUT_LINE(first_name || ' ' ||last_name || ' ' ||company_);
    CLOSE S;
END;
/
--5--

CREATE OR REPLACE PROCEDURE delete_invoice(invoice_id IN NUMBER)
IS
BEGIN

DELETE invoiceline WHERE invoiceid = invoice_id;
DELETE invoice WHERE invoiceid = invoice_id;
COMMIT;
END;
/
--EXECUTE 
EXECUTE delete_invoice(3);

--5
CREATE OR REPLACE PROCEDURE insert_customer(cid IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2, em IN VARCHAR2)
IS
BEGIN
savepoint boi;
INSERT INTO customer(customerid, firstname, lastname, email)
VALUES(cid, fn, ln, em);
EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
ROLLBACK TO boi;
DBMS_OUTPUT.PUT_LINE('Roling back to before the insert');
commit;
END;
/

EXEC insert_customer(100, 'eddie', 'eddie', 'email');


--6.1 TRIGGERS
SET SERVEROUTPUT ON; 
CREATE OR REPLACE TRIGGER my_new_trigger
AFTER INSERT on employee
BEGIN
DBMS_OUTPUT.PUT_LINE('roll tide inserted emplyee');
END;
/
INSERT INTO employee(employeeid, firstname, lastname)VALUES(1000, 'ed', 'di');

CREATE OR REPLACE TRIGGER album_trigger
AFTER UPDATE on album
BEGIN
DBMS_OUTPUT.PUT_LINE('roll tide inserted album');
END;
/
INSERT INTO album VALUES(500, 'gucci', 7);

CREATE OR REPLACE TRIGGER customer_trigger
AFTER DELETE on customer
BEGIN
DBMS_OUTPUT.PUT_LINE('roll tide deleted');
END;
/
INSERT INTO CUSTOMER(CUSTOMERID, EMAIL, FIRSTNAME, LASTNAME) VALUES(100, 'c.com', 'cu', 'UL');
DELETE FROM CUSTOMER WHERE CUSTOMERid = 100; 

-- 7.1 INNER JOINS
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM invoice
INNER JOIN customer ON invoice.customerid = customer.customerid;

--7.2 outer join
SELECT customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM invoice
FULL OUTER JOIN customer ON invoice.customerid = customer.customerid;

--7.3 right join
SELECT artist.name, album.title
FROM artist
RIGHT JOIN album ON artist.artistid = album.artistid;

--7.4
SELECT artist.name, album.title
FROM artist
CROSS JOIN album WHERE artist.artistid = album.artistid
ORDER BY artist.name, album.title ASC;

--7.5
SELECT e1.firstname AS employeeid,
e2.firstname AS reports_to
FROM employee e1 JOIN employee e2
ON e1.reportsto = e2.employeeid;

