### Brief Notes

#### Language: Java
- **Java**: A high-level, class-based, object-oriented programming language widely used for building enterprise-scale applications.

#### Technology: JDBC
- **JDBC (Java Database Connectivity)**: An API that allows Java programs to interact with databases. It provides methods to query and update data in a database.

#### Framework: Hibernate (ORM Tool)
- **ORM (Object-Relational Mapping)**: A technique to convert data between incompatible type systems (object-oriented programming languages and relational databases).
- **Hibernate**: An ORM framework that maps Java objects to database tables and vice versa.

#### ORM Operations
- **Operations in ORM**: Perform operations only on objects.
- **Hibernate**: Maps objects to database rows.
    - **Single Row Operation (SRO)**:
        - `save()` / `persist()`: Insert operations.
        - `get()` / `load()`: Retrieve operations.
        - `update()` / `saveOrUpdate()`: Update operations.
        - `delete()`: Delete operations.
    - **Bulk Operation**: Work with more than one row.
        - **HQL/JPQL**: Hibernate Query Language/Java Persistence Query Language.
        - **NativeQuery**: Use of native SQL queries.
        - **Criteria API**: A programmatic way to create queries, preferred by Java developers.

#### Hibernate Persistence Operations
- **Objects Used in Hibernate**:
    - `Configuration`: Configures Hibernate.
    - `SessionFactory` (heavy weight): Creates `Session` objects.
    - `Session`: Used to get a physical connection with a database.
    - `Transaction`: Manages transactions.
- **Single Row Operations (SRO)**:
    - `save()` / `persist()`: Perform insertion operations.
    - `get()` / `load()`: Fetch data.
    - `update()` / `saveOrUpdate()`: Modify existing data.
    - `delete()`: Remove data.

#### POC (Proof of Concept)
- **POC**: An implementation to verify that a concept or theory has practical potential.