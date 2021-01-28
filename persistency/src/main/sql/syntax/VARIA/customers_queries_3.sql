-- 1. Group and count customers by name
SELECT last_name, COUNT(*) AS number FROM customer
GROUP BY last_name
ORDER BY number DESC

-- 2. Count customers of same first and last name
SELECT first_name, last_name, COUNT(*) AS number FROM customer
GROUP BY first_name, last_name
ORDER BY number DESC

-- 3. Select first name of customers whose age average is below 50
SELECT first_name, AVG(
            EXTRACT(YEAR FROM CURDATE()) - EXTRACT(YEAR FROM birth_date)
    ) FROM customer
GROUP BY first_name
HAVING AVG(
                   EXTRACT(YEAR FROM CURDATE()) -
                   EXTRACT(YEAR FROM birth_date)
           ) < 50

-- 4. Select customers whose registration age is shorter than avg
SELECT first_name, last_name,
       EXTRACT(YEAR FROM CURDATE()) - EXTRACT(YEAR FROM registration_date)
           AS avg_registration_age FROM customer
HAVING avg_registration_age < (
    SELECT AVG(EXTRACT(YEAR  FROM CURDATE()) -
               EXTRACT(YEAR FROM registration_date))
    FROM customer
)
ORDER BY avg_registration_age ASC

-- 5. Count customers per field within given branch
SELECT branch_name, field_name,
    COUNT(customer.customer_id) AS customers FROM customer
    INNER JOIN
    branch_customers bc ON customer.customer_id = bc.customer_id
    INNER JOIN
    branch ON bc.branch_id = branch.branch_id
    INNER JOIN
    field f ON customer.customer_id = f.customer_id
GROUP BY
    branch_name, field_name
ORDER BY branch_name, customers DESC

-- 6. Most profitable fields within branch
SELECT branch_name, field_name,
       AVG(t.turnover) AS avg_turnover
FROM customer
         INNER JOIN
     branch_customers bc ON customer.customer_id = bc.customer_id
         INNER JOIN
     branch ON bc.branch_id = branch.branch_id
         INNER JOIN
     field f ON customer.customer_id = f.customer_id
         INNER JOIN
     turnover t ON customer.customer_id = t.customer_id
GROUP BY
    branch_name, field_name
ORDER BY branch_name, avg_turnover DESC