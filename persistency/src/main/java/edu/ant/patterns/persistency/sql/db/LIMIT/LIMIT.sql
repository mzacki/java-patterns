-- first argument: number of rows to omit
-- second argument: number of rows to include

SELECT
    company.name, hq_country,
    CASE
        hq_country
        WHEN 'JPN' THEN 'OK'
        WHEN 'KOR' THEN 'OK'
        ELSE 'Non-Asian'
        END AS country_check
FROM
    company
        LIMIT 2, 999;