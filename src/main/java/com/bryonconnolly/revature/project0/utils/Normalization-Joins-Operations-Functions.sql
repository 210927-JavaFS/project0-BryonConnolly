DROP TABLE IF EXISTS avengers;
DROP TABLE IF EXISTS homes;

--0NF

CREATE TABLE avengers (
	superhero_name VARCHAR(30) NOT NULL,
	superhero_power VARCHAR(150),
	real_name VARCHAR (50),
	power_level INTEGER,
	home_name VARCHAR(50),
	home_address VARCHAR(200)
);

--1NF
DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_name VARCHAR(30) NOT NULL,
	superhero_power VARCHAR(150),
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	power_level INTEGER,
	home_name VARCHAR(50),
	home_number VARCHAR(10),
	home_street VARCHAR(50),
	home_city VARCHAR(50),
	home_region VARCHAR(50),
	home_zip VARCHAR(15),
	home_country VARCHAR (20)
);

ALTER TABLE avengers ADD PRIMARY KEY (superhero_name, first_name, last_name);

--this is bad practice, don't do it. 
INSERT INTO avengers VALUES ('capt. america', 'magic frisbee', 'steve', 'rogers', 50, 'stark tower',
	'123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

INSERT INTO avengers VALUES ('capt. america', 'magic frisbee', 'bucky', 'barnes', 75, 'stark tower',
	'123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

INSERT INTO avengers VALUES ('hawkeye', 'paleolithic weapons expert', 'clint', 'barton', 505, 'stark tower',
	'123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

--2NF

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name VARCHAR(30) NOT NULL,
	superhero_power VARCHAR(150),
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	power_level INTEGER,
	home_name VARCHAR(50),
	home_number VARCHAR(10),
	home_street VARCHAR(50),
	home_city VARCHAR(50),
	home_region VARCHAR(50),
	home_zip VARCHAR(15),
	home_country VARCHAR (20)
);



INSERT INTO avengers (superhero_name,	superhero_power,	first_name,	last_name,	power_level,	home_name,	home_number,	home_street,	home_city,	home_region,	home_zip,	home_country) 
	VALUES ('capt. america', 'magic frisbee', 'steve', 'rogers', 50, 'stark tower', '123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

INSERT INTO avengers (superhero_name,	superhero_power,	first_name,	last_name,	power_level,	home_name,	home_number,	home_street,	home_city,	home_region,	home_zip,	home_country) 
	VALUES ('capt. america', 'magic frisbee', 'bucky', 'barnes', 75, 'stark tower', '123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

INSERT INTO avengers (superhero_name,	superhero_power,	first_name,	last_name,	power_level,	home_name,	home_number,	home_street,	home_city,	home_region,	home_zip,	home_country) 
	VALUES ('hawkeye', 'paleolithic weapons expert', 'clint', 'barton', 505, 'stark tower', '123', 'stark lane', 'new york', 'ny', '10587', 'usa'); 

--3NF

DROP TABLE IF EXISTS avengers;

CREATE TABLE powers (
	superhero_name VARCHAR(30) PRIMARY KEY,
	superhero_power VARCHAR(150)
);

CREATE TABLE homes (
	home_name VARCHAR(50) PRIMARY KEY,
	home_number VARCHAR(10),
	home_street VARCHAR(50),
	home_city VARCHAR(50),
	home_region VARCHAR(50),
	home_zip VARCHAR(15),
	home_country VARCHAR (20)
);

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name VARCHAR(30) REFERENCES powers(superhero_name) NOT NULL,
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	power_level INTEGER,
	home_name VARCHAR(50) REFERENCES homes(home_name)
);

INSERT INTO powers (superhero_name, superhero_power)
	VALUES ('capt. america', 'magic frisbee'), ('hawkeye', 'paleolithic weapons expert'); 

INSERT INTO powers (superhero_name, superhero_power)
	VALUES ('hulk', 'rage machine'); 

INSERT INTO homes (home_name, home_number, home_street, home_city, home_region, home_zip, home_country)
	VALUES ('stark tower', '123', 'stark lane', 'new york', 'ny', '10587', 'usa');

INSERT INTO homes (home_name, home_number, home_street, home_city, home_region, home_zip, home_country)
	VALUES ('helicarrier', '111', 'patomic river', 'washington', 'dc', '20105', 'usa');

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('capt. america', 'steve', 'rogers', 50, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('capt. america', 'bucky', 'barnes', 75, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('hawkeye', 'clint', 'barton', 505, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('hulk', 'bruce', 'banner', 8505, null);

--JOINS

SELECT * FROM avengers a INNER JOIN avengers h ON h.home_name = a.home_name;

SELECT * FROM avengers AS a LEFT JOIN homes AS h ON h.home_name = a.home_name;

SELECT * FROM avengers AS a RIGHT JOIN homes AS h ON h.home_name = a.home_name;

SELECT * FROM avengers FULL JOIN homes ON avengers.home_name = homes.home_name;

--Subquery

SELECT * FROM (SELECT * FROM avengers AS a FULL JOIN homes AS h ON h.home_name = a.home_name) 
	AS avhome FULL JOIN powers AS p ON p.superhero_name = avhome.superhero_name;

--Scalar and Aggregate

SELECT UPPER (superhero_name) AS sup_names FROM avengers; --SCALAR

SELECT AVG (power_level) AS avg_power FROM avengers; --AGGREGATE

--GROUP BY

SELECT superhero_name, SUM(power_level) FROM avengers GROUP BY superhero_name 
	ORDER BY superhero_name DESC;

--Union

SELECT superhero_name, last_name FROM avengers UNION SELECT home_name, home_street FROM homes;

--Triggers/Functions

ALTER TABLE homes ADD COLUMN residents INTEGER;

CREATE OR REPLACE FUNCTION increase_residents() RETURNS TRIGGER AS 
$$
BEGIN 
	UPDATE homes SET residents = 
		(SELECT residents FROM homes WHERE NEW.home_name = homes.home_name)+1 
		WHERE homes.home_name = NEW.home_name;
		RETURN NEW;
END
$$
LANGUAGE plpgsql;

CREATE TRIGGER increment_residents AFTER INSERT ON avengers
	FOR EACH ROW EXECUTE PROCEDURE increase_residents();

UPDATE homes SET residents = 0 WHERE home_name = 'stark tower';
UPDATE homes SET residents = 0 WHERE home_name = 'helicarrier';

TRUNCATE TABLE avengers; 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('capt. america', 'steve', 'rogers', 50, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('capt. america', 'bucky', 'barnes', 75, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('hawkeye', 'clint', 'barton', 505, 'stark tower'); 

INSERT INTO avengers (superhero_name,	first_name,	last_name,	power_level,	home_name) 
	VALUES ('hulk', 'bruce', 'banner', 8505, null);





