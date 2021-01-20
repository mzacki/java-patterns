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
        LEFT JOIN customer c ON company.customer_id = c.customer_id

-- example of use
SELECT * FROM company_left_join_customer -- view alias