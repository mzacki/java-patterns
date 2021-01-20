-- update record
UPDATE company
SET name = 'Seoul 88'
WHERE name = 'SEOUL_88';

-- update record copying column from joint table
UPDATE company
    INNER JOIN
    customer
ON company.customer_id = customer.customer_id
    SET company.name = CONCAT(
        company.name,
        '_',
        customer.first_name,
        '_',
        customer.last_name);

-- REVERSE name
UPDATE company
    INNER JOIN
    customer
ON company.customer_id = customer.customer_id
SET company.name = REVERSE(company.name);

-- SUB / ADD DATE
UPDATE company
SET established_date = DATE_SUB(established_date, INTERVAL 1 YEAR)
WHERE
        established_date > '2020-01-01'

-- insert space before last three chars:
-- (e.g. Entity Ltd instead of EntityLtd)
-- remove last tree chars
-- concat string, space and last three chars
UPDATE company
SET name =CONCAT(LEFT(name, LENGTH(name) - 3), ' Ltd')
WHERE
        established_date > '2020-01-01'

-- substract 2 years from date in case of even year, odd id and given country
-- substract 1 year in case of even year, even odd and given country
UPDATE company
SET established_date = (
        CASE
            WHEN
                EXTRACT(YEAR from established_date) % 2 = 0
        AND
        company_id % 2 != 0
                AND
                        hq_country = 'USA'
            THEN DATE_SUB(established_date, INTERVAL 2 YEAR)
        WHEN
                        EXTRACT(YEAR from established_date) % 2 = 0
                AND
                        company_id % 2 = 0
                AND
                        hq_country = 'USA'
            THEN DATE_SUB(established_date, INTERVAL 1 YEAR)
        ELSE established_date
        END
    );

-- funny thing, UPDATE date (if null, use current) by reversing year
UPDATE company
SET established_date = CONCAT(
    -- CASE should be add for null check...
    REVERSE(EXTRACT(YEAR from CURDATE())),
                              '-',
                              EXTRACT(MONTH from CURDATE()),
                              '-',
                              EXTRACT(DAY from CURDATE()))
WHERE
        name = 'Ale Lipa';




