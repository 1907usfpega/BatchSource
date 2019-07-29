
---DDL: create
CREATE TABLE pokemon(
    pokemon_id NUMBER(15) PRIMARY KEY,
    pokemon_name VARCHAR2(100),
    pokemon_type VARCHAR2(25),
    --PRIMARY KEY (pokemon_id)
);

--describes the structures of the table
DESCRIBE pokemon;

--DDL: drop
DROP TABLE pokemon;

--DDL: alter
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);

--DDL: TRUNCATE