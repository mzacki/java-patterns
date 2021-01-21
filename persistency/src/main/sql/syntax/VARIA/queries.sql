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

-- count customers per current branch using view
SELECT customer_branch_turnover_current.branch_name,
       COUNT(*) AS customers_per_branch
FROM
    customer_branch_turnover_current -- view alias
GROUP BY
    branch_name

-- count customers per field (including past fields)
SELECT f.field_name,
       COUNT(*) AS customers_per_field FROM
    customer
        INNER JOIN
    field f on customer.customer_id = f.customer_id
GROUP BY
    f.field_name

-- customers per turnover range rounded to multiplicity of 10000
SELECT ROUND(customer_branch_turnover_current.turnover / 10000) AS range,
       COUNT(*) AS customers_per_turnover
FROM
    customer_branch_turnover_current -- view alias
GROUP BY
    range
