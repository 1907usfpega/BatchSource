CREATE TABLE superhero(
hero_id NUMBER PRIMARY KEY,
hero_name VARCHAR2(30)
);

CREATE TABLE superpower(
power_id NUMBER PRIMARY KEY,
power_name VARCHAR2(30)
);

CREATE TABLE weakness(
weakness_id NUMBER PRIMARY KEY,
weakness_name VARCHAR(30)
);

CREATE SEQUENCE heroseq;
CREATE SEQUENCE powseq;
CREATE SEQUENCE weakseq;

CREATE OR REPLACE PROCEDURE insert_superhero(supname IN VARCHAR2)
AS
BEGIN
INSERT INTO superhero VALUES(heroseq.NEXTVAL,supname);
COMMIT;
END;
/

ALTER TABLE superhero ADD power_id NUMBER;
UPDATE superhero SET power_id = 2 WHERE hero_id = 9;
UPDATE superhero SET power_id = 3 WHERE hero_id = 1;

ALTER TABLE superhero ADD CONSTRAINT fk_superhero_power_id
    FOREIGN KEY (power_id) REFERENCES superpower(power_id);


SELECT superhero.hero_name, superpower.power_name 
    FROM superhero full join superpower on superpower.power_id = superhero.power_id
    order by hero_ID, superpower.power_ID;

DESCRIBE superhero;

CREATE OR REPLACE PROCEDURE insert_hero_and_power 
(heroname IN VARCHAR2, powername IN VARCHAR2) AS
BEGIN
INSERT INTO superpower VALUES(powseq.NEXTVAL, powername);
INSERT INTO superhero VALUES(heroseq.NEXTVAL, heroname, powseq.CURRVAL);
COMMIT;
END;
/

execute insert_hero_and_power('Squirrel Girl','Squirrels');














