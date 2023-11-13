-- a) Get the names of employees from department “Information Technology” who are working on the “Database” project.
SELECT E.EmpName
FROM EMPLOYEE E
JOIN WORKS W ON E.EmpNo = W.EmpNo
JOIN PROJECT P ON W.ProjNo = P.ProjNo
JOIN DEPARTMENT D ON E.DeptNo = D.DeptNo
WHERE D.DeptName = 'Information Technology' AND P.ProjName = 'Database';
/
-- b) Get the names of all projects worked on by the employee named “Atuff Hady”.
SELECT P.ProjName
FROM PROJECT P
JOIN WORKS W ON P.ProjNo = W.ProjNo
JOIN EMPLOYEE E ON W.EmpNo = E.EmpNo
WHERE E.EmpName = 'Atuff Hady';
/
-- c) Get the projects name that have highest budget.
SELECT ProjName
FROM PROJECT
WHERE Budget = (SELECT MAX(Budget) FROM PROJECT);
/
-- d) Get the names of department that have less than 4 employees in it.
SELECT DeptName
FROM DEPARTMENT
WHERE NumOfStaff < 4;
/
-- e) Get the names and salaries of employees in the “Logistic” department who has a higher salary than the maximum salary in the “Accounting” department.
SELECT DISTINCT E.EmpName, E.Salary
FROM EMPLOYEE E
JOIN DEPARTMENT D1 ON E.DeptNo = D1.DeptNo
JOIN DEPARTMENT D2 ON D1.DeptName = 'Logistic' AND E.Salary > (SELECT MAX(Salary) FROM EMPLOYEE WHERE DeptNo = (SELECT DeptNo FROM DEPARTMENT WHERE DeptName = 'Accounting'));
/
-- f) Update the salary of the staffs in sales department so it would match the average salary of the staffs in HR department.
UPDATE EMPLOYEE
SET Salary = (SELECT AVG(Salary) FROM EMPLOYEE WHERE DeptNo = (SELECT DeptNo FROM DEPARTMENT WHERE DeptName = 'Human Resources'))
WHERE DeptNo = (SELECT DeptNo FROM DEPARTMENT WHERE DeptName = 'Sales');
/
-- g) Modify the WORKS table by adding in new column entry for duration required to complete the project.
ALTER TABLE WORKS
ADD Duration VARCHAR(50);
