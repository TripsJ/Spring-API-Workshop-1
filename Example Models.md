# Example Models

Here are my models for each of our Dataclasses

## Student

```Java

package com.example.apiworkshop.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinTable;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;

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

@JsonBackReference

@ManyToOne

private Promotion promotion;

private String orientation;

@JsonBackReference

@ManyToMany(cascade = CascadeType.ALL)

@JoinTable(name = "Student_Promotion",

joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),

inverseJoinColumns = @JoinColumn(name = "promotion_id",

referencedColumnName = "id"))

private List<Course >courses;

}
```

## Promotion

```Java 
package com.example.apiworkshop.Models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@JsonBackReference
	@ManyToOne
	
	private Coach headCoach;
	@JsonManagedReference
	@OneToMany(mappedBy = "promotion")
	private List<Student> containedStudents;

}

```

## Course

```Java
package com.example.apiworkshop.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.ManyToOne;

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

@JsonBackReference

@ManyToOne

private Coach responsibleCoach;

@JsonManagedReference

@ManyToMany(mappedBy ="courses" )

private List<Student> attendingStudents;

}
```

### Coach

```Java
package com.example.apiworkshop.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

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

@JsonManagedReference

@OneToMany(mappedBy= "responsibleCoach")

private List<Course> givingCourses;

@JsonManagedReference

@OneToMany(mappedBy = "headCoach")

private List<Promotion> headCoachOf;

}
```

With this, our previously unsuccessful get requests are solved, and we can test this with Postman

![Pasted image 20230511115647.png](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/0_Resources/Images/Pasted%20image%2020230511115647.png)



## Finally


Well done, you have built an entire API from scratch.
There is much more you can do, like custom Database queries, Custom Error Messages, Or Setting values as mandatory, but those can be part of an eventual part 2 of this workshop.
You can find the complete code for this workshop in the CourseApi folder. 

For now, I can only encourage you to explore Spring on your own.

For Questions, Comments, or suggestions do not hesitate to reach out to me through GitHub's Issues or even fork this workshop and do a pull request.

*Thank You*

***Jérôme Trips***
