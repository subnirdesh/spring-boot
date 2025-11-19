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

 
### @Id
- simply marks a field as the primary key of the entity.
- @GeneratedValue tells Hibernate HOW to automatically generate IDs.
    - | GenerationType     | Requires (DB Requirement)                      | How It Works                                                        | Description / Notes                                                |
      |--------------------|------------------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------|
      | AUTO               | Nothing specific                               | Hibernate chooses the best strategy based on the database           | Safe default, behavior varies depending on DB dialect              |
      | IDENTITY           | Auto-increment column                          | DB generates ID at INSERT; Hibernate retrieves it afterwards        | Best for MySQL; does NOT support batch inserts well                |
      | SEQUENCE           | Database sequence (e.g., Postgres, Oracle)     | Hibernate calls NEXTVAL on sequence *before* insert                 | Best for Postgres/Oracle; supports batching                        |
      | TABLE              | A table to store ID counters                   | Hibernate uses a table to simulate a sequence                       | Slow; rarely used in modern apps                                   |
      | UUID               | None (Hibernate generates UUID)                | Hibernate generates random UUID (Java UUID class)                   | Good for microservices; no DB dependency                           |
      | AUTO (with @SequenceGenerator) | Sequence recommended on DB         | Uses sequence generator if configured                               | You can override default sequence allocation                       |

- @SequenceGenerator — Custom Sequence Settings
  - @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1, initialValue = 100 )
  -  | Paramter | What it does                                                                    |
     |----------|---------------------------------------------------------------------------------|
     | name    | A unique name inside the entity.                                                |
     | sequenceName| Actual sequence name in the database.                                           |
      | allocationSize | Performance optimization. like storing next ids to be used so no need to hit db |
      | initialValue| First value of the sequence Hibernate will use.                                 |
 
    

## Persistence and Persistence Context 

Persistence in Java refers to the mechanism of storing and retrieving data permanently, so that it survives beyond the 
application's lifecycle. When your Java application closes, persistent data remains stored (typically in databases) and can be retrieved when the application restarts.

**What is Persistence Context in Java?**

A Persistence Context is a set of entity instances managed by the EntityManager. Think of it as a first-level cache or a staging area where JPA tracks all entities and their state changes.
Think of the persistence context as a special box (memory storage) created by the EntityManager to store and track your entity objects.

```
1. Reduces DB queries

find() for the same ID is served from the first-level cache.

2. Enables dirty checking

Because the persistence context holds the original and modified values.

3. Ensures identity

Within a persistence context:

em.find(User.class, 1L) == em.find(User.class, 1L)  // true

The same object instance is returned.

This ensures consistency.

```


### Key Characteristics:

- Acts as cache between java object and database
    - Caching : keeping entity objects in the persistence context instead of hitting DB repeatedly.
- Tracks changes to entities automatically
    - Ensures one Java object per ID while the EntityManager is active.
- Ensures uniqueness - only one instance of an entity with a given ID exists in the context

## Entity Manager 

EntityManager is the primary JPA interface for interacting with the persistence context. It's your gateway to perform all database operations - creating, reading, updating, and deleting entities.
Think of EntityManager as a manager that handles the lifecycle of your entities and their relationship with the database.

In Spring Boot, you rarely create EntityManager manually. Spring manages it for you through:

- Spring Data JPA (Repository pattern - most common)
- @PersistenceContext injection (direct EntityManager usage)
- EntityManagerFactory (manual creation - rare)

### PersistenceContext Injection 

```
@Repository
public class EmployeeRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }
    
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }
    
    public void update(Employee employee) {
        entityManager.merge(employee);
    }
    
    public void delete(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
```


##  DDL-auto Specification  in Spring Boot

Hibernate (the JPA provider) needs to know how it should handle your database schema when the application starts.

Spring Boot does not know whether you want:
- to create tables automatically
- to update tables automatically
- to validate existing tables
- or to do nothing

So you must tell Hibernate what to do with database structure using:

| Value | Behavior | Data Loss | When to Use | What It Does | Pros | Cons |
|-------|----------|-----------|-------------|--------------|------|------|
| none | No schema management | No | Production | Hibernate does nothing with schema | Full control, predictable | Requires manual schema management |
| validate | Schema validation only | No | Production | Validates entity mappings match database schema | Safe, catches mismatches early | Won't fix issues automatically |
| update | Adds missing elements | No | Development | Adds new tables and columns only | Convenient during development | Can cause inconsistencies over time |
| create | Drops and recreates | YES | Testing | Drops all tables on startup, creates fresh schema | Always clean state | Destroys all data on every restart |
| create-drop | Creates/drops on start/stop | YES | Integration Tests | Creates schema on startup, drops on shutdown | Perfect test isolation | Destroys data on startup and shutdown |


## Spring Data JPA
Spring Data JPA is a part of the Spring Data project. It’s a framework that simplifies working with relational databases in Java applications using JPA (Java Persistence API).

**Repository Hierarchy**
```angular2html

Repository (marker interface)
            ↓
CrudRepository (basic CRUD operations)
            ↓
PagingAndSortingRepository (pagination + sorting)
            ↓
JpaRepository (JPA specific + all above)
```

### JPA Repository 
JpaRepository is an interface provided by Spring Data JPA that gives you ready-made methods to perform database operations without writing any SQL or implementation code.



```angular2html
public interface StudentRepository extends JpaRepository<Student, Long> {
    // That's it! You get tons of methods for free
}
```


### Cascade
Cascade determines what happens to related entities when you perform operations (save, delete, update, etc.) on a parent entity. It's about propagating operations from parent to child entities.

### Quick Summary of all Cascade Type 
| Cascade Type | What It Does | When Operation Happens | Use When | ⚠️ Caution |
|--------------|--------------|------------------------|----------|------------|
| **PERSIST** | Saves child entities when parent is saved | `entityManager.persist(parent)` <br> `repository.save(parent)` | Creating new parent with new children together | Child must be transient (new, not yet in DB) |
| **MERGE** | Updates child entities when parent is updated | `entityManager.merge(parent)` <br> `repository.save(parent)` (on existing entity) | Updating parent and children in same operation | Can cause unexpected updates if not careful |
| **REMOVE** | Deletes child entities when parent is deleted | `entityManager.remove(parent)` <br> `repository.delete(parent)` <br> `repository.deleteById(id)` | Children cannot exist without parent (true ownership) | **DANGEROUS!** Can delete large amounts of data. Never use on ManyToMany or shared entities |
| **REFRESH** | Reloads child entities from DB when parent is refreshed | `entityManager.refresh(parent)` | Need to discard in-memory changes and reload from DB | Rarely used. Loses unsaved changes |
| **DETACH** | Removes child entities from persistence context when parent is detached | `entityManager.detach(parent)` <br> `entityManager.clear()` | Memory management in long transactions | Detached entities can't be lazy-loaded |
| **ALL** | Applies all above operations (PERSIST + MERGE + REMOVE + REFRESH + DETACH) | Any of the above operations | Strong parent-child ownership where child lifecycle is fully controlled by parent | Combines all risks above. Use carefully! |

### Common Combinations that are generally used 

| Scenario | Recommended Cascade | Example |
|----------|---------------------|---------|
| **Strong Ownership** (child can't exist without parent) | `CascadeType.ALL` + `orphanRemoval = true` | Order → OrderItems <br> Blog → Comments <br> User → Addresses |
| **Shared Entity** (child exists independently) | `{CascadeType.PERSIST, CascadeType.MERGE}` | Student ↔ Course <br> Author ↔ Book <br> Product ↔ Category |
| **Reference Only** (child is managed elsewhere) | **No cascade** or just `CascadeType.PERSIST` | Address → City <br> Employee → Department <br> Order → Customer |
| **ManyToMany** | `{CascadeType.PERSIST, CascadeType.MERGE}` | **NEVER use REMOVE!** |



