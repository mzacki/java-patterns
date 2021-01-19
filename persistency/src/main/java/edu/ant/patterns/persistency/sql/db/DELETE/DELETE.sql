-- DELETE row duplicates (copies)
DELETE FROM
    company
WHERE
    company.name LIKE '%_COPY'

-- JOIN DELETE
-- joining three tables, delete records from two (branch remains intact)
DELETE customer, bc FROM
customer
INNER JOIN
    branch_customers bc
ON
    customer.customer_id = bc.customer_id
INNER JOIN
    branch b
ON
    bc.branch_id = b.branch_id
WHERE
    customer.last_name LIKE '%smith%'
AND
    bc.to_date = '9999-01-01'
AND
    customer.gender = 'M'