SELECT UPPER(Name) FROM Artist;
--AGGREGATE
SELECT AVG(UnitPrice) FROM Track;

SELECT COUNT(EmployeeID), Country, City
FROM Employee GROUP BY Country, City
HAVING COUNT(EmployeeID) > 1;


--DROP TABLE Stuwnt;
--DROP TABLE School;
CREATE TABLE Student(
    S_ID NUMBER,
    S_Name VARCHAR2(20),
    Sch_ID NUMBER
);
CREATE TABLE School(
    Sch_ID NUMBER,
    Sch_Name VARCHAR2(20)
);

INSERT INTO School VALUES(1, 'USF');
INSERT INTO School VALUES(2, 'FSU');
INSERT INTO School VALUES(3, 'UA');
INSERT INTO School VALUES(4, 'UGA');
INSERT INTO School VALUES(5, 'LSU');


INSERT INTO Student VALUES(1, 'Matt', 3);
INSERT INTO Student VALUES(2, 'Ben', 5);
INSERT INTO Student VALUES(3, 'Hann', 1);
INSERT INTO Student VALUES(4, 'Ken', 5);
INSERT INTO Student VALUES(5, 'Jackson', 4);
INSERT INTO Student VALUES(6, 'John', 3);
INSERT INTO Student VALUES(7, 'Levi', 1);
INSERT INTO Student VALUES(8, 'Andrew', 3);
INSERT INTO Student VALUES(9, 'Brad', 2);
INSERT INTO Student VALUES(10, 'Rine', 5);

SELECT * FROM School LEFT JOIN Student
    ON School.Sch_ID = Student.Sch_ID;
SELECT * FROM School RIGHT JOIN Student
    ON School.Sch_ID = Student.Sch_ID;
    
CREATE TABLE Student2(
    ID NUMBER,
    Name VARCHAR2(20),
    LabPartner NUMBER
);
INSERT INTO Student2 VALUES(1, 'Matt', 6);
INSERT INTO Student2 VALUES(2, 'Ben', 5);
INSERT INTO Student2 VALUES(3, 'Rine', 4);
INSERT INTO Student2 VALUES(4, 'Hann', 3);
INSERT INTO Student2 VALUES(5, 'Ken', 2);
INSERT INTO Student2 VALUES(6, 'Levi', 1);

SELECT A.Name AS Student, B.Name AS LabPartner
FROM Student2 A JOIN Student2 B
ON A.LabPartner = B.ID;

SELECT Title FROM Album, Artist WHERE Album.Title = Artist.Name
INTERSECT
SELECT Name FROM Artist, Album WHERE Album.Title = Artist.Name;

SELECT Title FROM Album, Artist WHERE Album.Title = Artist.Name;

SELECT Name FROM Artist, Album WHERE Album.Title = Artist.Name;



--Day 4444444444444444444
CREATE SEQUENCE MyTestSeq
MINVALUE 100
MAXVALUE 10000
START WITH 5000
INCREMENT BY -5
CACHE 20;
SELECT MyTestSeq.NEXTVAL FROM DUAL;

INSERT INTO School VALUES(MyTestSeq.NEXTVAL, 'Harvard');

CREATE OR REPLACE VIEW MyView
AS
    SELECT Title AS A_List_Of_Stuff FROM Album
    UNION
    SELECT Name FROM Artist;

SELECT * FROM MyView;

CREATE INDEX MyIndex
ON Album(Artist.ID);

CREATE OR REPLACE TRIGGER MyTrig
BEFORE INSERT ON Student
FOR EACH ROW
BEGIN
    SELECT MyTestSeq.NEXTVAL INTO: NEW.S_ID FROM Dual;
END;
/
INSERT INTO Student VALUES(67, 'Deonta', 5);

CREATE OR REPLACE FUNCTION CalcTax
    (TID IN NUMBER, Tax IN  NUMBER)
    RETURN NUMBER AS
    TotalPrice NUMBER(10, 2);
    BEGIN
        SELECT UnitPrice INTO TotalPrice
        FROM Track
        WHERE TrackID = TID;
        RETURN TotalPrice + (TotalPrice * Tax);
    END;
/
SELECT CalcTax(500, 0.1) FROM Dual;

CREATE OR REPLACE PROCEDURE MyStoPro
    (Name IN VARCHAR2)
    AS
    BEGIN
        INSERT INTO School VALUES(MyTestSeq.NEXTVAL, Name);
        COMMIT;
    END;
/
EXECUTE MyStoPro('MIT');

CREATE TABLE Bear(
    Bear_ID NUMBER PRIMARY KEY,
    BearTypeId NUMBER,
    BearName VARCHAR(100),
    BearBirthDate DATE,
    BearWeight NUMBER DEFAULT 200,
    CaveID NUMBER
);
CREATE TABLE BearType(
    BearTypeId NUMBER PRIMARY KEY,
    BearTypeName VARCHAR2(100)
);
CREATE TABLE Cave(
    CaveId NUMBER PRIMARY KEY,
    CaveName VARCHAR2(100),
    MaxBears NUMBER DEFAULT 4
);
CREATE TABLE Beehive(
    BeehiveId NUMBER PRIMARY KEY,
    BeehiveWeight NUMBER DEFAULT 50
);
CREATE TABLE BearBeehive(
    BearId NUMBER,
    BeehiveId NUMBER,
    PRIMARY KEY (BearId, BeehiveId)
);

ALTER TABLE Bear
ADD CONSTRAINT FK_Bear_BearType
FOREIGN KEY(Bear, BearId) REFERENCES BearType(BearTypeId);

ALTER TABLE Bear
ADD CONSTRAINT CK_Bear_Weight_Positive
CHECK(BearWeight > 0);

ALTER TABLE Beehive
ADD CONSTRAINT CK_Beehive_Weight_Positive
CHECK(BeehiveWeight > 0);

ALTER TABLE BearCave
ADD CONSTRAINT CK_CaveName
UNIQUE(CaveName);

CREATE OR REPLACE PROCEDURE BearPro
(CaveName IN VARCHAR2, BearName IN VARCHAR2,
BearBirthDate IN DATE)
    AS
    BEGIN
        INSERT INTO Cave VALUES(1, CaveName, 4);
        INSERT INTO Beehive VALUES(MyTestSeq.NEXTVAL, 50);
        INSERT INTO BearType VALUES(1, 'Black');
        INSERT INTO Bear VALUES(MyTestSeq.NEXTVAL, 1, 
            BearName, BearBirthDate, 2000, 1);
        COMMIT;
    END;
/
EXECUTE BearPro('MattsCave', 'MattBonds', DATE '2013-06-26');

CREATE OR REPLACE PROCEDURE GetAllAlbums
(S OUT SYS_REFCURSOR)
IS
    BEGIN
        OPEN S FOR 
        SELECT AlbumId, Title FROM Album;
    END;
/
SET SERVEROUT ON;

DECLARE S SYS_REFCURSOR;
Album_Id Album.AlbumId%TYPE;--Set album_Id to whaterever datatype albumid is
AlbumName Album.Title%TYPE;
    BEGIN
        GetAllAlbums(S);
        LOOP
            FETCH S INTO Album_Id, AlbumName;
            EXIT WHEN S%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(Album_Id||' IS CURRENT ID, '||
                AlbumName||' IS CURRENT NAME'); 
        END LOOP;
        CLOSE S;
    END;
/
