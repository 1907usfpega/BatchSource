-- Database Creation Script --

CREATE TABLE customer(
userid NUMBER PRIMARY KEY,
username VARCHAR2(20) UNIQUE,
PASSWORD VARCHAR2(20),
firstname VARCHAR2(20),
lastname VARCHAR2(20)
);

CREATE TABLE bankaccount(
accountid NUMBER PRIMARY KEY,
accountname VARCHAR2(20),
accounttype VARCHAR2(20),
balance NUMBER DEFAULT 0
);

CREATE TABLE customer_bankaccount(
uaid NUMBER PRIMARY KEY,
userid NUMBER,
accountid NUMBER
);

ALTER TABLE customer MODIFY (username NOT NULL);
ALTER TABLE customer MODIFY (password NOT NULL);
ALTER TABLE customer MODIFY (firstname NOT NULL);
ALTER TABLE customer MODIFY (lastname NOT NULL);

ALTER TABLE bankaccount MODIFY (accountname NOT NULL);
ALTER TABLE bankaccount MODIFY (accounttype NOT NULL);
ALTER TABLE bankaccount MODIFY (balance NOT NULL);

ALTER TABLE customer_bankaccount ADD CONSTRAINT fk_cust_bankacc_userid
    FOREIGN KEY (userid) REFERENCES customer(userid) ON DELETE CASCADE;
ALTER TABLE customer_bankaccount ADD CONSTRAINT fk_cust_bankacc_accid
    FOREIGN KEY (accountid) REFERENCES bankaccount(accountid) ON DELETE CASCADE;
ALTER TABLE customer_bankaccount MODIFY(accountid NOT NULL);
ALTER TABLE customer_bankaccount MODIFY (userid NOT NULL);

CREATE SEQUENCE userseq
MINVALUE 100
MAXVALUE 10000
START WITH 5000
INCREMENT BY 5
CACHE 20;

CREATE SEQUENCE accseq
MINVALUE 100
MAXVALUE 10000
START WITH 201
INCREMENT BY 5
CACHE 20;

CREATE SEQUENCE uaseq
MINVALUE 100
MAXVALUE 10000
START WITH 302
INCREMENT BY 5
CACHE 20;

CREATE OR REPLACE PROCEDURE add_account
(account_name IN VARCHAR2, user_id IN VARCHAR2, account_type IN VARCHAR2)
AS
BEGIN
INSERT INTO bankaccount VALUES (accseq.NEXTVAL, account_name, account_type,0);
INSERT INTO customer_bankaccount (uaid, accountid, userid) VALUES(uaseq.NEXTVAL, accseq.CURRVAL, user_id);
COMMIT;
END;
/