-- all customers of given name pattern and their current branches
SELECT * FROM
    customer
        INNER JOIN
    branch_customers bc
    ON
            customer.customer_id = bc.customer_id
        INNER JOIN
    branch b ON bc.branch_id = b.branch_id
WHERE
        customer.last_name LIKE '%smith%'
  AND
        bc.to_date = '9999-01-01'