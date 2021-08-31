drop table if exists detail;
drop table if exists worker
drop table if exists car;
drop table if exists positions;


CREATE TABLE car(
id bigint NOT NULL AUTO_INCREMENT,
name_owner varchar(15),
name_car varchar(15),
mileage int,
power int,
is_electro bool not null,
is_hibrid bool not null,
DATA_TIME_START_FIX  datetime,
PRIMARY KEY (id));

CREATE TABLE detail(
id bigint NOT NULL AUTO_INCREMENT,
name varchar(15),
notes varchar(255),
PART_NUMBER int,
PURCHASE_PRICE double,
SELLING_PRICE double,
EXTRA_CHARGE smallint,
CAR_ID bigint,
DATA_TIME_DELIVERY datetime,
primary key(id),
FOREIGN KEY (car_id) REFERENCES car(id)
);

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
data_start_work date,
primary key(id),
);

INSERT INTO car(name_owner, name_car, mileage, power,  is_electro, is_hibrid, DATA_TIME_START_FIX)
values('IT-ACADEMY', 'ZAZ', 10000, 50, true, false, sysdate());

INSERT INTO detail (name, notes, PART_NUMBER, PURCHASE_PRICE, CAR_ID, DATA_TIME_DELIVERY)
values('POWER', 'THE BEST OF THE BEST', 1234567, 50.0, 1, sysdate());

INSERT INTO positions(status) values('MASTER');






