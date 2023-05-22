## Student Class

```Java
package com.example.apiworkshop;

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

@ManyToOne

private Promotion promotion;

private String orientation;

@ManyToMany(cascade = CascadeType.ALL)

@JoinTable(name = "Student_Promotion",

joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),

inverseJoinColumns = @JoinColumn(name = "promotion_id",

referencedColumnName = "id"))

private Course[] courses;

}
```

##Course Class

```java
package com.example.apiworkshop;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String subject;
	@ManyToOne
	private Coach responsibleCoach;
	@ManyToMany(mappedBy ="courses" )
	private Student[] attendingStudents;

}

```

## Promotion Class

```Java
package com.example.apiworkshop;

import java.time.LocalDate;

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

public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	@ManyToOne
	private Coach headCoach;
	@OneToMany(mappedBy = "promotion")
	private Student[] containedStudents;

}

```

## Coach Class

```Java
package com.example.apiworkshop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String lastname;
	private String[] expertise;
	@OneToMany(mappedBy= "responsibleCoach")
	private Course[] givingCourses;
	@OneToMany(mappedBy= "headCoach")
	private Promotion[] headCoachOf;
	

}

```

If you now try to run this, you can see that the Error we are getting changed to 
```
Property 'com.example.apiworkshop.Course.randomClass' is not a collection and may not be a '@OneToMany', '@ManyToMany', or '@ElementCollection'
```

Which means it is time to talk about Arrays and Collections.

[[Collections]]