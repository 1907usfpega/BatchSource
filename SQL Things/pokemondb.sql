SELECT * FROM artist;
/*
Datatypes: VARCHAR CARCHAR2 NUMBER DATE TIMESTAMP BLOB CLOB
===============================================================
CONSTRAINTS: primary ket foreign key unique not null & check
PK/primary key is a combination of unique and not null
foreign key - reference pointer to another tables primary key
---FOREIGN KEY (reference_from_this_table) REFERENCES other_table (PK_from_other_table)
CHECK creates an additional custom condition for the column
--- CONSTRAINT constraint_name CHECK (column_name > 15)
*/
--DDL create
CREATE TABLE pokemon(
    pokemon_id NUMBER(15),
    pokemon_name VARCHAR2(100),
    pokemon_type VARCHAR2(25),
    PRIMARY KEY(pokemon_id)
);
--describes the structure of the table desc works, too
DESCRIBE pokemon;
--drop table ddl
DROP TABLE pokemon;

--DDL alter
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR(25);
--DDL truncate - 
-----deletes all entries, but keeps table intact

--this is how you view all entries into a table
SELECT * FROM pokemon;

--DML
INSERT INTO pokemon VALUES(1, 'bulbasaur', 'grass', 'ice');
INSERT INTO pokemon VALUES(2, 'ignatius', 'fire', null);
INSERT INTO pokemon VALUES(3, 'bubblysoda', 'water', 'psychic');
--
INSERT INTO pokemon(pokemon_name, pokemon_id, pokemon_type)
    Values('blastoise', 9, 'water');

DELETE FROM pokemon WHERE pokemon_id=121;
DELETE FROM pokemon;

commit;
rollback;