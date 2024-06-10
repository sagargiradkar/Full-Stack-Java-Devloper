Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 13
Server version: 8.0.36 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| ineuron            |
| information_schema |
| mysql              |
| performance_schema |
| sagar              |
| sakila             |
| sales              |
| scm                |
| sys                |
| tableu             |
| world              |
+--------------------+
11 rows in set (0.01 sec)

mysql> use ineuron;
Database changed
mysql> show tables;
+-------------------+
| Tables_in_ineuron |
+-------------------+
| student           |
+-------------------+
1 row in set (0.01 sec)

mysql> select * from stundent order by FNAME asc
    -> ;
ERROR 1146 (42S02): Table 'ineuron.stundent' doesn't exist
mysql> select * from student order by FNAME asc;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
|   2 | NITIN | M        |   28 | BLR      |
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+-----+-------+----------+------+----------+
8 rows in set (0.01 sec)

mysql> select * from student order by LNAME asc;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   2 | NITIN | M        |   28 | BLR      |
+-----+-------+----------+------+----------+
8 rows in set (0.00 sec)

mysql> select * from student order by LNAME desc;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
|   2 | NITIN | M        |   28 | BLR      |
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+-----+-------+----------+------+----------+
8 rows in set (0.00 sec)

mysql> select * from student order by FNAME desc;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   2 | NITIN | M        |   28 | BLR      |
+-----+-------+----------+------+----------+
8 rows in set (0.00 sec)

mysql> select * from student where AGE >21 and AGE <26 order by CITY DESC;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+-----+-------+----------+------+----------+
7 rows in set (0.00 sec)

mysql> select * from student where AGE between 19 and 26 order b
y CITY DESC;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+-----+-------+----------+------+----------+
7 rows in set (0.00 sec)

mysql> select * from student where AGE not between 19 and 26 ord
er by CITY DESC;
+----+-------+-------+------+------+
| ID | FNAME | LNAME | AGE  | CITY |
+----+-------+-------+------+------+
|  2 | NITIN | M     |   28 | BLR  |
+----+-------+-------+------+------+
1 row in set (0.00 sec)

mysql> select * from student;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|   2 | NITIN | M        |   28 | BLR      |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
+-----+-------+----------+------+----------+
8 rows in set (0.00 sec)

mysql> select distinct FNAME from student;
+-------+
| FNAME |
+-------+
| RAM   |
| SAGAR |
| NITIN |
+-------+
3 rows in set (0.01 sec)

mysql> select distinct lNAME from student;
+----------+
| lNAME    |
+----------+
| LAXMAN   |
| GIRADKAR |
| M        |
+----------+
3 rows in set (0.00 sec)

mysql> select distinct city from student;
+----------+
| city     |
+----------+
| PUNE     |
| BHANDARA |
| BLR      |
+----------+
3 rows in set (0.00 sec)

mysql> select * from student;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|   2 | NITIN | M        |   28 | BLR      |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
+-----+-------+----------+------+----------+
8 rows in set (0.00 sec)

mysql> select distinct age from student;
+------+
| age  |
+------+
|   25 |
|   23 |
|   28 |
+------+
3 rows in set (0.00 sec)

mysql> select * distinct age from student;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'distinct age from student' at line 1
mysql> select distinct age from student;
+------+
| age  |
+------+
|   25 |
|   23 |
|   28 |
+------+
3 rows in set (0.00 sec)

mysql>