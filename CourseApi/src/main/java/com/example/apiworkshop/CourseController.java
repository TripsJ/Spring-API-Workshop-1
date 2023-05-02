package com.example.apiworkshop;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;



	@PostMapping("/course")
	public String saveCourse(@RequestBody Course c) {
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
			return new Course(10,"Intro to Java",coach,attending);
		}
		else if(cid == 11) {
			return new Course(11,"Intro to Spring Framework",coach,attending);
			
		}
		
		else {
			return null;
		}
		
	}

}
