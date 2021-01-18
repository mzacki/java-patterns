-- INNER JOIN returns records with matching values in both tables (here: customer_id)
SELECT * FROM
    customer
INNER JOIN
    field f ON customer.customer_id = f.customer_id
WHERE
    f.field_name = 'Engineer';

-- INNER JOIN with two more tables, both contain customer_id
SELECT  * FROM
    customer
        INNER JOIN
    field f on customer.customer_id = f.customer_id
        INNER JOIN
    turnover t on customer.customer_id = t.customer_id
WHERE
        customer.registration_date > '2000-01-01'
   OR (
       customer.birth_date < '1980-01-01'
    AND
       t.turnover < 10000
    )
   OR (
       customer.birth_date < '1960-01-01'
    AND
       f.field_name NOT LIKE  '%Engineer%'
    );

-- INNER JOIN shows only the records from company that have customer id NOT NULL
-- use OUTER JOINS: LEFT / RIGTH JOIN etc. if expect null fields to be included
SELECT * FROM
    company
INNER JOIN
    customer c ON company.customer_id = c.customer_id

-- CROSS JOIN joins all rows from one table with all rows of second table
-- on given condition
-- without condition it makes Cartesian product
SELECT * FROM
    customer
        CROSS JOIN
    company
WHERE
        customer.customer_id = company.customer_id

-- USING
SELECT * FROM
    company
        INNER JOIN
    customer USING(customer_id);

SELECT last_name, name
    FROM
    company
        INNER JOIN
    customer USING(customer_id);