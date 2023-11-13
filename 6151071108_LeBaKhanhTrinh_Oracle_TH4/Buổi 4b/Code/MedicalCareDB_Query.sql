--a. Retrieve the name and address of patients who live in Hanoi and treated by Dr. Jaspal.
SELECT p.PatientName, p.Address
FROM Patients p
JOIN Treatments t ON p.PatientID = t.PatientID
JOIN Doctors d ON d.DoctorID = t.DoctorID
WHERE p.City = 'Hanoi' AND d.DoctorName = 'Dr. Jaspal';

--b. Retrieve the name and salary of all doctors who can treat “Cancer” disease and earn more than RM55,000.
SELECT DoctorName, Salary
FROM Doctors
WHERE DoctorID IN (
    SELECT DoctorID
    FROM Treatments
    JOIN Patients ON Treatments.PatientID = Patients.PatientID
    WHERE Disease = 'Cancer'
    GROUP BY DoctorID
    HAVING MIN(Salary) > 55000
);

--c. Retrieve the name, sex and age of every patient in room 679 at Saigon Hospital.
SELECT PatientName, Sex, TRUNC(MONTHS_BETWEEN(SYSDATE, BirthDate) / 12) AS Age
FROM Patients
WHERE Room = 679 AND HospitalID = 1;

--d. Retrieve the name, age and phone number of every female patient.
SELECT PatientName, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM BirthDate) AS Age, Phone
FROM Patients
WHERE Sex = 'Female';

--e. Retrieve the name of every doctor who has at least one male patient older than 60.
SELECT DISTINCT d.DoctorName
FROM Doctors d
JOIN Treatments t ON d.DoctorID = t.DoctorID
JOIN Patients p ON t.PatientID = p.PatientID
WHERE p.Sex = 'Male' AND EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM p.BirthDate) > 60;


--f. Dr. Yuzery will retire, transfer all his patients to some available doctors and delete records relating to him. Make sure that all constraints are met.
-- Chuy?n giao b?nh nhân c?a Dr. Yuzery cho các bác s? khác
UPDATE Treatments
SET DoctorID = 2
WHERE DoctorID = 1; -- Dr. Yuzery có DoctorID là 1
/
-- Xóa thông tin c?a Dr. Yuzery t? b?ng Doctor
DELETE FROM Doctors
WHERE DoctorID = 1; -- Dr. Yuzery có DoctorID là 1

