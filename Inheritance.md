# Inheritance and Repositories

Our aim is to implement so-called CRUD operations in our code, so that a user can interact with our database by using only our API.

CRUD stands for Create, Read, Update, Delete wich are the four main operations we can execute on data.

In JPA, these operations are implemented through a Repository.
a Repository is an interface that extends from a Base Class.

Extends is the keyword Java uses to handle Inheritance

## Inheritance

In Object oriented programming, one of the main concepts you need to understand is the concept of inheritance.

Objects can pass on Attributes and Methods to other Objects that inherit from them.

For example, You Have a class Person

```Java

public class Person {
	int age;
	String name;

	
	public String present() {
		System.out.println("Hello, my name is "+ name +" and i am "String.valueOf(age)+" years old")
	}
	
Person(int age, String name){
	this.age = age;
	this.name = name;
}
}
```
Than we can create a class Teacher as follows

```Java

public class Teacher extends Person{
	String subject;

	public String teach(){
		System.out.println("I teach " + subject)
		
	}

	Teacher(int age, String name, String Subject){
		super(age, name);
		this.subject = subject;
	}
}
```

Now my Teacher has access to the person's present method as well.

super() calls the constructor of the parent class.

Now that we know that, let's have a look at the repository I mentioned before.

[Repository](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Repository.md)
