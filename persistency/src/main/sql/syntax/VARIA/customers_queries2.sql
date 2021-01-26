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

