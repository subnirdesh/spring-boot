# JPA 

## ORM (Object Relational Mapping)

**Understanding the problem first:**

Java works with objects (Student instances), but databases work with tables and rows. These are two completely different worlds:

**Java** = Object-oriented (objects, inheritance, encapsulation, polymorphism)

**Database** = Relational (tables, rows, foreign keys, SQL)

This mismatch is called the "Impedance Mismatch".

**Impedance mismatch** in Java means the conceptual and structural gap between object-oriented data (Java objects) and relational data (database tables), which makes direct mapping difficult.


### What ORM Does

ORM is a technique/framework that automatically converts (maps) between:

```
Java objects <--> Database tables

Object fields <--> Table columns

Object references <--> Foreign keys

Collections of objects ↔️ SQL JOINs
```

Think of ORM as a translator that speaks both "Object Language" and "Database Language".

## Complete Picture: The ORM Stack in Spring

```
                            
                                        ┌─────────────────────────────────────┐
                                        │   Your Application (@Service)       │
                                        │   - Business Logic                  │
                                        └──────────────┬──────────────────────┘
                                                       │
                                        ┌──────────────▼──────────────────────┐
                                        │   Spring Data JPA                   │
                                        │   - Repository Interfaces           │
                                        │   - Query Methods                   │
                                        │   - @Transactional                  │
                                        └──────────────┬──────────────────────┘
                                                       │
                                        ┌──────────────▼──────────────────────┐
                                        │   JPA (Specification)               │
                                        │   - @Entity, @Id annotations        │
                                        │   - EntityManager API               │
                                        │   - JPQL                            │
                                        └──────────────┬──────────────────────┘
                                                       │
                                        ┌──────────────▼──────────────────────┐
                                        │   Hibernate (JPA Implementation)    │
                                        │   - Persistence Context             │
                                        │   - Caching                         │
                                        │   - SQL Generation                  │
                                        │   - Dirty Checking                  │
                                        └──────────────┬──────────────────────┘
                                                       │
                                        ┌──────────────▼──────────────────────┐
                                        │   JDBC (Low-level)                  │
                                        │   - Connection Management           │
                                        │   - SQL Execution                   │
                                        └──────────────┬──────────────────────┘
                                                       │
                                        ┌──────────────▼──────────────────────┐
                                        │   Database (MySQL/PostgreSQL/etc)   │
                                        └─────────────────────────────────────┘


```

**Difference between ORM and Raw SQL**

  | **When to Use ORM** | **When to Use Raw SQL** |
  |----------------------|--------------------------|
  | Standard CRUD operations | Complex reporting queries |
  | Object-oriented domain model | Bulk operations (millions of records) |
  | Rapid development needed | Performance-critical sections |
  | Database independence important | Database-specific features needed |


  


## Java Persistence API (JPA)

JPA ( Java Persistence API) is a specification (not an implementation) that defines how Java objects should be mapped to relational database tables. Think of it as a contract that tells us how to:

- Convert Java objects into database rows
- Retrieve database rows as Java objects
- Manage relationships between objects/tables

**With JPA:**
- Work with Java objects naturally
- JPA handles SQL generation
- Automatic object-relational mapping
- Database-independent code

**ORM (Object-Relational Mapping)**
The bridge between object-oriented programming and relational databases:

- Class ↔ Table
- Object ↔ Row
- Field ↔ Column
- Reference ↔ Foreign Key

 
 **Entity**

A entity is an java class that represents the database table
Each instance of the class corresponds to a row in that table.
  
In Spring Boot / JPA, an entity class is usually annotated with @Entity:
```
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private int age;

    // constructors, getters, setters
}
```

**Entity classes are mainly used to:**

- Represent database tables in code: We can work with objects instead of writing raw SQL queries.
- Enable Object-Relational Mapping (ORM): Automatically map Java objects to database tables.
- Maintain data consistency: The mapping ensures that updates to objects are reflected in the database and vice versa.
- Reduce boilerplate: We don’t need to manually convert query results to objects; JPA/Hibernate does it for us.


## JPA Annotations 

| Annotation                | Purpose                                             | Example                                |
| ------------------------- | --------------------------------------------------- | -------------------------------------- |
| `@Entity`                 | Marks a class as a JPA entity (table)               | `@Entity public class Student { ... }` |
| `@Table(name="students")` | Specifies the table name in the database (optional) | `@Table(name="students")`                                                              |
| `@Id`                                                     | Marks the primary key                         | `@Id private Long id;`                                    |
| `@GeneratedValue(strategy=GenerationType.IDENTITY)`       | Auto-generates primary key                    | `@GeneratedValue(strategy = GenerationType.IDENTITY)`     |
| `@Column(name="student_name", nullable=false, length=50)` | Maps field to column with optional properties | `@Column(name="student_name", nullable=false, length=50)` |
| `@Transient`                                              | Field will **not** be persisted in DB         | `@Transient private int tempValue;`                       |




  





