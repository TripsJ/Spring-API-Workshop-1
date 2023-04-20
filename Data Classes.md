# The Student Class

Our Student class looks nice and cleaned up now

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

and if we ask ourselves what real world object it might represent, one might come to think it represents a Student. And, while for most explanations that approximation might be enough, if you look at it in more detail the Student class in fact ***represents a row in a database that contains information on a student***

and Rows in Databases need id's.

The Datatype is Integer since our database is small enough and thus we add

``` java
private Integer id;
```

to the top of our list of fields.

We could use int, but that is a primitive type while Integer is an object, giving us more possibilities.

It is now time to Introduce Advanced Datatypes and Wrapper Classes.

[Advanced Datatypes](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Advanced%20Datatypes.md)



