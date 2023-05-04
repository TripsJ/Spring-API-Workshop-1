
Now that we have a Database and a way to interact with it , we can finally rebuild our controllers so that they use the data from the database instead of our statically programmed data.
In order to do that i need to teach You about another important Concept, called dependency Injection

## Inversion of Controle

As i told you in the beginning, Spring takes care of creating our Objects for us, when we need them and we have, in fact, only created our static Data Objects in our controllers so far. All the rest somehow just "works".

In normal Java programming, Every time you would need an object of a class, you would have to call its constructor to create an instance of that Object and pass on all the data.

Wich means that every time a new student enroles we need to create an Instance of the Student class. 
That means we need a line of code similar to this
```Java
Student s1 = new Student(100,"Jack","Bauer",p,"Webdev",courses);
```

for each row in our student Table.
The same goes of course for Coaches, Promotions and courses as well.

You can see where that might become somewhat hard to Manage.
Inversion of control makes it so that Spring has scanned our Project and knows its Components, that are also referred to as Beans within the context of Spring. That is one of the reasons why we use Annotations like @Entity or @RestController, they tell Spring to treat that class as a component of our application and use it where needed to create Objects.

That allows for a lot of flexibility in our code.
Along with that concept, Spring uses another mechanism called Dependency Injection.

## Dependency Injection

Dependency Injection is a way of making Objects rely on each other. 
Meaning that to create a Student we need a Promotion. So we inject that Promotion into our Student class and pass it on as a parameter.

That allows for even more flexibility, because our Student Object does not care about how the promotion is implemented, it just wants it to exist.

We can inject a dependency in multiple ways,
	- as a constructor
	- as a getter or setter
	- as an interface

For our purposes, we will now use that concept as an Interface, by injecting our Repository into our controller.

Right now our Student Controller looks like this.
``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

@PostMapping("/student")

public String saveStudent(@RequestBody Student s) {

//Code to save student to Database

System.out.print(s);

return "saved";

}

@GetMapping("/student")

public List<Student> getAll(){

Course Course1 = new Course();

Course[] courses = {Course1};

Promotion p = new Promotion();

Student s1 = new Student(100,"Jack","Bauer",p,"Webdev",courses);

Student s2 = new Student(10,"Peter","Parker",p,"E-Marketing",courses);

Student s3 = new Student(123,"Aurélie","Smith",p,"Software Dev",courses);

List<Student> s = Arrays.asList(s1,s2,s3);


return s;

}

}
```