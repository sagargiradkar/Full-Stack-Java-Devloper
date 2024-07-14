### Advanced Object-Relational Mapping (ORM) with Hibernate

Advanced ORM techniques in Hibernate allow for more sophisticated mappings and configurations, enabling you to handle complex database schemas and relationships. Here are some advanced ORM concepts and how to implement them in Hibernate:

1. **Inheritance Mapping**:
   Hibernate supports mapping of Java inheritance hierarchies to database tables using different strategies.

   - **Single Table Inheritance**:
     All classes in the hierarchy are mapped to a single table.

     ```java
     @Entity
     @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
     @DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
     public abstract class Person {
         @Id
         private Long id;
         private String name;
     }

     @Entity
     @DiscriminatorValue("EMP")
     public class Employee extends Person {
         private String department;
     }

     @Entity
     @DiscriminatorValue("STU")
     public class Student extends Person {
         private String course;
     }
     ```

   - **Table Per Class Inheritance**:
     Each class in the hierarchy is mapped to its own table.

     ```java
     @Entity
     @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
     public abstract class Person {
         @Id
         private Long id;
         private String name;
     }

     @Entity
     public class Employee extends Person {
         private String department;
     }

     @Entity
     public class Student extends Person {
         private String course;
     }
     ```

   - **Joined Table Inheritance**:
     A separate table is created for each class, with the base class table containing common attributes.

     ```java
     @Entity
     @Inheritance(strategy = InheritanceType.JOINED)
     public abstract class Person {
         @Id
         private Long id;
         private String name;
     }

     @Entity
     public class Employee extends Person {
         private String department;
     }

     @Entity
     public class Student extends Person {
         private String course;
     }
     ```

2. **Composite Keys**:
   Composite keys (composite primary keys) are keys that consist of more than one column.

   - **Using `@Embeddable` and `@EmbeddedId`**:

     ```java
     @Embeddable
     public class EmployeeId implements Serializable {
         private String departmentId;
         private String employeeId;

         // getters, setters, equals, and hashCode
     }

     @Entity
     public class Employee {
         @EmbeddedId
         private EmployeeId id;

         private String name;

         // getters and setters
     }
     ```

   - **Using `@IdClass`**:

     ```java
     @Entity
     @IdClass(EmployeeId.class)
     public class Employee {
         @Id
         private String departmentId;
         @Id
         private String employeeId;

         private String name;

         // getters and setters
     }

     public class EmployeeId implements Serializable {
         private String departmentId;
         private String employeeId;

         // getters, setters, equals, and hashCode
     }
     ```

3. **Bidirectional Relationships**:
   Bidirectional relationships are relationships where both sides are aware of the other.

   - **One-to-Many / Many-to-One**:

     ```java
     @Entity
     public class Department {
         @Id
         private Long id;
         private String name;

         @OneToMany(mappedBy = "department")
         private List<Employee> employees;

         // getters and setters
     }

     @Entity
     public class Employee {
         @Id
         private Long id;
         private String name;

         @ManyToOne
         @JoinColumn(name = "department_id")
         private Department department;

         // getters and setters
     }
     ```

   - **Many-to-Many**:

     ```java
     @Entity
     public class Student {
         @Id
         private Long id;
         private String name;

         @ManyToMany
         @JoinTable(
             name = "student_course",
             joinColumns = @JoinColumn(name = "student_id"),
             inverseJoinColumns = @JoinColumn(name = "course_id"))
         private List<Course> courses;

         // getters and setters
     }

     @Entity
     public class Course {
         @Id
         private Long id;
         private String name;

         @ManyToMany(mappedBy = "courses")
         private List<Student> students;

         // getters and setters
     }
     ```

4. **Advanced Fetching Strategies**:
   Hibernate provides several fetching strategies to optimize data retrieval.

   - **Lazy and Eager Loading**:

     ```java
     @Entity
     public class Department {
         @Id
         private Long id;
         private String name;

         @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
         private List<Employee> employees;

         // getters and setters
     }
     ```

   - **Batch Fetching**:

     ```xml
     <hibernate-configuration>
         <session-factory>
             <!-- other properties -->
             <property name="hibernate.batch_fetch_size">10</property>
         </session-factory>
     </hibernate-configuration>
     ```

   - **Fetch Joins** (using JPQL):

     ```java
     String jpql = "SELECT d FROM Department d JOIN FETCH d.employees WHERE d.id = :id";
     Query query = entityManager.createQuery(jpql);
     query.setParameter("id", departmentId);
     Department department = query.getSingleResult();
     ```

5. **Custom Types and User-Defined Types**:
   Custom types can be created to handle non-standard data types or to map existing data types in a specific way.

   - **Creating a Custom Type**:

     ```java
     public class CustomStringType implements UserType {
         // implement required methods
     }
     ```

   - **Registering a Custom Type**:

     ```xml
     <hibernate-configuration>
         <session-factory>
             <!-- other properties -->
             <property name="hibernate.type.custom_type">com.example.CustomStringType</property>
         </session-factory>
     </hibernate-configuration>
     ```

6. **Second-Level Cache**:
   Hibernate’s second-level cache can be used to cache entities across sessions.

   - **Configuring Second-Level Cache**:

     ```xml
     <hibernate-configuration>
         <session-factory>
             <property name="hibernate.cache.use_second_level_cache">true</property>
             <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
         </session-factory>
     </hibernate-configuration>
     ```

   - **Caching Entities**:

     ```java
     @Entity
     @Cacheable
     @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
     public class Department {
         @Id
         private Long id;
         private String name;

         // getters and setters
     }
     ```

By leveraging these advanced ORM techniques, you can create a robust and efficient data access layer with Hibernate, capable of handling complex data models and relationships in your applications.