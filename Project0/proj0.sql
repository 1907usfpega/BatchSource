
/*
I think I actually added all non PK constraints
using ALTER TABLE table_name ADD CONSTRAINT
*/
create table login(
hashcode number primary key UNIQUE,
usrid number UNIQUE,
username varchar2(40));

create table accountslist(
	acctid number PRIMARY KEY,
	usrid number NOT NULL FOREIGN KEY references login(usrid)
);

create table accountsstate(
	acctid number not null UNIQUE foreign key references accountslist(acctid),
	balance number(*, 2) check(balance>=0)
);


CREATE SEQUENCE  ACCTID_SQ
MINVALUE 1001
MAXVALUE 9999
CACHE 20;

CREATE SEQUENCE  USRID_SQ
MINVALUE 1
MAXVALUE 999
CACHE 20;

create or replace PROCEDURE acct_creation
(hashcode in number, usrname in varchar2)
IS
u number;
a number;
BEGIN
u := USRID_SQ.nextval;
a := acctid_sq.nextval;
INSERT INTO login VALUES(hashcode, u, usrname);
INSERT INTO accountslist VALUES(a, u);
INSERT INTO accountsstate VALUES(a, 0.00);
END acct_creation;

create or replace PROCEDURE acct_delete
(acct_id in number)
IS
b Number;
BEGIN
select balance into b from accountsstate where acctid=acct_id;
IF b=0 THEN
    DELETE FROM accountsstate WHERE accountsstate.acctid=acct_id;
    DELETE FROM accountslist WHERE acctid=acct_id;
ELSE
    RAISE VALUE_ERROR;
END IF;
END acct_delete;


/*
ALTER TABLE table-Name
{
    ADD COLUMN column-definition |
    ADD CONSTRAINT clause |
    DROP [ COLUMN ] column-name [ CASCADE | RESTRICT ]
    DROP { PRIMARY KEY | FOREIGN KEY constraint-name | UNIQUE 
	 constraint-name | CHECK constraint-name | CONSTRAINT constraint-name }
    ALTER [ COLUMN ] column-alteration |
    LOCKSIZE { ROW | TABLE }
}
*/