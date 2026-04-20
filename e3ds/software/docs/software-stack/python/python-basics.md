# Python

## Basics

To output something to the console in python you use `print()`

```python
print("Hello World")
``` 

### Variables

To define variables in python, you do not need to define the datatype like in java
You can just write:

```python
# Numbers
x = 5
y = 3.14

# String
name = "Max"

# Boolean
is_true = True

# Arrays
fruits = ["Apple", "Orange"]

# List
numbers = {1, 2, 3, 4}
```


### If-Else

Python uses indents instead of `{}` like java

```python
age = 15

if age >= 18:
	print("Adult")
else:
	print("Minor")
``` 


### For-Loop

```python
for fruit in fruits:
	print(fruit)
	
# range
for i in range(5)
	print(i)
``` 


### While-Loop

```python
count = 0

while count < 5:
	print(count)
	count += 1
``` 


### Functions

Keyword `def`
No need for a return datatype like in java

```python
def greet(name)
	return "Hello " + name
	
message = greet("Max")
print(messgage)
``` 

```python
def add(a, b)
	return a + b #Can be int or float
	
result = add(5, 10) # result is a int 
result2 = add("Hi ", "!") # result2 is a string
``` 