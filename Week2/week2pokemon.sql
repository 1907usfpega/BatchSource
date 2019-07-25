select * from artist;

--manipulate schema
--create a table
--datatypes in sql: number, varchar, varchar2, date, timestamp, blob, clob
--constraints: primary key, foreign key, unique, not null, and check
--not null ensure the record has a value in this column
--column
--primary key: it represents the official unique identifies for the tbl
-- PK is a combo of uniq and not null
--Foreign key is a ref point to another tbl's pk
--ex syntax:Foreign key (ref_attribute_from_this_table
--Check creates an additional custom cond for the column
--ex syntax: Constraint contraint_name check (column_name >15)
--
--


create table pokemon(
    pokemon_id number(15), 
    pokemon_name varchar2(100),
    pokemon_type varchar(25),
    Primary KEY(pokemon_id)
);

--describes the structure of the table
desc pokemon;
describe pokemon;
--ddl: drop
--drop table pokemon;
--ddl: alter
alter table pokemon add pokemon_secontype varchar2(25);
/*not going to do an example BUT truncate deltes all entries into the table while keeping the table structure intact. DROP is 
like throwing a cup of water into the trash, while TRUNCATE is like pouring out the water and keeping the cup.
*/
select * from pokemon
order by pokemon_id;

--DML: insert
insert into pokemon values(1, 'bulbasaur', 'grass', 'ice');
insert into pokemon values(7, 'squirtle', 'water', null);
insert into pokemon values(121, 'starmie', 'water', 'psychic');
insert into pokemon values(25, 'pikachu', 'electric', null);

--
insert into pokemon(pokemon_name, pokemon_id, pokemon_type)
values('blastoise', 9, 'water');

--now, try to insert one of these records again to demonstrate the 
--unique constraint

--DML: Update
update pokemon set pokemon_secontype='poison' where pokemon_id=1;
--DML:Delete
delete from pokemon where pokemon_id=121;
delete from pokemon;
commit;
rollback;