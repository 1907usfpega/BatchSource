CREATE USER vgdemo
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to vgdemo;
GRANT resource to vgdemo;
GRANT create session TO vgdemo;
GRANT create table TO vgdemo;
GRANT create view TO vgdemo;



conn vgdemo/p4ssw0rd