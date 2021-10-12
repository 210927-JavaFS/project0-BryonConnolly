

DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS prize_options;
DROP TABLE IF EXISTS redemptions;

CREATE TABLE accounts(
	username VARCHAR(40) PRIMARY KEY,
	passwordX VARCHAR(40),
	tickets INTEGER,
	is_admin BOOLEAN,
	preferred_name VARCHAR(80)
	
	);

--first admin account added by this script
--future admins can be promoted by this admin
--and can later delete this one if desired
INSERT INTO accounts (username,passwordX,is_admin)
	VALUES('admin','password',true);


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
