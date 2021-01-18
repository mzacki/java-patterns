-- evaluate boolean value of query (0 as false, 1 as true)
SELECT 1 = 1 AS boolean_value; -- 1, true
SELECT 0 = 1 AS boolean_value; -- 0, false and so on.
SELECT 1 < 0 AS boolean_value;

-- AND (&& in some dialects)
SELECT 1 > 0 AND 1 = 1
SELECT 1 < 0 && 1 = 1

-- OR (|| in some dialects)
SELECT 1 < 0 OR 1 = 1
SELECT 1 > 0 || 1 = 1

-- <> (!=)
SELECT 1 <> 0;
SELECT 1 != 0;

-- NOT (sometimes: !)
SELECT NOT 1 != 0;

-- XOR
SELECT 1 = 0 XOR 1 = 1

-- arithmetic operators
SELECT 1 + 1 * 1 /  3
SELECT 3 % 5
