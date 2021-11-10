# Write your MySQL query statement below
SELECT max(salary) as secondHighestSalary from Employee where salary < (SELECT max(salary) from Employee) 