/*
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table,
the query should return 200 as the second highest salary.
If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
*/

/*
distinct 在order by之前生效
limit a, b : [a:行的下标（从零开始）, b:取多少行]
 */

# Write your MySQL query statement below

select (
  select distinct Salary
  from Employee ORDER by Salary desc limit 1, 1
) as SecondHighestSalary ;

