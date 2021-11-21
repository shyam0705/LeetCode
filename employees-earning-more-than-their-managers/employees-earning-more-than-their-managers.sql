# Write your MySQL query statement below
select name as Employee from Employee as a where a.managerId is not null and a.salary>(select salary from Employee where id=a.managerId)