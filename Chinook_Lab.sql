--2.0 SQL Queries

--2.1 SELECT
SELECT * FROM Employee;
SELECT * FROM Employee WHERE LastName = 'King';
SELECT * FROM Employee 
    WHERE FirstName = 'Andrew' AND Reportsto = null;

--2.2 ORDER BY
SELECT * FROM Album ORDER BY title DESC;
SELECT FirstName FROM Album ORDER BY City ASC;

--2.3 INSERT INTO
INSERT INTO Genre VALUES(1000, 'Baroque');
INSERT INTO Genre VALUES(1001, 'Spoken Word');

INSERT INTO Employee VALUES('1000', 'Applebaum', 'Levi', 'Custodian',
    'Matt', TO_DATE('02-27-1996', 'MM-DD-YYYY'), TO_DATE('07-15-2019', 'MM-DD-YYYY'), 
    '2115 W Cuyler Ave', 'Chicago', 'Illinois', 'USA', '60618', '773-580-LEVI', 'N/A', 
    'novocaine212@gmail.com');
INSERT INTO Employee VALUES('1001', 'Christ', 'Jesus', 'Carpenter',
    'GOD', TO_DATE('00-00-0000', 'MM-DD-YYYY'), TO_DATE('00-01-0000', 'MM-DD-YYYY'), 
    '213 0th St', 'Bethlehem', 'Galilee', 'Rome', '66666', '555-555-5555', 'dude_on@a.horse', 
    'carrier@pidgeon.ankle');
    
INSERT INTO Customer VALUE('1000', 'Bertson', 'Ernie', 'Ducks_n_such',
    '234 N Sesame St', 'New York', 'New York', 'USA', '31215',
    '555-555-5556', '555-555-5557', 'ernie_bertson@aol.com', 999);
INSERT INTO Customer VALUE('1000', 'Ernieson', 'Bert', 'Unibrow_LLC',
    '234 N Sesame St', 'New York', 'New York', 'USA', '31215',
    '555-555-5558', '555-555-5559', 'bert_ernieson@aol.com', 000);

--2.4 UPDATE
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter'
    WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM Invoices WHERE BillingAddress LIKE t%;

--2.6 BETWEEN
SELECT * FROM Invoices WHERE Total BETWEEN 15 AND 50;
SELECT * FROM Employee WHERE HireDate 
    BETWEEN TO_DATE('06-01-2003', 'MM-DD-YYYY')
    AND TO_DATE(03/03/2004, 'MM-DD-YYYY');

--2.7
DELETE from Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';

--3.0 SQL Functions

--3.1  System Defined Functions
ALTER SESSION SET nls_date_format = 'HH24:MM:SS';

CREATE OR REPLACE FUNCTION RetTime
    RETURN TIMESTAMP
    AS CurrentTime_1 TIMESTAMP;
    BEGIN
        SELECT SYSDATE
        INTO CurrentTime_1
        FROM Dual;
        RETURN CURRENT_TIMESTAMP;
    END;
/
SELECT RetTime FROM Dual;

CREATE OR REPLACE FUNCTION RetLength(MNum IN NUMBER)
    RETURN NUMBER
    AS ChosenNumber NUMBER(10, 2);
    BEGIN
        SELECT LENGTH(Name)
        INTO ChosenNumber
        FROM MediaType
        WHERE MediaTypeID = MNum;
        RETURN ChosenNumber;
    END;
/
SELECT RetLength(1) FROM Dual;
SELECT RetLength(2) FROM Dual;
SELECT RetLength(3) FROM Dual;
SELECT RetLength(4) FROM Dual;
SELECT RetLength(5) FROM Dual;

--3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION GetAvgInvTotal
    RETURN NUMBER
    AS ChosenNumber NUMBER(10, 2);
    BEGIN
        SELECT AVG(Total)
        INTO ChosenNumber
        FROM Invoice;
        RETURN ChosenNumber;
    END;
/
SELECT GetAvgInvTotal FROM Dual;

CREATE OR REPLACE FUNCTION RetMost$
    RETURN NUMBER
    AS retMostMoney NUMBER(10, 2);
    BEGIN
        SELECT MAX(UnitPrice)
        INTO retMostMoney
        FROM Track;
        RETURN retMostMoney;
    END;
/
SELECT RetMost$ FROM Dual;

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION RetAvgPriceInv
    RETURN NUMBER
    AS retAvgMoney NUMBER(10, 2);
    BEGIN
        SELECT AVG(UnitPrice)
        INTO retAvgMoney
        FROM InvoiceLine;
        RETURN retAvgMoney;
    END;
/
SELECT RetAvgPriceInv FROM Dual;

--3.4 User Defined Lable Valued Functions
/*CREATE OR REPLACE FUNCTION RetYoungPeople
    AS c1 SYS_REFCURSOR;
    BEGIN
        OPEN c1 FOR
        SELECT EmployeeId
        FROM Employee
        WHERE BirthDate > TO_DATE('12-31-1968', 'MM-DD-YYYY');
        DBMS_SQL.RETURN_RESULT(c1);
    END;
/
SELECT RetYoungPeople FROM Dual;*/

SELECT EmployeeId, FirstName, LastName, TO_DATE(BirthDate) FROM Employee
        WHERE BirthDate > TO_DATE('12-31-1968', 'MM-DD-YYYY');

--4.0 Stored Procedures

--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE GetFLNamesFromCusts
    AS c1 SYS_REFCURSOR;
    BEGIN
        OPEN c1 FOR
        SELECT FirstName, LastName FROM Employee;
        DBMS_SQL.RETURN_RESULT(c1);
    END;
/
EXECUTE GetFLNamesFromCusts;

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE UpdateEmployeeEmailPhone
(EmFirstName IN VARCHAR2, EmLastName IN VARCHAR2, 
NewPhone IN VARCHAR2, NewEmail IN VARCHAR2)
    AS
    BEGIN
        UPDATE Employee SET Email = NewEmail, Phone = NewPhone
        WHERE FirstName = EmFirstName AND LastName = EmLastName;
    END;
/
EXECUTE UpdateEmployeeEmailPhone('Jane', 'Peacock', 'test', 'test2');

CREATE OR REPLACE PROCEDURE FindManagerOfEmployee
(EmFirstName IN VARCHAR2, EmLastName IN VARCHAR2)
    AS c1 SYS_REFCURSOR;
    BEGIN
        OPEN c1 FOR
        SELECT FirstName, LastName FROM Employee WHERE EmployeeId = 
        (SELECT ReportsTo FROM Employee 
        WHERE FirstName = EmFirstName AND LastName = EmLastName);
        DBMS_SQL.RETURN_RESULT(c1);
    END;
/
EXECUTE FindManagerOfEmployee('Jane', 'Peacock');

--4.3 Stored Procedure Output Parameters
/*CREATE OR REPLACE PROCEDURE GetCompany
(FName Varchar2, LName VARCHAR2)
    RETURN VARCHAR2 AS
    CompName VARCHAR2;
    BEGIN
        SELECT Company INTO CompName FROM Customer
        WHERE FirstName = FName AND LastName = LName;
        RETURN CompName;
    END;
/
EXECUTE GetCompany('Tim', 'Goyer');*/

SELECT Company FROM Customer
    WHERE FirstName = 'Tim' AND LastName = 'Goyer';
--5.0 Transactions

CREATE OR REPLACE PROCEDURE DeleteFromInv
(InvId IN NUMBER)
    AS BEGIN
        DELETE FROM InvoiceLine WHERE InvoiceId = InvId;
        DELETE FROM Invoice WHERE InvoiceId = InvId;
    END;
/
EXECUTE DeleteFromInv('4');

CREATE OR REPLACE PROCEDURE InsertIntoCust
(CustId IN NUMBER, CustFirstName IN VARCHAR2, 
CustLastName IN VARCHAR2, CustEmail IN VARCHAR2)
    AS BEGIN
        INSERT INTO Customer(CustomerId, FirstName, LastName, Email)
            VALUES(CustId, CustFirstName, CustLastName, CustEmail);
    END;
/
EXECUTE InsertIntoCust(1009, 'Neil', 'Armstrong', 'apollo@eleven.com');


--6.0 Triggers

--6.1 AFTER/FOR
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER EmpBeforeInsertTrig
    BEFORE INSERT ON Employee
    BEGIN
        DBMS_OUTPUT.PUT_LINE('6.1.1 Trigger Test');
    END;
/

INSERT INTO Employee(EmployeeId, FirstName, LastName) 
    VALUES('1005', 'Alan', 'Turing');
    
CREATE OR REPLACE TRIGGER AlbumAfterInsertTrig
    AFTER INSERT ON Album
    BEGIN
        DBMS_OUTPUT.PUT_LINE('6.1.2 Trigger Test');
    END;
/
INSERT INTO Album VALUES('1001', 'Lakeshore Drive', 2);

CREATE OR REPLACE TRIGGER CustAfterDeleteTrig
    AFTER INSERT ON Customer
    BEGIN
        DBMS_OUTPUT.PUT_LINE('6.1.3 Trigger Test');
    END;
/
INSERT INTO Customer(CustomerId, FirstName, LastName, Email)
    VALUES('1007', 'Bill', 'Hader', 'officer_slater@superbad.com');
DELETE FROM Customer WHERE FirstName = 'Bill' AND LastName = 'Hader';


--7.0 JOINS

--7.1 INNER
SELECT Customer.FirstName, Customer.LastName, Invoice.InvoiceId
    FROM Invoice INNER JOIN Customer ON
    Customer.CustomerId = Invoice.CustomerId;

--7.2 OUTER
SELECT Invoice.CustomerId, Customer.FirstName, Customer.LastName, 
        Invoice.InvoiceId, Invoice.Total FROM Invoice 
        FULL OUTER JOIN CUSTOMER
        ON Customer.CustomerId = Invoice.CustomerId;

SELECT Customer.FirstName FROM (Invoice.CustomerId, Invoice.InvoiceId FROM Invoice LEFT JOIN Customer ON 
    Customer.CustomerId = Invoice.CustomerId;

SELECT  FROM School LEFT JOIN Student
    ON School.Sch_ID = Student.Sch_ID;

--7.3 RIGHT
SELECT Artist.Name, Album.Title FROM Artist RIGHT JOIN Album
    ON Artist.ArtistId = Album.ArtistId;

--7.4 CROSS
SELECT Artist.Name, Album.Title FROM Artist CROSS JOIN Album
    WHERE Album.ArtistId = Artist.ArtistId
    ORDER BY Artist.Name ASC;

--7.5 SELF
SELECT A.FirstName AS Employee_First, A.LastName AS Employee_Last, 
B.FirstName AS Boss_First, B.LastName AS Boss_Last 
FROM Employee A JOIN Employee B
ON A.ReportsTo = B.EmployeeId;
