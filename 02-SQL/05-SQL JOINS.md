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

mysql> create table studentinfo (id int(5) ,name varchar(50) not null , age int(5) not null , course varchar(20) not null , prim
ary key(id), foreign key(course));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ')' at line 1
mysql> create table studentinfo (id int(5) primary key,name varc
har(50) not null , age int(5) not null , course varchar(20) not
null foreign key(course));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key(course))' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20) not null
 foreign key(course));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key(course))' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20) foreign
key(course));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key(course))' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20) foreign key);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key)' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20) foreign key references Course(cid));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key references Course(cid))' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20) foreign key(course) references Course(cid));
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'foreign key(course) references Course(cid))' at line 1
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20), foreign
 key(course) references Course(cid));
ERROR 1824 (HY000): Failed to open the referenced table 'course'
mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20), foreign key(course) references Course(cid));
ERROR 1824 (HY000): Failed to open the referenced table 'course'
mysql> create table Course (cid int(5) primary key,cname varchar
(20));
Query OK, 0 rows affected, 1 warning (0.04 sec)

mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20), foreign key(course) references Course(cid));
Query OK, 0 rows affected, 3 warnings (0.08 sec)

mysql> select * from studentinfo;
Empty set (0.00 sec)

mysql> select * from course;
Empty set (0.01 sec)

mysql> desc studentInfo;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| id     | int         | NO   | PRI | NULL    |       |
| name   | varchar(50) | NO   |     | NULL    |       |
| age    | int         | NO   |     | NULL    |       |
| course | int         | YES  | MUL | NULL    |       |
+--------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> desc course;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| cid   | int         | NO   | PRI | NULL    |       |
| cname | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> insert into studentinfo values(1,"Sagar",22,1);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`ineuron`.`studentinfo`, CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`course`) REFERENCES `course` (`cid`))
mysql> insert into studentinfo values(1,"Sagar",22,1);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`ineuron`.`studentinfo`, CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`course`) REFERENCES `course` (`cid`))
mysql> insert into course (cid,cname) values (1,'JAVA'),(2,"SQL"
),(3,"PYTHON"),(4,"JS");
Query OK, 4 rows affected (0.01 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> insert into studentinfo values(1,"Sagar",22,1);
Query OK, 1 row affected (0.01 sec)

mysql> select * from course;
+-----+--------+
| cid | cname  |
+-----+--------+
|   1 | JAVA   |
|   2 | SQL    |
|   3 | PYTHON |
|   4 | JS     |
+-----+--------+
4 rows in set (0.00 sec)

mysql> select * from studentinfo;
+----+-------+-----+--------+
| id | name  | age | course |
+----+-------+-----+--------+
|  1 | Sagar |  22 |      1 |
+----+-------+-----+--------+
1 row in set (0.00 sec)

mysql> create table studentinfo (id int(5) primary key,name varchar(50) not null , age int(5) not null , course int(20), foreign key(course) references Course(cid));
ERROR 1050 (42S01): Table 'studentinfo' already exists
mysql> insert into studentinfo values(2,"Sagar",22,1);
Query OK, 1 row affected (0.01 sec)

mysql> insert into studentinfo values(3,"pavan ",18,2);
Query OK, 1 row affected (0.00 sec)

mysql> insert into studentinfo values(4,"pavan1 ",19,3);
Query OK, 1 row affected (0.01 sec)

mysql> insert into studentinfo values(4,"pavan1 ",19,4);
ERROR 1062 (23000): Duplicate entry '4' for key 'studentinfo.PRIMARY'
mysql> insert into studentinfo values(4,"PARTH",21,5);
ERROR 1062 (23000): Duplicate entry '4' for key 'studentinfo.PRIMARY'
mysql> insert into studentinfo values(4,"PARTH",21,4);
ERROR 1062 (23000): Duplicate entry '4' for key 'studentinfo.PRIMARY'
mysql> insert into studentinfo values(5,"PARTH1",11,4);
Query OK, 1 row affected (0.01 sec)

mysql> insert into studentinfo values(6,"ROHAN",11,5);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`ineuron`.`studentinfo`, CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`course`) REFERENCES `course` (`cid`))
mysql> insert into studentinfo values(6,"ROHAN",11,1);
Query OK, 1 row affected (0.01 sec)

mysql> insert into studentinfo values(7,"ROHAN Sharma",11,1);
Query OK, 1 row affected (0.01 sec)

mysql> select * from studentinfo;
+----+--------------+-----+--------+
| id | name         | age | course |
+----+--------------+-----+--------+
|  1 | Sagar        |  22 |      1 |
|  2 | Sagar        |  22 |      1 |
|  3 | pavan        |  18 |      2 |
|  4 | pavan1       |  19 |      3 |
|  5 | PARTH1       |  11 |      4 |
|  6 | ROHAN        |  11 |      1 |
|  7 | ROHAN Sharma |  11 |      1 |
+----+--------------+-----+--------+
7 rows in set (0.00 sec)

mysql> select * from studentinfo as studentData inner join cours
e on studentinfo.course = course.cid;
ERROR 1054 (42S22): Unknown column 'studentinfo.course' in 'on clause'
mysql> select * from studentInfo inner join course on studentinf
o.course = course.cid;
+----+--------------+-----+--------+-----+--------+
| id | name         | age | course | cid | cname  |
+----+--------------+-----+--------+-----+--------+
|  1 | Sagar        |  22 |      1 |   1 | JAVA   |
|  2 | Sagar        |  22 |      1 |   1 | JAVA   |
|  6 | ROHAN        |  11 |      1 |   1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |   1 | JAVA   |
|  3 | pavan        |  18 |      2 |   2 | SQL    |
|  4 | pavan1       |  19 |      3 |   3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |   4 | JS     |
+----+--------------+-----+--------+-----+--------+
7 rows in set (0.00 sec)

mysql> select * from studentInfo as studentData inner join cours
e on studentinfo.course = course.cid;
ERROR 1054 (42S22): Unknown column 'studentinfo.course' in 'on clause'
mysql> select * from studentInfo inner join course on studentinf
o.course = course.cid;
+----+--------------+-----+--------+-----+--------+
| id | name         | age | course | cid | cname  |
+----+--------------+-----+--------+-----+--------+
|  1 | Sagar        |  22 |      1 |   1 | JAVA   |
|  2 | Sagar        |  22 |      1 |   1 | JAVA   |
|  6 | ROHAN        |  11 |      1 |   1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |   1 | JAVA   |
|  3 | pavan        |  18 |      2 |   2 | SQL    |
|  4 | pavan1       |  19 |      3 |   3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |   4 | JS     |
+----+--------------+-----+--------+-----+--------+
7 rows in set (0.00 sec)

mysql> select * from studentInfo inner join course on studentinfo.course = course.cid order by desc;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'desc' at line 1
mysql> select * from studentInfo inner join course on studentinfo.course = course.cid;
+----+--------------+-----+--------+-----+--------+
| id | name         | age | course | cid | cname  |
+----+--------------+-----+--------+-----+--------+
|  1 | Sagar        |  22 |      1 |   1 | JAVA   |
|  2 | Sagar        |  22 |      1 |   1 | JAVA   |
|  6 | ROHAN        |  11 |      1 |   1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |   1 | JAVA   |
|  3 | pavan        |  18 |      2 |   2 | SQL    |
|  4 | pavan1       |  19 |      3 |   3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |   4 | JS     |
+----+--------------+-----+--------+-----+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course
on studentinfo.course = course.cid;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  5 | PARTH1       |      4 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by age asc;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
|  5 | PARTH1       |      4 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by id asc;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  5 | PARTH1       |      4 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by name asc;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  5 | PARTH1       |      4 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by studentInfo.name asc
;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  5 | PARTH1       |      4 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid order by studentInfo.name desc;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  7 | ROHAN Sharma |      1 |
|  6 | ROHAN        |      1 |
|  4 | pavan1       |      3 |
|  3 | pavan        |      2 |
|  5 | PARTH1       |      4 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid where age>18 order by student
Info.name desc;
+----+---------+--------+
| id | name    | course |
+----+---------+--------+
|  1 | Sagar   |      1 |
|  2 | Sagar   |      1 |
|  4 | pavan1  |      3 |
+----+---------+--------+
3 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo inner join course on studentinfo.course = course.cid where age<18 order by student
Info.name desc;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  7 | ROHAN Sharma |      1 |
|  6 | ROHAN        |      1 |
|  5 | PARTH1       |      4 |
+----+--------------+--------+
3 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo right join course
on studentinfo.course = course.cid order by studentInfo.name des
c;
+------+--------------+--------+
| id   | name         | course |
+------+--------------+--------+
|    1 | Sagar        |      1 |
|    2 | Sagar        |      1 |
|    7 | ROHAN Sharma |      1 |
|    6 | ROHAN        |      1 |
|    4 | pavan1       |      3 |
|    3 | pavan        |      2 |
|    5 | PARTH1       |      4 |
+------+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo right join course
on studentinfo.course = course.cid order by studentInfo.name des
c;
+------+--------------+--------+
| id   | name         | course |
+------+--------------+--------+
|    1 | Sagar        |      1 |
|    2 | Sagar        |      1 |
|    7 | ROHAN Sharma |      1 |
|    6 | ROHAN        |      1 |
|    4 | pavan1       |      3 |
|    3 | pavan        |      2 |
|    5 | PARTH1       |      4 |
+------+--------------+--------+
7 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo left join course o
n studentinfo.course = course.cid order by studentInfo.name desc
;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  7 | ROHAN Sharma |      1 |
|  6 | ROHAN        |      1 |
|  4 | pavan1       |      3 |
|  3 | pavan        |      2 |
|  5 | PARTH1       |      4 |
+----+--------------+--------+
7 rows in set (0.00 sec)

mysql> insert into studentinfo(id,name,age,corse) values(11,'hyder',24,4);
ERROR 1054 (42S22): Unknown column 'corse' in 'field list'
mysql> insert into studentinfo(id,name,age,course) values(11,'hy
der',24,4);
Query OK, 1 row affected (0.01 sec)

mysql> insert into studentinfo(id,name,age,course) values(11,'hyder',24,4);
ERROR 1062 (23000): Duplicate entry '11' for key 'studentinfo.PRIMARY'
mysql> insert into studentinfo(id,name,age,course) values(15,'hy
der',24,4);
Query OK, 1 row affected (0.01 sec)

mysql> select * from studentInfo;
+----+--------------+-----+--------+
| id | name         | age | course |
+----+--------------+-----+--------+
|  1 | Sagar        |  22 |      1 |
|  2 | Sagar        |  22 |      1 |
|  3 | pavan        |  18 |      2 |
|  4 | pavan1       |  19 |      3 |
|  5 | PARTH1       |  11 |      4 |
|  6 | ROHAN        |  11 |      1 |
|  7 | ROHAN Sharma |  11 |      1 |
| 11 | hyder        |  24 |      4 |
| 15 | hyder        |  24 |      4 |
+----+--------------+-----+--------+
9 rows in set (0.00 sec)

mysql> select * from course;
+-----+--------+
| cid | cname  |
+-----+--------+
|   1 | JAVA   |
|   2 | SQL    |
|   3 | PYTHON |
|   4 | JS     |
+-----+--------+
4 rows in set (0.00 sec)

mysql> select * from course;
+-----+--------+
| cid | cname  |
+-----+--------+
|   1 | JAVA   |
|   2 | SQL    |
|   3 | PYTHON |
|   4 | JS     |
+-----+--------+
4 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo si left join cours
e cr on si.course = cr.cid;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  5 | PARTH1       |      4 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
| 11 | hyder        |      4 |
| 15 | hyder        |      4 |
+----+--------------+--------+
9 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo si inner join cour
se cr on si.course = cr.cid;
+----+--------------+--------+
| id | name         | course |
+----+--------------+--------+
|  1 | Sagar        |      1 |
|  2 | Sagar        |      1 |
|  6 | ROHAN        |      1 |
|  7 | ROHAN Sharma |      1 |
|  3 | pavan        |      2 |
|  4 | pavan1       |      3 |
|  5 | PARTH1       |      4 |
| 11 | hyder        |      4 |
| 15 | hyder        |      4 |
+----+--------------+--------+
9 rows in set (0.00 sec)

mysql> select id,name,course from studentInfo si right join cour
se cr on si.course = cr.cid;
+------+--------------+--------+
| id   | name         | course |
+------+--------------+--------+
|    1 | Sagar        |      1 |
|    2 | Sagar        |      1 |
|    6 | ROHAN        |      1 |
|    7 | ROHAN Sharma |      1 |
|    3 | pavan        |      2 |
|    4 | pavan1       |      3 |
|    5 | PARTH1       |      4 |
|   11 | hyder        |      4 |
|   15 | hyder        |      4 |
+------+--------------+--------+
9 rows in set (0.00 sec)

mysql> select * from studentInfo si right join course cr on si.c
ourse = cr.cid;
+------+--------------+------+--------+-----+--------+
| id   | name         | age  | course | cid | cname  |
+------+--------------+------+--------+-----+--------+
|    1 | Sagar        |   22 |      1 |   1 | JAVA   |
|    2 | Sagar        |   22 |      1 |   1 | JAVA   |
|    6 | ROHAN        |   11 |      1 |   1 | JAVA   |
|    7 | ROHAN Sharma |   11 |      1 |   1 | JAVA   |
|    3 | pavan        |   18 |      2 |   2 | SQL    |
|    4 | pavan1       |   19 |      3 |   3 | PYTHON |
|    5 | PARTH1       |   11 |      4 |   4 | JS     |
|   11 | hyder        |   24 |      4 |   4 | JS     |
|   15 | hyder        |   24 |      4 |   4 | JS     |
+------+--------------+------+--------+-----+--------+
9 rows in set (0.00 sec)

mysql> select * from studentInfo si cross join course;
+----+--------------+-----+--------+-----+--------+
| id | name         | age | course | cid | cname  |
+----+--------------+-----+--------+-----+--------+
|  1 | Sagar        |  22 |      1 |   4 | JS     |
|  1 | Sagar        |  22 |      1 |   3 | PYTHON |
|  1 | Sagar        |  22 |      1 |   2 | SQL    |
|  1 | Sagar        |  22 |      1 |   1 | JAVA   |
|  2 | Sagar        |  22 |      1 |   4 | JS     |
|  2 | Sagar        |  22 |      1 |   3 | PYTHON |
|  2 | Sagar        |  22 |      1 |   2 | SQL    |
|  2 | Sagar        |  22 |      1 |   1 | JAVA   |
|  3 | pavan        |  18 |      2 |   4 | JS     |
|  3 | pavan        |  18 |      2 |   3 | PYTHON |
|  3 | pavan        |  18 |      2 |   2 | SQL    |
|  3 | pavan        |  18 |      2 |   1 | JAVA   |
|  4 | pavan1       |  19 |      3 |   4 | JS     |
|  4 | pavan1       |  19 |      3 |   3 | PYTHON |
|  4 | pavan1       |  19 |      3 |   2 | SQL    |
|  4 | pavan1       |  19 |      3 |   1 | JAVA   |
|  5 | PARTH1       |  11 |      4 |   4 | JS     |
|  5 | PARTH1       |  11 |      4 |   3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |   2 | SQL    |
|  5 | PARTH1       |  11 |      4 |   1 | JAVA   |
|  6 | ROHAN        |  11 |      1 |   4 | JS     |
|  6 | ROHAN        |  11 |      1 |   3 | PYTHON |
|  6 | ROHAN        |  11 |      1 |   2 | SQL    |
|  6 | ROHAN        |  11 |      1 |   1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |   4 | JS     |
|  7 | ROHAN Sharma |  11 |      1 |   3 | PYTHON |
|  7 | ROHAN Sharma |  11 |      1 |   2 | SQL    |
|  7 | ROHAN Sharma |  11 |      1 |   1 | JAVA   |
| 11 | hyder        |  24 |      4 |   4 | JS     |
| 11 | hyder        |  24 |      4 |   3 | PYTHON |
| 11 | hyder        |  24 |      4 |   2 | SQL    |
| 11 | hyder        |  24 |      4 |   1 | JAVA   |
| 15 | hyder        |  24 |      4 |   4 | JS     |
| 15 | hyder        |  24 |      4 |   3 | PYTHON |
| 15 | hyder        |  24 |      4 |   2 | SQL    |
| 15 | hyder        |  24 |      4 |   1 | JAVA   |
+----+--------------+-----+--------+-----+--------+
36 rows in set (0.00 sec)

mysql> select * from studentInfo si right join course cr on si.course = cr.cid;
+------+--------------+------+--------+-----+--------+
| id   | name         | age  | course | cid | cname  |
+------+--------------+------+--------+-----+--------+
|    1 | Sagar        |   22 |      1 |   1 | JAVA   |
|    2 | Sagar        |   22 |      1 |   1 | JAVA   |
|    6 | ROHAN        |   11 |      1 |   1 | JAVA   |
|    7 | ROHAN Sharma |   11 |      1 |   1 | JAVA   |
|    3 | pavan        |   18 |      2 |   2 | SQL    |
|    4 | pavan1       |   19 |      3 |   3 | PYTHON |
|    5 | PARTH1       |   11 |      4 |   4 | JS     |
|   11 | hyder        |   24 |      4 |   4 | JS     |
|   15 | hyder        |   24 |      4 |   4 | JS     |
+------+--------------+------+--------+-----+--------+
9 rows in set (0.00 sec)

mysql> select * from studentInfo si left join course cr on si.co
urse = cr.cid;
+----+--------------+-----+--------+------+--------+
| id | name         | age | course | cid  | cname  |
+----+--------------+-----+--------+------+--------+
|  1 | Sagar        |  22 |      1 |    1 | JAVA   |
|  2 | Sagar        |  22 |      1 |    1 | JAVA   |
|  3 | pavan        |  18 |      2 |    2 | SQL    |
|  4 | pavan1       |  19 |      3 |    3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |    4 | JS     |
|  6 | ROHAN        |  11 |      1 |    1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |    1 | JAVA   |
| 11 | hyder        |  24 |      4 |    4 | JS     |
| 15 | hyder        |  24 |      4 |    4 | JS     |
+----+--------------+-----+--------+------+--------+
9 rows in set (0.00 sec)

mysql> select * from studentInfo si inner join course cr on si.c
ourse = cr.cid;
+----+--------------+-----+--------+-----+--------+
| id | name         | age | course | cid | cname  |
+----+--------------+-----+--------+-----+--------+
|  1 | Sagar        |  22 |      1 |   1 | JAVA   |
|  2 | Sagar        |  22 |      1 |   1 | JAVA   |
|  6 | ROHAN        |  11 |      1 |   1 | JAVA   |
|  7 | ROHAN Sharma |  11 |      1 |   1 | JAVA   |
|  3 | pavan        |  18 |      2 |   2 | SQL    |
|  4 | pavan1       |  19 |      3 |   3 | PYTHON |
|  5 | PARTH1       |  11 |      4 |   4 | JS     |
| 11 | hyder        |  24 |      4 |   4 | JS     |
| 15 | hyder        |  24 |      4 |   4 | JS     |
+----+--------------+-----+--------+-----+--------+
9 rows in set (0.00 sec)

mysql>