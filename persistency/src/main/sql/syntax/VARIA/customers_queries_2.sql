-- 1. SELECT id, first and last name of all customers, sort ascending by birth year
SELECT customer_id, first_name, last_name,
EXTRACT(YEAR FROM birth_date) AS born FROM customer
ORDER BY born ASC

-- 2. SELECT id, first and last name of all customers, born after 1960
SELECT customer_id, first_name, last_name,
EXTRACT(YEAR FROM birth_date) AS born FROM customer
WHERE
EXTRACT(YEAR FROM birth_date) > 1960

-- 3. SELECT id, first and last name of all customers, first and last name starts with X
SELECT customer_id, first_name, last_name,
EXTRACT(YEAR FROM birth_date) AS born FROM customer
WHERE
first_name LIKE 'X%'
AND
last_name LIKE 'X%'

-- 4. SELECT all first names (without repetition) and count which are most popular
SELECT DISTINCT first_name, COUNT(*) AS occurences
FROM customer
GROUP BY first_name
ORDER BY occurences DESC

-- 5. SELECT birth years of all Xiahuas or Xinans
SELECT first_name, EXTRACT(YEAR FROM birth_date) FROM customer
WHERE
    first_name LIKE 'Xiahua'
OR
    first_name LIKE 'Xinan'

-- 6. SELECT all data of X names born after 1960
SELECT * FROM customer
WHERE
first_name LIKE 'X%'
AND
EXTRACT(YEAR FROM birth_date) > 1960

-- 7. SELECT birth years and count occurences of Xiahuas and Xinans
SELECT EXTRACT(YEAR FROM birth_date) AS born,
COUNT(*) AS occurences FROM customer
WHERE
first_name IN('Xiahua', 'Xinan')
GROUP BY born

-- 8. Ten oldest customers
SELECT customer_id, first_name, last_name,
       birth_date AS born FROM customer
ORDER BY birth_date ASC
    LIMIT 10

-- 9. Omit first ten, get another ten of the oldest customer
SELECT customer_id, first_name, last_name,
       birth_date AS born FROM customer
ORDER BY birth_date ASC
    LIMIT 10, 10

-- 10. How many customers?
SELECT COUNT(customer_id) AS customers_total FROM customer

-- 11. Year of birth of the youngest customer
SELECT EXTRACT(YEAR FROM birth_date) AS latest_birth_year
FROM customer
ORDER BY birth_date DESC
    LIMIT 1

-- 12. How old is the oldest customer?
SELECT EXTRACT(YEAR FROM CURDATE()) -
       EXTRACT(YEAR FROM birth_date) AS age_of_the_senior
FROM customer
ORDER BY birth_date ASC
    LIMIT 1

-- 13. Average age of female customer
SELECT AVG(EXTRACT(YEAR  FROM CURDATE()) -
           EXTRACT(YEAR FROM birth_date)) AS avg_female_age
FROM customer
WHERE gender = 'F'

-- 14. Sum of age of all customers
SELECT SUM(EXTRACT(YEAR  FROM CURDATE()) -
           EXTRACT(YEAR FROM birth_date)) AS total_age
FROM customer

-- 15. All data of the senior customer (subquery)
SELECT * FROM customer
WHERE customer_id IN (
    SELECT customer_id
    FROM customer
    ORDER BY birth_date ASC
)
    LIMIT 1

-- 16. Customers registered later than given person
SELECT * FROM customer
WHERE registration_date > (
    SELECT registration_date FROM customer
    WHERE first_name = 'Mr. X'
      AND last_name = 'Mr. Y'
)
ORDER BY  registration_date DESC

-- 17. Select last name of such customers, whose first name is equal to
-- first name of Japanese-like last names
SELECT DISTINCT last_name FROM customer
WHERE first_name IN (
    SELECT first_name FROM customer
    WHERE last_name LIKE '%shi'
       OR last_name LIKE '%to'
       OR last_name LIKE '%ura'
)