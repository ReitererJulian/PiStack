# PostgreSQL

## What is PostgreSQL

PostgreSQL (Postgres) is a relational database.
It uses classic tables.

```
Tabelle: users
┌────┬──────┬─────────────────┐
│ id │ name │ email           │
├────┼──────┼─────────────────┤
│  1 │ Max  │ max@example.com │
│  2 │ Anna │ anna@example.com│
└────┴──────┴─────────────────┘
```

Data saved in the data base stays there, even if you restart the application

### PostgreSQL vs other Databases

| Database       | H2 (In-Memory) | SQLite        | PostgreSQL        |
|----------------|----------------|---------------|--------------------|
| Runs as        | In RAM / file  | File-based    | Dedicated server   |
| Use case       | Testing        | Small apps    | Production         |
| Multiple users | No             | Poor support  | Yes                |
| Data persists after restart | No (RAM mode) | Yes | Yes |
| In Spring Boot | Testing only   | Rarely used   | Standard           |

#### H2

H2 can run in your RAM or you can choose to save data in one file like with `PSQlite`.
This makes testing very great because you do not need to install anything, or set up anything like a server.

The problem is: Every time you restart your application, the database gets wiped (in RAM mode)

#### SQLite

SQLite saves everything in one file on your hard drive.
No server needed, runs everywhere.
Used in many mobile apps, or other small desktop apps.

The problem is: SQLite is not created for many request at once.
When two users want to access the data at the same time, on of them has to wait.
This causes a big bottleneck for large web applications

#### PostgreSQL

Postregs runs as a server process and can handle hundreds of requests at the same time.
It is built to be reliable, easy to scale and fast.
Standard for web applications.

Disadvantages: Needs to be installed and configured.

---

## How do PostgreSQL and Spring Boot connect

Your spring boot app is the restaurant, `Postgres` is the storage in the basement.
The app cooks (handles requests) but it gets the ingredients from the storage (`database`).

```
Client → Controller → Service → Repository → PostgreSQL
``` 

The `repository` is the layer that communicates with the database

---

### Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

JPA is the bridge between Java and the database.
It translates Java-Objects in Database-Cells and reversed.

### Configure the Connection

The connection is defined in the `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myDB
spring.datasource.username=postgres
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
```

You tell spring: "The database runs here (`datasource.url`), connect using theses credentials (`datasource.username` and `datasource.password`) "

#### `ddl-auto`

Using the `spring.jpa.hibernate.ddl-auto=` you can control `hibernate`  (Framework that translates Java-Objects to tables).


```properties
# update = Spring changes the tables automatically
# create = Tables 
# none
``` 

--- 

### Annotations

#### `@Entity`

`@Entity` tells JPA: "This class is a table in the database"


```java
@Entity
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;      // Primary-Key

    private String name;
    private String email;

    // Getter & Setter
}
```

`@ID` - Marks the primary key

`@GeneratedValue` - Postgres sets ID automatically


#### `@Repository`

`@Repository` tells Spring: "In this class are all the database operations"

```java
@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
    // findAll(), findById(), save(), delete()
}
```

---
