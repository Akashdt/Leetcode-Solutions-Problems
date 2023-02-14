# Write your MySQL query statement below
SELECT   (CASE WHEN COUNT(salary) <1 THEN NULL
        ELSE MAX(SALARY) END) AS SecondHighestSalary
From Employee
WHERE salary < (SELECT MAX(salary) FROM Employee)