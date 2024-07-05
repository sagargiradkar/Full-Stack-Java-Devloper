JPA (Java Persistence API) provides different strategies for generating primary key values for entities. These strategies are specified using the `@GeneratedValue` annotation along with a strategy type. Here’s an explanation of each strategy with examples:

### 1. Identity
**Identity** generation relies on the underlying database to generate the primary key values. The database auto-increments the primary key values, making them unique for each new record.

#### Example:

```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private double price;

    // Getters and setters
}
```

In this example, when a new `Product` entity is persisted, the database will automatically generate the value for the `id` field.

### 2. Sequence
**Sequence** generation uses a database sequence to generate unique values. This is particularly useful in databases like Oracle which support sequences.

#### Example:

```java
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", allocationSize = 1)
    private Long id;
    
    private Date orderDate;
    private double total;

    // Getters and setters
}
```

In this example, a sequence named `order_sequence` is used to generate the primary key values for `Order` entities. The `allocationSize` parameter determines how many sequence numbers are allocated at a time.

### 3. Table
**Table** generation uses a separate table to generate primary key values. This strategy is database-agnostic and can be used with any database.

#### Example:

```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_gen")
    @TableGenerator(name = "customer_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "customer_id", allocationSize = 1)
    private Long id;
    
    private String firstName;
    private String lastName;

    // Getters and setters
}
```

In this example, a table named `id_gen` is used to generate primary key values for `Customer` entities. The table has columns `gen_name` and `gen_value` to store the name of the generator and the current value, respectively.

### 4. Auto
**Auto** generation allows the persistence provider (e.g., Hibernate) to choose the appropriate strategy based on the database dialect. It can choose between `IDENTITY`, `SEQUENCE`, or `TABLE` based on what the database supports.

#### Example:

```java
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Date invoiceDate;
    private double amount;

    // Getters and setters
}
```

In this example, the persistence provider will automatically choose the most suitable strategy for generating primary key values for `Invoice` entities based on the database in use.

Each of these strategies offers a way to generate unique primary key values, tailored to different database capabilities and requirements.