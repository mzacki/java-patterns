-- PLACEHOLDER
-- returns S plus 7 other chars replaced by underscore
SELECT * FROM company
WHERE name LIKE 'S_______';

-- WILDCARD
-- returns sth before - L - sth after
SELECT * FROM company
WHERE name LIKE '%L%';

-- SELECT WITHOUT FROM
SELECT 123;
SELECT 9999 AS id, 'mock company' AS company_name;

-- NULL CHECK
SELECT IFNULL('GIVEN ARGUMENT (NOT NULL)', 'Exception: given argument is NULL') AS null_check; -- returns first arg
SELECT IFNULL(null, 'Exception: given argument is NULL') AS null_check; -- returns second arg

-- TERNARY OPERATOR
SELECT IF(0 = 0, 'TRUE', 'FALSE') AS ternary_operator; -- returns second arg
SELECT IF(1 = 0, 'TRUE', 'FALSE') AS ternary_operator; -- returns third arg

-- COALESCE
SELECT COALESCE(NULL, NULL, 'it is a first not null arg!') AS coalesce; -- returns first not null arg available

-- CASE
SELECT
    company.name, hq_country,
    CASE
        WHEN hq_country LIKE 'JPN' THEN 'OK'
        WHEN hq_country LIKE 'KOR' THEN 'OK'
        ELSE 'Non-Asian'
        END AS country_check
FROM
    company;

-- CASE - another version
SELECT
    company.name, hq_country,
    CASE
        hq_country
        WHEN 'JPN' THEN 'OK'
        WHEN 'KOR' THEN 'OK'
        ELSE 'Non-Asian'
        END AS country_check
FROM
    company;