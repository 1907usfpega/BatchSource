--2.1
SELECT * FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto = null;
-------------
--2.2
/*Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city */
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;
-----------
--2.3
/*
Task – Insert two new records into Genre table || Task – Insert two new records into Employee table || Task – Insert two new records into Customer table
*/
INSERT INTO genre VALUES(26, Igorrr);
INSERT INTO genre VALUES(27, EDM);
--
DESC employee;
INSERT INTO employee VALUES(100000, Schenck, Leonardo, Dr, null, 
    06/06/1995, 15/07/2019, '23SW somestreet alabama', 'Venice', 
    'Florida', 33219, '(1) 234 554 9982', '1-231-4124', ('someaddress@somedomain.gov'));
INSERT INTO employee VALUES(10000, Katja, Schneider, null, null, 
    10/06/1987, 24/02/2019, '304SE someotherstreet', 'Las Vegas', 
    'Nevada', 11392, '(49) 15735332202', '1-231-234-4124', ('katjachatja@somedomain.gov'));
--
INSERT INTO customer VALUES(1000, 'Anthony', 'Brausel', 'Revature', 'Kunterbuntstr.309', 'Cape Resort', 'Nebraska', 'USA', '22301', '1-123-321-4455', null, 'anthony.b@revature.com', '9');
INSERT INTO customer VALUES(1000, 'Guenther', 'Claas', 'Aldi', 'Kunterbuntstr.306', 'Cape Resort', 'Nebraska', 'USA', '44301', '1-321-123-4213', null, 'guenther.c@aldi.com', '2');
--------
--2.4
SELECT firstname FROM customer WHERE lastname = 'Mitchell' OR lastname = 'Walter';
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron' AND lastname = 'Mitchell';
SELECT firstname FROM customer WHERE lastname = 'Mitchell' OR lastname = 'Walter';
--
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
-------
--2.5
SELECT * FROM invoice
    WHERE billingaddress LIKE 'T%';
-------
--2.6
SELECT * FROM invoice
    WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee
    WHERE hiredate 
    BETWEEN TO_DATE('01/06/2003','DD/MM/YYYY') AND  TO_DATE('01/03/2004','DD/MM/YYYY');
-------
--2.7
SELECT TO_CHAR(get_systime(), 'DD-MON-RR HH24.MM.SS AM TZR') FROM dual;

--==========================
--ALTER SESSION SET nls_date_format='DD-MON-YYYY';
ALTER SESSION SET TIME_ZONE = '-04';
--3.1
CREATE OR REPLACE FUNCTION get_systime
    RETURN TIMESTAMP AS
    l_sysdate TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO l_sysdate
    FROM dual;
RETURN l_sysdate;
END;
/
--ALTER SESSION SET nls_date_format='DD-MON-YYYY'; --Else the Time won't be displayed correctly
--SELECT get_systime() FROM dual;
SELECT TO_CHAR(get_systime(), 'HH24:MM:SS') FROM dual;
SELECT current_timestamp FROM dual;
-- 3.1.2
--DIDN'T DO IT! Heh.
--jkjk
create or replace function length_of_mediatypename
(media_id in number)
return number as
name_length number(10,2);
begin
   select length(name) into name_length
   from mediatype where mediatypeid=media_id;
   return name_length;
end ;
/
----------
--3.2
CREATE OR REPLACE FUNCTION getAvgInvoice
Return NUMBER AS
AvgTotal NUMBER;
BEGIN
    SELECT AVG(total)
    INTO AvgTotal
    FROM invoice;
RETURN AvgTotal;
END;
/
SELECT getAvgInvoice From dual;
--
--3.2.2
CREATE OR REPLACE FUNCTION getMaxCostTrack
Return NUMBER AS
maxCostId NUMBER;
BEGIN
    SELECT trackid
    INTO maxCostId
    FROM (SELECT * FROM track ORDER BY unitprice DESC) 
    fetch first row only;
RETURN maxCostId;
END;
/
SELECT * FROM track WHERE trackid = getMaxCostTrack;
SELECT * FROM track ORDER BY unitprice DESC;
--
--3.3
CREATE OR REPLACE FUNCTION getAvgInvoicePrice
Return NUMBER AS
AvgPrice NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO AvgPrice
    FROM invoiceline;
RETURN AvgPrice;
END;
/
SELECT getAvgInvoicePrice From dual;
--
--3.4
CREATE OR REPLACE FUNCTION getRef
RETURN SYS_REFCURSOR AS
refCurse SYS_REFCURSOR;
BEGIN
    OPEN refCurse FOR
    SELECT *
    FROM employee
    WHERE birthdate > '01-JAN-1968';
RETURN refCurse;
END;
/
SELECT getRef FROM dual;
------------
--4.1
CREATE OR REPLACE PROCEDURE get_employee_names
(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR 
SELECT firstname, lastname
FROM employee;
END;
/
--function outside of function:
SET SERVEROUT ON;

DECLARE S SYS_REFCURSOR;
fName employee.firstname%TYPE; --sets album_id to whatever datatype the albumid is. Same as writing album_id VARCHAR2
lName employee.lastname%TYPE;
BEGIN
    get_employee_names(S);
    LOOP
    FETCH S into fName, lName;
    EXIT WHEN S%NOTFOUND; --break out of loop when no more rows available
    DBMS_OUTPUT.PUT_LINE(fName ||' & ' || lName|| ' is the first & last name respectively');
    END LOOP;
    CLOSE S;
END;
/
--
--4.2
CREATE OR REPLACE PROCEDURE updateUser
(newLastName IN VARCHAR2, newFirstName IN VARCHAR2, employeID IN NUMBER)
AS
BEGIN
    UPDATE employee SET firstname = newFirstName, lastname = newLastName WHERE employeeid = employeid;
COMMIT;
END;
/
EXECUTE updateUser('Hans', 'Baams', 6);
--4.2.2 TODO
--CREATE OR REPLACE PROCEDURE iWannaSpeakTheManager
--(custId IN NUMBER, managers OUT VIEW)
--4.3
CREATE OR REPLACE PROCEDURE get_customer_info
(fName OUT customer.firstname%TYPE, lName OUT VARCHAR2, outCompany OUT VARCHAR2, user_id IN NUMBER)
AS
BEGIN
    SELECT firstname, lastname, company INTO fName, lName, outCompany FROM customer WHERE customerid = user_id;
END;
/
SET SERVEROUT ON;
DECLARE lName customer.lastname%TYPE;
fName customer.firstname%TYPE;
outCompany customer.company%TYPE;
BEGIN 
get_customer_info(
    fName,
    lName, 
    outCompany, 
    1);
    DBMS_OUTPUT.PUT_LINE(outCompany||' is the company (or empty if null). ' || fName || ' is the customers firstname & ' || lName || ' is the customers lastname');
END;
/
---------------
--5.0
/*
ALTER TABLE Invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;
DELETE FROM invoice WHERE invoiceid = 2;
COMMIT;   ---TCL
ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
ON DELETE CASCADE; --Same code runs for others - I don't get why it does not run here. Please come back to me if you figure something out :s I really want to know.
*/

--5.0.2
CREATE OR REPLACE PROCEDURE insertCustomer
(CUSTOMERID2 IN NUMBER,
FIRSTNAME2 IN VARCHAR2,
LASTNAME2 IN VARCHAR2,
COMPANY2 IN VARCHAR2,
ADDRESS2 IN VARCHAR2,
CITY2 IN VARCHAR2,
STATE2 IN VARCHAR2,
COUNTRY2 IN VARCHAR2,
POSTALCODE2 IN VARCHAR2,
PHONE2 IN VARCHAR2,
FAX2 IN VARCHAR2,
EMAIL2 IN VARCHAR2,
SUPPORTREPID2 IN NUMBER)
AS
BEGIN
    INSERT INTO customer VALUES(CUSTOMERID2,
FIRSTNAME2,
LASTNAME2,
COMPANY2,
ADDRESS2,
CITY2,
STATE2,
COUNTRY2,
POSTALCODE2,
PHONE2,
FAX2,
EMAIL2,
SUPPORTREPID2);
COMMIT;
END;
/
------------------
--6.0
CREATE SEQUENCE employeeCounter
MINVALUE 1000
MAXVALUE 10000
START WITH 1000
INCREMENT BY 1
CACHE 20;
CREATE SEQUENCE albumCounter 
MINVALUE 1000
MAXVALUE 10000
START WITH 1000
INCREMENT BY 1
CACHE 20;
CREATE SEQUENCE customerCounter
MINVALUE 1000
MAXVALUE 10000
START WITH 1000
INCREMENT BY 1
CACHE 20;
--6.1.1
CREATE OR REPLACE TRIGGER afterEmployeeInsert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('We successfully fired an after inserttrigger!');
END;
/
--6.1.2
CREATE OR REPLACE TRIGGER afterAlbumUpdate
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('We successfully fired an updatetrigger!');
END;
/
--6.1.3
CREATE OR REPLACE TRIGGER afterCustomerDelete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('We successfully fired an after delete trigger! goodbye customer.');
END;
/
-- 7.1
SELECT customer.firstname, customer.lastname, invoice.invoiceid
    FROM customer 
    INNER JOIN invoice 
    ON customer.customerid = invoice.customerid;
-- 7,2 
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
    FROM customer c 
    FULL OUTER JOIN invoice i 
    ON c.customerid = i.customerid;
-- 7.3
SELECT album.title, artist.name, artist.artistid, album.albumid
    FROM artist
    RIGHT OUTER JOIN album 
    ON album.artistid = artist.artistid;
--7.4
SELECT * 
FROM ALBUM
CROSS JOIN ARTIST ORDER BY artist.name ASC;
--7.5
SELECT * FROM employee a JOIN employee b 
ON a.REPORTSTO = b.employeeid;