

DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS prize_options;
DROP TABLE IF EXISTS redemptions;

CREATE TABLE accounts(
	username VARCHAR(40) PRIMARY KEY UNIQUE,
	password VARCHAR(100),
	tickets INTEGER,
	is_admin BOOLEAN,
	preferred_name VARCHAR(80)
	
	);

--first admin account added by this script
--future admins can be promoted by this admin
--and can later delete this one if desired.
--password is : password
--encoded_password is : $2a$16$tHT0bpiyC9pLK5KbEFbjQuHKX1Tfu7TGRXlheLmRF0NjKV6NxXPNG
INSERT INTO accounts (username,password,is_admin)
	VALUES('admin','$2a$16$tHT0bpiyC9pLK5KbEFbjQuHKX1Tfu7TGRXlheLmRF0NjKV6NxXPNG',true);

INSERT INTO accounts (username,password,is_admin)
	VALUES('bryon','$2a$16$zmPKZQZONs6sVg7jc67z8edqjsN0EE1AHEX6dXG9atsDMTHPZRa9K',true);

CREATE TABLE animals( --fill this IN java
	name VARCHAR(3) PRIMARY KEY
--	tickets integer
);

--TODO connect animals with accounts/players


CREATE TABLE prize_options(
	prize_option_name VARCHAR(40) PRIMARY KEY,
	description VARCHAR(140),
	quantity_available INTEGER,
	price_in_tickets INTEGER

);

INSERT INTO prize_options (prize_option_name,description,quantity_available,price_in_tickets)
	VALUES 	('toy','a fun one',10,10),
			('candy','yum yum',10,10),
			('ball','it bounces',10,10);

CREATE TABLE redemptions(
	username VARCHAR(40) REFERENCES accounts(username) NOT NULL,
	prize_option_name VARCHAR(40) REFERENCES prize_options(prize_option_name)
);
