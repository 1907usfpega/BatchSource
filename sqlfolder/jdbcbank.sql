CREATE TABLE users (
user_id NUMBER NOT NULL,
username VARCHAR2(40) NOT NULL,
userpass VARCHAR2(20) NOT NULL,
CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE account (
account_id NUMBER NOT NULL,
balance NUMBER NOT NULL,
user_id NUMBER NOT NULL,
CONSTRAINT PK_account PRIMARY KEY (account_id)
);


ALTER TABLE account 
ADD CONSTRAINT FK_users
FOREIGN KEY (user_id) REFERENCES users (user_id);


CREATE SEQUENCE NEXTUSERID;

--create new user/customer
CREATE OR REPLACE PROCEDURE create_new_user
(newusername IN VARCHAR2, newuserpass IN VARCHAR2)
AS
BEGIN
    INSERT INTO users VALUES (NEXTUSERID.NEXTVAL, newusername , newuserpass);
    COMMIT;
END;
/

--create a new account
CREATE SEQUENCE NEXTACCOUNTID;

CREATE OR REPLACE PROCEDURE create_new_account
(newuser_id IN NUMBER)
AS
BEGIN
    INSERT INTO account VALUES(NEXTACCOUNTID.NEXTVAL, 0, newuser_id);
    COMMIT;
END;
/

--update user information
CREATE OR REPLACE PROCEDURE update_user
(user_id2 IN NUMBER, username_2 IN VARCHAR2, userpass_2 IN VARCHAR2)
AS 
BEGIN
    UPDATE users 
    SET 
    username=username_2,
    userpass=userpass_2
    WHERE user_id=user_id2;
    COMMIT;
END;
/
    
    
    


--update balance
CREATE OR REPLACE PROCEDURE update_balance
(account_id2 IN NUMBER, balance_2 IN NUMBER )

AS
BEGIN
    UPDATE account SET balance=balance_2
    WHERE account_id=account_id2;
    COMMIT;
END;
/


--user delete account
CREATE OR REPLACE PROCEDURE delete_account
(account_id2 IN NUMBER)
AS
BEGIN
    DELETE FROM account 
    WHERE account_id = account_id2;
    COMMIT;
END;
/


--admin delete user and all accounts assoc. w/user
CREATE OR REPLACE PROCEDURE delete_user
(user_id2 IN NUMBER )
AS
BEGIN
    DELETE FROM account 
    WHERE user_id = user_id2;
    
    DELETE FROM users
    WHERE user_id = user_id2;
    COMMIT;
END;
/




    

