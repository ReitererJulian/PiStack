# Spring Boot

## What is Spring Boot?

Spring Boot is a Tool that helps you build applications (server + API) quickly and easily

### Think like this:

- Your Java app is the restaurant
- Spring Boot sets it all up
	- Starting a server 
	- Creating requests (/users)
	- Handling requests

Without Spring Boot, you would have to build all that yourself


### Easy example in Java
```java
@GetMapping("/users")
public List<Users> getUsers()
{
	return userService.getAllUsers();
}
```

This calls the method ```getUsers()``` every time the server receives a ```GET /users```  request. The method returns all users as a list.


## What you need for this to work

You will need a Controller. 
The controller is the class that handles HTTP requests and defines the URLs.

### Controller

```java
@RestController  
@RequestMapping("/api")  
public class UserController  
{  
private final UserService userService;  
  
public UserController(UserService userService)  
{  
this.userService = userService;  
}  
  
@GetMapping("/users")  
public List<User> getUsers()  
{  
return userService.getAllUsers();  
}  
}
```

When you send a GET request to `localhost:8080/api/users`,
you will receive a list of all users.

### Service

The service class is there for the actual work

```java
@Service
public class UserService
{
	public List<User> getAllUsers()
	{
		return List.of(
			new User(1, "Max"),
			new User(2, "Anna")
		);
	}
}
```
This can also be used to get data from a database

### Model

The model class defines the objects you want to work with, in our case `User`

```java
public class User
{
	private int id;
	private String name;
	
	public User(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	// Getter and Setter
}
```

### How everything works together

- Client / Browser sends a request -> `GET /api/users`
- Controller receives the request
- Controller calls service
- Service gets data
- Controller returns the data as a JSON

```JSON
[
  { "id": 1, "name": "Max" },
  { "id": 2, "name": "Anna" }
]
``` 

### Starting a Spring Boot App

The main class starts everything

```java
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

This starts automatically:

- The integrated server
- the complete backed (Controller etc)

## What is IoC?

Inversion of Control (IoC) is the backbone of Spring Boot.
Normally you create objects in your code, when you need them. 
But with IoC you let Spring deiced when your Objects get created 

## What is Dependency Injection?

Dependency Injection is how IoC is implemented. Instead of your class creating its own dependencies (like `new UserService()`), Spring injects them for you, usually through the constructor. This is why your `UserController` takes a `UserService` in its constructor rather than creating one itself.

## What is a @Bean?