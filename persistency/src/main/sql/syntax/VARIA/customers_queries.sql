-- all customers of given name pattern and their current branches
SELECT * FROM
    customer
        INNER JOIN
    branch_customers bc
    ON
            customer.customer_id = bc.customer_id
        INNER JOIN
    branch b ON bc.branch_id = b.branch_id
WHERE
        customer.last_name LIKE '%smith%'
  AND
        bc.to_date = '9999-01-01'

-- count customers per current branch using view
SELECT customer_branch_turnover_current.branch_name,
       COUNT(*) AS customers_per_branch
FROM
    customer_branch_turnover_current -- view alias
GROUP BY
    branch_name

-- count customers per field (including past fields)
SELECT f.field_name,
       COUNT(*) AS customers_per_field FROM
    customer
        INNER JOIN
    field f on customer.customer_id = f.customer_id
GROUP BY
    f.field_name

-- customers per turnover range rounded to multiplicity of 10000
SELECT ROUND(customer_branch_turnover_current.turnover / 10000) AS range,
       COUNT(*) AS customers_per_turnover
FROM
    customer_branch_turnover_current -- view alias
GROUP BY
    range

-- create stored procedure: branches per name
DELIMITER
$$
CREATE PROCEDURE get_branch_names()
BEGIN
SELECT branch.branch_name
FROM branch
END $$

-- 0. create procedure update turnover per branch:
-- 1. alter table branch - add column turnover
-- 2. join customer to current branch
-- 3. sum current turnover of customers per branch (grouped)
-- 4. update branch.column with given value

-- STEP 0. create procedure skeleton as above
-- STEP 1. MariaDB allows if exists, MySql needs a workaround (to be added)
ALTER TABLE branch
    ADD turnover BIGINT NULL;
-- STEP 2-4. fill the body of procedure as follows
UPDATE branch
    INNER JOIN
    (
    SELECT b.branch_id AS join_id, b.branch_name, SUM(turnover.turnover) AS turnover_current FROM
    turnover
    INNER JOIN
    branch_customers bc
    ON
    turnover.customer_id = bc.customer_id
    INNER JOIN
    branch b ON bc.branch_id = b.branch_id
    WHERE
    turnover.to_date = '9999-01-01' -- current
    AND
    bc.to_date = '9999-01-01' -- current
    GROUP BY
    branch_name
    ) AS joint_tables
SET branch.turnover = joint_tables.turnover_current
WHERE branch.branch_id = joint_tables.join_id

-- create company procedure
DELIMITER
$$
CREATE PROCEDURE create_company(
    company_name VARCHAR(255),
    established DATE,
    country VARCHAR(4))
BEGIN
INSERT INTO company(name, established_date, hq_country)
VALUES(company_name, established, country);
END $$

-- create procedure showing current customers for given branch
DELIMITER
$$
CREATE PROCEDURE show_customers_for_branch(
    branch_name VARCHAR(255))
BEGIN
-- //TODO add check if passed branch exists in branch table
-- if not select error alert
SELECT customer.*
FROM customer
         INNER JOIN
     branch_customers
     ON
             customer.customer_id = branch_customers.customer_id
         INNER JOIN
     branch
     ON
             branch_customers.branch_id = branch.branch_id
WHERE
        branch_customers.to_date = '9999-01-01'
  AND
        branch.branch_name = branch_name;
END
$$



