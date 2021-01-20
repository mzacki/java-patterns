-- UNION merges multiple queries as one result
SELECT
    1 AS id, 'Sunrise Ltd.' AS name
UNION
SELECT
    2 AS id, 'Sunset Co.' AS name;

-- only distinct rows are included
SELECT
    1 AS id, 'Sunrise Ltd.' AS name
UNION
SELECT
    1 AS id, 'Sunrise Ltd.' AS name;

-- UNION ALL allows duplicated rows
SELECT
    * FROM company
UNION ALL
SELECT
    * FROM company;

-- UNION from different tables is possible but the result set must have same number of columns
-- error:
SELECT
    * FROM company
UNION ALL
SELECT
    * FROM customer;

-- works:
SELECT
    name, customer_id FROM company
UNION ALL
SELECT
    CONCAT(last_name, ' ', first_name), customer_id FROM customer;

-- UNION workaround instead of OUTER JOIN (without LEFT / RIGHT JOIN)
-- customer_id must be not null
SELECT name, company.customer_id FROM
    company
        INNER JOIN
    customer
        ON
    company.customer_id = customer.customer_id
UNION
SELECT name, company.customer_id FROM
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

-- above workaround with all columns from both tables included
-- and rows with null customer_id
SELECT * FROM -- returns columns from company and customer
    company
        INNER JOIN
    customer
    ON
            company.customer_id = customer.customer_id
UNION
SELECT *, NULL, NULL, NULL, NULL, NULL, NULL FROM
-- returns colums from company only (no join), so null to replace missing columns from customer
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
        company.customer_id IS NULL;

--//TODO how to make the workaround from above without LEFT JOIN and without UNION ???