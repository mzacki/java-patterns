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

UPDATE company
    INNER JOIN
    customer
ON company.customer_id = customer.customer_id
SET company.name = REVERSE(company.name);
