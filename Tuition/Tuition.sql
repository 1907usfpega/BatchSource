-- creating database

CREATE TABLE employee(
employeeid NUMBER PRIMARY KEY,
firstname VARCHAR2(20) not null,
lastname VARCHAR2(20) not null,
email VARCHAR2(20) not null,
address_street VARCHAR2(20),
address_city VARCHAR2(20),
address_state VARCHAR2(2),
address_zip NUMBER(5)
);

CREATE TABLE username(
employeeid NUMBER UNIQUE, --foreign key
username VARCHAR2(20) UNIQUE,
password VARCHAR2(20)
);

CREATE TABLE reim_app(
formid NUMBER PRIMARY KEY,
employeeid NUMBER not null, -- foreign key
datesubmitted DATE not null,
datestart DATE not null,
dateend DATE not null,
location_city VARCHAR2(20) not null,
location_state VARCHAR2(2) not null,
location_zip NUMBER(5) not null,
course_description VARCHAR(200) not null,
course_cost NUMBER not null,
grading_format NUMBER not null, --foreign key
type_of_event NUMBER not null, --foreign key
status NUMBER DEFAULT 0 not null, -- foreign key
status_change_date date default sysdate not null
);

-- employee may optionally include: 
-- event-related attachments of pdf, png, jpeg, txt, or doc file type, 
-- attachments of approvals already provided of .msg (Outlook Email File) file type and type of approval,
-- work time that will be missed.

--create table attachment(
--attachmentID number primary key,
--appID number, -- foreign key
--attachment file
--);

CREATE TABLE event_type(
typeid NUMBER PRIMARY KEY,
type_description VARCHAR2(200),
reimbursement_percent NUMBER(3)
);

CREATE TABLE form_status(
statusid NUMBER PRIMARY KEY,
status_description VARCHAR2(200)
);

create table grading_format(
formatId number primary key,
grading_format varchar2(20)
);

ALTER TABLE reim_app ADD CONSTRAINT fk_employeeid FOREIGN KEY(employeeid) REFERENCES employee(employeeid) ON DELETE CASCADE;
ALTER TABLE reim_app ADD CONSTRAINT fk_type_of_event FOREIGN KEY(type_of_event) REFERENCES event_type(typeid);
ALTER TABLE reim_app ADD CONSTRAINT fk_grading_format FOREIGN KEY(grading_format) REFERENCES grading_format(formatID);

CREATE SEQUENCE formseq
START WITH 5
INCREMENT BY 7;

CREATE SEQUENCE employeeseq
INCREMENT BY 7;

CREATE OR REPLACE PROCEDURE newform
(employeeid IN NUMBER, datestart IN DATE, dateend IN DATE, location_city IN VARCHAR2, location_state IN VARCHAR2,
location_zip IN NUMBER, course_description IN VARCHAR, course_cost IN NUMBER, grading_format IN number, 
type_of_event IN NUMBER)
AS
BEGIN
    INSERT INTO reim_app VALUES(formseq.NEXTVAL, employeeid, sysdate, datestart, dateend,
    location_city, location_state, location_zip, course_description, course_cost, 
    type_of_event, 0, grading_format, sysdate);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE newemployee(
firstname IN VARCHAR2, lastname IN VARCHAR2, email IN VARCHAR2, address_street IN VARCHAR2, address_city IN VARCHAR2,
address_state VARCHAR2, address_zip IN NUMBER)
AS
BEGIN
INSERT INTO employee VALUES(employeeseq.NEXTVAL, firstname, lastname, email, 
    address_street, address_city, address_state, address_zip);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE REGISTER(firstname IN VARCHAR2, lastname IN VARCHAR2, email IN VARCHAR2, 
address_street IN VARCHAR2, address_city IN VARCHAR2, address_state VARCHAR2, address_zip IN NUMBER, 
username IN VARCHAR2, password IN VARCHAR2)
AS
BEGIN
INSERT INTO employee VALUES(employeeseq.NEXTVAL, firstname, lastname, email, 
    address_street, address_city, address_state, address_zip);
INSERT INTO username VALUES(employeeseq.CURRVAL, username, password);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE register_username(e_id IN NUMBER, uname IN VARCHAR2, pass IN VARCHAR2)
AS
BEGIN
INSERT INTO username VALUES(e_id, uname, pass);
COMMIT;
END;
/


INSERT INTO event_type VALUES(0, 'Certification', 100);
INSERT INTO event_type VALUES(1, 'Technical Training', 90);
INSERT INTO event_type VALUES(2, 'University Course', 80);
INSERT INTO event_type VALUES(3, 'Certification Preparation Classes', 75);
INSERT INTO event_type VALUES(4, 'Seminars', 60);
INSERT INTO event_type VALUES(5, 'Other', 30);


insert into form_status values(0, 'Pending Approval');
insert into form_status values(1, 'Direct Supervisor Approval');
insert into form_status values(2, 'Department Head Approval');
insert into form_status values(3, 'Benefits Coordinator Approval');
insert into form_status values(4, 'Pending Reimbursement');
insert into form_status values(5, 'Grade/Presentation Uploaded');
insert into form_status values(6, 'Approved');
insert into form_status values(7, 'Awarded');
insert into form_status values(10, 'Denied');


select * from form_status order by statusID;

COMMIT;

select * from username;
select * from employee;

select * from employee full join username on employee.employeeID = username.employeeID;

execute newEmployee('John','Doe','JDoe@gmail.com','1234 Average Lane', 'Nowhere','MT',83401);
insert into username values(1,'johndoe','password');

execute register('Zach','Thompson','ZThompson@gmail.com','1720 Bruce B Downs','Tampa','FL',33612,'zachthom','password');


commit;




















