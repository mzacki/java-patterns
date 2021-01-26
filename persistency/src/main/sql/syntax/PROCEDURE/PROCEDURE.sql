-- STORED PROCEDURE - SQL query saved directly in db as a function
-- such function accepts argument being used to execute query within stored procedure
-- procedure can be then called multiple times with different args

-- HOW TO CREATE
DELIMITER
$$
CREATE PROCEDURE get_company_by_country_code(
    country_code VARCHAR (4)
)
BEGIN
    IF
country_code IS NULL
THEN
SELECT 'Function argument is null'
    ELSE
SELECT *
FROM company
WHERE company.hq_country = country_code;
END IF;
END $$

-- HOW TO CALL
CALL get_company_by_country_code('JPN') -- returns result
$$
CALL get_company_by_country_code(null) -- returns hard-coded answer
$$
CALL get_company_by_country_code() -- returns error as arg is expected
$$