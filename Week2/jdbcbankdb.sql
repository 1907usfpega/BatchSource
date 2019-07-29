--To create a new user
--and grant that user permissions
/*
CREATE USER jdbcbankdb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO  jdbcbankdb;
GRANT DBA TO jdbcbankdb WITH ADMIN OPTION;
*/
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
--PK triggers were created to utilize the sequences

CREATE OR REPLACE PROCEDURE insertuser(firstnam VARCHAR2, lastnam VARCHAR2)
IS
BEGIN
    INSERT INTO bankuser(firstname,lastname) VALUES(firstnam,lastnam);
END insertuser;
