--To create a new user
--and grant that user permissions

/*CREATE USER jdbcbankdb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO  jdbcbankdb;
GRANT DBA TO jdbcbankdb WITH ADMIN OPTION;*/

--Create the tables

CREATE TABLE bankuser
(
    userid NUMBER PRIMARY KEY,
    firstname VARCHAR2(50) NOT NULL,
    lastname VARCHAR2(50) NOT NULL
);

CREATE TABLE account
(
    accountid NUMBER PRIMARY KEY,
    balance NUMBER(*,2),
    loginid NUMBER NOT NULL,
    userid NUMBER NOT NULL
);

CREATE TABLE login
(
    loginid NUMBER PRIMARY KEY,
    username VARCHAR2(50) NOT NULL UNIQUE,
    password VARCHAR2(50) NOT NULL,
    userid NUMBER,
    adminid NUMBER
);

CREATE TABLE admin
(
    adminid NUMBER PRIMARY KEY,
    firstname VARCHAR2(50) NOT NULL,
    lastname VARCHAR2(50) NOT NULL
);


--Add constraints to table
ALTER TABLE account ADD CONSTRAINT fk_accountloginid
    FOREIGN KEY (loginid) REFERENCES login (loginid)
    ON DELETE CASCADE;

ALTER TABLE account ADD CONSTRAINT fk_accountuserid
    FOREIGN KEY (userid) REFERENCES bankuser (userid)
    ON DELETE CASCADE;

ALTER TABLE account
ADD CHECK(balance >= 0);

ALTER TABLE account
MODIFY balance DEFAULT 0;

ALTER TABLE login ADD CONSTRAINT fk_loginadminid
    FOREIGN KEY (adminid) REFERENCES admin (adminid)
    ON DELETE CASCADE;
    
ALTER TABLE login ADD CONSTRAINT fk_loginuserid
    FOREIGN KEY (userid) REFERENCES bankuser (userid)
    ON DELETE CASCADE;
    
--creating sequences
CREATE SEQUENCE useridseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE accountidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE loginidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE adminidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1;
--PK triggers created to utilize the sequences
create or replace trigger accountidtrigger  
   before insert on "JDBCBANKDB"."ACCOUNT" 
   for each row 
begin  
   if inserting then 
      if :NEW."ACCOUNTID" is null then 
         select ACCOUNTIDSEQ.nextval into :NEW."ACCOUNTID" from dual; 
      end if; 
   end if; 
end;
/

create or replace trigger adminidtrigger  
   before insert on "JDBCBANKDB"."ADMIN" 
   for each row 
begin  
   if inserting then 
      if :NEW."ADMINID" is null then 
         select ADMINIDSEQ.nextval into :NEW."ADMINID" from dual; 
      end if; 
   end if; 
end;
/

create or replace trigger useridtrigger  
   before insert on "JDBCBANKDB"."BANKUSER" 
   for each row 
begin  
   if inserting then 
      if :NEW."USERID" is null then 
         select USERIDSEQ.nextval into :NEW."USERID" from dual; 
      end if; 
   end if; 
end;
/

create or replace trigger loginidtrigger  
   before insert on "JDBCBANKDB"."LOGIN" 
   for each row 
begin  
   if inserting then 
      if :NEW."LOGINID" is null then 
         select LOGINIDSEQ.nextval into :NEW."LOGINID" from dual; 
      end if; 
   end if; 
end;
/

CREATE OR REPLACE PROCEDURE insertuser(firstnam VARCHAR2, lastnam VARCHAR2)
IS
BEGIN
    INSERT INTO bankuser(firstname,lastname) VALUES(firstnam,lastnam);
END insertuser;
/

CREATE OR REPLACE PROCEDURE insertlogin(usernam VARCHAR2, passwor VARCHAR2, useri NUMBER, admini NUMBER)
IS
same_username VARCHAR2(50);
username_exception EXCEPTION;
BEGIN
    INSERT INTO login(username,password,userid,adminid) VALUES(usernam,passwor,useri,admini);
END insertlogin;
/

CREATE OR REPLACE PROCEDURE insertaccount(logini NUMBER, useri NUMBER)
IS
BEGIN
    INSERT INTO account(loginid,userid) VALUES(logini,useri);
END insertaccount;
/

CREATE OR REPLACE PROCEDURE deleteuser(useri NUMBER)
IS
BEGIN
    DELETE FROM bankuser WHERE userid = useri;
END deleteuser;
/

CREATE OR REPLACE PROCEDURE deleteaccount(accounti NUMBER)
IS
BEGIN
    DELETE FROM account WHERE accountid = accounti;
END deleteaccount;
/

CREATE OR REPLACE PROCEDURE updateuser(useri NUMBER, firstnam VARCHAR2, lastnam VARCHAR2)
IS
BEGIN
    UPDATE bankuser SET firstname = firstnam, lastname = lastnam WHERE userid = useri;
END updateuser;
/

CREATE OR REPLACE PROCEDURE updateaccount(accounti NUMBER, amount NUMBER)
IS
    curr_balance NUMBER(38,2);
    new_balance NUMBER(38,2);
    overdraft EXCEPTION;
BEGIN
    SELECT balance INTO curr_balance FROM account WHERE accountid = accounti;
    new_balance := curr_balance - amount;
    
    IF new_balance < 0
    THEN RAISE overdraft;
    END IF;
    
    UPDATE account SET balance = new_balance WHERE accountid = accounti;
    
    EXCEPTION
        WHEN overdraft
        THEN DBMS_OUTPUT.PUT_LINE('We don''t allow overdrafts');
END updateaccount; 
/

INSERT INTO admin(firstname, lastname) VALUES('Deonta' , 'Kilpatrick');
INSERT INTO login(username,password,adminid) VALUES('DeontaK','kilpatrick', 1);