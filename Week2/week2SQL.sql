--scalar

select upper(name) from artist;

--aggregate
select round(avg(unitprice),2) from track;

--complete query
select count(employeeid), city, country
from employee
group by city,country
having count(employeeid)>1;

--
create table student(
s_id number,
s_name VARCHAR2(20),
sch_id number);
create table school(
sch_id number,
sch_name VARCHAR2(20));

insert into school values(1,'usf');
insert into school values(2,'fsu');
insert into school values(3,'ua');
insert into school values(4,'uga');
insert into school values(5,'lsu');
insert into school values(6,'au');

insert into student values(1, 'matt', 5);
insert into student values(2, 'ben', 5);
insert into student values(3, 'hann', 1);
insert into student values(4, 'ken', 5);
insert into student values(5, 'jackson', 4);
insert into student values(6, 'john', 2);
insert into student values(7, 'levi', 1);
insert into student values(8, 'andrew', 3);
insert into student values(9, 'brad', 2);
insert into student values(10, 'ren', 3);

select * from school
right join student
on school.sch_id= student.sch_id
order by student.s_name;

create table student2(
id number,
name VARCHAR2(20),
lab_partner number);

insert into student2 values(1, 'matt',6);
insert into student2 values(2, 'ben',5);
insert into student2 values(3, 'ren',4);
insert into student2 values(4, 'hann',3);
insert into student2 values(5, 'ken',2);
insert into student2 values(6, 'levi',1);

select A.name as student, B.name as lab_partner
from student2 A join student2 
on A.lab_partner=B.id;

select a.name as genre, b.albumid as album
from album  
where genre.id='1'
join genre
on b.albumid=a.name;

join genre
on albumname = album.
where genre='rock';

