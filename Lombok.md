# What is Project Lombok

Project Lombok aims to simplify Java developement by removing a lot of boilerplate code and replace it with annotations

[Project Lombok](https://projectlombok.org)


To import Project Lombok into your Project, open your pom.xml file and add the following dependency in the <dependencies>
section of your file.

<dependency>

    <groupId>org.projectlombok</groupId>

    <artifactId>lombok</artifactId>

    <optional>true</optional>

</dependency>

If you followed the guide to this point, it is already there because we included it in the Initializer in one of the previous steps.

now right click on your pom.xml file Maven \> Update Project

You are presented with a window.

Verify that Update Project from pom.xml is checked and leave everything else as is.
Click Ok and observe Eclipse reloading your project for a second.

Now you know how to reload dependencies for your project.

At this point we can go clean up the Student class to end up with something a lot more readable.

## Cleaning up your Student Class

Right now our student class looks like this

``` java
import java.util.Arrays;

public class Student {

// Fields

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

//getters and Setters

public String getUsername() {

return username;

}

public void setUsername(String username) {

this.username = username;

}

public Promotion getPromotion() {

return promotion;

}

public void setPromotion(Promotion promotion) {

this.promotion = promotion;

}

public String getOrientation() {

return orientation;

}

public void setOrientation(String orientation) {

this.orientation = orientation;

}

public Course[] getCourses() {

return courses;

}

public void setCourses(Course[] courses) {

this.courses = courses;

}

public Coach[] getResponsibleCoaches() {

return responsibleCoaches;

}

public void setResponsibleCoaches(Coach[] responsibleCoaches) {

this.responsibleCoaches = responsibleCoaches;

}

public Student(String username, Promotion promotion, String orientation, Course[] courses,

Coach[] responsibleCoaches) {

super();

this.username = username;

this.promotion = promotion;

this.orientation = orientation;

this.courses = courses;

this.responsibleCoaches = responsibleCoaches;

}

@Override

public String toString() {

return "Student [username=" + username + ", promotion=" + promotion + ", orientation=" + orientation

+ ", courses=" + Arrays.toString(courses) + ", responsibleCoaches="

+ Arrays.toString(responsibleCoaches) + "]";

}

}
```

The easiest thing to get Rid off is the constructor.

Reminder: that's the method that has he same name as the class.

If you look at it, it takes all the attributes the class has as arguments.

We can delete it and annotate the class with a lombok annotation instead

Write @AllArgsConstructor before the class declaration. Your IDE will complain about a missing import from lombok so add that too. and while we are there lets add @NoArgsConstructor too and import it.

Why? Because later we will use JPA to interface with our Database and JPA requires a no argument constructor that is only there for JPA, but Theres no need to worry about that now.

We can safely get rid of the constructor so go ahaead and delete it.

Your code should look similar to this

``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Student {

// Fields

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

//getters and Setters

public String getUsername() {

return username;

}

public void setUsername(String username) {

this.username = username;

}

public Promotion getPromotion() {

return promotion;

}

public void setPromotion(Promotion promotion) {

this.promotion = promotion;

}

public String getOrientation() {

return orientation;

}

public void setOrientation(String orientation) {

this.orientation = orientation;

}

public Course[] getCourses() {

return courses;

}

public void setCourses(Course[] courses) {

this.courses = courses;

}

public Coach[] getResponsibleCoaches() {

return responsibleCoaches;

}

public void setResponsibleCoaches(Coach[] responsibleCoaches) {

this.responsibleCoaches = responsibleCoaches;

}


@Override

public String toString() {

return "Student [username=" + username + ", promotion=" + promotion + ", orientation=" + orientation

+ ", courses=" + Arrays.toString(courses) + ", responsibleCoaches="

+ Arrays.toString(responsibleCoaches) + "]";

}

}
```

Next we can eliminate the

``` java
public String toString() {
```

in the same way by annotating the class with @ToString and importing that, before deleting the toString() method, so lets do that.
Without the toString method we do not need the @Overwrite anymore either so you can delete hat too.

In the next Section, we will further slim down our code by Using lombok to require even less boilerplate code.

[Lombok part 2](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Lombok_2.md)
