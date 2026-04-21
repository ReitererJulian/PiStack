# Spring Boot

## What is Spring Boot?

Spring Boot is a Java framework that lets you build web servers with REST APIs quickly.  
Without Spring Boot, you need to set everything up by yourself, like configuring a server.

You just write classes and use special annotations like `@RestController`, and Spring Boot takes care of the rest.

It also makes it a lot easier to work with databases.

---

## What is IoC?

Inversion of Control (IoC) is the backbone of Spring Boot.  
Normally, you create objects in your code when you need them.  
But with IoC, you let Spring decide when your objects get created.

### Easy example

#### Without IoC

- You go into the kitchen
    
- Prepare all ingredients
    
- Preheat the oven
    
- Bake the pizza
    

#### With IoC

- You go into a restaurant
    
- Tell them you want a pizza
    

---

## What is Dependency Injection?

Dependency Injection (DI) is how IoC is implemented.  
Instead of your class creating its own dependencies (like `new UserService()`), Spring injects them for you, usually through the constructor.

That is why your `UserController` takes a `UserService` in its constructor rather than creating one itself.

### Easy example

Your pizza needs more than just dough — it needs toppings.  
These toppings are **dependencies**.

#### Without DI

```java
public class UserController {
    private UserService userService = new UserService();
}
```

#### With DI

You just “inject” the dependency:

```java
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
```

In your code you simply say:  
“I need a `UserService`.”

Spring looks for it and injects it into your class via the constructor.

---

## What is a @Bean?

For your restaurant to know what can be served, it needs to be written down somewhere.

- `@Component` / `@Service` are standard classes that Spring detects and creates automatically.
    
- These are used for your own classes.
    

`@Bean` is used for external classes (libraries) that Spring does not manage by default.

You define that Spring should use the object you provide.

```java
@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }
}
```

---

## What is Spring Boot?

Spring Boot is a tool that helps you build applications (server + API) quickly and easily.

### Think like this:

- Your Java app is the restaurant
    
- Spring Boot sets everything up:
    
    - Starts a server
        
    - Creates routes (`/users`)
        
    - Handles requests
        

Without Spring Boot, you would have to build all of that yourself.

---

### Easy Java example

```java
@GetMapping("/users")
public List<User> getUsers() {
    return userService.getAllUsers();
}
```

This method is called every time the server receives a `GET /users` request.  
It returns all users as a list.

---

## What you need for this to work

You need a Controller.  
The controller handles HTTP requests and defines the URLs.

---

## Controller

The controller contains no business logic.  
It only forwards requests.

```java
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
```

When you send a request to  
`localhost:8080/api/users`,  
you receive a list of users.

---

## Service

The service class contains the business logic.

```java
@Service
public class UserService {

    public List<User> getAllUsers() {
        return List.of(
            new User(1, "Max"),
            new User(2, "Anna")
        );
    }
}
```

This can also be used to fetch data from a database.

---

## Model

The model class defines your data structure (e.g. `User`).

```java
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters
}
```

---

## How everything works together

- Client / Browser sends request → `GET /api/users`
    
- Controller receives request
    
- Controller calls Service
    
- Service gets data
    
- Controller returns data as JSON
    

```json
[
  { "id": 1, "name": "Max" },
  { "id": 2, "name": "Anna" }
]
```

---

## Starting a Spring Boot app

The main class starts everything:

```java
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

This automatically starts:

- The embedded server
    
- The whole backend (controllers, services, etc.)
    

---

## Annotation Recap

### `@SpringBootApplication`

Starts the entire Spring Boot app.  
Combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

```java
@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
```

---

### `@RestController`

Marks a class as an HTTP controller.  
Combines `@Controller` and `@ResponseBody`.  
Returns JSON instead of HTML.

---

### `@RequestBody`

Converts JSON request body into a Java object.

```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return userService.save(user);
}
```

---

### `@RequestParam`

Reads query parameters like `/users?name=Max`.

```java
@GetMapping("/users")
public List<User> search(@RequestParam String name) {
    return userService.findByName(name);
}
```

---

### `@RequestMapping`

Sets a base URL for a controller.

```java
@RequestMapping("/api")
```

---

### `@GetMapping`

Handles HTTP GET requests.

---

### `@PostMapping`

Handles HTTP POST requests.

```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return userService.save(user);
}
```

---

### `@DeleteMapping`

Handles HTTP DELETE requests.

```java
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable int id) {
    userService.delete(id);
}
```

---

### `@PathVariable`

Extracts values from the URL path.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable int id) {
    return userService.findById(id);
}
```

---

### `@Component`

Generic Spring-managed component. Spring detects and manages it automatically.

```java
@Component
public class EmailValidator {

    public boolean isValid(String email) {
        return email.contains("@");
    }
}
```

---

### `@Service`

Marks a service layer class. Used for business logic.

```java
@Service
public class UserService {

    public List<User> getAllUsers() {
        return List.of(
            new User(1, "Max"),
            new User(2, "Anna")
        );
    }
}
```

---

### `@Repository`

Marks a database access class.  
Spring handles database-related exceptions differently for repositories.

```java
@Repository
public class UserRepository {

    public User findById(int id) {
        return new User(id, "Max");
    }
}
```

---

### `@Bean`

Spring manages the returned object as a bean.  
Used for external classes that you cannot modify.

```java
@Bean
public PasswordEncoder encoder() {
    return new PasswordEncoder();
}
```

---

### `@Autowired`

Spring injects dependencies automatically.  
(Usually not needed anymore if you use constructor injection.)

```java
@Service
public class OrderService {

    @Autowired
    private UserService userService;
}
```

---

### `@Configuration`

Marks a class as a source of bean definitions.

```java
@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new PasswordEncoder();
    }
}
```


---