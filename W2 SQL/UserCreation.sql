--single line comment
--CREATE A NEW USER and GRANT PERMISSIONS
CREATE USER pokemondb IDENTIFIED BY p4ssw0rd;

--
GRANT CONNECT, RESOURCE TO pokemondb;
GRANT DBA TO pokemondb WITH ADMIN OPTION;
