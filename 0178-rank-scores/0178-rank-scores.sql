# Write your MySQL query statement below

select a.score,(select count(distinct score) from Scores where score>=a.score) as "rank" from Scores as a order by a.score Desc;
