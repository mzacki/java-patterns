-- VIEW acts like reusable saved SELECT
-- is stored directly in db

CREATE VIEW company_left_join_customer AS
SELECT company.*,
       c.customer_id AS customer_number, -- table name even in different tables must be unique
       c.first_name,
       c.last_name,
       c.registration_date
FROM
    company
        LEFT JOIN customer c ON company.customer_id = c.customer_id;

-- example of use
SELECT * FROM company_left_join_customer; -- view alias

-- customer, current branch, current turnover
CREATE VIEW customer_branch_turnover_current AS
SELECT
    customer.customer_id,
    customer.first_name,
    customer.last_name,
    customer.registration_date,
    b.branch_name,
    bc.from_date AS branch_since,
    t.turnover,
    t.from_date AS monthly_turnover_since
FROM
    customer
        INNER JOIN
    branch_customers bc
    ON customer.customer_id = bc.customer_id
        INNER JOIN
    branch b
    ON bc.branch_id = b.branch_id
        INNER JOIN
    turnover t
    ON customer.customer_id = t.customer_id
WHERE
        bc.to_date = '9999-01-01'
  AND
        t.to_date = '9999-01-01'