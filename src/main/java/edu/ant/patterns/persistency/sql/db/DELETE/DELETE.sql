-- DELETE row duplicates (copies)
DELETE FROM
    company
WHERE
    company.name LIKE '%_COPY'