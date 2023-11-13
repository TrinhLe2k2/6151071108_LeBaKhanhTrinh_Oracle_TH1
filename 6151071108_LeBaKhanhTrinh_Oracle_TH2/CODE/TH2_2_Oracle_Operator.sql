--(2) Oracle Operator
-- 1. Write a query to list the name of all the employees who are working in department number 20.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE department_id = 20;

-- 2. Write a query to list the employees name and total salary of a year and yearly salary is more than $10000.
SELECT first_name || ' ' || last_name AS employee_name, salary * 12 AS annual_salary
FROM employees
WHERE salary * 12 > 10000;

-- 3. Write a query to list the employees name and salary who?s daily salary is more than $100.
SELECT first_name || ' ' || last_name AS employee_name, salary
FROM employees
WHERE salary > 100;

-- 4. Write a query to list the name of all the employees who are not working in department number 20.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE department_id != 20;

-- 5. Write a query to list the name of all the employees who are working as account manager and drawing a salary more than $5000.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE job_id = 'account manager' AND salary > 5000;

-- 6. Write a query to list the names of all the employees who are working as accountant in finance section and drawing a salary less than $20000.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE job_id = 'FI_ACCOUNT' AND department_id = 100 AND salary < 20000;

-- 7. Write a query to list the name of all the employees who are working as accountant in finance section and drawing a salary is greater than equal to $5000 and less than equal to $20000.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE job_id = 'FI_ACCOUNT' AND department_id = 100 AND salary BETWEEN 5000 AND 20000;

-- 8. Write a query to list the names, salary of all the employees who are working with a commission package.
SELECT first_name || ' ' || last_name AS employee_name, salary
FROM employees
WHERE commission_pct IS NOT NULL;

-- 9. Write a query to list the name, salary of all the employees where employee first name belongs in a specified list.
SELECT first_name || ' ' || last_name AS employee_name, salary
FROM employees
WHERE first_name IN ('Pat', 'David', 'Lex');

-- 10. Write a query to list the first name, last name, Job id of all the employees except &quot;PRESIDENT&quot; &amp; &quot;MGR&quot; in asc order of Salaries.\
SELECT first_name, last_name, job_id, salary
FROM employees
WHERE job_id NOT IN ('AD_PRES', 'FI_MGR')
ORDER BY salary ASC;

-- 11. Write a query to list the name (first and last name), hire date of all the employees who joined before or after 2005.
SELECT first_name || ' ' || last_name AS employee_name, hire_date
FROM employees
WHERE hire_date < TO_DATE('01-Jan-2005', 'dd-mon-yyyy')
/
SELECT first_name || ' ' || last_name AS employee_name, hire_date
FROM employees
WHERE hire_date > TO_DATE('31-Dec-2005', 'dd-mon-yyyy');


-- 12. Write query to list the name (first and last name), hire date of all the employees who joined on 1-JUL-2006,24-MAR-2007,04-JAN-2008 in ascending order of seniority.
SELECT first_name || ' ' || last_name AS employee_name, hire_date
FROM employees
WHERE hire_date IN (TO_DATE('01-Jul-2006', 'dd-mon-yyyy'), TO_DATE('24-Mar-2007', 'dd-mon-yyyy'), TO_DATE('04-Jan-2008', 'dd-mon-yyyy'))
ORDER BY hire_date ASC;
/
select * from employees where hire_date IN (TO_DATE('07-Jun-1994', 'dd-mon-yyyy'));

-- 13. Write a query to concatenate first name, last name and job id from employees table in the following format.
SELECT first_name || ' ' || last_name || ' - ' || job_id AS employee_info
FROM employees;

-- 14. Write a query to list the employees who are joined in the year between &#39;01-Jan-2004&#39; and &#39;31-Dec-2008&#39;.
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE hire_date BETWEEN TO_DATE('01-Jan-2004', 'dd-mon-yyyy') AND TO_DATE('31-Dec-2008', 'dd-mon-yyyy');
/

select * from employees order by hire_date
/
SELECT first_name || ' ' || last_name AS employee_name
FROM employees
WHERE hire_date BETWEEN TO_DATE('01-SEP-1989', 'dd-mon-yyyy') AND TO_DATE('07-JUN-1994', 'dd-mon-yyyy');