-- db cursor is a kind of a pointer similar to Java iterator
-- implemented as stored procedure
-- cursor iterates through records one by one
DELIMITER $$
CREATE PROCEDURE pointer()
BEGIN
    -- variables holding values of colums in row that are currently being traversed by cursor
    DECLARE cursor_company_id INT;
    DECLARE cursor_company_name VARCHAR(255);
    DECLARE cursor_country_code VARCHAR(4);
    -- boolean variable (false / true flag) showing if cursor iteration is finished
    DECLARE iteration_completed BIT DEFAULT 0;
    -- cursor declaration
    DECLARE company_cursor CURSOR FOR
    SELECT company_id, name, hq_country FROM company;
    -- handler of continue type launched when not found occurs
    -- not found means no more rows to iterate
    -- in case of not found flag is raised
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET iteration_completed = 1;
    -- opening cursor and fetching first row, procedure starts
    -- first row is mapped to declared variables
    OPEN company_cursor;
    FETCH company_cursor INTO cursor_company_id, cursor_company_name, cursor_country_code;
    -- 'WHILE' loop (do as long as no empty rows)
    WHILE iteration_completed = 0 DO
    SELECT cursor_company_id, cursor_company_name, cursor_country_code; -- displaying declared variables containing values currently being traversed by cursor
    FETCH company_cursor INTO cursor_company_id, cursor_company_name, cursor_country_code; -- map another row to declared variables, repeat the flow
    END WHILE;
    -- procedure ends, cursor closed
    CLOSE company_cursor;
END
