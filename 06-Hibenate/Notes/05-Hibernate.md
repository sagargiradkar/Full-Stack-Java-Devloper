Soft deletion in Hibernate refers to a strategy where records are not actually removed from the database when they are "deleted." Instead, a flag or timestamp is set to indicate that the record is no longer active. This approach allows you to maintain historical data and restore records if necessary. Here's how you can implement soft deletion in Hibernate:

### Step-by-Step Guide

1. **Add a Soft Delete Flag to Your Entity**

   Add a boolean field or a timestamp field to your entity to indicate whether the record is deleted.

   ```java
   @Entity
   public class YourEntity {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;

       private boolean deleted = false; // Soft delete flag

       // Getters and Setters
   }
   ```

2. **Create a Custom Base Entity**

   If you have multiple entities and want to implement soft delete across them, you can create a base entity class that all your entities will extend.

   ```java
   @MappedSuperclass
   public abstract class BaseEntity {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private boolean deleted = false;

       // Getters and Setters
   }
   ```

   Then, your entities will extend this base class.

   ```java
   @Entity
   public class YourEntity extends BaseEntity {
       private String name;

       // Additional fields and methods
   }
   ```

3. **Override the Delete Method in Your Repository**

   Instead of physically deleting the record, update the `deleted` flag.

   ```java
   public interface YourEntityRepository extends JpaRepository<YourEntity, Long> {
       @Modifying
       @Query("UPDATE YourEntity e SET e.deleted = true WHERE e.id = :id")
       void softDelete(@Param("id") Long id);
   }
   ```

4. **Filter Out Soft Deleted Records in Queries**

   To ensure that soft deleted records are not included in queries, you can use a global filter. 

   ```java
   @Entity
   @SQLDelete(sql = "UPDATE your_entity SET deleted = true WHERE id = ?")
   @Where(clause = "deleted = false")
   public class YourEntity {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;

       private boolean deleted = false;

       // Getters and Setters
   }
   ```

   The `@SQLDelete` annotation overrides the default delete behavior to update the `deleted` flag, and the `@Where` annotation ensures that the soft deleted records are filtered out in queries.

5. **Create a Custom Repository Method to Retrieve Deleted Records**

   If you need to access soft deleted records, you can create a custom repository method.

   ```java
   public interface YourEntityRepository extends JpaRepository<YourEntity, Long> {
       @Query("SELECT e FROM YourEntity e WHERE e.deleted = true")
       List<YourEntity> findDeleted();
   }
   ```

### Example

Here’s a complete example with a simple entity:

```java
@Entity
@SQLDelete(sql = "UPDATE your_entity SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class YourEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private boolean deleted = false;

   // Getters and Setters
}

public interface YourEntityRepository extends JpaRepository<YourEntity, Long> {
   @Modifying
   @Query("UPDATE YourEntity e SET e.deleted = true WHERE e.id = :id")
   void softDelete(@Param("id") Long id);

   @Query("SELECT e FROM YourEntity e WHERE e.deleted = true")
   List<YourEntity> findDeleted();
}
```

In your service layer, you can use the `softDelete` method to soft delete an entity:

```java
@Service
public class YourEntityService {
   @Autowired
   private YourEntityRepository repository;

   public void softDeleteEntity(Long id) {
       repository.softDelete(id);
   }
}
```

With this setup, calling `softDeleteEntity(id)` will mark the entity as deleted without physically removing it from the database. The `@Where` annotation ensures that soft deleted entities are not included in standard queries.