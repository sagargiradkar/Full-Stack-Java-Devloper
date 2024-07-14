### Component Mapping in Hibernate

Component Mapping (also known as Embedded Objects) in Hibernate allows you to map multiple properties of an entity to a single Java object. This is particularly useful for grouping related attributes into a reusable component.

### Key Concepts

1. **Embeddable Class**: A class that contains fields to be embedded in an entity.
2. **Embedded Object**: An instance of the embeddable class within an entity.

### Example Scenario

Let's consider an example where an `Employee` entity has an `Address` component, which is a value object.

### Step-by-Step Implementation

1. **Define the Embeddable Class**:
   - The embeddable class contains fields to be embedded in the entity. This class is annotated with `@Embeddable`.

   ```java
   import javax.persistence.Embeddable;

   @Embeddable
   public class Address {
       private String street;
       private String city;
       private String state;
       private String zipCode;

       // Constructors, getters, and setters
       public Address() {}
       
       public Address(String street, String city, String state, String zipCode) {
           this.street = street;
           this.city = city;
           this.state = state;
           this.zipCode = zipCode;
       }

       public String getStreet() {
           return street;
       }

       public void setStreet(String street) {
           this.street = street;
       }

       public String getCity() {
           return city;
       }

       public void setCity(String city) {
           this.city = city;
       }

       public String getState() {
           return state;
       }

       public void setState(String state) {
           this.state = state;
       }

       public String getZipCode() {
           return zipCode;
       }

       public void setZipCode(String zipCode) {
           this.zipCode = zipCode;
       }
   }
   ```

2. **Embed the Component in an Entity**:
   - The entity class contains an instance of the embeddable class and is annotated with `@Embedded`.

   ```java
   import javax.persistence.*;

   @Entity
   public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;

       @Embedded
       private Address address;

       // Constructors, getters, and setters
       public Employee() {}

       public Employee(String name, Address address) {
           this.name = name;
           this.address = address;
       }

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Address getAddress() {
           return address;
       }

       public void setAddress(Address address) {
           this.address = address;
       }
   }
   ```

3. **Composite Embeddable Object**:
   - Sometimes, an embeddable object might itself contain other embeddable objects.

   ```java
   @Embeddable
   public class ContactInfo {
       private String phone;
       private String email;

       @Embedded
       private Address address;

       // Constructors, getters, and setters
       public ContactInfo() {}

       public ContactInfo(String phone, String email, Address address) {
           this.phone = phone;
           this.email = email;
           this.address = address;
       }

       public String getPhone() {
           return phone;
       }

       public void setPhone(String phone) {
           this.phone = phone;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }

       public Address getAddress() {
           return address;
       }

       public void setAddress(Address address) {
           this.address = address;
       }
   }
   ```

4. **Embedded Object with Overrides**:
   - You can override column mappings for embedded objects using the `@AttributeOverrides` and `@AttributeOverride` annotations.

   ```java
   @Entity
   public class Company {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;

       @Embedded
       @AttributeOverrides({
           @AttributeOverride(name = "address.street", column = @Column(name = "company_street")),
           @AttributeOverride(name = "address.city", column = @Column(name = "company_city")),
           @AttributeOverride(name = "address.state", column = @Column(name = "company_state")),
           @AttributeOverride(name = "address.zipCode", column = @Column(name = "company_zip_code"))
       })
       private ContactInfo contactInfo;

       // Constructors, getters, and setters
       public Company() {}

       public Company(String name, ContactInfo contactInfo) {
           this.name = name;
           this.contactInfo = contactInfo;
       }

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public ContactInfo getContactInfo() {
           return contactInfo;
       }

       public void setContactInfo(ContactInfo contactInfo) {
           this.contactInfo = contactInfo;
       }
   }
   ```

### Conclusion

Component mapping in Hibernate allows for a more modular and reusable approach to mapping complex data structures. By grouping related attributes into embeddable objects, you can achieve a cleaner and more maintainable domain model. This approach is especially beneficial when you have repeating patterns of attributes across multiple entities.