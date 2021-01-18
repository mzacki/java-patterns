-- PLACEHOLDER
-- returns S plus 7 other chars
SELECT * FROM company
WHERE name LIKE 'S_______';

-- WILDCARD
-- returns sth before - L - sth after
SELECT * FROM company
WHERE name LIKE '%L%';

-- SELECT WITHOUT FROM
SELECT 123;
SELECT 9999 AS id, 'mock company' AS company_name;

