-- (3) Oracle Wildcard special Operators
-- 1. Write a Oracle SQL statement to get the first date of the current month.
SELECT TRUNC(SYSDATE, 'MONTH') AS first_day_of_month FROM dual;

-- 2. Write a Oracle SQL statement to get the last date of the current month.
SELECT LAST_DAY(SYSDATE) AS last_day_of_month FROM dual;

-- 3. Write a Oracle SQL statement to get the current date in the specified session time zone.
SELECT SYSTIMESTAMP AT TIME ZONE 'MST' AS current_date_with_timezone FROM dual;

-- 4. Write a Oracle SQL statement to determine how many days are left in the current month.
SELECT LAST_DAY(SYSDATE) - SYSDATE AS days_left_in_month FROM dual;

-- 5. Write a Oracle SQL statement to get the first and last day of the current year.
SELECT TRUNC(SYSDATE, 'YEAR') AS first_day_of_year, TRUNC(TRUNC(SYSDATE, 'YYYY') + INTERVAL '1' YEAR - INTERVAL '1' DAY) AS last_day_of_year FROM dual;

-- 6. Write a Oracle SQL statement to get the number of days in current month.
SELECT EXTRACT(DAY FROM LAST_DAY(SYSDATE)) AS number_of_days_in_current_month FROM dual;

-- 7. Write a Oracle SQL statement to get number of days between two given dates.
SELECT TO_DATE('2023-12-31', 'YYYY-MM-DD') - TO_DATE('2023-01-01', 'YYYY-MM-DD') AS number_of_days_between FROM dual;

-- 8. Write a Oracle SQL statement to get the start date and end date of each month in current year from current month.
SELECT TRUNC(ADD_MONTHS(SYSDATE, LEVEL - 1), 'MONTH') AS start_date_of_month, LAST_DAY(ADD_MONTHS(SYSDATE, LEVEL - 1)) AS end_date_of_month
FROM dual
CONNECT BY LEVEL <= 12;

