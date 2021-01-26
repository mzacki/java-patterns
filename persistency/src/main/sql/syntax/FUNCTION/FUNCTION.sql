-- CREATE FUCTION
DELIMITER $$
CREATE FUNCTION logarithm(
    base INT,
    n INT
    )
    RETURNS INT DETERMINISTIC -- like idempotent but does not alter db state even in first call
BEGIN
-- DECLARE local variables
DECLARE a INT DEFAULT 2;
DECLARE b INT;
SET b = n;
IF base > 1
    THEN SET a = base -- log base cannot be 0 or 1, use default 2 in such case
IF n <= 0
    THEN RETURN NULL -- n must be > 0, return null as log cannot be counted
RETURN LOG(a, n);
END$$

-- HOW TO CALL
SELECT logarithm(2, 128)$$