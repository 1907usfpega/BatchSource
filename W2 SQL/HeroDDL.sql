CREATE TABLE SUPERHERO
(HEROID NUMBER PRIMARY KEY,
HERONAME VARCHAR2(30));

CREATE TABLE POWER (
POWERID NUMBER PRIMARY KEY,
POWERNAME VARCHAR2(30));

CREATE SEQUENCE USERSEQ;

CREATE OR REPLACE PROCEDURE INSERTSUPERHERO(NAME IN VARCHAR2)
AS
BEGIN
INSERT INTO SUPERHERO VALUES(HEROSEQ.NEXTVAL, NAME);
COMMIT;
END;
/


SELECT * FROM BANKACCOUNT;
DESC BANKACCOUNT;

CREATE OR REPLACE PROCEDURE INSERTSUPERHEROPOWER(HERONAME IN VARCHAR2, HEROPOWER IN VARCHAR2)
AS 
BEGIN 
INSERT INTO POWERS VALUES(POWSED.nextval,HEROPOWER);
INSERT INTO SUPERHERO VALUES(HEROSEQ.NEXTVAL,HERONAME, POWSED.currval);
COMMIT;
END;
/
--ALTER TABLE Persons
--ADD PRIMARY KEY (ID);

ALTER TABLE SUPERHERO
ADD FOREIGN KEY (POWERID) REFERENCES POWERS(POWERID);

ALTER TABLE SUPERHERO
ADD
POWERID NUMBER;

SELECT * FROM BANKACCOUNT;

CREATE TABLE BankAccount(userName VARCHAR2(30), userPass VARCHAR2(30), userID INT NOT NULL, PRIMARY KEY(userID));
SELECT * FROM BANKACCOUNT;

