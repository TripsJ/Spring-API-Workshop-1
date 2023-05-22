So once we create tables for everything, our code should look similar to this:

## Student class

```Java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor

@AllArgsConstructor

@Entity

@Table

public class Student {

@Id

@GeneratedValue(strategy=GenerationType.AUTO)

private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;

}
```

## Course Class

```Java
package com.example.apiworkshop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String subject;
	private Coach responsibleCoach;
	private Student[] attendingStudents;

}

```

## Coach Class

```Java
package com.example.apiworkshop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String lastname;
	private String[] expertise;
	private Course[] givingCourses;
	

}

```


## Promotion class

```Java

package com.example.apiworkshop;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Coach headCoach;
	private Student[] containedStudents;

}

```

All we have done here is added the Entity and Table annotation as well as the ID and GeneratedValue once, just like we did in the Student class

If you try to run this you'll be greeted by a random error from JDBC and that is due to the fact that right now Java doesn't know how to handle references to other tables, but we will fix that by introducing Relationships.

[Relationships](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Relationships.md)
