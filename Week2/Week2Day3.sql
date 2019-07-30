
-- SCALAR
SELECT UPPER(name) FROM artist;

--AGGREGATE
SELECT AVG(unitprice) FROM track;

SELECT COUNT(employeeID), country, city FROM employee GROUP BY country, city HAVING count(employeeId)>1;

CREATE TABLE STUDENT(
S_ID NUMBER,
s_name VARCHAR2(20),
SCH_ID NUMBER);

create table school(
sch_ID number,
sch_name VARCHAR2(20)
);

insert into school values(11, 'USF');
insert into school values(12, 'FSU');
insert into school values(13, 'UA');
insert into school values(14, 'UGA');
insert into school values(15, 'LSU');
insert into school values(16, 'AU');

insert into student values(1, 'Matt',13);
insert into student values(2, 'Ben',15);
insert into student values(3, 'Hann',11);
insert into student values(4, 'Ken',15);
insert into student values(5, 'Jackson',14);
insert into student values(6, 'John',12);
insert into student values(7, 'Levi',11);
insert into student values(8, 'Andrew',13);
insert into student values(9, 'Brad',12);
insert into student values(10, 'Ren',15);
insert into student (s_id, s_name) values(11, 'N/A');

select * from school right join student on school.sch_id =  student.sch_id order by student.s_name;
select * from school join student on school.sch_id =  student.sch_id order by school.sch_name;
select school.sch_name, student.s_name from school join student on school.sch_id = student.sch_id;

CREATE TABLE student2(
id NUMBER,
name VARCHAR2(20),
LAB_PARTNER NUMBER
);

insert into student2 values (1, 'Matt', 6);
insert into student2 values (2, 'Ben', 5);
insert into student2 values (3, 'Ren', 4);
insert into student2 values (4, 'Hann', 3);
insert into student2 values (5, 'Ken', 2);
insert into student2 values (6, 'Levi', 1);
-- self-join
SELECT A.NAME AS student, b.NAME AS lab_partner FROM student2 A JOIN student2 b ON b.ID = A.lab_partner ;


-- Set operations
SELECT count(track.name), album.title, artist.name FROM track 
JOIN album on track.albumID = album.albumID 
JOIN artist ON album.artistID = artist.artistID 
WHERE artist.name Like 'B%' 
GROUP BY artist.name, album.title 
ORDER BY count(track.name), artist.name, album.title;


select * from artist;

Select count (playlist.name), playlist.name as playlist from playlisttrack
join playlist on playlisttrack.playlistid =playlist.playlistid
join track on playlisttrack.trackid = track.trackid
group by playlist.name
order by count (playlisttrack.playlistid);




























