--2.1
select * from employee;

select * from employee
where lastname='King';

select * from employee
where firstname='Andrew' and reportsto is null;

--2.2
select * from album
order by title desc;

select firstname from customer
order by city;

--2.3
insert into genre values(26,'Dancehall');
insert into genre  values(27,'Yawd Rap');

insert into employee values(9,
'Anderson',
'Deja',
'Sales Support Agent',
2,
TO_DATE('28-FEB-97', 'DD-MON-RR'),
to_DATE('01-FEB-19','DD-MON-RR'),
'12 Sheridan Dr',
'Amherst',
'NY',
'US',
'14261',
'+1 (718) 445-0989',
'+1 (456) 367-7656', 
'dejaa@yahoo.com');
insert into employee  values(10,'Smith','Yogeros','IT Staff',6,TO_DATE('02-MAR-95','DD-MON-RR'),TO_DATE('09-JAN-19', 'DD-MON-RR'),'13 Sheridan Dr','Amherst','NY','US','14261','+1 (718) 445-0559', '+1 (456) 347-3456', 'yogeros@yahoo.com');

insert into customer  values(60,'Smith','George',null,'56 Love Lane','Manchester',null,'England','67883','+1 (433) 445-0559', '+1 (990) 347-3456', 'george@yahoo.com',3);
insert into customer  values(61,'Stanley','George',null,'56 Hate Lane','London',null,'England','76683','+1 (676) 655-0559', '+1 (560) 347-3456', 'stang@yahoo.com',5);

--2.4
update customer
set firstname='Robert', lastname='Walter'
where customerid=32;

update artist
set name='CRR'
where artistid=76;

--2.5
SELECT * FROM invoice
where billingaddress  like 'T%';


--2.6
select * from invoice
where total between 15 and 50;

select * from employee
where hiredate between '06-JUN-03' and '01-MAR-04';

--2.7
delete from invoiceline  where invoiceid in (select invoiceid from invoice where customerid=32) ;
delete from invoice where customerid=32;
delete from customer where customerid =32;


select TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;
--3.1
create or replace function current_time
return varchar2 as time_now varchar2(40);
begin
select TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') into time_now
     FROM DUAL;
     return time_now;
end;
/
select current_time() from dual;

create or replace function length_of_mediatypename
(media_id in number)
return number as 
name_length number(10,2);
begin
    select length(name) into name_length
    from mediatype where mediatypeid=media_id; 
    return name_length;
end ;
/  


--3.2
create or replace function avg_invoice
return number as avg_inv number(9,5);
begin
    select avg(total) into avg_inv from invoice;
    return avg_inv;
end;
/

create or replace function expensive_track
return track%rowtype as ex_track track%rowtype;
begin
    select * into ex_track from track where milliseconds =(                        
        select min(milliseconds) from (                       
            select name, milliseconds from track 
            where unitprice =(
                select max(unitprice) from track))); 
                return ex_track;
end;
/

--3.3
create or replace function avg_invoiceline
return number as 
avg_price number(12,10);
begin 
    select avg(unitprice) into avg_price from invoiceline;
    return avg_price;
end;
/


--3.4
select * from employee where birthdate >  '31-DEC-68';
    
    
--4.1
--Select first and last name of all employees
create or replace procedure emps
(s out sys_refcursor)
is 
begin
    open s for 
    select firstname,lastname from employee;
end;
/
SET SERVEROUT ON;
DECLARE S SYS_REFCURSOR;
fname employee.firstname%TYPE; --set album_id to whatever datatype albumud is
lname employee.lastname%TYPE;
BEGIN
    emps(S);
    LOOP
    FETCH S INTO fname, lname;
    EXIT WHEN S%notfound; --break out of loop when no more rows available
    dbms_output.put_line(fname|| ' '||lname);
    END LOOP;
    CLOSE S;
    END;
/

--4.2
--update personal info of an employee
create or replace procedure update_employee
(eid in number, addy in varchar2, cityy in varchar2,statee in varchar2,countryy in varchar2, pcode in varchar2,phonee in varchar2, faxx in varchar2, emaill in varchar2)
as BEGIN
update employee
set address=addy, city=cityy,state=statee,country=countryy,postalcode=pcode,phone=phonee,fax=faxx,email=emaill where employeeid=eid;
end;
/

--returns manager of all employees
create or replace procedure who_manages
(e_id in number, fname out varchar2, lname out varchar2) 
is
begin
    select a.firstname, a.lastname into fname,lname  from employee a
    where a.employeeid=(select b.reportsto from employee b where b.employeeid= e_id);
    dbms_output.put_line('Manager is '||fname||' '||lname);
end;

--4.3
--name and company of customer
create or replace Procedure get_commpany_and_name(S Out Sys_Refcursor)
is
begin
   open s for
   select firstname, lastname, company
   from customer;
end;

--5.1
--delete invoiceid
create or replace procedure del_inv
(invid in number)
as begin
delete from invoiceline where invoiceid=invid;
delete from invoice where invoiceid=invid;
end;
/

--insert customer information
create or replace procedure new_cus
(cid in number,fname in varchar2,lname in varchar2,companyy in varchar2, addy in varchar2, cityy in varchar2,statee in varchar2,countryy in varchar2, pcode in varchar2,phonee in varchar2, faxx in varchar2, emaill in varchar2,supid in number)
as begin
insert into customer values(cid,fname,lname ,companyy,addy,cityy,statee,countryy,pcode,phonee,faxx,emaill,supid);
end;
/


--6.1
--after insert trigger on the employee table fired after a new record is inserted into the table.
set serveroutput on;
create or replace trigger after_insert_trig
after insert on employee
for each row
enable
begin
    dbms_output.put_line('There was an insert into employee table');
end;
/

--trigger after update on album table
--after insert trigger on the employee table fired after a new record is inserted into the table.
set serveroutput on;
create or replace trigger after_update_trig
after update on album
for each row
enable
begin
    dbms_output.put_line('There was an update in album table');
end;
/

--trigger after delete on customer table
--after insert trigger on the employee table fired after a new record is inserted into the table.
set serveroutput on;
create or replace trigger after_delete_trig
after delete on customer
for each row
enable
begin
    dbms_output.put_line('There was a delete from customer table');
end;
/


--7.1
-- inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select * from customer a
inner join invoice b
on a.customerid=b.customerid;

--7.2
--outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select a.customerid, a.firstname, a.lastname, b.invoiceid, b.total
from customer a
JOIN  invoice b
on a.customerid=b.customerid;

--7.3
--right join that joins album and artist specifying artist name and title
select b.name, a.title from artist b
RIGHT outer join album a
on a.artistid=b.artistid;

--7.4
--cross join that joins album and artist and sorts by artist name in ascending order
select name from artist cross join album ORDER by artist.name ;

--7.5
--a self-join on the employee table, joining on the reportsto column
select a.firstname, a.lastname, b.firstname, b.lastname from employee a
join employee b on a.reportsto=b.employeeid;


