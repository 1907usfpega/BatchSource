create table bank_users(
user_id number primary key,
username varchar2(30) unique,
pasword varchar2(30));


create table bank_account(
bankaccount_id number primary key,
balance number);

create table user_account(
user_id number,
bankaccount_id number);

alter table user_account
add constraint fk_uacount_bankusers
foreign key (user_id) references bank_users(user_id);

alter table user_account
add constraint fk_uacount_bankaccount
foreign key (bankaccount_id) references bank_account(bankaccount_id);

alter table bank_users
add constraint uq_username
unique(username);

create sequence userseq
minvalue 1000
maxvalue 5000
start with 1001
increment by 1
cache 20;

create sequence accountseq
minvalue 10000
maxvalue 15000
start with 10001
increment by 1
cache 20;

create or replace procedure new_user(uname in varchar2, pword in varchar2)
as
begin
    insert into bank_users values(userseq.nextval, uname, pword);
    insert into bank_account values(accountseq.nextval,100);
    insert into user_account values(userseq.currval,accountseq.currval);
end;
/

create or replace procedure balance_update(bank_id in number, bal in number)
as
begin
    update bank_account
    set balance=bal
    where bankaccount_id=bank_id;
end;
/

create or replace procedure delete_acct(bank_id in number)
as
begin
    delete from user_account where bankaccount_id=bank_id;
    delete from bank_account where bankaccount_id=bank_id;
end;
/

create or replace procedure new_acct(userid in varchar)
as 
begin
    insert into bank_account values(accountseq.nextval, 0);
    insert into user_account values(userid,accountseq.currval);
end;
/

