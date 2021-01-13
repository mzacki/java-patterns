-- INNER JOIN shows only the records from company table that have customer id NOT NULL
-- (can be joined with relevant rows from customer table)
-- use LEFT / RIGTH JOIN if expects null rows with NULL customer_id to be included
SELECT * FROM
    company
INNER JOIN
    customer c ON company.customer_id = c.customer_id

-- LEFT JOIN shows all rows from left table (company) - even the records that cannot be joined
-- with customer table records due to NULL customer_id in company table
SELECT * FROM
    company
LEFT JOIN
    customer c ON company.customer_id = c.customer_id

-- on the other hand, RIGHT JOIN shows all rows from right table (customer)
-- - even the records that cannot be joined with company table
-- due to missing customer_id in company table
SELECT * FROM
    company
RIGHT JOIN
    customer c ON company.customer_id = c.customer_id

-- FULL OUTER JOIN lists all rows from both tables
-- no matter if NULL
-- FULL OUTER JOIN is not supported in MySql
-- workaround: https://www.xaprb.com/blog/2006/05/26/how-to-write-full-outer-join-in-mysql/