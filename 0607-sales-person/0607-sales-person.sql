# Write your MySQL query statement below
select name from SalesPerson where sales_id not in (select sales_id from Orders as a inner join Company as b on (a.com_id=b.com_id) where b.name='RED');