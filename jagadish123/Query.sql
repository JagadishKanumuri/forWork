create table Customer1(
name varchar(30) primary key,
age  number(30) not null,
gender varchar(30) not null,
phone number(30) not null
);


insert into Customer1 values('jagadish',22,'male',9999);
insert into Customer1 values('nikilendra',21,'male',8888);
insert into Customer1 values('hari',20,'male',7777);

select * from Customer1;

drop table Customer1;

delete from Customer1 where name='hari';

update Customer1 set age=20 ,gender='male', phone=9988 where name='hari';

select * from Customer1 where name='nikilendra';