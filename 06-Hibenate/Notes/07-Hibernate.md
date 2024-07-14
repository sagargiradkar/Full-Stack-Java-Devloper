User Input => PageSize(3)
parameter  => pageNo([1],[2],[3].....) ,
              pageCount(In How many pages the records should be displayed)

### Hibernate Reverse Engineering Steps:

1. **Entity Class <====> ORM <======> Table Generation**
   - Hibernate reverse engineering involves generating Java entity classes from an existing database schema. This process is facilitated using Hibernate tools provided by JBoss.

### Installing JBoss Tools for Hibernate Reverse Engineering:

1. **Open Eclipse IDE**:
   - Launch your Eclipse IDE where you want to set up Hibernate reverse engineering.

2. **Navigate to Eclipse Marketplace**:
   - Click on the `Help` menu.
   - Select `Eclipse Marketplace`.

3. **Search and Install JBoss Tools**:
   - In the `Find` search box, type `JBoss Tools`.
   - Look for the `JBoss Tools` plugin (version 4.2.6 or the latest compatible version with your Eclipse).
   - Click `Install` and follow the on-screen instructions to complete the installation.

### Using Hibernate Tools for Reverse Engineering:

1. **Configure Hibernate Tools**:
   - After installing JBoss Tools, you need to configure the Hibernate tools within Eclipse.
   - Go to `Window` -> `Preferences` -> `Hibernate`.
   - Set up the Hibernate configuration by providing necessary details such as database connection settings, dialect, etc.

2. **Create a Hibernate Configuration File**:
   - Right-click on your project in the Project Explorer.
   - Select `New` -> `Other` -> `Hibernate` -> `Hibernate Configuration File (cfg.xml)`.
   - Configure the file with your database connection details.

3. **Generate Hibernate Reverse Engineering File**:
   - Right-click on your project again.
   - Select `New` -> `Other` -> `Hibernate` -> `Hibernate Reverse Engineering File (reveng.xml)`.
   - Configure the reverse engineering file to specify which tables and columns to map.

4. **Run Hibernate Code Generation**:
   - Right-click on your project.
   - Select `Run As` -> `Hibernate Code Generation`.
   - Choose your configuration and run the code generation to create entity classes from the database schema.

### Example of `reveng.xml` Configuration:
```xml
<!DOCTYPE hibernate-reverse-engineering PUBLIC
        "-//Hibernate/Hibernate Reverse Engineering DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-reverse-engineering-3.0.dtd">
<hibernate-reverse-engineering>
    <schema-selection match-catalog="YOUR_DATABASE_NAME"/>
    <table-filter match-name="YOUR_TABLE_NAME"/>
</hibernate-reverse-engineering>
```

### Example of `hibernate.cfg.xml` Configuration:
```xml
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME</property>
        <property name="hibernate.connection.username">YOUR_DB_USERNAME</property>
        <property name="hibernate.connection.password">YOUR_DB_PASSWORD</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <mapping resource="your_package/EntityName.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```

By following these steps, you can effectively use Hibernate tools from JBoss to perform reverse engineering, generating entity classes from your existing database tables.