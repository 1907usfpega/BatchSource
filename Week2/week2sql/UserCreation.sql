--comment

--To create a new user
--and grant that user permission
create user pokemondb1 identified by P4ssw0rd;

grant connect, resource to week2db;
grant dba to pokemondb1 with admin option;
