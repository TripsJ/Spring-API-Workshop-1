Spring Boot makes building a rest controller extremly easy.
The Spring web-starter package includes everything you need in order to create your Controller. Spring Boot relies on the use of Annotations to set up and configure your application.

## Build your Controller

### Declaring a Controller and the Post Method

1.  Create a new java class called Controller
2.  Tell Spring that this class is a RestController by adding the @RestController Annotation to the class and importing it.
3.  Add a method called saveStudent() to your controller, that method should return a String that says saved for now.

``` java

package org.workshop.spring.CourseApi;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

public String saveStudent() {
//code to save data to Database goes Here

return "saved";

}
```

that is what your code looks like now.

4.  Map the saveStudent function to a Post request on a /student endpoint
    To do that add @PostMapping("/student") before the save method and import the Annotation.

    This Tells Spring to execute this method whenever a post request is made to the /student Url on our server.

Wait Server? but we havent set up a server yet.

Don't worry, Spring comes with a builtin developement Server to test our application.

So lets test it.

Look in the sidebar for your Application Class. its name should end with Application.Java

left click and select Run As \> Java Application

That starts a Tomcat webserver, by default on port 8080
Next we open postman and post an empty request to /student on our local Host

and if all goes well it returns saved.
Now we will add code allowing us to send json as a parameter in the body of our request and print that to the console

to do that we add a parameter of Type Student to our Post method and annotate it with @RequestBody.

``` java
package org.workshop.spring.CourseApi;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

@PostMapping("/student")

public String saveStudent(@RequestBody Student s) {

//Code to save student to Database

System.out.print(s);

return "saved";

}

}
```

let us now flush this out by Renaming our Controller to StudentController.
and adding a Get method on the same url that returns , for now couple of prebuild Students.

To do that, we need to add the @AllArgsConstructor back into our Student class, temporarily and create a few basic objects. So add @AllArgsConstructor directly below @Data in your Student class. and save.

Next, right click your Controller Class, go to refactor and select Rename.
Name it StudentController.

### The Get Methods

Next, below our saveStudent method, we create a getAll method that returns a List of Students and is mapped to the Same url as the post method.

``` java
public List<Student> getAll(){
}
```

The method returns a List and since java, by default, does not know what a list is, we need to import it.

In order to make that method respond to a get request, we will need to Annotate it, just like we did on our saveStudent() method, with a Mapping, in this case @GetMapping followed by the url endpoint as a string.

The Annotation will also need to be imported.

next lets create an empty promotion, an empty course and a Course\[\] containing that empty course, so we have everything to build students.

Once we have a database, this process will mostly be automated but for now we need to do it by hand.

add the following to your getAll() method

``` java
Course Course1 = new Course();

Course[] courses = {Course1};

Promotion p = new Promotion();
```

Now, we can have that method create 3 students by using the Student Class AllArgsConstructor like so:

``` java
Student s1 = new Student(100,"Jack","Bauer",p,"Webdev",courses);

Student s2 = new Student(10,"Peter","Parker",p,"E-Marketing",courses);

Student s3 = new Student(123,"Aurélie","Smith",p,"Software Dev",courses);
```

for the promotion and courses, im reusing the empty once we just created.

We will now convert those 3 Students to a list by using a method called Arrays.aslist() that takes the elements of our list as parameters.

``` java
List<Student> s = Arrays.asList(s1,s2,s3);
```

Again, Java doesent know how to do this by default so we need to add the import statement.

Lestly we instruct our method to return that list.

Our Student Class should look a lot like this now.

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

Now, what if we wanted to pass a parameter in the url so that only a student with a specific id gets returned ?

We can do that by adding a parameter to our get method and a variable to our url.

to demonstrate we will create a method called getById that returns a student.
we will annotate it with @GetMapping to make it react to a get request and we will add a parameter po its url.

``` java
@GetMapping("/student/{sid}")

public Student getById() {

}
```

Notice the {sid} at the end of our url?
That is our parameter
Naxt we will grab that parameter from the url and pass it to our method.
to do that we use the @PathVariable annotation before a variable of the type we are trying to obtain.

In Our cas that Type is Integer because thats how we defined the id in the Student class.

``` java
@GetMapping("/student/{sid}")

public Student getById(@PathVariable Integer sid) {

}
```

in order to have the code create student objects, we again create our dummy course and dummy promotion as we did before.

We can now use if statements to make our method create and return a different Object to us depending on the given Id.

``` java
@GetMapping("/student/{sid}")

public Student getById(@PathVariable Integer sid) {

Course Course1 = new Course();

Course[] courses = {Course1};

Promotion p = new Promotion();

if (sid == 100) {

return new Student(100,"Jack","Bauer",p,"Webdev",courses);

}

else if(sid == 10) {

return new Student(10,"Peter","Parker",p,"E-Marketing",courses);

}

else if(sid == 123) {

return new Student(123,"Aurélie","Smith",p,"Software Dev",courses);

}

else {

return null;

}

}
```

For the else statement we currently just return null but you usually would raise an exception to handle an error.

Right now we can test our API using a tool like Postman.

To do that go to the top menu bar of your IDE and click on the Green Round Play Button.

![test your Code](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230418145046.png)

Spring should now launch its own embedded web server with your application. By default it launches on port 8080 on your local machine.

Now we can send a couple of requests as illutrated below, using Postman

### GetAll

![Get All Postman](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/getAll.png)

### GetById

![GetById](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/getById.png)

### Post

![PostRequest](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/post.png)


You will notice that we recieve our Get responses as Json Data. Spring does this by default and that's good since it is the defacto standard for api responses.

The responses also include Http Status codes without us having to specify it, again spring has some sensible defaults here.

Spring also takes care of converting our Json Data into Student objects for the Post request.
