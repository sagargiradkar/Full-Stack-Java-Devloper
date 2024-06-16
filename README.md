# Full Stack Java Developer Learning Repository

Welcome to my Full Stack Java Developer Learning Repository! This repository is a daily log of my journey to become a proficient full-stack Java developer. Here, I document my learning progress, code examples, projects, and notes on various technologies that I explore. My learning path includes Core Java, SQL, JDBC, JSP & JEE, Spring Framework, Spring MVC, Spring Data JPA, Spring Boot, and Microservices.

## Table of Contents

- [Full Stack Java Developer Learning Repository](#full-stack-java-developer-learning-repository)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Technologies](#technologies)
    - [Core Java](#core-java)
    - [SQL](#sql)
    - [JDBC](#jdbc)
    - [Servlet \& JSP](#servlet--jsp)
    - [Spring Framework](#spring-framework)
    - [Spring MVC](#spring-mvc)
    - [Spring Data JPA](#spring-data-jpa)
    - [Spring Boot](#spring-boot)
    - [Microservices](#microservices)
  - [Daily Learning Logs](#daily-learning-logs)
    - [Example Log Structure](#example-log-structure)
    - [Exercises:](#exercises)
    - [Issues Encountered:](#issues-encountered)
  - [Projects](#projects)
    - [Example Projects](#example-projects)
  - [Resources](#resources)
    - [Books](#books)
    - [Online Courses](#online-courses)
    - [Documentation](#documentation)
    - [Blogs and Websites](#blogs-and-websites)
  - [Contributing](#contributing)
    - [How to Contribute](#how-to-contribute)
  - [License](#license)

## Introduction

This repository serves as my personal knowledge base where I keep track of everything I learn about full-stack Java development. Each day, I focus on a different technology, gradually building a comprehensive understanding of the full stack. This README provides an overview of the technologies I'm learning, the structure of my daily logs, and how to navigate and contribute to this repository.

## Technologies

### Core Java

Core Java forms the foundation of my learning journey. It includes understanding the basics of Java programming language, including syntax, data types, control structures, object-oriented programming principles, and essential libraries. 

- **Topics Covered**: 
  - Basic syntax and structure
  - Variables, data types, and operators
  - Control flow statements (if-else, switch, loops)
  - Classes and objects
  - Inheritance, polymorphism, encapsulation, and abstraction
  - Exception handling
  - Collections framework (List, Set, Map)
  - Java Streams and Lambda expressions

### SQL

SQL (Structured Query Language) is crucial for database management. It involves learning how to create, read, update, and delete data in relational databases.

- **Topics Covered**: 
  - Basic SQL syntax
  - Creating and managing tables
  - Inserting, updating, and deleting data
  - Querying data with SELECT statements
  - Using JOINs to combine data from multiple tables
  - Aggregate functions (SUM, COUNT, AVG, etc.)
  - Subqueries and nested queries
  - Indexing and optimization

### JDBC

JDBC (Java Database Connectivity) is the Java API for connecting and executing queries with databases. It provides a standard interface for interacting with databases using Java.

- **Topics Covered**:
  - JDBC architecture
  - Establishing a connection to the database
  - Executing SQL queries and updates
  - Processing the ResultSet
  - Handling transactions
  - Using PreparedStatement and CallableStatement
  - Managing database connections with connection pools

### Servlet , JSP & JEE

JSP (JavaServer Pages) and JEE (Java Enterprise Edition) are used for building dynamic web applications.

- **Topics Covered**:
  - Basics of web applications
  - JSP syntax and directives
  - JSP implicit objects and scripting elements
  - Servlets and their lifecycle
  - MVC architecture
  - Session management and cookies
  - JSTL (JSP Standard Tag Library)
  - Creating and deploying web applications

### Spring Framework

The Spring Framework is a comprehensive framework for enterprise Java development. It provides support for dependency injection, aspect-oriented programming, transaction management, and more.

- **Topics Covered**:
  - Overview of the Spring Framework
  - Inversion of Control (IoC) and Dependency Injection (DI)
  - Spring Bean lifecycle
  - Spring AOP (Aspect-Oriented Programming)
  - Spring transaction management
  - Spring JDBC and ORM support

### Spring MVC

Spring MVC is a module of the Spring Framework for building web applications. It follows the Model-View-Controller design pattern.

- **Topics Covered**:
  - Basics of Spring MVC
  - Setting up Spring MVC project
  - Controllers and RequestMappings
  - Handling form submissions
  - Data binding and validation
  - Integrating with JSP for views
  - Exception handling in Spring MVC

### Spring Data JPA

Spring Data JPA makes it easier to implement JPA-based repositories. It provides a standard approach to managing relational data in applications.

- **Topics Covered**:
  - Introduction to Spring Data JPA
  - Setting up Spring Data JPA project
  - Defining repositories and CRUD operations
  - Query methods and custom queries
  - Pagination and sorting
  - Entity relationships and mappings
  - Using criteria API and specifications

### Spring Boot

Spring Boot simplifies the development of Spring applications by providing a set of conventions and configurations. It allows for rapid development and deployment.

- **Topics Covered**:
  - Introduction to Spring Boot
  - Creating Spring Boot applications
  - Spring Boot starters and dependencies
  - Configuration and properties
  - Spring Boot auto-configuration
  - Creating RESTful web services
  - Testing Spring Boot applications
  - Deploying Spring Boot applications

### Microservices

Microservices architecture involves breaking down applications into smaller, independently deployable services. This section covers the basics of microservices and how to build them using Spring Boot and Spring Cloud.

- **Topics Covered**:
  - Introduction to microservices
  - Benefits and challenges of microservices
  - Designing microservices architecture
  - Building microservices with Spring Boot
  - Service discovery with Eureka
  - Load balancing with Ribbon
  - Circuit breaker with Hystrix
  - API Gateway with Zuul
  - Distributed tracing with Sleuth and Zipkin

## Daily Learning Logs

Each day, I document what I learn in a markdown file within the `daily-logs` directory. These logs include summaries of concepts learned, code snippets, exercises, and any issues encountered along the way. 

### Example Log Structure

```
## Date: YYYY-MM-DD

### Topic: Core Java

### Summary:
- Learned about basic syntax and structure of Java.
- Practiced writing simple Java programs.

### Code Snippets:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Exercises:
1. Write a Java program to print the sum of two numbers.
2. Create a class representing a Car with attributes and methods.

### Issues Encountered:
- Faced an issue with classpath configuration. Resolved by setting the correct environment variables.
```

## Projects

In addition to daily learning, I undertake projects to apply what I've learned in practical scenarios. These projects are stored in the `projects` directory and come with their own README files explaining the project goals, setup instructions, and implementation details.

### Example Projects

1. **Employee Management System**:
   - A web application to manage employee records using Spring Boot, Spring MVC, and Spring Data JPA.

2. **Online Store**:
   - An e-commerce platform built with JSP, JEE, and Spring Framework, featuring product listings, shopping cart, and order management.

3. **Microservices Demo**:
   - A microservices-based application demonstrating service discovery, load balancing, and API gateway using Spring Boot and Spring Cloud.

## Resources

Here are some resources that I find useful in my learning journey:

### Books
- *Effective Java* by Joshua Bloch
- *Java: The Complete Reference* by Herbert Schildt
- *Spring in Action* by Craig Walls
- *Microservices Patterns* by Chris Richardson

### Online Courses
- [Udemy: Java Programming Masterclass](https://www.udemy.com/course/java-the-complete-java-developer-course/)
- [Coursera: Java Programming and Software Engineering Fundamentals](https://www.coursera.org/specializations/java-programming)
- [Pluralsight: Spring Framework: Spring Fundamentals](https://www.pluralsight.com/courses/spring-framework-spring-fundamentals)

### Documentation
- [Official Java Documentation](https://docs.oracle.com/javase/8/docs/)
- [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

### Blogs and Websites
- [Baeldung](https://www.baeldung.com/)
- [DZone Java Zone](https://dzone.com/java-jdk-development-tutorials-tools-news)
- [Java Code Geeks](https://www.javacodegeeks.com/)

## Contributing

I welcome contributions from others who are also passionate about full-stack Java development. If you have any suggestions, improvements, or want to share your own learning experiences, please feel free to submit a pull request.

### How to Contribute
1. Fork this repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## License

This repository is licensed under the MIT License. You are free to use, modify, and distribute the content as long as you include proper attribution.

---

Thank you for visiting my Full Stack Java Developer Learning Repository! I hope you find the content here helpful and inspiring. Happy coding!