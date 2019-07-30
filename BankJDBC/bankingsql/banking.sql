-- this file is primarily for testing things and messing around with the database --

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

--CREATE PROCEDURE [name]
--[parameters] AS
--[variable declarations]
--BEGIN
----LOGIC
--COMMIT;
--END;

create or replace procedure add_Account
(account_name in varchar2, user_ID in varchar2, account_type in varchar2)
AS
BEGIN
insert into bankaccount values (accseq.nextVal, account_name, account_type,0);
insert into customer_bankaccount (uaid, accountID, userID) values(uaseq.nextVal, accseq.currval, user_ID);
commit;
end;
/
select * from customer;
execute add_account('Acc2',5000,'Saving');



INSERT INTO customer (username, PASSWORD) VALUES('hlerum','pass');
UPDATE customer SET firstname = 'Hann', lastname = 'Lerum' WHERE username = 'hlerum';

SELECT * FROM customer;
SELECT * FROM bankaccount;
SELECT * FROM useraccount;

INSERT INTO bankaccount (accountname,accounttype) VALUES ('Hann''s account','Checking');
INSERT INTO customer_bankaccount (uaid,userid, accountid) VALUES(1,5000,200);


SELECT username, customer.firstname, customer.lastname, accountname, accounttype, balance 
FROM customer FULL JOIN customer_bankaccount ON customer_bankaccount.userid = customer.userid
FULL JOIN bankaccount ON bankaccount.accountid = customer_bankaccount.accountid;

SELECT bankaccount.accountid, accountname, accounttype, balance 
    FROM bankaccount JOIN customer_bankaccount 
        ON customer_bankaccount.accountid = bankaccount.accountid
    WHERE userid = 5000;
    
    
select * from bankaccount;
select * from customer;

select * from bankaccount where accountID in( select accountID from customer_bankaccount where userID = 5000);

commit;
rollback;

UPDATE bankaccount SET balance = balance + 420 WHERE accountid = 200;

