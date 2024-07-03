### Limitations of JDBC with Example Explanation

1. **Boilerplate Code**
   - **Example**: Establishing a connection, executing a query, and processing the results require multiple lines of repetitive code.
   ```java
   Connection connection = null;
   Statement statement = null;
   ResultSet resultSet = null;
   try {
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
       statement = connection.createStatement();
       resultSet = statement.executeQuery("SELECT * FROM users");
       while (resultSet.next()) {
           System.out.println("User ID: " + resultSet.getInt("id"));
           System.out.println("Username: " + resultSet.getString("username"));
       }
   } catch (SQLException e) {
       e.printStackTrace();
   } finally {
       try {
           if (resultSet != null) resultSet.close();
           if (statement != null) statement.close();
           if (connection != null) connection.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   ```
   - **Explanation**: The code involves a lot of boilerplate for managing connections, statements, and result sets, which makes it verbose and error-prone.

2. **Manual Mapping**
   - **Example**: Mapping SQL result sets to Java objects manually.
   ```java
   List<User> users = new ArrayList<>();
   try {
       resultSet = statement.executeQuery("SELECT * FROM users");
       while (resultSet.next()) {
           User user = new User();
           user.setId(resultSet.getInt("id"));
           user.setUsername(resultSet.getString("username"));
           users.add(user);
       }
   } catch (SQLException e) {
       e.printStackTrace();
   }
   ```
   - **Explanation**: The manual mapping of result set data to Java objects is tedious and error-prone, especially for large and complex queries.

3. **Error Handling**
   - **Example**: Handling SQL exceptions.
   ```java
   try {
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
       statement = connection.createStatement();
       resultSet = statement.executeQuery("SELECT * FROM users");
   } catch (SQLException e) {
       e.printStackTrace();
       // Additional error handling logic
   }
   ```
   - **Explanation**: Error handling with JDBC involves catching and managing SQL exceptions explicitly, which can clutter the code and make it harder to follow.

4. **Resource Management**
   - **Example**: Ensuring all resources are closed.
   ```java
   try {
       if (resultSet != null) resultSet.close();
       if (statement != null) statement.close();
       if (connection != null) connection.close();
   } catch (SQLException e) {
       e.printStackTrace();
   }
   ```
   - **Explanation**: Properly managing resources is complex and easy to get wrong, potentially leading to memory leaks and other resource-related issues.

5. **Lack of Abstraction**
   - **Example**: Changing database structure requires code changes.
   ```java
   String query = "SELECT id, username FROM users";
   resultSet = statement.executeQuery(query);
   while (resultSet.next()) {
       int id = resultSet.getInt("id");
       String username = resultSet.getString("username");
   }
   ```
   - **Explanation**: Directly working with SQL queries means any change in the database structure requires corresponding changes in the code, making maintenance harder.

6. **No Caching Mechanism**
   - **Example**: Querying the database for frequently accessed data.
   ```java
   resultSet = statement.executeQuery("SELECT * FROM users WHERE id = 1");
   if (resultSet.next()) {
       System.out.println("Username: " + resultSet.getString("username"));
   }
   ```
   - **Explanation**: JDBC does not provide caching, leading to potential performance issues for frequently accessed data.

7. **Database Vendor Dependency**
   - **Example**: Vendor-specific SQL syntax.
   ```java
   String query = "SELECT TOP 10 * FROM users"; // SQL Server syntax
   resultSet = statement.executeQuery(query);
   ```
   - **Explanation**: SQL syntax and features can vary between database vendors, leading to compatibility issues when switching databases.

8. **Scalability Issues**
   - **Example**: Managing complex transactions.
   ```java
   connection.setAutoCommit(false);
   try {
       statement.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
       statement.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");
       connection.commit();
   } catch (SQLException e) {
       connection.rollback();
       e.printStackTrace();
   }
   ```
   - **Explanation**: As applications grow, managing complex transactions and batch processing with JDBC can lead to intricate and hard-to-maintain code.

9. **Concurrency Control**
   - **Example**: Handling concurrent updates.
   ```java
   connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
   ```
   - **Explanation**: Properly managing concurrent database access and transactions can be challenging and requires careful coding to avoid issues like deadlocks and data inconsistencies.

10. **Lack of Advanced Features**
    - **Example**: No built-in support for advanced query features.
    ```java
    // No automatic change tracking or lazy loading
    ```
    - **Explanation**: JDBC lacks advanced features such as automatic change tracking, lazy loading, and built-in support for complex queries that ORM frameworks offer, leading to more manual effort for developers.


### Why We Go for ORM (Object-Relational Mapping)

ORM frameworks are used to simplify and streamline the process of interacting with databases by abstracting the database interactions and providing a higher level of abstraction over JDBC. Here are some key reasons to use ORM with examples and explanations:

1. **Simplified Development**
   - **Example**:
     ```java
     // Using Hibernate ORM to save a User object
     Session session = sessionFactory.openSession();
     session.beginTransaction();
     User user = new User();
     user.setUsername("john_doe");
     session.save(user);
     session.getTransaction().commit();
     session.close();
     ```
   - **Explanation**: ORM frameworks reduce the amount of boilerplate code required to perform database operations. In this example, saving a `User` object to the database requires only a few lines of code, without needing to write SQL statements or manage connections manually.

2. **Automatic Mapping**
   - **Example**:
     ```java
     @Entity
     @Table(name = "users")
     public class User {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private int id;
         
         @Column(name = "username")
         private String username;
         
         // Getters and setters
     }
     ```
   - **Explanation**: ORM frameworks automatically map Java objects to database tables based on annotations or XML configurations. This reduces the need for manual mapping and minimizes the risk of errors. In this example, the `User` class is automatically mapped to the `users` table in the database.

3. **Improved Productivity**
   - **Example**:
     ```java
     // Using JPA (Java Persistence API) with Spring Data
     @Repository
     public interface UserRepository extends JpaRepository<User, Integer> {
         List<User> findByUsername(String username);
     }
     ```
   - **Explanation**: ORM frameworks like JPA, combined with libraries like Spring Data, provide built-in repository interfaces that handle common database operations. This allows developers to focus on business logic rather than writing repetitive CRUD operations. The `UserRepository` interface in this example provides methods for querying users by username without writing SQL.

4. **Performance Optimization**
   - **Example**:
     ```java
     // Enabling second-level cache in Hibernate
     @Entity
     @Cacheable
     @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
     public class User {
         // Class definition
     }
     ```
   - **Explanation**: Many ORM frameworks offer caching mechanisms to improve performance, especially for read-heavy applications. In this example, Hibernate's second-level cache is enabled for the `User` entity, reducing the number of database hits for frequently accessed data.

5. **Database Independence**
   - **Example**:
     ```java
     // Switching from MySQL to PostgreSQL with minimal changes
     spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
     spring.datasource.username=postgres
     spring.datasource.password=password
     ```
   - **Explanation**: ORM frameworks provide a layer of abstraction that makes it easier to switch between different databases. By changing the database connection properties, the underlying ORM framework handles the differences in SQL dialects and database features, requiring minimal code changes.

6. **Transaction Management**
   - **Example**:
     ```java
     @Transactional
     public void transferFunds(int fromAccountId, int toAccountId, double amount) {
         Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow();
         Account toAccount = accountRepository.findById(toAccountId).orElseThrow();
         fromAccount.setBalance(fromAccount.getBalance() - amount);
         toAccount.setBalance(toAccount.getBalance() + amount);
         accountRepository.save(fromAccount);
         accountRepository.save(toAccount);
     }
     ```
   - **Explanation**: ORM frameworks often include built-in support for transaction management. In this example, the `@Transactional` annotation ensures that the entire method executes within a transaction, simplifying the handling of complex transactional operations and ensuring data consistency.

7. **Advanced Query Capabilities**
   - **Example**:
     ```java
     // Using JPQL (Java Persistence Query Language)
     String jpql = "SELECT u FROM User u WHERE u.username = :username";
     TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
     query.setParameter("username", "john_doe");
     List<User> results = query.getResultList();
     ```
   - **Explanation**: ORM frameworks provide advanced query languages like JPQL (Java Persistence Query Language) or HQL (Hibernate Query Language) that allow developers to write database queries in an object-oriented manner. This example demonstrates querying users by username using JPQL, which is more intuitive and easier to maintain than raw SQL.

By using ORM frameworks, developers can focus more on business logic and less on boilerplate code and manual database interactions. This leads to more maintainable, readable, and efficient code.