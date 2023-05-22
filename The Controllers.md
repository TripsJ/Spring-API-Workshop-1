
The following are the controllers for the various classes.

For now, they are filled with dummy data as we do not yet have a database.

## CoachController

```Java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

	@PostMapping("/coach")
	public String saveCoach(@RequestBody Coach c) {
		//Code to save student to Database
		System.out.print(c);
		return "Coach saved";
	}
	


	@GetMapping("/coach")
	public List<Coach> getAll(){
		Course Course1 = new Course();
		Course[] courses = {Course1};
		String[] expertise = new String[] {"Java","JavaScript"};
	
		Coach c1 = new Coach(100,"Peter","Bauer",expertise,courses);
		Coach c2 = new Coach(10,"Jiminy","Cricket",expertise,courses);
		Coach c3 = new Coach(123,"Jane","Doe",expertise,courses);
		
		List<Coach> s = Arrays.asList(c1,c2,c3);
		
		
		System.out.print(s);
		return s;
		
				
	
}
	@GetMapping("/coach/{cid}")
	public Coach getById(@PathVariable Integer cid) {
		
		Course Course1 = new Course();
		Course[] courses = {Course1};
		String[] expertise = new String[] {"Java","JavaScript"};
		
		if (cid == 100) {
			return new Coach(100,"Peter","Bauer",expertise,courses);
			
		}
		else if(cid == 10) {
			return new Coach(10,"Jiminy","Cricket",expertise,courses);
		}
		else if(cid == 123) {
			return new Coach(123,"Jane","Doe",expertise,courses);
		}
		else {
			return null;
		}
		
	}

}

```

This controller is like the student controller, except for the fact that a Coach object needs some expertise in the form of an Array:

```Java
String[] expertise = new String[] {"Java","JavaScript"};
```

In Java, Arrays are declared with [] at the end of the type the Array will contain. An array's content can be defined between {}.

## Course Controller

```java
package org.workshop.spring.CourseApi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	
	



	@PostMapping("/course")
	public String saveCourse(@RequestBody Student c) {
		//Code to save student to Database
		System.out.print(c);
		return "course saved";
	}
	


	@GetMapping("/course")
	public List<Course> getAll(){
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Coach coach = new Coach();
		Student[] attending = {s1,s2,s3};
		Course c1 = new Course(10,"Intro to Java",coach,attending);
		Course c2 = new Course(11,"Intro to Spring Framework",coach,attending);
		
		
		
		List<Course> c = Arrays.asList(c1,c2);
		
		
		System.out.print(c);
		return c;
		
				
	
}
	@GetMapping("/course/{cid}")
	public Course getById(@PathVariable Integer cid) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Coach coach = new Coach();
		Student[] attending = {s1,s2,s3};
		
		if (cid == 10) {
JAVA			return new Course(10,"Intro to Java",coach,attending);
		}
		else if(cid == 11) {
			return new Course(11,"Intro to Spring Framework",coach,attending);
			
		}
		
		else {
			return null;
		}
		
	}

}

```

In here, there is nothing new, we just define all the empty objects we need in order to create a course.

## Promotion Controller

```java
package org.workshop.spring.CourseApi;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {
	

	@PostMapping("/promotion")
	public String saveStudent(@RequestBody Promotion p) {
		//Code to save student to Database
		System.out.print(p);
		return "saved";
	}
	


	@GetMapping("/promotion")
	public List<Promotion> getAll(){
	
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Coach c1 = new Coach();
		Student[] attending = {s1,s2,s3};
		
		Promotion p1 = new Promotion(1,"Einstein12",LocalDate.of(2022, Month.OCTOBER, 16),LocalDate.of(2023, Month.AUGUST, 16),c1,attending);
		Promotion p2 = new Promotion(2,"Curie04",LocalDate.of(2022, Month.NOVEMBER, 2),LocalDate.of(2023, Month.SEPTEMBER, 30),c1,attending);
		List<Promotion> p = Arrays.asList(p1,p2);
		
		
		System.out.print(p);
		return p;
		
				
	
}
	@GetMapping("/promotion/{pid}")
	public Promotion getById(@PathVariable Integer pid) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Coach c1 = new Coach();
		Student[] attending = {s1,s2,s3};
		
		
	
		if (pid == 1) {
			Promotion p1 = new Promotion(1,"Einstein12",LocalDate.of(2022, Month.OCTOBER, 16),LocalDate.of(2023, Month.AUGUST, 16),c1,attending);
			return p1;
			
		}
		else if(pid == 2) {
			Promotion p2 = new Promotion(2,"Curie04",LocalDate.of(2022, Month.NOVEMBER, 2),LocalDate.of(2023, Month.SEPTEMBER, 30),c1,attending);

			return p2;
		}
		
		else {
			return null;
		}
		
	}

}

```

This is again pretty similar, except for the use of LocalDate.of

```java
LocalDate.of(2022, Month.NOVEMBER, 2)
```

This creates a LocalDate object from the information given.

Month is an enum.

### Enums

An enum is a special type of class that contains a list of constants. 

`Month` Is an enum representing the 12 months of the year, it is defined in java.time

You can test your controllers with postman, as demonstrated on the Student Controller.


Now that our controllers are ready and tested, we can start working on keeping our data persistent.

[Getting ready for persistence](https://github.com/TripsJ/Spring-API-Workshop-1/blob/main/Getting%20Ready%20for%20persistance.md)
