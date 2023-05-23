
Now that we have a Database and a way to interact with it , we can finally rebuild our controllers so that they use the data from the database instead of our statically programmed data.


Right now, our Student Controller looks like this.
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

What we want our Controllers to do is


1. Accept Post requests that contain JSON and Save them to our Database
2. Verify that JSON send by post requests is valid
3. to Respond to a Get request with all entries of a given Dataclass. GET student/ would return a list of Students
4. Respond to a get Request containing an id, with the Corresponding student
5. Be able to respond to a put request by updating the Data.
6. Return an error if the Data in the Post request is not valid.

To make things easier, we will clean out our Student class until it looks like this.

```Java
package org.workshop.spring.CourseApi;


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



}
```

We already have our Post Mapping established but we need our controller to know how to interact with our Database.

To do that, we will inject a dependency into our controller.
That dependency is an object that implements our StudentRepository Interface.

Normally we would need to create an object that implements our Repository Interface but, using the Power of Spring, we can instruct the Framework to do that for us.

In our controller we add a new private Attribute like this

```Java
private StudentRepository studentRepository;
```

The type of that attribute is StudentRepository, and its name is studentRepository. Since that Repository lives in a sub-package, we let the IDE import it.

In order for Spring to understand that we want the Framework to create the Object for us and integrate it into our Controller, we add the annotation @Autowired to that object and import it into our code.

Our class now looks like this:

```Java
package org.workshop.spring.CourseApi;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.apiworkshop.Repositories.StudentRepository;

@RestController

public class StudentController {

@Autowired
private StudentRepository studentRepository;



@PostMapping("/student")
public String saveStudent(@RequestBody Student s) {

//Code to save student to Database

System.out.print(s);

return "saved";

}



}
```

@Autowired essentially takes a component of our application and injects it into another component. 

Spring knows that StudentRepository is a Component because of the @Repository we put on top of it when we created it. 
That means that we now can use studentRepository as an object, including calling methods on it that were inherited from JPARepository, because that`s where our Interface inherits from.

## The Post Method 

JPARepository contains a Method called save() that takes an object as a parameter. In this case we pass the object in our request body, and it is a Student.

It would then look like this

```Java

@PostMapping("/student")

public String saveStudent(@RequestBody Student s) {

studentRepository.save(s);

System.out.print(s);

return "saved";

}
```

Now we can test our StudentController Post method, using postman. Simply push a post request to your /student endpoint with the name, firstname and orientation. 

```JSON

{

"name": "Jackson",

"firstname": "Peters",

"orientation":"Webdev"

}
```

After receiving saved, check your database via PhpMyAdmin and you should be seeing something like this.

![Pasted image 20230505200939.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230505200939.png)

Great. We can add things to our database.
But getting saved back is not exactly helpful. It would be better if we got the entry back we just added.
And we can do that by simply returning s and changing the return typ to Student.

```Java
@PostMapping("/student")

public Student saveStudent(@RequestBody Student s) {

studentRepository.save(s);

System.out.print(s);

return s;

}
```

If we test our application again, we will see the following:

![[Pasted image 20230505201632.png]]

And you notice that our student has an Id of 2 that is automatically assigned to it.

You can also create empty entries, but we will fix that later.

## The Get methods

Now we would need 2 get methods. One to retrieve all the Student entries in our Database, and One that takes an Id as a parameter and retrieves that specific Student.

Getting all the Students is easy. In fact, our repository inherits a method called findAll() that returns a list of Students.

So we create a Get Mapping just like before, but instead of returning Static Objects, we return the result of findAll().

```Java
@GetMapping("/student")

public List<Student> findAll(){

return studentRepository.findAll();

}
```

Of course that requires us to import @GetMapping, List and our own Student Model, but your IDE will complain as usual. 

And while we are at it, we can add a findById method that takes an ID as a parameter from the URL.

We already did that in our original controller. We need to make use of @PathVariable like this.

```Java
@GetMapping("/student/{sid}")

public void getById(@PathVariable Integer sid) {
```

In this example i set the return Type to void, but that won't do.

You would think that a method like this returns a Student Object, but what if the Id we give is not in the Database?

We require a type that can potentially be something else. Turns out there is a Collection in java.util we can use, called Optional<T>
Let us use that.

```Java
public Optional<Student> getById(@PathVariable Integer sid) {
```
We need to Import PathVariable as well as Optional again.

Within our Repository, there is a method called findbyId that can take an Integer as parameter and returns an Optional, so we can call on that.

```Java
public Optional<Student> getById(@PathVariable Integer sid) {

return studentRepository.findById(sid);

}
```

Now we can test our controllers by running a few get requests through Postman.

## Get All

![Pasted image 20230506145825.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230506145825.png)

## Get by Id

With an existing id

![Pasted image 20230506150001.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230506150001.png)

With one that does not exist.

![Pasted image 20230506150113.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230506150113.png)

You might notice that returning null upon not finding anything still counts as a 200 OK Http Status code. And that is due to the fact that we did not define what to do in case of an error.

[Exceptions](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Exceptions.md)

