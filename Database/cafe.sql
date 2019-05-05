drop database if exists cafe;
create database cafe;
use cafe;
create table orders(order_id int NOT NULL auto_increment, total_price double, status varchar(8) default 'unpaid', t timestamp not null DEFAULT CURRENT_TIMESTAMP, cus_id double, re_id varchar(10), PRIMARY key(order_id));
create table customer(cus_id int NOT NULL auto_increment, points double, account_balance double, password char(40),PRIMARY KEY (cus_id));
create table employee(emp_id varchar(10), name varchar(10), gender varchar(4), re_id char(10) );
create table cafe(re_id varchar(10), location varchar(20));

create table order_drink (order_id int, drink_id varchar(20));

create table drink(drink_id int NOT NULL auto_increment, ice_level varchar(4), sugar_level varchar(4), price double, emp_id varchar(10), tea_name varchar(10), PRIMARY KEY (drink_id));
create table tea(tea_name varchar(10), price double);
create table sugar(sugar_level varchar(10));
create table ice(ice_level varchar(10));
create table topping(topping_name varchar(20), price double);
insert into topping values('boba', 0.5); insert into topping values('Jelly grass', 0.5);insert into topping values('pudding', 0.5);insert into topping values('red beans', 0.5);

insert into ice values('100%');insert into ice values('50%');insert into ice values('30%');insert into ice values('0%');insert into ice values('hot');
insert into sugar values('100%');insert into sugar values('50%');insert into sugar values('30%');insert into sugar values('0%');


insert into tea values('OL', 1.2);
insert into drink values('1001', '30', '50', 50.00, 'emp_01', 'Oolong');

insert into order_drink values('001', '001');
insert into cafe values('cafe_01', 'SJSU');
insert into cafe values('cafe_02', 'WestField');
insert into employee values('emp_01', 'Wen Li', 'F', 'SJSU');
insert into customer values('1203456789', 234, 423.2, '25f9e794323b453885f5181f1b624d0b');
create table payment (order_id long, payment_id varchar(8));
insert into payment values('11', '123412');

insert into orders values('11', 15, 'paid', '2008-01-01 00:00:01', '1203456789', 'cafe_01');
insert into orders values('12', 10.2, 'unpaid', '2009-01-01 00:00:01','1203456789', 'cafe_01');

select * from payment;

--create view
CREATE VIEW emp_order AS SELECT emp_id, tea_name, drink.order_id, cus_id, status 
FROM drink, orders 
where drink.order_id = orders.order_id;