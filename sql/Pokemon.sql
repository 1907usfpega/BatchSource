-- SCHEMA MANIPULATION

-- create a table
--DDL: create
CREATE TABLE pokemon(
    pokemon_ID NUMBER(15), -- PRIMARY KEY,
        pokemon_name VARCHAR2(100),
        pokemon_type VARCHAR2(25), 
        PRIMARY KEY(pokemon_ID)
);

--describes the structure of the table
DESC pokemon;
DESCRIBE pokemon;

-- DDL: drop
DROP TABLE pokemon;

-- DDL: alter
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);

-- DDL: truncate
/*
not gonna do an example but TRUNCATE deletes all entries in the table while keeping the table structure intact. 
DROP is like throwing a cup of water into the trash, while TRUNCATE is like pouring out the water and keeping the cup.
*/


--this is how you view all entries into a table:
SELECT * FROM pokemon;

-- DML: insert
INSERT INTO pokemon VALUES(1, 'bulbasaur','grass','ice');
INSERT INTO pokemon VALUES(7, 'squirtle','water',null);
INSERT INTO pokemon VALUES(121, 'starmie','water','psychic');
INSERT INTO pokemon VALUES(25, 'pikachu','electric',null);
--
INSERT INTO pokemon (pokemon_name, pokemon_ID, pokemon_type ) VALUES ('blastoise',9,'water');

-- DML: update
UPDATE pokemon SET pokemon_secondtype = 'poison' WHERE pokemon_id = 1;

--DML delete
DELETE FROM pokemon WHERE pokemon_ID = 9;
DELETE FROM pokemon WHERE pokemon_ID = 121;


commit;
rollback; -- returns us to the previous commit

SELECT * FROM pokemon ORDER BY pokemon_ID;

-- DML 

CREATE table Ben(
pokemon_name VARCHAR2(100)
);
insert into ben values ('starmie');

select * from ben;
select * from matt;

select * from BEN left join MATT on Ben.pokemon_name = Matt.pokemon_name;

select * from matt;
select * from ben cross join matt;

alter table ben add(trainer varchar2(20));
update ben set trainer = 'Ben';

select * from ben union select * from matt;
SELECT * FROM ben intersect SELECT * FROM matt;

(select * from ben union select * from matt) minus (SELECT * FROM ben intersect SELECT * FROM matt);















































