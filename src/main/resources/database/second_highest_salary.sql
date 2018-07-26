/* Write your PL/SQL query statement below */
--https://leetcode.com/problems/second-highest-salary/description/
select max(e.Salary) as "SecondHighestSalary" from Employee e
where e.Salary < (select max(Salary) from Employee)