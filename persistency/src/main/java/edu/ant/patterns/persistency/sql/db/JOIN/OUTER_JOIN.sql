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
SELECT * FROM
    company
        LEFT OUTER JOIN
    customer c ON company.customer_id = c.customer_id
UNION
SELECT * FROM
    company
        RIGHT OUTER JOIN
    customer c ON company.customer_id = c.customer_id
ORDER BY company_id DESC

-- workaround of FULL OUTER JOIN without using LEFT / RIGHT JOIN
SELECT * FROM
    company
        INNER JOIN
    customer
    ON
            company.customer_id = customer.customer_id
UNION
SELECT *, NULL, NULL, NULL, NULL, NULL, NULL FROM
    company
WHERE
    NOT
            company.customer_id
            IN
            (
                SELECT DISTINCT
                    company.customer_id
                FROM
                    company
                        INNER JOIN
                    customer
                    ON
                            company.customer_id = customer.customer_id
            )
   OR
    company.customer_id IS NULL
UNION
SELECT
       NULL, NULL, NULL, NULL, NULL,
       customer.customer_id, customer.birth_date, customer.first_name,
       customer.last_name, customer.gender, customer.registration_date
FROM customer
ORDER BY company_id DESC
    LIMIT 10;