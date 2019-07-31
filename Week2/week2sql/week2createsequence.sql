/*
create sequence(seq name)
minvalue(value)
maxvalue(value)
startwith(value)
increment by(value)
cache(value);
*/

create sequence MYTESTSEQ
minvalue 100
maxvalue 10000
start with 5000
increment by -5
cache 20;
select MYTESTSEQ.nextval from dual;

insert into school values(MYTESTSEQ.nextval, 'harvard');
--a view to kill
--a view is a saved select statement
create or replace view myview
as 
select title as a_list_of_stuff from album
union 
select name from artist;

select * from myview
where a_list_of_stuff like 'T%' or a_list_of_stuff like 'B%';

--index
/* create index(my name)on (table name) ( [column name] ) asc/desc;
*/

create index myindex
on album(artistid);

--Trigger
create or replace trigger mytrig
before insert on student
for each row
begin
select MYTESTSEQ.nextval into: new.s_id from dual;
end;
/
insert into student values( 67, 'deonta',5);
insert into student (s_name, sch_id) values('kenny g',1);

alter table student
add constraint pkid
primary key(S_ID);

--user defined functions
--functions
/* functions are a block of code we can execute 
they mush return one and only value
can have 0+ parameters
function
*/
create or replace function calc_tax
(t_id in number, tax in number:=1, testdog in number:=2)
return number as
total_price number (10,2);
begin
select unitprice into total_price
from track
where trackid= t_id;
return total_price +(total_price*tax)*testdog;
end;
/

--use calc_tax
select calc_tax(10,.08,3)from dual;
--select calc_tax(548,1,3) from dual;

--stored procedure
create or replace procedure mystopro
(name in varchar2)
as 
begin
insert into school values(MYTESTSEQ.nextval,name);
commit;
end;
/

exec mystopro('mit');

--more complex structure
create table bear(
bear_id number primary key,
bear_type_id number,
bear_name varchar2(100),
bear_birthdate date,
bear_weight number default 200,
cave_id number);

create table bear_type(
bear_type_id number primary key,
bear_type_name varchar2(100));

create table cave(
cave_id number primary key,
cave_name varchar2(100),
max_bears number default 4);

create table beehive(
beehive_id number primary key,
beehive_weight number default 50);

create table bear_beehive(
bear_id number,
beehive_id number,
primary key (bear_id,beehive_id));

alter table bear
add constraint fk_bear_bear_type
foreign key(bear_type_id) references bear_type(bear_type_id);

alter table bear
add constraint fk_bear_cave
foreign key (cave_id) references cave(cave_id);

alter table bear_beehive
add constraint fk_bear_beehive_beehive
foreign key (beehive_id) references beehive(beehive_id);

alter table bear_beehive
add constraint fk_bear_beehive_bear
foreign key (bear_id) references bear(bear_id);

alter table bear
add constraint ck_bear_weight_positive
check(bear_weight>0);

alter table beehive
add constraint ck_beehive_weight_positive
check (beehive_weight>0);

alter table cave
add constraint uq_cave_name
unique(cave_name);

alter table bear_type
add constraint uq_type_name
unique (bear_type_name);

create or replace procedure bearpro
(cave_name in varchar2, bear_name in varchar2,
bear_birthdate in date)
as 
begin
insert into cave values(MYTESTSEQ.nextval,cave_name,4);
insert into beehive values(MYTESTSEQ.nextval,50);
--insert into bear_type values(1,'black');
insert into bear values(MYTESTSEQ.nextval, 1,bear_name,bear_birthdate,20,(MYTESTSEQ.currval+50));
commit;
end;

exec bearpro('mattscave2','mattyice',date '2013-06-26');

--Cursors
--procedure with a cursor as an out parameter

create or replace procedure get_all_albums
(s out sys_refcursor)
is 
begin
open s for
select albumid,title from album;
end;
/

set serverout on;

declare s sys_refcursor;
album_id album.albumid%type;--set album_id to whater datatype albumid is
albumname album.title%type;
begin
    get_all_albums(s);
    loop
    fetch s into album_id,albumname;
    exit when s%notfound;--break out of loop when no more rows available
    dbms_output.put_line(album_id||' is current id, '||albumname||' is current name');
    end loop;
    close s;
    end;
    /
    
