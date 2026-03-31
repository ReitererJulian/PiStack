# Spring Boot

## What is Spring Boot?

Spring Boot is a Tool that helps you build applications (server + api) quick and easy 

### Think like this:

- Your Java app is the restaurant
- Spring Boot sets it all up
	- Starting a server 
	- Creating requests (/users)
	- Handling requests

Without Spring Boot, you would have to build all that yourself


## Example in Spring Boot
```java
@GetMapping("/users")
public List<Users> getUsers()
{
	return userService.getAllUsers();
}
```

This calls the method ```getUsers()``` every time the server receives a ```GET /users```  request. Then the method then returns all Users through a list