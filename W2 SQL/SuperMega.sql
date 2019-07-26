
--schema manipulation
--datatypes: numbers, varchar,varchar2,date,timestamp,blob,clob
---constraints:pk, fk, unique, not null, check
--not null: ensures the record has a value in this column
--unique:ensures that any two records will not have the same value in this column.
--PK: not null and unique, the official unique identifier for the table. 
--FK: key in one table that references the other table. 
--example: FOREIGN KEY (refence_attribute_from_this_table) REFERENCES other_table (pk_from_other_table)
--CHECK creates an additional custom condition for the column example: CONSTRAINT constraint_name CHECK (column_nmae >15)




--------------------------------------
--DDL : drop, create, alter, truncate
--DDL Create
CREATE TABLE pokemon (
    pokemon_id NUMBER(15), --PRIMARY KEY,
    pokemon_name VARCHAR2(100),
    pokemon_type VARCHAR2(25),
    PRIMARY KEY(pokemon_id)
);
--describes the structures of the table
DESC pokemon; 


--DDL : DROP
DROP TABLE pokemon;
--DDL: ALTER
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);
--DDL: truncate
/* truncate deletes all entries into the table while keeping the table structure intact. DROP is like throwing a cup of water 
into the trash, TRUNCATE is like pourinf the water out of the cup.*/

--this is how you view all entries into a table--
SELECT * FROM pokemon;

--DML:insert
INSERT INTO pokemon VALUES (1,'bulbasaur','grass','ice');
INSERT INTO pokemon VALUES (2,'bulbasaurzzz','fire','fire');
INSERT INTO pokemon VALUES (3,'bulbasaursss','ghost','rock');
INSERT INTO pokemon VALUES (4,'bulbasaursssszzz','rock','steel');
-----
INSERT INTO pokemon(pokemon_name,pokemon_id,pokemon_type) 
VALUES ('Blastoise',9,'water');

--DML: update
UPDATE pokemon SET pokemon_secondtype='food' WHERE pokemon_id=1;

--DML: delete, delete you can roll back, a truncate you cannot.
DELETE FROM pokemon WHERE pokemon_id=9;
DELETE FROM pokemon;

commit;  --DDL auto commits(TCL), DML needs to be committed.
rollback;


