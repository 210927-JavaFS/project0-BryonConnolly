

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS animals;

--starting simple
CREATE TABLE accounts(
	username VARCHAR(40) PRIMARY KEY,
	password VARCHAR(40),
	tickets INTEGER,
	is_admin BOOLEAN,
	preferred_name VARCHAR(80)
	
	);

CREATE TABLE animals( --fill this IN java
	name VARCHAR(3) PRIMARY KEY
--	tickets integer
);

--TODO connect animals with accounts/players





