CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE m INT; 
    IF((N-1)>0) THEN 
        SET m=N-1;
    ELSE
        SET m=0; 
    END IF;
  RETURN (
      # Write your MySQL query statement below.
      
      select max(salary) as `getNthHighestSalary${N}` from Employee where salary <= (select distinct  salary from Employee order by salary desc limit 1 offset m)
  );
END