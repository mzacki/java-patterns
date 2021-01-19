-- JOIN through third table
SELECT *
FROM customer
         INNER JOIN
     branch_customers
     ON
         customer.customer_id = branch_customers.customer_id
         INNER JOIN
     branch
     ON
         branch_customers.branch_id = branch.branch_id

-- how many CUSTOMERS per BRANCH ?
SELECT branch_name, COUNT(*) AS number_of_customers
FROM customer
         INNER JOIN
     branch_customers
     ON customer.customer_id = branch_customers.customer_id
         INNER JOIN
     branch
     ON branch_customers.branch_id = branch.branch_id
GROUP BY branch_name