## What are exceptions

An exception is the way for a Program to react to unexpected behaviour or errors, such as a resource not being available or an entry in a database that does not exist.

Java, as well as many other programming Languages, use a Mechanism called exceptions.

Exceptions, in the context of Java, are special objects that can interrupt the normal flow of a program and force it to end.

For this reason, Exceptions need to be handled.
A lot of things you do in Java can cause Exceptions like FileNotFoundException or ArithmeticException, and we usually handle them by wrapping our code in 
```Java
try{
//Code that could fail goes here
}
catch(exception e){
// if exception e occurs do this. 
}
```

## Launching our own exceptions 

If you write a method that could fail because of things that are out of your control, you can cause your program to throw an exception by using the keyword *throw*

Springs http package, wich is part of the web starter, comes with a couple of prepared exceptions that allow us to modify the Http status code.

In the following we are going to use the ResponseStatusException if the id in our path does not exsist.


```Java
public Optional<Student> getById(@PathVariable Integer sid) {

Optional<Student>foundStudent = studentRepository.findById(sid);

if (foundStudent.isEmpty()) {

throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given ID not found");

}

return foundStudent;

}
```

For clarification, isEmpty() is a method from the Collections framework that allows to check if a collection is empty.

Spring also comes with prebuild error messages you can customize, but that is beyond the scope of this Workshop.

Now that our getById() method can return an error, it is time to see how we can update a given entry. 

[Rebuilding Controllers 2](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Rebuilding%20Controllers%202.md)
