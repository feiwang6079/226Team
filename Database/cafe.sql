drop database if exists cafe;
create database cafe;
use cafe;
create table orders(order_id varchar(8), total_price varchar(8), status varchar(8), t timestamp);
create table customer(cus_id varchar(10), points int, account_balance double, password char(40));


insert into customer values('1203456789', 234, 423.2, '25f9e794323b453885f5181f1b624d0b');
create table payment (order_id varchar(8), payment_id varchar(8));
insert into payment values('11', '123412');

insert into orders values('11', 15, 'paid', '2008-01-01 00:00:01');
insert into orders values('12', 10.2, 'unpaid', '2009-01-01 00:00:01');

select * from orders;