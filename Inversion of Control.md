## Inversion of Control

As I told you in the beginning, Spring takes care of creating our Objects for us, when we need them, and we have, in fact, only created our static Data Objects in our controllers so far. All the rest somehow just “works”.

In normal Java programming, Every time you would need an object of a class, you would have to call its constructor to create an instance of that object and pass on all the data.

Which means that every time a new student enrols we need to create an Instance of the Student class. 
That means we need a line of code similar to this
```Java
Student s1 = new Student(100,"Jack","Bauer","Promotion","Webdev",{"Course 1",Course 2});
```

For each row in our student table.
The same goes of course for Coaches, Promotions, and courses as well.

You can see where that might become somewhat hard to manage.
Inversion of control makes it so that Spring has scanned our Project and knows its Components, that are also referred to as beans within the context of Spring. That is one of the reasons why we use Annotations like @Entity or @RestController, they tell Spring to treat that class as a component of our application and use it where needed to create objects.

That allows for a lot of flexibility in our code.
Along with that concept, Spring uses another mechanism called Dependency Injection.

## Dependency Injection

Dependency Injection is a way of making objects rely on each other. 
Meaning that to create a Student, we need a Promotion. So we inject that Promotion into our Student class and pass it on as a parameter.

That allows for even more flexibility, because our Student Object does not care about how the promotion is implemented, it just wants it to exist.

We can inject a dependency in multiple ways,
	- as a constructor
	- as a getter or setter
	- as an interface

We will Mostly use Constructors, because we will make objects depend on each other. Later we will Also talk about Interfaces and Inject those.

For now, let us return to our IDE.

[Importing the Starter](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Importing%20the%20Starter.md)