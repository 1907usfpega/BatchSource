CREATE TABLE customer (
user_id NUMBER PRIMARY KEY,
user_name VARCHAR2(20),
user_password VARCHAR2(20)
);
CREATE TABLE bankaccount(
account_id NUMBER PRIMARY KEY,
balance NUMBER,
customer_id NUMBER
);
ALTER TABLE customer
RENAME COLUMN user_id TO customer_id;

ALTER TABLE customer
RENAME COLUMN user_name TO customer_name;

ALTER TABLE customer
RENAME COLUMN user_password TO customer_password;

ALTER TABLE bankaccount
ADD CONSTRAINT fkcustomer_id
FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

ALTER TABLE customer
ADD CONSTRAINT uniqueName
UNIQUE (customer_name);

CREATE SEQUENCE AccountSeq;
CREATE SEQUENCE CustomerSeq;

CREATE OR REPLACE PROCEDURE InsertCustomer
(customername IN customer.customer_name%TYPE, customerpassword IN customer.customer_password%TYPE)
AS
BEGIN
    INSERT INTO customer VALUES(CustomerSeq.NEXTVAL, customername, customerpassword);
END;
/
CREATE OR REPLACE PROCEDURE DeleteCustomer
(ind IN NUMBER)
AS
BEGIN
    DELETE FROM bankaccount WHERE customer_id = ind;
    DELETE FROM customer WHERE customer_id = ind;
END;
/

CREATE OR REPLACE PROCEDURE InsertAccount
(ind IN NUMBER)
AS
BEGIN
    INSERT INTO bankaccount VALUES(AccountSeq.NEXTVAL, 0, ind);
END;
/
CREATE OR REPLACE PROCEDURE DELETEACCOUNT
(ind IN NUMBER)
AS
BEGIN
    DELETE FROM bankaccount WHERE account_id = ind;
END;
/
CREATE OR REPLACE PROCEDURE WithdrawOrDeposit
(account_ind IN NUMBER, newBalance IN NUMBER)
AS 
BEGIN
    UPDATE bankaccount SET balance = newBalance WHERE account_id = account_ind;
END;
/

CREATE OR REPLACE PROCEDURE UpdateCustomer
(customerName IN VARCHAR2, customerPassword IN VARCHAR2, ind IN NUMBER)
AS
BEGIN
    UPDATE customer SET customer_name = customerName, customer_password = customerPassword WHERE customer_id = ind;
END;
/