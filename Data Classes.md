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

\[\[5. Projects/Workshop Java Spring API/#\^Table1\]\]

### The Coach class

For a coach we need the following info

\[\[5. Projects/Workshop Java Spring API/#\^Table3\]\]

## The Course Class

for a course we will need the following info

\[\[5. Projects/Workshop Java Spring API/#\^Table4\]\]
Once tose are build, it might be a good idea to remove the responsible Coach from the student class, as a Coach is responsible for a promotion or a course not a particular student.

Also we should replace the Students username with a first and a last name.

Go ahaead and try building your Dataclasses following the example of our student class and the outline in the table below.

Hint: Java has a Datatype to handle Dates.

go take a look at a possible implementation here:

\[\[Our Dataclasses\]\]
