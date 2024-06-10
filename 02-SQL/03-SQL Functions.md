
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
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
11 rows in set (0.02 sec)

mysql> use ineuron;
Database changed
mysql> show tables;
+-------------------+
| Tables_in_ineuron |
+-------------------+
| student           |
+-------------------+
1 row in set (0.01 sec)

mysql> select * from student;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|  2 | NITIN | M        |   28 | BLR      |
+----+-------+----------+------+----------+
2 rows in set (0.01 sec)

mysql> select UPPER("ineuron");
+------------------+
| UPPER("ineuron") |
+------------------+
| INEURON          |
+------------------+
1 row in set (0.01 sec)

mysql> select LOWER("INEURON");
+------------------+
| LOWER("INEURON") |
+------------------+
| ineuron          |
+------------------+
1 row in set (0.00 sec)

mysql> select UPPER(FNAME) from student;
+--------------+
| UPPER(FNAME) |
+--------------+
| SAGAR        |
| NITIN        |
+--------------+
2 rows in set (0.00 sec)

mysql> select LOWER(FNAME) from student;
+--------------+
| LOWER(FNAME) |
+--------------+
| sagar        |
| nitin        |
+--------------+
2 rows in set (0.00 sec)

mysql> select sbstr("INEURON",1,5);
ERROR 1305 (42000): FUNCTION ineuron.sbstr does not exist
mysql> select substr("INEURON",1,5);
+-----------------------+
| substr("INEURON",1,5) |
+-----------------------+
| INEUR                 |
+-----------------------+
1 row in set (0.01 sec)

mysql> select sbustring("ineurin",1,4);
ERROR 1305 (42000): FUNCTION ineuron.sbustring does not exist
mysql> select substring("ineurin",1,4);
+--------------------------+
| substring("ineurin",1,4) |
+--------------------------+
| ineu                     |
+--------------------------+
1 row in set (0.00 sec)

mysql> select substring("ineurin",2,4);
+--------------------------+
| substring("ineurin",2,4) |
+--------------------------+
| neur                     |
+--------------------------+
1 row in set (0.00 sec)

mysql> select substring(FNAME,2,4);
ERROR 1054 (42S22): Unknown column 'FNAME' in 'field list'
mysql> select substring(FNAME,2,4) from student;
+----------------------+
| substring(FNAME,2,4) |
+----------------------+
| AGAR                 |
| ITIN                 |
+----------------------+
2 rows in set (0.00 sec)

mysql> select substring(FNAME,1,3) from student;
+----------------------+
| substring(FNAME,1,3) |
+----------------------+
| SAG                  |
| NIT                  |
+----------------------+
2 rows in set (0.00 sec)

mysql> select substring(FNAME,1,30) from student;
+-----------------------+
| substring(FNAME,1,30) |
+-----------------------+
| SAGAR                 |
| NITIN                 |
+-----------------------+
2 rows in set (0.00 sec)

mysql> select substring(FNAME,1,30) as shortName from student;
+-----------+
| shortName |
+-----------+
| SAGAR     |
| NITIN     |
+-----------+
2 rows in set (0.00 sec)

mysql> select substring(FNAME,1,3) as shortName from student;
+-----------+
| shortName |
+-----------+
| SAG       |
| NIT       |
+-----------+
2 rows in set (0.00 sec)

mysql> select abs(-20) from student;
+----------+
| abs(-20) |
+----------+
|       20 |
|       20 |
+----------+
2 rows in set (0.00 sec)

mysql> select abs(-20) as absolute from student;
+----------+
| absolute |
+----------+
|       20 |
|       20 |
+----------+
2 rows in set (0.00 sec)

mysql> select pow(2,5);
+----------+
| pow(2,5) |
+----------+
|       32 |
+----------+
1 row in set (0.01 sec)

mysql> select pow(2,5) as POWER;
+-------+
| POWER |
+-------+
|    32 |
+-------+
1 row in set (0.00 sec)

mysql> clear;
mysql> clean;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'clean' at line 1
mysql> cls;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'cls' at line 1
mysql> clr
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'clr' at line 1
mysql> 5+58;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '5+58' at line 1
mysql> sum(25+55);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'sum(25+55)' at line 1
mysql> select sum(50+5);
+-----------+
| sum(50+5) |
+-----------+
|        55 |
+-----------+
1 row in set (0.01 sec)

mysql> select sum(50+5) as sum;
+------+
| sum  |
+------+
|   55 |
+------+
1 row in set (0.00 sec)

mysql> select sum(50+5) as sum of two number ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'of two number' at line 1
mysql> select sum(50+5) as "sum of two number" ;
+-------------------+
| sum of two number |
+-------------------+
|                55 |
+-------------------+
1 row in set (0.00 sec)

mysql> select sum(50+1000) as "sum of two number" ;
+-------------------+
| sum of two number |
+-------------------+
|              1050 |
+-------------------+
1 row in set (0.00 sec)

mysql> select sqrt(25000) as 'Square root of 2500';
+---------------------+
| Square root of 2500 |
+---------------------+
|  158.11388300841898 |
+---------------------+
1 row in set (0.01 sec)

mysql> select * from student;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|  2 | NITIN | M        |   28 | BLR      |
+----+-------+----------+------+----------+
2 rows in set (0.00 sec)

mysql> insert into student values(3,'RAM','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

mysql> insert into student values(3,'RAM','LAXMAN',25,'PUNE');
ERROR 1062 (23000): Duplicate entry '3' for key 'student.PRIMARY'
mysql> insert into student values(3,'RAM','LAXMAN',25,'PUNE');
ERROR 1062 (23000): Duplicate entry '3' for key 'student.PRIMARY'
mysql> insert into student values(3,'RAM','LAXMAN',25,'PUNE');
ERROR 1062 (23000): Duplicate entry '3' for key 'student.PRIMARY'
mysql> insert into student values(4,'RAM','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

mysql> insert into student values(5,'RAM','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

mysql> insert into student values(6,'RAM','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

mysql> select * from student;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|  2 | NITIN | M        |   28 | BLR      |
|  3 | RAM   | LAXMAN   |   25 | PUNE     |
|  4 | RAM   | LAXMAN   |   25 | PUNE     |
|  5 | RAM   | LAXMAN   |   25 | PUNE     |
|  6 | RAM   | LAXMAN   |   25 | PUNE     |
+----+-------+----------+------+----------+
6 rows in set (0.00 sec)

mysql> insert into student(FNAME,LNAME,AGE,CITY) values('RAM','L
AXMAN',25,'PUNE');
ERROR 1364 (HY000): Field 'ID' doesn't have a default value
mysql> insert into student(ID,FNAME,LNAME,AGE,CITY) values(7,'RA
M','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

mysql> insert into student(ID,FNAME,LNAME,AGE,CITY) values(7,'RAM','LAXMAN',25,'PUNE');
ERROR 1062 (23000): Duplicate entry '7' for key 'student.PRIMARY'
mysql> insert into student(ID,FNAME,LNAME,AGE,CITY) values(-58,'
RAM','LAXMAN',25,'PUNE');
Query OK, 1 row affected (0.01 sec)

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

mysql> select FNAME,LNAME from student where AGE between 18 and
25;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
7 rows in set (0.01 sec)

mysql> select FNAME,LNAME from student where AGE between 18 and 2;
Empty set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE between 18 and 20;
Empty set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE between 18 and 205;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE between 1 and 0
5;
Empty set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE between 1 and 050
    -> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ')' at line 2
mysql> select FNAME,LNAME from student where AGE between 1 and 050;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE between 1 and 050;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql>
mysql> select FNAME,LNAME from student where AGE >18;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >20;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >21;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >22;
+-------+----------+
| FNAME | LNAME    |
+-------+----------+
| RAM   | LAXMAN   |
| SAGAR | GIRADKAR |
| NITIN | M        |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
| RAM   | LAXMAN   |
+-------+----------+
8 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >23;
+-------+--------+
| FNAME | LNAME  |
+-------+--------+
| RAM   | LAXMAN |
| NITIN | M      |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
+-------+--------+
7 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >24;
+-------+--------+
| FNAME | LNAME  |
+-------+--------+
| RAM   | LAXMAN |
| NITIN | M      |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
| RAM   | LAXMAN |
+-------+--------+
7 rows in set (0.00 sec)

mysql> select FNAME,LNAME from student where AGE >25;
+-------+-------+
| FNAME | LNAME |
+-------+-------+
| NITIN | M     |
+-------+-------+
1 row in set (0.00 sec)

mysql> select from student where AGE >25;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'from student where AGE >25' at line 1
mysql> select * from student where AGE >25;
+----+-------+-------+------+------+
| ID | FNAME | LNAME | AGE  | CITY |
+----+-------+-------+------+------+
|  2 | NITIN | M     |   28 | BLR  |
+----+-------+-------+------+------+
1 row in set (0.00 sec)

mysql> select * from student where AGE >24;
+-----+-------+--------+------+------+
| ID  | FNAME | LNAME  | AGE  | CITY |
+-----+-------+--------+------+------+
| -58 | RAM   | LAXMAN |   25 | PUNE |
|   2 | NITIN | M      |   28 | BLR  |
|   3 | RAM   | LAXMAN |   25 | PUNE |
|   4 | RAM   | LAXMAN |   25 | PUNE |
|   5 | RAM   | LAXMAN |   25 | PUNE |
|   6 | RAM   | LAXMAN |   25 | PUNE |
|   7 | RAM   | LAXMAN |   25 | PUNE |
+-----+-------+--------+------+------+
7 rows in set (0.00 sec)

mysql> select * from student where AGE >24 and AGE <18;
Empty set (0.00 sec)

mysql> select * from student where AGE < 24 and AGE > 18;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+----+-------+----------+------+----------+
1 row in set (0.00 sec)

mysql> select * from student where AGE < 25 and AGE > 18;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
+----+-------+----------+------+----------+
1 row in set (0.00 sec)

mysql> select * from student where AGE < 26 and AGE > 18;
+-----+-------+----------+------+----------+
| ID  | FNAME | LNAME    | AGE  | CITY     |
+-----+-------+----------+------+----------+
| -58 | RAM   | LAXMAN   |   25 | PUNE     |
|   1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|   3 | RAM   | LAXMAN   |   25 | PUNE     |
|   4 | RAM   | LAXMAN   |   25 | PUNE     |
|   5 | RAM   | LAXMAN   |   25 | PUNE     |
|   6 | RAM   | LAXMAN   |   25 | PUNE     |
|   7 | RAM   | LAXMAN   |   25 | PUNE     |
+-----+-------+----------+------+----------+
7 rows in set (0.00 sec)

mysql>
