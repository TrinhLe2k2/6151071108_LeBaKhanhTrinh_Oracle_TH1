-- (4) Oracle Queries: where statement
-- 1. Write a Oracle SQL query to get the employee no, first name and last name for those employees who are earning commission.
SELECT employee_id, first_name, last_name, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

-- 2. Write a Oracle SQL query to get the employee id, first_name and last_name for those employees do not earn any commission.
SELECT employee_id, first_name, last_name
FROM employees
WHERE commission_pct IS NULL;

-- 3. Write a Oracle SQL query to get the the first_name and last_name of the employees who are working as &#39;ST_CLERK&#39;, &#39;SA_MAN&#39; or &#39;IT_PROG&#39; and drawing a salary more than 3000.
SELECT first_name, last_name
FROM employees
WHERE (job_id IN ('ST_CLERK', 'SA_MAN', 'IT_PROG')) AND (salary > 3000);

-- 4. Write a Oracle SQL query to get the first_name and last_name, job_id, department_id of the employees who are working in the department no 10 or 20 or 40 or employees working as &#39;ST_CLERK&#39;, &#39;SA_MAN&#39; or &#39;IT_PROG&#39;.
SELECT first_name, last_name, job_id, department_id
FROM employees
WHERE (department_id IN (10, 20, 40)) OR (job_id IN ('ST_CLERK', 'SA_MAN', 'IT_PROG'));

-- 5. Write a Oracle SQL query to get the first_name and last_name of the employees whose first_name are exactly five characters in length.
SELECT first_name, last_name
FROM employees
WHERE LENGTH(first_name) = 5 AND LENGTH(last_name) = 5;

-- 6. Write a Oracle SQL query to get the the first_name and last_name of the employees who are not working as &#39;AC_MGR&#39;.
SELECT first_name, last_name
FROM employees
WHERE job_id != 'AC_MGR';

-- 7. Write a Oracle SQL query to get the the first_name and last_name of the employees who are not working as &#39;ST_CLERK&#39;, &#39;SA_MAN&#39; or &#39;IT_PROG&#39;.
SELECT first_name, last_name
FROM employees
WHERE job_id NOT IN ('ST_CLERK', 'SA_MAN', 'IT_PROG');

-- 8. Write a Oracle SQL query to get the maximum salary being paid to &#39;ST_CLERK&#39;.
SELECT MAX(salary)
FROM employees
WHERE job_id = 'ST_CLERK';

-- 9. Write a Oracle SQL query to get the maximum salary being paid to department ID.
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;

-- 10. Write a Oracle SQL query to get the minimum salary being paid to SA_MAN.
SELECT MIN(salary)
FROM employees
WHERE job_id = 'SA_MAN';

-- 11. Write a Oracle SQL query to get the total salary drawn by &#39;SA_MAN&#39; working in the department number 80.
SELECT SUM(salary)
FROM employees
WHERE job_id = 'SA_MAN' AND department_id = 80;

-- 12. Write a Oracle SQL query to get the department number with more than 10 employees in each department.
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 10;

-- 13. Write a Oracle SQL query to get the designations (jobs) along with the total salary for those designations where total salary is more than 50000.
SELECT job_id, SUM(salary)
FROM employees
GROUP BY job_id
HAVING SUM(salary) > 50000;

-- 14. Write a Oracle SQL query to get the designations (jobs) along with the total number of employees in each designation. The output should contain only those jobs with more than three employees.
SELECT job_id, COUNT(*)
FROM employees
GROUP BY job_id
HAVING COUNT(*) > 3;
