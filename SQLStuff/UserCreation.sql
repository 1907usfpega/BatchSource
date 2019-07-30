--this is a comment

----TO CREATE A NEW USER
--and grant that user permissions
CREATE USER testuser IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO testuser;
GRANT DBA TO testuser WITH ADMIN OPTION;

