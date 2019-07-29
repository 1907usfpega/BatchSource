--Scalar
SELECT UPPER(Name) FROM artist;
-- Aggregate
SELECT AVG(unitprice) FROM track;
--Queries
/* SELECT-keyword columnlist
    FROM-keyword tablelist
    WHERE condition1 AND condition2
    GROUP BY columnlist
    HAVING condition
*/
--Complete Query
SELECT COUNT(employeeid),country, city
    FROM employee
    GROUP BY country,city
    HAVING COUNT(employeeid)>1;
    
--inner and outter queries:
SELECT S_ID,S_NAME
    FROM StudentDetails
    WHERE S_NAME IN (
    SELECT S_NAME FROM StudentDetails
    WHERE S_MAJOR = 'History');
    
-- Joins
/* Equi vs Theta
InnerJoin 
*/
CREATE TABLE student(
s_id NUMBER,
s_name VARCHAR2 (20),
sch_id NUMBER);
CREATE TABLE school(
sch_id NUMBER,
sch_name VARCHAR2(20));


INSERT INTO school VALUES(1, 'USF');
INSERT INTO school VALUES(2, 'FSU');
INSERT INTO school VALUES(3, 'ABC');
INSERT INTO school VALUES(4, 'UA');
INSERT INTO school VALUES(5, 'LSU');
INSERT INTO school VALUES(6, 'Loser');
INSERT INTO student VALUES(1,'MATT', 3);
INSERT INTO student VALUES(2,'LEO', 2);
INSERT INTO student VALUES(3,'MAT', 4);
INSERT INTO student VALUES(4,'MALDY', 3);
INSERT INTO student VALUES(5,'BEN', 5);
INSERT INTO student VALUES(6,'HANN', 1);
INSERT INTO student VALUES(7,'KENN', 4);
INSERT INTO student VALUES(8,'JACKSON', 1);
INSERT INTO student VALUES(9,'JASON', 5);
INSERT INTO student VALUES(0,'ANDREW', 1);

SELECT * FROM school
LEFT JOIN student 
ON school.sch_id = student.sch_id;


CREATE TABLE student2(
id NUMBER, 
name VARCHAR2(20),
lab_partner NUMBER);


INSERT INTO student2 VALUES(1,'LEO',6);
INSERT INTO student2 VALUES(2,'REN',3);
INSERT INTO student2 VALUES(3,'TERRY',2);
INSERT INTO student2 VALUES(4,'BEN',5);
INSERT INTO student2 VALUES(5,'KENN',4);
INSERT INTO student2 VALUES(6,'DAYANA',1);

SELECT a.NAME as student, b.name as LAB_Partner FROM student2
A JOIN student2 b
on a.lab_partner = b.id;
SELECT * from student2;
---union, intersect, minus


SELECT * FROM employee JOIN customer 
    on employee.firstname = customer.firstname; 





Select * FROM artist, track 
    WHERE artist.name = track.name;
    


--------
--TCL
/* Commit, Rollback, Savepoint

--ACID
    Atomicity
        Smalles logical uni that can be ran
        Alloperations execute successfully or rollback
        bad automicity = loss of referential integrity
    Consistency
        Database is in a valid state  to existing structure & constraints after every commit
    Isolation
        Concurrent Transactions don't effect one another
        
    Durability
        Shoot it = have a backup!
        commits are final and cannot be rolled back
Transactional Phenomenon
    issues orrucing in concurrent transactions
    DIRTY READ - returns something from an uncommitted column/table 
        Bad databases allow it
    NON-REPEATABLE-READS - row is edited after view
    PHANTOM READ - Row is inserted after read
Isolationlevels:


Isolation Levels
Dirty Read
Non-Repeatable Read
Phantom Read
Read-uncommitted
Yes
Yes
Yes
Read-committed (Oracle Default)
No
Yes
Yes
Repeatable Read
No
No
Yes
Serializable
No
No
No



PL/SQL (Procedural Language)
    
*/
--SEQUENCE
CREATE SEQUENCE mytestseq
MINVALUE 100
MAXVALUE 10000
START WITH 5000
INCREMENT BY -5
CACHE 20;

SELECT mytestseq.NEXTVAL FROM DUAL;
INSERT INTO school VALUES (mytestseq.NEXTVAL, 'Harvard');


/*
CREATE SEQUENCE [Seq name]
MINVALUE[value]
MAXVALUE[value]
START WITH [value]
INCREMENT BY [value]
CACHE [value];
*/
--VIEW
CREATE OR REPLACE VIEW my_view
AS 
SELECT TITLE AS a_list_of_stuff FROM album
UNION 
SELECT name FROM artist;

SELECT * FROM my_view
WHERE a_list_of_stuff LIKE 'T%' OR a_list_of_stuff LIKE 'B%';


CREATE INDEX myindex
ON album(artistid);

--tRIGGEREDDDDD Trigger
CREATE OR REPLACE TRIGGER MYTRIG
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
    SELECT mytestseq.NEXTVAL INTO: NEW.s_id FROM DUAL;
END;
/

INSERT INTO student VALUES(9298, 'DEONTA', 5);
INSERT INTO student (s_name,sch_id) VALUES ('KENNY G', 1);
INSERT INTO student (s_name,sch_id) VALUES ('Danny McBride', 3);

ALTER TABLE student 
ADD CONSTRAINT pk_id 
PRIMARY KEY (s_id);





---user defined function 
CREATE OR REPLACE FUNCTION calc_tax
(t_id IN NUMBER, tax IN NUMBER, testdog IN NUMBER:=9)
RETURN NUMBER AS
total_price NUMBER (10,2);
BEGIN
SELECT unitprice INTO total_price
FROM track
WHERE trackid = t_id;
RETURN total_price + (total_price*tax);
END;
/
--User function
SELECT calc_tax(569, .08) FROM track;




-------------Stored Procedures
/*DML yes, DDL no. Transactions are ok. 
*/

CREATE OR REPLACE PROCEDURE mystopro
(NAME IN VARCHAR2)
AS
BEGIN
INSERT INTO school VALUES(mytestseq.NEXTVAL, NAME);
COMMIT;
END;
/

EXECUTE mystopro('MIT');

--More complex structure
CREATE TABLE bear(
bear_id NUMBER PRIMARY KEY,
bear_type NUMBER,
bear_name VARCHAR2(100),
bear_birthdate DATE,
bear_weight NUMBER DEFAULT 200,
cave_id NUMBER);

CREATE TABLE bear_type(
bear_type_id NUMBER PRIMARY KEY,
bear_type_name VARCHAR2(100));

CREATE TABLE cave(
cave_id NUMBER PRIMARY KEY,
CAVE_NAME VARCHAR2(100),
max_bears NUMBER DEFAULT 4);

CREATE TABLE beehive(
beehive_id NUMBER PRIMARY KEY,
beehive_weight NUMBER DEFAULT 50);

CREATE TABLE bear_beehive(
bear_id NUMBER,
beehive_id NUMBER,
PRIMARY KEY(bear_id, beehive_id));

ALTER TABLE bear
RENAME COLUMN bear_type TO bear_type_id;
------ConstraintAdding:
ALTER TABLE bear
ADD CONSTRAINT fk_bear_bear_type
FOREIGN KEY(bear_type_id) REFERENCES bear_type(bear_type_id);

ALTER TABLE bear 
ADD CONSTRAINT fk_bear_cave
FOREIGN KEY (cave_id) REFERENCES CAVE(CAVE_ID);

ALTER TABLE bear_beehive
ADD CONSTRAINT fk_bear_beehive_beehive
FOREIGN KEY (beehive_id) REFERENCES beehive(beehive_id);

ALTER TABLE bear_beehive
ADD CONSTRAINT fk_bear_beehive_bear
FOREIGN KEY (bear_id) REFERENCES bear(bear_id);

ALTER TABLE bear
ADD CONSTRAINT ck_bear_weight_positive
CHECK (bear_weight>0);

ALTER TABLE beehive
ADD CONSTRAINT ck_beehive_weight_positive
CHECK(beehive_weight>0);

ALTER TABLE cave
ADD CONSTRAINT uq_cave_name
UNIQUE(cave_name);

ALTER TABLE bear_type
ADD CONSTRAINT uq_type_name
UNIQUE(bear_type_name);

CREATE OR REPLACE PROCEDURE bearpro
(cave_name IN VARCHAR2, bear_name IN VARCHAR2,
bear_birthdate IN DATE)
AS 
BEGIN
INSERT INTO cave VALUES(mytestseq.NEXTVAL,cave_name, 9);
INSERT INTO beehive VALUES(mytestseq.NEXTVAL, 50);
INSERT INTO bear_type VALUES(2, 'BROWN');
INSERT INTO bear VALUES(mytestseq.NEXTVAL, 2, bear_name, bear_birthdate, 2000, (mytestseq.CURRVAL +10));
commit;
END;
/
EXECUTE bearpro('mattssd cave', 'Masdtt Bonds', DATE '2013-3-26');




-------------------
--Cursors
--Procedure with a Cursor as an out parameter:
CREATE OR REPLACE PROCEDURE get_all_albums
(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR 
SELECT albumid, title 
FROM album;
END;
/
--function outside of function:
SET SERVEROUT ON;

DECLARE S SYS_REFCURSOR;
album_id album.albumid%TYPE; --sets album_id to whatever datatype the albumid is. Same as writing album_id VARCHAR2
albumname album.title%TYPE;
BEGIN
    get_all_albums(S);
    LOOP
    FETCH S into album_id, albumname;
    EXIT WHEN S%NOTFOUND; --break out of loop when no more rows available
    DBMS_OUTPUT.PUT_LINE(album_id||'is current id' || albumname || ' is current name');
    END LOOP;
    CLOSE S;
END;
/

