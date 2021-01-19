-- create table in the db currently in use, set columns and their type
CREATE TABLE company (
    company_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (255) NOT NULL,
    established_date DATE,
    hq_country VARCHAR (4),
    PRIMARY KEY (company_id),
    -- constraint on column
    -- CHECK (established_date >= '2000-01-01')
    -- constraint on multiple columns
    -- CONSTRAINT CHK_Company CHECK (established_date >= '2000-01-01' AND hq_country NOT LIKE 'Z%')
);

-- add column with ALTER TABLE
ALTER TABLE company
    ADD customer_id INT;

-- insert rows
INSERT INTO company (name, established_date, hq_country)
VALUES ('Sunrise Ltd', '1987-06-26', 'JPN'),
('SEOUL_88', '1988-09-17', 'KOR');

-- select (view) particular columns
SELECT name, country FROM company;

-- select all columns from given table
SELECT * FROM company;

-- select where clause
SELECT * FROM company
WHERE hq_country='JPN';

-- in some sql dialects field name containing date must be within ticks, not single quotes, otherwise it's string and does not work!
SELECT * FROM company
WHERE hq_country='JPN' AND `established_date` < '1987-06-26';

SELECT * FROM company
WHERE hq_country='JPN' OR hq_country='KOR';

-- elastic search, limit
SELECT * FROM company
WHERE name LIKE 'S%' LIMIT 2;

-- group by (counts rows grouped by country)
-- name may be replaced by any column
SELECT COUNT(name), hq_country FROM company
GROUP BY hq_country;

-- order result
SELECT birth_date, first_name, last_name FROM customer
WHERE first_name LIKE 'Fran%' ORDER BY first_name, last_name ASC;

SELECT birth_date, first_name, last_name FROM customer
WHERE first_name LIKE 'Fran%' ORDER BY `birth_date` DESC;

-- remove table
-- DROP TABLE company;