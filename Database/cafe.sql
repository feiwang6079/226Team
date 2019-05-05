drop database if exists cafe;
create database cafe;
use cafe;

create table orders(order_id int NOT NULL auto_increment, total_price double, 
status varchar(8) default 'unpaid', t timestamp not null DEFAULT CURRENT_TIMESTAMP, 
cus_id long, re_id varchar(10), 
PRIMARY key(order_id));

create table customer(cus_id int NOT NULL auto_increment, points double, account_balance double, password char(40),PRIMARY KEY (cus_id));
create table employee(emp_id varchar(10), name varchar(10), gender varchar(4), re_id char(10) );
create table cafe(re_id varchar(10), location varchar(20));

create table drink(drink_id int NOT NULL auto_increment, ice_level varchar(4), 
sugar_level varchar(4),
topping varchar(20),
price double, emp_id varchar(10), 
tea_name varchar(10), 
PRIMARY KEY (drink_id), order_id int
, foreign key  (order_id) REFERENCES orders(order_id) ON delete CASCADE
);

create table tea(tea_name varchar(20), price double);
create table sugar(sugar_level varchar(10));
create table ice(ice_level varchar(10));
create table topping(topping_name varchar(20), price double);
insert into topping values('boba', 0.5); insert into topping values('Jelly grass', 0.5);insert into topping values('pudding', 0.5);insert into topping values('red beans', 0.5);
insert into ice values('100%');insert into ice values('50%');insert into ice values('30%');insert into ice values('0%');insert into ice values('hot');
insert into sugar values('100%');insert into sugar values('50%');insert into sugar values('30%');insert into sugar values('0%');
insert into tea values('Oolong', 1.2);
insert into cafe values('cafe_01', 'SJSU');
insert into cafe values('cafe_02', 'WestField');
insert into employee values('emp_01', 'Wen Li', 'F', 'SJSU');
insert into customer values('12345', 234, 423.2, '827ccb0eea8a706c4c34a16891f84e7b');
insert into customer values('1203456789', 234, 423.2, '827ccb0eea8a706c4c34a16891f84e7b');

create table payment ( payment_id  int NOT NULL auto_increment, orders_order_id long, primary key(payment_id));

insert into orders values('1', 15, 'paid', '2008-01-01 00:00:01', '1203456789', 'cafe_01');
insert into orders values('2', 10.2, 'unpaid', '2009-01-01 00:00:01','1203456789', 'cafe_01');
insert into drink values(1, '30', '50', 'boba', 50.00, 'emp_01', 'Oolong', '1');
insert into payment values('1', '1');

insert into tea values('Tieguanyin', 1.2);
insert into tea values('Jasmine', 1.2);
insert into tea values('peach white', 1.2);
-- select * from customer;
-- update orders set total_price = total_price +5;
-- orders



CREATE VIEW emp_order AS SELECT emp_id, tea_name, drink.order_id, cus_id, status 
FROM drink, orders 
where drink.order_id = orders.order_id;



DROP PROCEDURE IF EXISTS PAY;
DELIMITER $$
CREATE PROCEDURE PAY(in my_cus_id int, in my_order_id int, out message varchar(30))
BEGIN
	DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET 	`_rollback` = 1;
    START TRANSACTION;
    
	SELECT total_price INTO @my_total_price
		FROM orders
		WHERE order_id = my_order_id;
	
	SELECT account_balance INTO @my_account_balance
		FROM customer
		WHERE cus_id = my_cus_id;
	
    set @my_orders_order_id = null;
	SELECT orders_order_id INTO @my_orders_order_id
		FROM payment
		WHERE orders_order_id = my_order_id;
        
    IF @my_orders_order_id IS NOT NULL THEN
        SET message= @my_orders_order_id;
		SET message= "Order is paid";
    ELSEIF @my_account_balance >= @my_total_price THEN
		UPDATE customer
			SET account_balance = account_balance - @my_total_price
				WHERE cus_id = my_cus_id;
        
        UPDATE orders
			SET status = 'paid'
				WHERE order_id = my_order_id;
        
        INSERT INTO payment (orders_order_id) VALUES (my_order_id);
        
		SET message= "Succeed!";
	ELSE
		SET message= "Not enough balance";
	END IF;
    
	IF `_rollback` THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
END
$$
DELIMITER ;