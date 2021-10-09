-- This is a single line comment

/*
	This is a multi-line comment just like Java. 
*/

--DDL

--CREATE DATABASE demos;

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(150),
	real_name VARCHAR(50),
	power_level INTEGER
);

ALTER TABLE avengers ADD COLUMN active BOOLEAN;

TRUNCATE TABLE avengers;

--DML

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level) 
	VALUES ('capt. america', 'ultimate frisbee champion', 'steve rogers', 50),
	('iron man', 'being super rich', 'tony stark', 300);

UPDATE avengers SET active = TRUE WHERE superhero_name = 'iron man';
UPDATE avengers SET active = FALSE WHERE superhero_name = 'capt. america';

DELETE FROM avengers WHERE power_level < 100;

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level, active)
	VALUES ('hawkeye', 'massive biceps', 'clint barton', 3700, TRUE);

--DQL

SELECT superhero_name, power_level FROM avengers; 

SELECT * FROM avengers WHERE power_level > 500; 

SELECT * FROM avengers ORDER BY real_name ASC;

--TCL

BEGIN;
INSERT INTO avengers (superhero_name, superhero_power)
	VALUES ('hulk', 'anger issues');
UPDATE avengers SET real_name = 'bruce banner' WHERE superhero_name = 'hulk';
UPDATE avengers SET power_level = 8001 WHERE superhero_name = 'hulk';
UPDATE avengers SET active = TRUE WHERE superhero_name = 'hulk';
COMMIT;

--ROLLBACK;

DELETE FROM avengers WHERE superhero_name = 'hulk';

-- Constraints

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30) NOT NULL,
	superhero_power VARCHAR(150) NOT NULL UNIQUE,
	real_name VARCHAR(50) NOT NULL,
	power_level INTEGER CHECK (power_level > 0),
	active BOOLEAN DEFAULT FALSE
);

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level) 
	VALUES ('capt. america', 'ultimate frisbee champion', 'steve rogers', 50),
	('iron man', 'being super rich', 'tony stark', 300);


INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level, active)
	VALUES ('hawkeye', 'massive biceps', 'clint barton', 3700, TRUE);

CREATE TABLE homes (
	home_name VARCHAR(100) PRIMARY KEY,
	home_address VARCHAR(150) NOT NULL UNIQUE
);

INSERT INTO homes (home_name, home_address) VALUES ('stark tower', '123 stark blvd, new york, ny');

ALTER TABLE avengers ADD COLUMN home VARCHAR(100) REFERENCES homes(home_name);

UPDATE avengers SET home = 'stark tower' WHERE superhero_name = 'iron man';



