Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 10
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
11 rows in set (0.03 sec)

mysql> use uneuron;
ERROR 1049 (42000): Unknown database 'uneuron'
mysql> use ineuron;
Database changed
mysql> show tables;
+-------------------+
| Tables_in_ineuron |
+-------------------+
| student           |
+-------------------+
1 row in set (0.03 sec)

mysql> desc student;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | YES  |     | NULL    |       |
| sname | varchar(20) | YES  |     | NULL    |       |
| sage  | int         | YES  |     | NULL    |       |
| scity | varchar(25) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
4 rows in set (0.02 sec)

mysql> select * from student;
+------+-------+------+----------+
| id   | sname | sage | scity    |
+------+-------+------+----------+
|    1 | sagar |   25 | Bhandara |
+------+-------+------+----------+
1 row in set (0.00 sec)

mysql> insert into student values(2,"pavan",22,"Nagar");
Query OK, 1 row affected (0.01 sec)

mysql> select * from student;
+------+-------+------+----------+
| id   | sname | sage | scity    |
+------+-------+------+----------+
|    1 | sagar |   25 | Bhandara |
|    2 | pavan |   22 | Nagar    |
+------+-------+------+----------+
2 rows in set (0.00 sec)

mysql> drop student;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'student' at line 1
mysql> drop table student;
Query OK, 0 rows affected (0.06 sec)

mysql> show tables;
Empty set (0.00 sec)

mysql> show tables;
Empty set (0.00 sec)

mysql> CREATE TABLE STUDENT(ID INT(5) AUTO_INCREMENT PRIMARY KEY,
    -> ENAME VARCHAR(20) NOT NULL,
    -> EMNAME VARCHAR(20) ,
    -> ELNAME VARCHAR(20) NOT NULL ,
    -> EAGE INT(5) NOT NULL );
Query OK, 0 rows affected, 2 warnings (0.05 sec)

mysql> DESC STUDENT
    -> ;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| ID     | int         | NO   | PRI | NULL    | auto_increment |
| ENAME  | varchar(20) | NO   |     | NULL    |                |
| EMNAME | varchar(20) | YES  |     | NULL    |                |
| ELNAME | varchar(20) | NO   |     | NULL    |                |
| EAGE   | int         | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)

mysql> INSER INTO STUDENT VALUES("SAGAR","PRAKASH","GIRADKAR",23);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'INSER INTO STUDENT VALUES("SAGAR","PRAKASH","GIRADKAR",23)' at line 1
mysql> INSER INTO STUDENT VALUES(ENAME , EMNAME , ELNAME , EAGE)("SAG
AR","PRAKASH","GIRADKAR",23);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'INSER INTO STUDENT VALUES(ENAME , EMNAME , ELNAME , EAGE)("SAGAR","PRAKASH","GIR' at line 1
mysql> INSERT INTO STUDENT VALUES(ENAME , EMNAME , ELNAME , EAGE)("SA
GAR","PRAKASH","GIRADKAR",23);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '("SAGAR","PRAKASH","GIRADKAR",23)' at line 1
mysql>  insert into student values(2,"pavan",22,"Nagar");
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql>  insert into student values(2,"pavan","RAJU","Nagar",25);
Query OK, 1 row affected (0.01 sec)

mysql> select * from student;
+----+-------+--------+--------+------+
| ID | ENAME | EMNAME | ELNAME | EAGE |
+----+-------+--------+--------+------+
|  2 | pavan | RAJU   | Nagar  |   25 |
+----+-------+--------+--------+------+
1 row in set (0.00 sec)

mysql> insert into student values("pavan",22,"Nagar");
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql>  insert into student value(ID,ENAME,EMNAME,ELNAME,EAGE)(2,"pav
an","RAJU","Nagar",25);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '(2,"pavan","RAJU","Nagar",25)' at line 1

Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 8.0.36 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> SHOW DATABASES;
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

mysql> USE INEURON;
Database changed
mysql> SHOW TABLES;
+-------------------+
| Tables_in_ineuron |
+-------------------+
| student           |
+-------------------+
1 row in set (0.01 sec)

mysql> SELECT * FROM STUDENT ;
+----+-------+--------+--------+------+
| ID | ENAME | EMNAME | ELNAME | EAGE |
+----+-------+--------+--------+------+
|  2 | pavan | RAJU   | Nagar  |   25 |
+----+-------+--------+--------+------+
1 row in set (0.00 sec)

mysql> DESC STUDENT
    -> ;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| ID     | int         | NO   | PRI | NULL    | auto_increment |
| ENAME  | varchar(20) | NO   |     | NULL    |                |
| EMNAME | varchar(20) | YES  |     | NULL    |                |
| ELNAME | varchar(20) | NO   |     | NULL    |                |
| EAGE   | int         | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

mysql> INSERT INTO STUDENT VALUE('SAGAR','PRAKASH','GIRADKAR',25);
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> INSERT INTO STUDENT VALUE(1,'SAGAR','PRAKASH','GIRADKAR',25);
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO STUDENT VALUES('SAGAR','PRAKASH','GIRADKAR',25);
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> INSERT INTO STUDENT VALUES(2,'SAGAR','PRAKASH','GIRADKAR',25);
ERROR 1062 (23000): Duplicate entry '2' for key 'student.PRIMARY'
mysql> INSERT INTO STUDENT VALUES(3,'SAGAR','PRAKASH','GIRADKAR',25);
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM STUDENT;
+----+-------+---------+----------+------+
| ID | ENAME | EMNAME  | ELNAME   | EAGE |
+----+-------+---------+----------+------+
|  1 | SAGAR | PRAKASH | GIRADKAR |   25 |
|  2 | pavan | RAJU    | Nagar    |   25 |
|  3 | SAGAR | PRAKASH | GIRADKAR |   25 |
+----+-------+---------+----------+------+
3 rows in set (0.00 sec)

mysql> INSERT INTO STUDENT VALUES(3,'SAGAR','PRAKASH','GIRADKAR',25);
ERROR 1062 (23000): Duplicate entry '3' for key 'student.PRIMARY'
mysql> DROP TABLE STUDENT;
Query OK, 0 rows affected (0.03 sec)

mysql> SHOW TABLES;
Empty set (0.00 sec)

mysql> CREATE TABLE STUDINFO (ID INT(5),
    -> FIRSTNAME VARCHAR(50),
    -> LASTNAME VARCHAR(50),
    -> AGE INT(5),
    -> CITY VARCHAR(20),
    -> CITY VARCHAR(20)
    -> PRIMARY KEY(ID)
    -> );
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '(ID)
)' at line 7
mysql> CREATE TABLE STUDINFO (ID INT(5),
    -> FIRSTNAME VARCHAR(50),
    -> LASTNAME VARCHAR(50),
    ->  AGE INT(5),
    -> CITY VARCHAR(20),
    -> CITY VARCHAR(20),
    ->  PRIMARY KEY(ID) );
ERROR 1060 (42S21): Duplicate column name 'CITY'
mysql> CREATE TABLE STUDENT (ID INT(5),FNAME VARCHAR(20),LNAME VARCHAR(20),
AGE INT(5),CITY VARCHAR(20),PRIMARY KEY(ID));
Query OK, 0 rows affected, 2 warnings (0.04 sec)

mysql> SELECT * FROM STUDENT ;
Empty set (0.00 sec)

mysql> DESC STUDENT;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| ID    | int         | NO   | PRI | NULL    |       |
| FNAME | varchar(20) | YES  |     | NULL    |       |
| LNAME | varchar(20) | YES  |     | NULL    |       |
| AGE   | int         | YES  |     | NULL    |       |
| CITY  | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> INSERT INTO STUDENT (ID,FNAME,LNAME,AGE,CITY) VALUES (1,'SAGAR','GIR
ADKAR',23,'BHANDARA'),(2,'NITIN','M',28,'BLR');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM STUDENT ;
+----+-------+----------+------+----------+
| ID | FNAME | LNAME    | AGE  | CITY     |
+----+-------+----------+------+----------+
|  1 | SAGAR | GIRADKAR |   23 | BHANDARA |
|  2 | NITIN | M        |   28 | BLR      |
+----+-------+----------+------+----------+
2 rows in set (0.00 sec)

mysql>