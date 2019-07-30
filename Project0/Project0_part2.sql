DROP TABLE BANK_ACCOUNTS;
DROP TABLE ANULOOKUP;
DROP TABLE BANK_USERS;
DROP SEQUENCE USERSEQ;
DROP SEQUENCE ACCOUNTSEQ;

--tables
CREATE TABLE BANK_ACCOUNTS(
account_id NUMBER PRIMARY KEY,
account_type VARCHAR2(20),
balance NUMBER,
status VARCHAR2(20) 
);

--ACCOUNT AND USER LOOKUP TABLE
CREATE TABLE ANULOOKUP(
user_id NUMBER,
account_id NUMBER
);

CREATE TABLE BANK_USERS (
user_id NUMBER PRIMARY KEY,
user_name VARCHAR2(50),
user_password VARCHAR2(50),
clearance_level VARCHAR2(20),
status VARCHAR2(20)
);

--sequences
CREATE SEQUENCE USERSEQ;
CREATE SEQUENCE ACCOUNTSEQ;


--lookup table constraints
ALTER TABLE ANULOOKUP
ADD CONSTRAINT fk_user_lookup
FOREIGN KEY (user_id) REFERENCES bank_users(user_id);

ALTER TABLE ANULOOKUP
ADD CONSTRAINT fk_account_lookup
FOREIGN KEY (account_id) REFERENCES bank_accounts(account_id);

ALTER TABLE ANULOOKUP
ADD CONSTRAINT pk_user_account
PRIMARY KEY (user_id, account_id);
----------------------------USER PROCEDURES-----------------------------------------------------
--stored procedures
--all users are pending from the start
CREATE OR REPLACE PROCEDURE insert_user
(login_name VARCHAR2, login_password VARCHAR2, user_type VARCHAR2)
IS
BEGIN
INSERT INTO BANK_USERS VALUES(USERSEQ.NEXTVAL, login_name, login_password, user_type, 'Pending');
commit;
END;
/

--EXEC insert_user('eheredia', 'password', 'customer');

CREATE OR REPLACE PROCEDURE delete_user
(login_id NUMBER)
IS
BEGIN
DELETE FROM BANK_USERS WHERE user_id = login_id;
commit;
END;
/

--EXEC delete_user(1);

CREATE OR REPLACE PROCEDURE change_user_status (login_id NUMBER, user_status VARCHAR2) 
IS
BEGIN
UPDATE bank_users 
SET status = user_status 
WHERE login_id = user_id;
commit;
END;
/

--EXEC change_user_status(2, 'Approved');



----------------------------ACCOUNT PROCEDURES-----------------------------------------------------

CREATE OR REPLACE PROCEDURE insert_account
(a_type VARCHAR2)
IS
BEGIN
INSERT INTO BANK_ACCOUNTS VALUES(ACCOUNTSEQ.NEXTVAL, a_type, 0, 'Pending');
commit;

END;
/

--EXEC insert_account('Checking');

CREATE OR REPLACE PROCEDURE delete_account
(acc_id NUMBER)
IS
BEGIN
DELETE FROM BANK_ACCOUNTS WHERE acc_id = account_id;
commit;
END;
/
--EXEC delete_account(1);


CREATE OR REPLACE PROCEDURE update_balance
(acc_id NUMBER, amount NUMBER)
IS 
BEGIN
UPDATE bank_accounts
SET balance = balance + amount
WHERE acc_id = account_id;
commit;
END;
/

--EXEC deposit(1, -500);

CREATE OR REPLACE PROCEDURE set_balance
(acc_id NUMBER, amount NUMBER)
IS 
BEGIN
UPDATE bank_accounts
SET balance = amount
WHERE acc_id = account_id;
commit;
END;
/

CREATE OR REPLACE PROCEDURE update_account_status
(acc_id NUMBER, account_status VARCHAR2)
IS 
BEGIN
UPDATE bank_accounts
SET status = account_status
WHERE acc_id = account_id;
commit;
END;
/


----------------------ANULOOKUP

CREATE OR REPLACE PROCEDURE link_user_account(u_id NUMBER, a_id NUMBER)
IS
BEGIN
INSERT INTO anulookup VALUES(u_id, a_id);
commit;
END;
/
--EXEC link_user_account(2, 3);

--unlink all accounts of designated user
CREATE OR REPLACE PROCEDURE unlink_user(u_id NUMBER)
IS
BEGIN
DELETE FROM anulookup 
WHERE (u_id = user_id);
commit;
END;
/
--EXEC unlink_user(2);

--unlink all users of designated account
CREATE OR REPLACE PROCEDURE unlink_account(a_id NUMBER)
IS
BEGIN
DELETE FROM anulookup 
WHERE (a_id = account_id);
commit;
END;
/
--exec unlink_account(12);

--unlink specific account of user
CREATE OR REPLACE PROCEDURE unlink_user_account(u_id NUMBER, a_id NUMBER)
IS
BEGIN
DELETE FROM anulookup 
WHERE (u_id = user_id  AND a_id = account_id);
commit;
END;
/
--EXEC unlink_user(2);




