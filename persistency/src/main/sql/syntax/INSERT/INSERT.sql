-- How many records (customer ids) in db
SELECT COUNT(*)
FROM customer;

-- Find the highest id
SELECT customer_id
FROM customer
ORDER BY customer_id DESC LIMIT 1;

-- INSERT
INSERT INTO customer(customer_id, birth_date, first_name, last_name, gender, registration_date)
VALUES (500000, '1972-06-06', 'Noriaki', 'Kasai', 'M', '2021-01-12');

-- INSERT (short version - autoincrement / default value will be put in case of ommited values,
-- if such property is set on columns, in this case it is not)
INSERT INTO customer
VALUES (500001, '1996-11-06', 'Ryoyu', 'Kobayashi', 'M', '2021-01-12');
-- auto_increment is set
INSERT INTO company(name, hq_country)
VALUES ('Ale Lipa', 'POL'),

-- bulk row INSERT
INSERT INTO customer
VALUES
    (500002, '1991-06-11', 'Jun', 'Kobayashi', 'M', '2021-01-12'),
    (500003, '1994-05-16', 'Yuka', 'Kobayashi', 'F', '2021-01-12');

-- INSERT preselected row while editing some fields
INSERT INTO customer(customer_id, birth_date, first_name, last_name, gender, registration_date)
SELECT 2,
       birth_date,
       'Facelia',
       last_name,
       'F',
       registration_date
FROM customer
WHERE customer_id = 10001;

-- same thing with auto_increment id, IN keyword used
INSERT INTO company(name, established_date, hq_country)
SELECT 'Ale Lipa New Name',
       '1990-01-01',
       hq_country
FROM company
WHERE company_id IN (3, 4);

-- INSERT duplicated records with name suffix
INSERT INTO company(name, established_date, hq_country)
SELECT CONCAT(name, '_COPY'),
       established_date,
       hq_country
FROM company

-- INSERT copied / partially modified records into company for each joint customer
    INSERT
INTO company(name, established_date, hq_country, customer_id)
SELECT CONCAT(first_name, ' ', last_name, ' Sole Trader'),
       CURDATE(),
       hq_country,
       c.customer_id
FROM company
         INNER JOIN
     customer c on company.customer_id = c.customer_id

-- similar INSERT: for each record in branch table, create entry in company table
    INSERT
INTO company(name, established_date, hq_country)
SELECT CONCAT(branch_name, ' Ltd'),
       CURDATE(),
       'USA'
FROM branch