drop table if exists positions;
drop table if exists detail;
drop table if exists orders_worker;
drop table if exists worker;
drop table if exists orders;
drop table if exists car;

CREATE TABLE orders(
id bigint NOT NULL AUTO_INCREMENT,
first_name_client varchar(25) not null,
last_name_client varchar(25) not null,
phone_number int DEFAULT 0,
volume_bonus smallint(50) DEFAULT 0,
bill decimal DEFAULT 0,
is_cash bool DEFAULT false,
data_time_request datetime DEFAULT sysdate(),
primary key(id)
);

CREATE TABLE car(
id bigint NOT NULL AUTO_INCREMENT,
name_owner varchar(15) not null,
name_car varchar(15) not null,
mileage int DEFAULT 0,
power int DEFAULT 0,
is_electro bool DEFAULT false,
is_hibrid bool DEFAULT false,
DATA_TIME_START_FIX  datetime DEFAULT sysdate(),
order_id bigint DEFAULT 0,
PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders(id));

CREATE TABLE detail(
id bigint NOT NULL AUTO_INCREMENT,
name varchar(15) not null,
notes varchar(255) not null,
PART_NUMBER int DEFAULT 0,
PURCHASE_PRICE double DEFAULT 0,
SELLING_PRICE double DEFAULT 0,
EXTRA_CHARGE smallint DEFAULT 0,
CAR_ID bigint DEFAULT 0,
DATA_TIME_DELIVERY datetime DEFAULT sysdate(),
primary key(id),
FOREIGN KEY (car_id) REFERENCES car(id));

CREATE TABLE positions(
id bigint NOT NULL AUTO_INCREMENT,
status varchar(15) not null,
primary key(id)
);

CREATE TABLE worker(
id bigint NOT NULL AUTO_INCREMENT,
first_name varchar(15) not null,
second_name varchar(15) not null,
salary decimal DEFAULT 0,
bonus smallint(100) DEFAULT 0,
phone_number int DEFAULT 0,
is_cheif bool DEFAULT false,
data_time_start_work datetime DEFAULT sysdate(),
position_id bigint DEFAULT 0,
primary key(id),
FOREIGN KEY (position_id) REFERENCES positions(id)
);

CREATE TABLE orders_worker (
  order_id bigint NOT NULL,
  worker_id bigint NOT NULL,
  PRIMARY KEY (order_id, worker_id),
  FOREIGN KEY (order_id) REFERENCES orders(id),
  FOREIGN KEY (worker_id) REFERENCES worker(id));

INSERT INTO orders(first_name_client, last_name_client)
values ('OMA', 'HR');
INSERT INTO orders(first_name_client, last_name_client)
values ('MATERIK', 'SALES');
INSERT INTO orders(first_name_client, last_name_client)
values ('MILE', 'SEQURITY');

INSERT INTO car(name_owner, name_car)
values('KOSTISHKO', 'ZAZ');
INSERT INTO car(name_owner, name_car)
values('GARMAZA', 'LADA');
INSERT INTO car(name_owner, name_car)
values('SELEDKA', 'GEELY');

INSERT INTO detail (name, notes)
values('POWER', 'THE BEST OF THE BEST');
INSERT INTO detail (name, notes)
values('PASS', 'CONTINENTAL');
INSERT INTO detail (name, notes)
values('KEY', 'BROLE DOWN ELECTRONIC');

INSERT INTO positions(status) values('MASTER');
INSERT INTO positions(status) values('ASSISTANT');
INSERT INTO positions(status) values('MECHANIC');

INSERT INTO worker(second_name, first_name, data_time_start_work)
values ('KAZAK', 'VADIM', '2015-09-01');
INSERT INTO worker(second_name, first_name, data_time_start_work)
values ('SAKHARUK', 'ALIAKSANDR', '2018-01-09');
INSERT INTO worker(second_name, first_name, data_time_start_work)
values ('SALAPURA', 'PETIA', '2019-10-01');


INSERT INTO orders_worker(order_id, worker_id) values(1,1);
INSERT INTO orders_worker(order_id, worker_id) values(2,2);
INSERT INTO orders_worker(order_id, worker_id) values(3,3);






