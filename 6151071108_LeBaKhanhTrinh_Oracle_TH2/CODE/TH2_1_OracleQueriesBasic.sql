-- (1) Oracle Queries: Basic

-- 1. Write a Oracle SQL query to get the details of all employees and also display the specific information of all employees.
SELECT * FROM employees;

-- 2. Write a Oracle SQL command to display the employee name, job and annual salary for all employees
SELECT first_name || ' ' || last_name AS employee_name, job_id, salary * 12 AS annual_salary FROM employees;

-- 3. Write a Oracle SQL query to get the total number of employees working in the company.
SELECT COUNT(*) FROM employees;

-- 4. Write a Oracle SQL query to get the total salary being paid to all employees.
SELECT SUM(salary) FROM employees;

-- 5. Write a Oracle SQL query to get the maximum and minimum salary from the employees table.
SELECT MAX(salary), MIN(salary) FROM employees;

-- 6. Write a Oracle SQL query to display the name of the employees in order to earning from lowest salary to highest.
SELECT first_name || ' ' || last_name AS employee_name, salary FROM employees ORDER BY salary;

--7. Write a Oracle SQL query to display the name of the employees in order to earning from highest salary to lowest.
SELECT first_name || ' ' || last_name AS employee_name, salary FROM employees ORDER BY salary DESC;

-- 8. Write a Oracle SQL query to display the name of the employees in order to alphabetically ascending order.
SELECT first_name || ' ' || last_name AS employee_name FROM employees ORDER BY last_name;

-- 9. Write a Oracle SQL query to display employee id, name, department no, salary of the employees. The output first based on the employee name in ascending order, for unique name department will come in ascending order, and for same name and department the highest salary will come first.
SELECT employee_id, first_name || ' ' || last_name AS employee_name, department_id, salary
FROM employees
ORDER BY first_name ASC, last_name ASC, department_id ASC, salary DESC;

-- 10. Write a Oracle SQL query to display the name and their annual salary. The result should contain those employees first who earning the highest salary.
SELECT first_name || ' ' || last_name AS employee_name, salary * 12 AS annual_salary 
FROM employees
ORDER BY salary DESC;

-- 11. Write a Oracle SQL query to display department id and total number of employees working in each department.
SELECT department_id, COUNT(*) as total_employees 
FROM employees
GROUP BY department_id;

-- 12. Write a Oracle SQL query to display the designation (job id) and total number of employees working in each designation.
SELECT job_id, COUNT(*) as total_employees 
FROM employees
GROUP BY job_id;

-- 13. Write a Oracle SQL query to display the department number and total salary for each department.
SELECT department_id, SUM(salary) as total_salary 
FROM employees
GROUP BY department_id;

-- 14. Write a Oracle SQL query to display the department number and maximum salary for each department.
SELECT department_id, MAX(salary) as max_salary 
FROM employees
GROUP BY department_id;

-- 15. Write a Oracle SQL query to display the designations (job id) and total salary allotted for each designation from the company.
SELECT job_id, SUM(salary) as total_salary 
FROM employees
GROUP BY job_id;

