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
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	



	@PostMapping("/student")
	public String saveStudent(@RequestBody Student s) {
		//Code to save student to Database
		System.out.print(s);
		return "saved";
	}
	


	@GetMapping("/student")
	public List<Student> getAll(){
		Course Course1 = new Course();
		Course[] courses = {Course1};
		Promotion p = new Promotion();
		Student s1 = new Student(100,"Jack","Bauer",p,"Webdev",courses);
		Student s2 = new Student(10,"Peter","Parker",p,"E-Marketing",courses);
		Student s3 = new Student(123,"Aurélie","Smith",p,"Software Dev",courses);
		
		List<Student> s = Arrays.asList(s1,s2,s3);
		
		
		System.out.print(s);
		return s;
		
				
	
}
	@GetMapping("/student/{sid}")
	public Student getById(@PathVariable Integer sid) {
		
		Course Course1 = new Course();
		Course[] courses = {Course1};
		Promotion p = new Promotion();
		
		if (sid == 100) {
			return new Student(100,"Jack","Bauer",p,"Webdev",courses);
			
		}
		else if(sid == 10) {
			return new Student(10,"Peter","Parker",p,"E-Marketing",courses);
		}
		else if(sid == 123) {
			return new Student(123,"Aurélie","Smith",p,"Software Dev",courses);
		}
		else {
			return null;
		}
		
	}

}
