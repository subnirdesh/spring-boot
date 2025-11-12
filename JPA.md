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

  | **When to Use ORM** | **When to Use Raw SQL** |
  |----------------------|--------------------------|
  | Standard CRUD operations | Complex reporting queries |
  | Object-oriented domain model | Bulk operations (millions of records) |
  | Rapid development needed | Performance-critical sections |
  | Database independence important | Database-specific features needed |


  





