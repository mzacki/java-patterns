-- AGGREGATION functions: COUNT, MAX, MIN, AVG, SUM
SELECT
    COUNT(*) AS 'turnover records',
    COUNT(turnover) AS 'turnover records not empty',
    MAX(turnover) AS 'max turnover',
    MIN(turnover) AS 'min turnover',
    AVG(turnover) AS 'average turnover',
    SUM(turnover) AS 'in total'
FROM
    turnover;

-- COUNT grouped by GROUP BY
SELECT
	first_name,
	COUNT(*)
FROM
	customer
GROUP BY
	first_name;

-- HAVING
SELECT
    first_name,
    COUNT(*)
FROM
    customer
GROUP BY
    first_name
HAVING
    COUNT(*) > 250
ORDER BY
    COUNT(*) DESC;

-- WHERE is used before GROUP BY, after GROUP BY - HAVING
SELECT
    first_name,
    COUNT(*)
FROM
    customer
WHERE
    first_name
LIKE 'H%'
GROUP BY
    first_name
HAVING
    COUNT(*) > 200
ORDER BY
    COUNT(*) DESC;

