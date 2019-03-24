drop database if exists cafe;
create database cafe;
use cafe;

create table customer (
    cus_id varchar(10),
    points int,
    account_balance double,
    password varchar(20),

    primary key (cus_id)
);

create table topping (
    topping_name varchar(10),
    price double,

    primary key (topping_name)
);

create table cafe (
    re_id varchar(10),
    location varchar(20),

    primary key (re_id)
);

create table employee (
    emp_id varchar(10),
    name varchar(20),
    birthday date,
    gender varchar(10),
    re_id varchar(10),

    primary key (emp_id),
    foreign key (re_id) references cafe(re_id) on delete set null
);

create table drink (
    drink_name varchar(10),
    ice_level int,
    sugar int,
    price double,
    emp_id varchar(10),

    primary key (drink_name),
    foreign key (emp_id) references employee(emp_id) on delete set null
);

create table orders (
    order_id varchar(10),
    total_price double,
    status varchar(10),
    t timestamp,
    cus_id varchar(10),
    re_id varchar(10),

    primary key (order_id),
    foreign key (cus_id) references customer(cus_id) on delete set null,
    foreign key (re_id) references cafe(re_id) on delete set null
);

# check foreign key constraint
create table payment (
    payment_id varchar(10),
    order_id varchar(10),
    emp_id varchar(10),
    platform varchar(20),

    primary key (payment_id, order_id),
    foreign key (order_id) references orders(order_id) on delete cascade,
    foreign key (emp_id) references employee(emp_id) on delete cascade
);

create table topping_with_drink (
    drink_name varchar(10),
    topping_name varchar(10),

    primary key (drink_name, topping_name),
    foreign key (drink_name) references drink(drink_name) on delete cascade,
    foreign key (topping_name) references topping(topping_name) on delete cascade
);

create table drink_has_order (
    order_id varchar(10),
    drink_name varchar(10),

    primary key (order_id, drink_name),
    foreign key (order_id) references orders(order_id) on delete cascade,
    foreign key (drink_name) references drink(drink_name) on delete cascade
);

insert into customer values('1203456789', 234, 423.2, '25f9e79432');
insert into topping values('pudding', 1.5);
insert into cafe values('3', 'san jose');
insert into employee values('89932', 'John Peter', '1992-7-04', 'male', '3');
insert into drink values('milk', 2, 3, 3.6, '89932');
insert into orders values('2285732', 10.8, 'complete', '2008-01-01 00:00:01', '1203456789', '3');
insert into payment values('77482', '2285732', '89932', 'cash');
insert into topping_with_drink values('milk', 'pudding');
insert into drink_has_order values('2285732', 'milk');

select * from drink_has_order;
