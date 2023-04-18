In the previous section we started making our Code more readable by using Lombok to eliminate boilerplate code.

We will continue doing that here and start by removing the Getters and Setters for our attributes.

Currently our student Class looks like this:

## Getters and Setters

``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString

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




}
```

As you can see, most of the object is taken up by methods that are called setAttribute() and getAttribute()

These are called Getters and Setters and we use them to Access (Getters) and Modify (Setters) private attributes of objects.

Why? Because it allows us to regulate what information is accessed and updated from where and can be used to do error checking.
In the case of a Database, these Methods are fairly standardized and Lombok allows us to automate their creation.

The easiest way to do that would be to annotate the class with
@Getter and @Setter, wich would prompt lombok to automate the generation of Getters and Setters for all attributes in that class.
So lets do that.
Add @Getter and @Setter to after @ToString and remove all the getters and setters until your code looks like this:

``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter


public class Student {

// Fields

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;






}
```

Notice how readable the code is now?
It is in fact a lot easier to read once you get used to the Annotations.

But what does this code represent ?
Let us investigate that and finish our Student Class.

[Data Classes](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Data%20Classes.md)
