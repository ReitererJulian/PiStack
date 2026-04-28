
# DTO

A `dto` or `Data Transfer Object` is a simple Object which only purpose is to transfer data.
Not much logic, no database.

Your Entity is the internal truth. It mirrors the database and stays internal. The DTO is the external representation. 
It shows the client exactly what they need to see, nothing more and nothing less.

## Problem without DTO

Your `user` Entity looks like this:

```java
@Entity
public class User
{
	private int id; private String name; 
	private String email; 
	private String password; // Senistive
	private String role; // Only intern
}
```

If you now ask for an entity through a `GET` request you will receive the whole object (including the password and role)

```java
@GetMapping("/users")
public List<User> getUsers()
{
	return userRepository.findAll();
}
```

Response:

```json
{ 
	"id": 1,
	"name": "Max",
	"email": "max@example.com",
	"password": "geheim123",
	"role": "ADMIN" 
}
```


## Solution (using a dto)

You create a new class only with the fields the client is allowed to see.
So not including `password` or `role`

```java
	private int id;
	private String name;
	private String email;
	
	// No password or role
	
	// Getter & Setter
}
```


In your `service` you translate the `User Entity` into the dto

```java
@Service
public class UserService {

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(this::toDTO)  // translates into dto
            .toList();
    }
}
```

Client only gets this: 

```json
{
  "id": 1,
  "name": "Max",
  "email": "max@example.com"
}
```

DTOs are not only for response but also for saving data.

```java
public class RegisterDTO {
    private String name;
    private String email;
    private String password;  // gets into the server, never leaves it
}
```

```java
@PostMapping("/register")
public UserDTO register(@RequestBody RegisterDTO dto) {
    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPassword(hash(dto.getPassword())); // saved as hash
    
    User saved = userRepository.save(user);
    return userService.toDTO(saved); // returns a dto, not the entity
}
```

## Entity vs DTO

|                  | Entity                  | DTO                        |
|------------------|-------------------------|----------------------------|
| Connected to     | Database (@Entity)      | Nothing                    |
| Contains         | All fields of the table | Only what is needed        |
| Used for         | Database operations     | Communication with client  |
| Annotations      | @Entity, @Id, ...       | No Spring annotations      |

## Where to put dtos

```
src/
├── controller/
├── service/
├── repository/
├── model/
│   └── User.java          ← Entity
└── dto/
    ├── UserDTO.java        ← Response to the client
    └── RegisterDTO.java    ← Input from the client

```