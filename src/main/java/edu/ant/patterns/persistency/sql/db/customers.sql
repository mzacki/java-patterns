DROP DATABASE IF EXISTS customers;
CREATE DATABASE IF NOT EXISTS customers;
USE customers;

DROP TABLE IF EXISTS branch_customers,
    branch_top_customer,
    field,
    turnover,
    customer,
    branch;

CREATE TABLE customer (
                           customer_id      INT             NOT NULL,
                           birth_date  DATE            NOT NULL,
                           first_name  VARCHAR(14)     NOT NULL,
                           last_name   VARCHAR(16)     NOT NULL,
                           gender      ENUM ('M','F')  NOT NULL,
                           registration_date   DATE            NOT NULL,
                           PRIMARY KEY (customer_id)
);

CREATE TABLE branch (
                             branch_id     CHAR(4)         NOT NULL,
                             branch_name   VARCHAR(40)     NOT NULL,
                             PRIMARY KEY (branch_id),
                             UNIQUE  KEY (branch_name)
);

CREATE TABLE branch_top_customer (
                              customer_id       INT             NOT NULL,
                              branch_id      CHAR(4)         NOT NULL,
                              from_date    DATE            NOT NULL,
                              to_date      DATE            NOT NULL,
                              FOREIGN KEY (customer_id)  REFERENCES customer (customer_id)    ON DELETE CASCADE,
                              FOREIGN KEY (branch_id) REFERENCES branch (branch_id) ON DELETE CASCADE,
                              PRIMARY KEY (customer_id,branch_id)
);

CREATE TABLE branch_customers (
                          customer_id      INT             NOT NULL,
                          branch_id     CHAR(4)         NOT NULL,
                          from_date   DATE            NOT NULL,
                          to_date     DATE            NOT NULL,
                          FOREIGN KEY (customer_id)  REFERENCES customer   (customer_id)  ON DELETE CASCADE,
                          FOREIGN KEY (branch_id) REFERENCES branch (branch_id) ON DELETE CASCADE,
                          PRIMARY KEY (customer_id,branch_id)
);

CREATE TABLE field (
                        customer_id      INT             NOT NULL,
                        field_name       VARCHAR(50)     NOT NULL,
                        from_date   DATE            NOT NULL,
                        to_date     DATE,
                        FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE,
                        PRIMARY KEY (customer_id,field_name, from_date)
)
;

CREATE TABLE turnover (
                          customer_id      INT             NOT NULL,
                          turnover      INT             NOT NULL,
                          from_date   DATE            NOT NULL,
                          to_date     DATE            NOT NULL,
                          FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE,
                          PRIMARY KEY (customer_id, from_date)
)
;

CREATE OR REPLACE VIEW branch_customers_latest_date AS
SELECT customer_id, MAX(from_date) AS from_date, MAX(to_date) AS to_date
FROM branch_customers
GROUP BY customer_id;

# view current branch only for each customer
CREATE OR REPLACE VIEW current_branch_customers AS
SELECT l.customer_id, branch_id, l.from_date, l.to_date
FROM branch_customers d
         INNER JOIN branch_customers_latest_date l
                    ON d.customer_id=l.customer_id AND d.from_date=l.from_date AND l.to_date = d.to_date;