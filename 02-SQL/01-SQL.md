## Introduction to SQL

SQL stands for Structured Query Language and is the standard language for interacting with relational databases. It allows users to create, manipulate, and query data stored in a database. SQL is used in various database management systems (DBMS) such as MySQL, PostgreSQL, SQLite, Microsoft SQL Server, and Oracle Database.

### Key Components of SQL

1. **DDL (Data Definition Language)**: Commands that define the structure of the database and objects within it.
   - `CREATE`: Creates a new table, database, index, or other objects.
   - `ALTER`: Modifies an existing database object.
   - `DROP`: Deletes an existing database object.

2. **DML (Data Manipulation Language)**: Commands that manipulate data stored in the database.
   - `INSERT`: Adds new data to a table.
   - `UPDATE`: Modifies existing data within a table.
   - `DELETE`: Removes data from a table.
   - `SELECT`: Retrieves data from a table.

3. **DCL (Data Control Language)**: Commands that control access to the data within the database.
   - `GRANT`: Gives a user permission to perform certain tasks.
   - `REVOKE`: Takes back permissions granted to a user.

4. **TCL (Transaction Control Language)**: Commands that manage transactions within a database.
   - `COMMIT`: Saves all changes made during the current transaction.
   - `ROLLBACK`: Reverts all changes made during the current transaction.

## CRUD Operations

### 1. CREATE Operation

The `CREATE` command is used to create a new table or database. Here's an example of creating a table named `employees`:

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    hire_date DATE
);
```

### 2. READ Operation

The `SELECT` command is used to retrieve data from one or more tables. It's the most commonly used SQL command.

**Basic SELECT Query:**

```sql
SELECT * FROM employees;
```

This query retrieves all columns from the `employees` table.

**Filtering Data with WHERE Clause:**

```sql
SELECT first_name, last_name FROM employees WHERE hire_date > '2020-01-01';
```

This query retrieves the first and last names of employees who were hired after January 1, 2020.

**Using ORDER BY to Sort Results:**

```sql
SELECT * FROM employees ORDER BY last_name ASC;
```

This query retrieves all columns from the `employees` table, sorted by last name in ascending order.

**Aggregate Functions and GROUP BY:**

```sql
SELECT hire_date, COUNT(*) as employee_count
FROM employees
GROUP BY hire_date;
```

This query retrieves the hire date and the count of employees hired on each date.

### 3. UPDATE Operation

The `UPDATE` command is used to modify existing records in a table.

**Basic UPDATE Query:**

```sql
UPDATE employees
SET email = 'new.email@example.com'
WHERE id = 1;
```

This query updates the email of the employee with an `id` of 1.

**Updating Multiple Columns:**

```sql
UPDATE employees
SET first_name = 'John', last_name = 'Doe'
WHERE id = 2;
```

This query updates both the first and last names of the employee with an `id` of 2.

### 4. DELETE Operation

The `DELETE` command is used to remove records from a table.

**Basic DELETE Query:**

```sql
DELETE FROM employees
WHERE id = 3;
```

This query deletes the record of the employee with an `id` of 3.

**Deleting All Records:**

```sql
DELETE FROM employees;
```

This query deletes all records from the `employees` table but keeps the table structure intact.

**Using TRUNCATE to Delete All Records:**

```sql
TRUNCATE TABLE employees;
```

This command also deletes all records from the `employees` table, but it is faster than `DELETE` without a `WHERE` clause because it does not log individual row deletions.

## Example Scenario: Managing an Online Store Database

To illustrate these operations, let's consider an example scenario where we're managing a database for an online store. We'll have tables for `customers`, `orders`, and `products`.

### 1. Creating Tables

**Customers Table:**

```sql
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15)
);
```

**Products Table:**

```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2),
    stock_quantity INT
);
```

**Orders Table:**

```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```

### 2. Inserting Data

**Inserting Data into Customers Table:**

```sql
INSERT INTO customers (customer_id, first_name, last_name, email, phone)
VALUES (1, 'Alice', 'Smith', 'alice.smith@example.com', '123-456-7890');
```

**Inserting Data into Products Table:**

```sql
INSERT INTO products (product_id, product_name, price, stock_quantity)
VALUES (1, 'Laptop', 899.99, 50);
```

**Inserting Data into Orders Table:**

```sql
INSERT INTO orders (order_id, customer_id, order_date, total_amount)
VALUES (1, 1, '2023-06-01', 899.99);
```

### 3. Reading Data

**Selecting All Customers:**

```sql
SELECT * FROM customers;
```

**Selecting Orders for a Specific Customer:**

```sql
SELECT * FROM orders WHERE customer_id = 1;
```

**Joining Tables to Get Order Details:**

```sql
SELECT orders.order_id, customers.first_name, customers.last_name, orders.order_date, orders.total_amount
FROM orders
JOIN customers ON orders.customer_id = customers.customer_id;
```

### 4. Updating Data

**Updating Customer Email:**

```sql
UPDATE customers
SET email = 'alice.new.email@example.com'
WHERE customer_id = 1;
```

**Updating Product Stock Quantity:**

```sql
UPDATE products
SET stock_quantity = stock_quantity - 1
WHERE product_id = 1;
```

### 5. Deleting Data

**Deleting a Customer:**

```sql
DELETE FROM customers WHERE customer_id = 1;
```

**Deleting All Orders for a Specific Customer:**

```sql
DELETE FROM orders WHERE customer_id = 1;
```

## Conclusion

SQL is a powerful language for managing and manipulating relational databases. The CRUD operations (Create, Read, Update, Delete) form the backbone of any database interaction. By mastering these operations, you can effectively manage data in a relational database, ensuring that you can create new records, retrieve existing data, update records, and delete data as needed.

