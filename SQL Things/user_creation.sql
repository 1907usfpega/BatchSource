--THIS IS A COMMENT
----TO create a new user
--and grant that user permissions
CREATE USER pokemondb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO pokemondb;
GRANT DBA TO pokemondb WITH ADMIN OPTION;

