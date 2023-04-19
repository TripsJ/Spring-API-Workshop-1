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

Since we do not have any final attributes in our Class we can Replace @AllArgsConstructor with @RequiredArgsConstructor.

A RequiredArgsConstructor would by default exclude all attributes marked as Final
But wait.

The combination of @ToString, @RequiredArgsConstructor, @Getter and @Setter is so common that lombok contains a shorthand annotation for all of those =\> @Data.
lets use that on our Student class and remove the, now useless Annotations as well as their imports.

``` java
package org.workshop.spring.CourseApi;

import java.util.Arrays;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Student {

// Fields

private int id;

private String username;

private Promotion promotion;

private String orientation;

private Course[] courses;

private Coach[] responsibleCoaches;

}
```

Leave the @NoArgsConstructor in for now, we need it later.

Based on that template we can now create all the Data Classes we need.


### The Promotion class

A promotion is a group of students pursuing the same courses at the same time

we need the following information on promotion



| Attribute         | Datatype  | Constant | Explanation                         |
| ----------------- | --------- | -------- | ----------------------------------- |
| id                | int       | no       | id of the Table Row                 |
| name              | String    | no       | Name of the Promotion               |
| starDate          | LocalDate | no       | Start Date of the Promotion         |
| endDate           | LocalDate | no       | Projected End Date of the promotion |
| headCoach         | Coach     | no       | Coach in charge of the Promotion    |
| includedtStudents | Student[] | no       | Array of all included Students      | 



### The Coach class

For a coach we need the following info



| Name          | Datatype | Constant | Explanation                          |
| ------------- | -------- | -------- | ------------------------------------ |
| id            | int      | no       | Database row id                      |
| name          | String   | no       | Coaches lastname                     |
| firstname     | String   | no       | Coaches  firstname                   |
| expertise     | String[] | no       | list of subjects the coach can teach |
| givingCourses | Course[] | no       | List of courses the coache teaches   |



## The Course Class

for a course we will need the following info

 Name              | Datatype  | Constant | Explanation                           |
| ----------------- | --------- | -------- | ------------------------------------- |
| id                | int       | no       | Database row id                       |
| subject           | String    | no       | Subject of the course                 |
| responsibleCoach  | Coach     | no       | Coach teaching the course             |
| studentsAttending | Student[] | no       | List of students Attending the course |


Once tose are build, it might be a good idea to remove the responsible Coach from the student class, as a Coach is responsible for a promotion or a course not a particular student.

Also we should replace the Students username with a first and a last name.

Go ahaead and try building your Dataclasses following the example of our student class and the outline in the table below.


go take a look at a possible implementation here:

[Our Dataclasses](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Our%20Dataclasses.md)
