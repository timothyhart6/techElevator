-- INSERT

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES ('USA', 'Klingon', false, 0);
-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES ('GBR', 'Klingon', false, 0);

-- UPDATE

-- 1. Update the capital of the USA to Houston
UPDATE country SET capital = 3796 WHERE code = 'USA'
-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country SET capital = 3818, headofstate = 'Donald Trump' WHERE code = 'USA'

-- DELETE

-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage where countrycode = 'USA' AND language = 'English'
-- 2. Delete all occurrences of the Klingon language 
DELETE FROM countrylanguage where language = 'Klingon'

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
INSERT INTO countrylanguage (language) VALUES ('Klingon');
-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES ('ZZZ', 'English', false, 0);
-- 3. Try deleting the country USA. What happens?
DELETE FROM country WHERE code = 'USA'

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES ('USA', 'English', false, 0);
-- 2. Try again. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES ('USA', 'English', false, 0);
-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country SET continent = 'Outer Space' WHERE code = 'USA';

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
START TRANSACTION;
DELETE from countrylanguage;
SELECT * FROM countrylanguage;
ROLLBACK;
-- 2. Try updating all of the cities to be in the USA and roll it back
START TRANSACTION;
select * from city;
UPDATE city SET countrycode = 'USA';
ROLLBACK;
-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.

