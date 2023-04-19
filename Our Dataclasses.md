# Implementation of the Data classes

In this section i will show you a possible implementation of the Classes we will use to represent our Data

The Classes we implemented should now look like this:

## Student class

``` java
package org.workshop.spring.CourseApi;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Student {

private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

}
```

## Coach class

``` java

package org.workshop.spring.CourseApi;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Coach {

private Integer id;

private String firstname;

private String lastname;

private String[] expertise;

private Course[] givingCourses;

}
```

## Course class

``` java
package org.workshop.spring.CourseApi;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Course {

private Integer id;

private String subject;

private Coach responsibleCoach;

private Student[] attendingStudents;

}
```

## Promotion class

``` java

package org.workshop.spring.CourseApi;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Promotion {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Coach headCoach;
    private Student[] containedStudents;

}
```

Now that we have Classes that represent our Data and a Spring Boot Framework set up, we can use that Framework to create our Rest Api starting with:

[Building a Rest API Controller](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Building%20a%20Rest%20API%20Controller.md)
