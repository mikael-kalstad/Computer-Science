# SQL (Structured Query Language)

## 	|   Setup

#### Creating a database

````mysql
CREATE DATABASE databasename;
````

#### Deleting a database

````mysql
DROP DATABASE databasename;
````

#### Create a table

````mysql
CREATE TABLE tablename(table fields)

E.g (NB! Seperate with ,)
CREATE TABLE customers(
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    email VARCHAR(100),
    adress VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    zipcode VARCHAR(100),
    PRIMARY KEY(id)
);
````

#### Additional comments

````sql
/* Field cannot be null/empty */
NOT NULL 

/* Automatically make unique id, increment of 1 for every new customer */
AUTO_INCREMENT 

/* Array of chars (String), max length as paramter */
VARCHAR(Max length) 

/* Unique specified id for each record in table
   Normally an id column is used for primary key */
PRIMARY KEY(id)
````



## 	|   Modification

#### Inserting data

*Instead of declaring table field names and then values for each record, we can specify multiple values for several records. Separate with "," .*

````sql
INSERT INTO tablename(table fields names) VALUES (tables field values)

E.g.
INSERT INTO customers(firstName, lastName, email, adress, city, state, zipcode) VALUES 
('John', 'Doe', 'jdoe@gmail.com', '55 Main st', 'Boston', 'Massachussets', '01221'), 
('Martin', 'Doe', 'mdoe@gmail.com', '59 Main st', 'New York', 'New York', '76291'), 

````

#### Update data

*NB! WHERE is really important, if it is not specified all records of "field-name" will be changed.* 

````sql
UPDATE tablename SET field-name = new-value WHERE field-name(can be different) = value

E.g.
UPDATE customers SET email = "test@gmail.com" WHERE id = 3;
````

#### Delete data

*NB! WHERE is really important, if it is not specified all records of "field-name" will be deleted.* 

````sql
DELETE FROM tablename WHERE field-name = value

E.g.
DELETE FROM customers WHERE id = 3;
````



## 	|   Alter Table

#### Add a column

````mysql
ALTER TABLE customers ADD testCol VARCHAR(255);
````

#### Change data type for a column

````mysql
ALTER TABLE customers MODIFY COLUMN testCOl INT(11);
````

#### Delete column 

````mysql
ALTER TABlE customers DROP COLUMN testCol;
````



## 	|   Select

#### Examples

Used to get specific data in a certain way.

````mysql
SELECT * FROM customers   /* Return all columns */

SELECT firstName, lastName FROM customers   
/* Return firstName and lastName column */

SELECT * FROM customers WHERE id = 2;   
/* Return the unique customer */
````

#### DISTINCT 

Used to get unique values, not duplicates.

````mysql
SELECT DISTINCT age FROM customers /* only unique ages */
````

#### Sorting

- DESC - Descending
- ASC - Ascending (default)
- DISTINCT - no duplicates

```mysql
SELECT * FROM customers ORDER BY lastName; /* Return all columns sorted by lastName */

SELECT DISTINCT state FROM customers; /* column with no duplicates Returns state */

SELECT * FROM customers WHERE age < 30; /* Return age>30 */
```



## 	|   Operators

#### Table

|   Operator   |              Description               |             Example              |
| :----------: | :------------------------------------: | :------------------------------: |
|      =       |                Equal to                |        Author = 'Alcott'         |
|      <>      |    Not equal to (other DB != also)     |         Dept <> 'Sales'          |
|   BETWEEN    |       Between an inclusive range       |  Cost BETWEEN 100.00 AND 500.00  |
|     LIKE     |       Match a character pattern        |      firstName LIKE 'Will%'      |
|      IN      |      Equal to one of many values       |   DeptCode IN (101, 103, 209)    |
| IS or IS NOT |     Compare to null (missing data)     |        Adress IS NOT NULL        |
|      AS      | Change field name when viewing results | SELECT employee AS 'department1' |

#### AND & OR

AND has higher priority than OR, like in java.

#### IN 

````mysql
SELECT * FROM customers WHERE age IN(10, 20, 30);
/* Return all ages that are either 10, 20 or 30 */
````



#### Examples

Get customers with age between 22 and 30

````sql
SELECT * FROM customers WHERE age BETWEEN 22 AND 30;
````

Get citys ending with an 'on'. % is a wild card, means anything and then 'on'. Can be used both ways.

````mysql
SELECT * FROM customers WHERE city LIKE '%on';
````



## 	|   Indexes

Index is a pointer to data in a table. These indexes should only be created on columns (and tables) that will be fequently searched against.

#### Creating an index

````mysql
CREATE INDEX CIndex ON customers(city);
````

#### Remove an index

````mysql
DROP INDEX CIndex ON customers;
````



## 	|   Relationships & Foreign Keys

The purpose of a foreign key is to prevent data corruption within a database. Declaring this will make is so we cant delete a record if other records depend on it.

#### Creating a foreign key

````mysql
FOREIGN KEY(field-name) REFERENCES refTable(field-name);
````

#### Example

````mysql
CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  orderNumber INT,
  productId INT,
  customerId INT,
  orderDate DATETIME default CURRENT_TIMESTAMP,
  PRIMARY KEY(id),
  FOREIGN KEY(customerId) REFERENCES customers(id),
  FOREIGN KEY(productId) REFERENCES products(id),
)
````



## 	|   Joins

Used to combine rows from two or more tables based on commond field between them.

**Types**: *INNER JOIN, LEFT JOIN,  RIGHT JOIN, FULL JOIN*

#### INNER JOIN

````mysql
SELECT customers.firstName, customers.lastName, orders.orderNumber
FROM customers 
INNER JOIN orders 
ON customers.id = orders.customerId
ORDER BY customers.lastName; /*Sorting table by last name*/
````

#### LEFT JOIN

Will return rows on the left table matching with the rows on the right table

````mysql
SELECT customers.firstName, customers.lastName, orders.orderNumber, orders.orderDate
FROM customers 
LEFT JOIN orders 
ON customers.id = orders.customerId
ORDER BY customers.lastName; /*Sorting table by last name*/
````

#### RIGHT JOIN

Will return rows on the righttable matching with the rows on the left table



## 	|   Aliases

#### Change row display name

````mysql
SELECT firstName AS 'First Name', lastName AS 'Last Name' FROM customers;
````

#### Combine columns

````mysql
SELECT CONCAT(firstName, ' ', lastName) AS 'Name', adress, city, state FROM customers;
````

#### Combine tables

````mysql
SELECT o.id, o.orderDate, c.firstName, c.lastName FROM customers AS c, orders AS o.
````



## 	|   SQL Aggregate Functions

#### Average 

````mysql
SELECT AVG(age) FROM customers; /* Average age of all customers */
````

#### Count

````mysql
SELECT COUNT(age) FROM customers; /* Amount of customers with an age */
````

#### Max

````mysql
SELECT MAX(age) FROM customers; /* Return the oldest customer */
````

#### Min

````mysql
SELECT MIN(age) FROM customers; /* Return the youngest customer */
````

#### Sum

````mysql
SELECT SUM(age) FROM customers; /* Total age of all customers */
````

#### Group

Will return a table with ages above 30, also with a column with how many ages there are of that number. E.g. 2 customers are 33. (Count)

`````mysql
SELECT age, COUNT(age) FROM customers WHERE age > 30 GROUP BY age;
`````

Same as above, but will only return ages with a count of 2 or more.

````mysql
SELECT age, COUNT(age) FROM customers GROUP BY age HAVING COUNT(age) >= 2;
````





## 		|   Other

#### Date type

````mysql
CREATE TABLE orders (orderDate DATETIME);

// To get current date and time automatically
CREATE TABLE orders (ordersDate DATETIME default CURRENT_TIMESTAMP);
````

