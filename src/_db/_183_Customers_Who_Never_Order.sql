/*
Suppose that a website contains two tables,
the Customers table and the Orders table.
Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
*/

# Write your MySQL query statement below

select Customers
from (
  select Customers.Name as Customers, Orders.Id
  from Orders left join Customers on Customers.Id=Orders.CustomerId
) as customerleftjoinorder
group by Customers HAVING count(*)=0 ;