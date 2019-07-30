CREATE TABLE bankuser1(
    userid NUMBER PRIMARY KEY,
    username VARCHAR2(20) UNIQUE,
    firstname VARCHAR2(20),
    lastname VARCHAR2(20),
    userpass VARCHAR2(20),
    admincode NUMBER DEFAULT 0,
    emplocode NUMBER DEFAULT 0
);

CREATE TABLE bankaccount(
	accountid NUMBER PRIMARY KEY,
    accounttype VARCHAR2(20),
	accountname VARCHAR2(20) UNIQUE,
	balance NUMBER,
    userid NUMBER
);

ALTER TABLE bankaccount ADD FOREIGN KEY (userid) REFERENCES bankuser(userid);

CREATE SEQUENCE useridincrement;
CREATE SEQUENCE acctidincrement;

CREATE OR REPLACE TRIGGER useridmaker
BEFORE INSERT ON bankuser
FOR EACH ROW
BEGIN
    SELECT useridincrement.NEXTVAL INTO: NEW.userid FROM dual;
END;

CREATE OR REPLACE TRIGGER acctidmaker
BEFORE INSERT ON bankaccount
FOR EACH ROW
BEGIN
    SELECT acctidincrement.NEXTVAL INTO: NEW.accountid FROM dual;
END;

CREATE OR REPLACE PROCEDURE insertuser(uname IN VARCHAR2, fname IN VARCHAR2, lname IN VARCHAR2, pass IN VARCHAR2, adm IN NUMBER, emp IN NUMBER)
AS BEGIN
INSERT INTO bankuser(username, firstname, lastname, userpass, admincode, emplocode) VALUES (uname,fname,lname,pass,adm,emp);
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE removeuser(uname IN VARCHAR2)
AS BEGIN
DELETE FROM bankuser WHERE username=uname;
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE updateuser
(newfname IN VARCHAR2, newlname IN VARCHAR2, newpass IN VARCHAR2, acctuser IN VARCHAR2)
AS
BEGIN 
UPDATE bankuser SET firstname = newfname,lastname = newlname, userpass=newpass WHERE username=acctuser;
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insertacct(accttype IN VARCHAR2, acctname IN VARCHAR2, uid IN NUMBER)
AS BEGIN
INSERT INTO bankaccount(accounttype, accountname, balance, userid) VALUES (accttype,acctname,0,uid);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE removeacct(aid IN NUMBER)
AS BEGIN
DELETE FROM bankaccount WHERE accountid=aid;
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE updateacct(aid IN NUMBER, bal IN NUMBER)
AS BEGIN
UPDATE bankaccount SET balance=bal WHERE accountid=aid;
COMMIT;
END;
/



