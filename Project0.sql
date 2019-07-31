DROP table accounts;
DROP table customer;
DROP table bank_admin;
DROP table bank_user;

-------------------------------Create Tables-------------------------------
CREATE TABLE bank_user (
    user_id NUMBER(10) NOT NULL,
    username VARCHAR2(20) NOT NULL,
    user_password VARCHAR2(20) NOT NULL, 
    user_type VARCHAR2(10) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);


CREATE TABLE bank_admin (
    admin_id NUMBER(10) NOT NULL,
    fk_user_id NUMBER(10) NOT NULL,
    admin_name VARCHAR2(20),
    CONSTRAINT admin_pk PRIMARY KEY (admin_id),
    CONSTRAINT fk_user_admin_id
        FOREIGN KEY (fk_user_id)
        REFERENCES bank_user(user_id)
        ON DELETE CASCADE
);


CREATE TABLE customer (
    customer_id NUMBER(10) NOT NULL,
    fk_user_id NUMBER(10) NOT NULL,
    customer_name VARCHAR2(20),
    CONSTRAINT customer_pk PRIMARY KEY (customer_id),
    CONSTRAINT fk_user_customer_id
        FOREIGN KEY (fk_user_id)
        REFERENCES bank_user(user_id)
        ON DELETE CASCADE
);


CREATE TABLE accounts (
    account_id NUMBER(10) NOT NULL,
    fk_customer_id NUMBER(10) NOT NULL,
    account_type VARCHAR2(10) NOT NULL,
    balance NUMBER(10) NOT NULL,
    CONSTRAINT account_pk PRIMARY KEY (account_id),
    CONSTRAINT fk_customer_id
        FOREIGN KEY (fk_customer_id)
        REFERENCES customer(customer_id)
        ON DELETE CASCADE
);


/*
CREATE TABLE transactions (
    transaction_id NUMBER(10) NOT NULL,
    fk_customer_id NUMBER(10) NOT NULL,
    fk_account_id NUMBER(10) NOT NULL,
    transaction_type VARCHAR2(10) NOT NULL,
    amount NUMBER(10) NOT NULL,
    receiving_account NUMBER(10),
    CONSTRAINT transaction_pk PRIMARY KEY (transaction_id),
    CONSTRAINT fk_customer_transaction_id
        FOREIGN KEY (fk_customer_id)
        REFERENCES customer(customer_id),
    CONSTRAINT fk_account_transaction_id
        FOREIGN KEY (fk_account_id)
        REFERENCES accounts(account_id)
);
*/


-------------------------------Create Sequences-------------------------------
DROP SEQUENCE bank_user_seq;
DROP SEQUENCE bank_admin_seq;
DROP SEQUENCE customer_seq;
DROP SEQUENCE accounts_seq;

CREATE SEQUENCE bank_user_seq;
CREATE SEQUENCE bank_admin_seq;
CREATE SEQUENCE customer_seq;
CREATE SEQUENCE accounts_seq;
--CREATE SEQUENCE transactions_seq;


-------------------------------Create Procedures-------------------------------
-----Creates User-----
CREATE OR REPLACE PROCEDURE insert_bank_user
(username IN VARCHAR2, user_password IN VARCHAR2, user_type IN VARCHAR2)
AS
BEGIN
    INSERT INTO bank_user VALUES(bank_user_seq.NEXTVAL, username, user_password, user_type);
COMMIT;
END;
/


-----Updates Admin Name-----
CREATE OR REPLACE PROCEDURE update_admin_name
(admin_name2 IN VARCHAR2, user_id IN NUMBER)
AS
BEGIN
    UPDATE bank_admin
        SET admin_name = admin_name2
        WHERE fk_user_id = user_id;
COMMIT;
END;
/


-----Updates Customer Name-----
CREATE OR REPLACE PROCEDURE update_customer_name
(customer_name2 IN VARCHAR2, user_id IN NUMBER)
AS
BEGIN
    UPDATE customer
        SET customer_name = customer_name2
        WHERE fk_user_id = user_id;
COMMIT;
END;
/


-----Creates Accounts-----
CREATE OR REPLACE PROCEDURE insert_accounts
(fk_customer_id IN NUMBER, account_type IN VARCHAR2, balance IN NUMBER)
AS
BEGIN
    INSERT INTO accounts VALUES(accounts_seq.NEXTVAL, fk_customer_id, account_type, balance);
COMMIT;
END;
/


-----Updates Account Balance-----
CREATE OR REPLACE PROCEDURE update_account_balance
(balance2 IN NUMBER, account_id2 IN NUMBER)
AS
BEGIN
    UPDATE accounts
        SET balance = balance2
        WHERE account_id = account_id2;
COMMIT;
END;
/


-------------------------------Create Triggers-------------------------------
-----Creates Customer_ID or Admin_ID -----
CREATE OR REPLACE TRIGGER insert_user_id
AFTER INSERT ON bank_user
FOR EACH ROW
BEGIN
    IF :NEW.user_type = 'admin'  THEN
        INSERT INTO bank_admin(admin_id, fk_user_id) VALUES(bank_admin_seq.NEXTVAL, bank_user_seq.CURRVAL);
    ELSE
        INSERT INTO customer(customer_id, fk_user_id) VALUES(customer_seq.NEXTVAL, bank_user_seq.CURRVAL);
    END IF;
END;
/


-------------------------------Load Example Data-------------------------------
EXECUTE insert_bank_user('SmithJ', 'password', 'admin');
EXECUTE update_admin_name('Jonathon Smith', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('BarkerB', 'password', 'customer');
EXECUTE update_customer_name('Billy Barker', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('ConnorT', 'password', 'customer');
EXECUTE update_customer_name('Connor Tuttle', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('MeganH', 'password', 'customer');
EXECUTE update_customer_name('Megan Hara', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('JodyK', 'password', 'customer');
EXECUTE update_customer_name('Jody Kim', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('ThomasK', 'password', 'customer');
EXECUTE update_customer_name('Thomas Kim', bank_user_seq.CURRVAL);

EXECUTE insert_bank_user('BecUr', 'password', 'admin');
EXECUTE update_admin_name('Rebbecca Urban', bank_user_seq.CURRVAL);

EXECUTE insert_accounts(1, 'checking', 1000);
EXECUTE insert_accounts(1, 'saving', 5000);

EXECUTE insert_accounts(2, 'checking', 8920);

EXECUTE insert_accounts(4, 'saving', 20192);

EXECUTE insert_accounts(5, 'checking', 7348);
EXECUTE insert_accounts(5, 'saving', 14031);

