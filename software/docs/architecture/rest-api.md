# What is an API?

An API is a way for programs to communicate.

You (Client) want something from a other system (Server). The API is the thing in between

--- 

## Easy example:

You are in a restaurant and want to order pizza

- You -> Client
- Kitchen -> Server
- Waiter -> API

You tell the waiter (API) you want a pizza.
The waiter GETs the pizza from the kitchen (Server) and brings it to your table

--- 

The same thing works with software.

Your java app could do something like that:

```
GET /users
```
(This is a API request)

The answer could be:
```json
[
	{ "name" : "MAX" }
]
```

--- 

# What is a REST-API?

A REST API is an API which follows specific rules
These rules are base on HTTP

- Everything is treated like a resource (like ```/users```)
- Uses CRUD (Create, Read, Update, Delete)
	- GET -> Read
	- POST -> Create
	- PUT -> Update
	- DELETE -> Delete

--- 

## Example

```
GET /users       -> get all users
POST /users      -> create new user
DELETE /users/1  -> delete user 1
```

--- 

# What is HTTP?

HTTP (HyperText Transfer Protocol ) is a language for computers to communicate using the web

It transports a message between a client and a server
Each message can include:

- Request from the client
	- Method (GET, POST, etc)
	- URL (what resource is requested)
	- Headers (metadata, like content type)
	- Body (optional data to send)
- Response from the server
	- Status code (200 OK, 404 Not found, 500 Error)
	- Headers (metadata)
	- Body (actual data, like JSON)

---

## Example

Client request:

Structured like this: 
```
Method -> resource (path) -> protocol version
```

```
GET /users HTTP/1.1
Host: example.com
Content-Type: application/json
```

Server Response:
```
HTTP/1.1 200 OK
Content-Type: application/json

[
  { "name": "Max" }
]
```

---
