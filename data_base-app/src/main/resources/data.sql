drop table if exists positions;
drop table if exists detail;
drop table if exists orders_worker;
drop table if exists worker;
drop table if exists orders;
drop table if exists car;

CREATE TABLE orders(
id bigint NOT NULL AUTO_INCREMENT,
first_name_client varchar(25),
last_name_client varchar(25),
phone_number int,
volume_bonus smallint(50),
bill decimal,
is_cash bool,
data_time_request datetime,
primary key(id)
);

CREATE TABLE car(
id bigint NOT NULL AUTO_INCREMENT,
name_owner varchar(15) not null,
name_car varchar(15) not null,
mileage int,
power int,
is_electro bool,
is_hibrid bool,
DATA_TIME_START_FIX  datetime,
order_id bigint,
PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders(id));

CREATE TABLE detail(
id bigint NOT NULL AUTO_INCREMENT,
name varchar(15) not null,
notes varchar(255),
PART_NUMBER int,
PURCHASE_PRICE double,
SELLING_PRICE double,
EXTRA_CHARGE smallint,
CAR_ID bigint,
DATA_TIME_DELIVERY datetime,
primary key(id),
FOREIGN KEY (car_id) REFERENCES car(id));

CREATE TABLE positions(
id bigint NOT NULL AUTO_INCREMENT,
status varchar(15),
primary key(id)
);

CREATE TABLE worker(
id bigint NOT NULL AUTO_INCREMENT,
first_name varchar(15),
second_name varchar(15),
salary decimal,
bonus smallint(100),
phone_number int,
is_cheif bool,
data_time_start_work datetime,
position_id bigint,
primary key(id),
FOREIGN KEY (position_id) REFERENCES positions(id)
);

CREATE TABLE orders_worker (
  order_id bigint NOT NULL,
  worker_id bigint NOT NULL,
  PRIMARY KEY (order_id, worker_id),
  FOREIGN KEY (order_id) REFERENCES orders(id),
  FOREIGN KEY (worker_id) REFERENCES worker(id));

INSERT INTO orders(first_name_client, last_name_client, volume_bonus, phone_number, bill, is_cash)
values ('OMA', 'HR', 20, 292020202, 1500.55, true);
INSERT INTO orders(first_name_client, last_name_client, volume_bonus, phone_number, bill, is_cash)
values ('MATERIK', 'SALES', 10, 291111111, 15.23, false);
INSERT INTO orders(first_name_client, last_name_client, volume_bonus, phone_number, bill, is_cash)
values ('MILE', 'SEQURITY', 50, 292222222, 1200, true);

INSERT INTO car(name_owner, name_car, mileage, power,  is_electro, is_hibrid, order_id, DATA_TIME_START_FIX)
values('KOSTISHKO', 'ZAZ', 10000, 50, true, false, 1, sysdate());
INSERT INTO car(name_owner, name_car, mileage, power,  is_electro, is_hibrid, order_id, DATA_TIME_START_FIX)
values('GARMAZA', 'LADA', 1300, 50, false, false, 2, sysdate());
INSERT INTO car(name_owner, name_car, mileage, power,  is_electro, is_hibrid, order_id, DATA_TIME_START_FIX)
values('SELEDKA', 'GEELY', 500, 50, false, false, 3, sysdate());

INSERT INTO detail (name, notes, PART_NUMBER, PURCHASE_PRICE, CAR_ID, DATA_TIME_DELIVERY)
values('POWER', 'THE BEST OF THE BEST', 1234567, 50.0, 1, sysdate());
INSERT INTO detail (name, notes, PART_NUMBER, PURCHASE_PRICE, CAR_ID, DATA_TIME_DELIVERY)
values('PASS', 'CONTINENTAL', 838924, 100.0, 2, sysdate());
INSERT INTO detail (name, notes, PART_NUMBER, PURCHASE_PRICE, CAR_ID, DATA_TIME_DELIVERY)
values('KEY', 'BROLE DOWN ELECTRONIC', 123442, 55, 3, sysdate());

INSERT INTO positions(status) values('MASTER');
INSERT INTO positions(status) values('ASSISTANT');
INSERT INTO positions(status) values('MECHANIC');

INSERT INTO worker(second_name, first_name, salary, is_cheif, position_id, data_time_start_work)
values ('KAZAK', 'VADIM', 10000.55, true, 1, '2015-09-01');
INSERT INTO worker(second_name, first_name, salary, is_cheif, position_id, data_time_start_work)
values ('SAKHARUK', 'ALIAKSANDR', 10.55, false, 2, '2018-01-09');
INSERT INTO worker(second_name, first_name, salary, is_cheif, position_id, data_time_start_work)
values ('SALAPURA', 'PETIA', 1000, false, 3, '2019-10-01');


INSERT INTO orders_worker(order_id, worker_id) values(1,1);
INSERT INTO orders_worker(order_id, worker_id) values(2,2);
INSERT INTO orders_worker(order_id, worker_id) values(3,3);






