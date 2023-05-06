package com.example.apiworkshop.Controllers;





import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiworkshop.Models.Course;
import com.example.apiworkshop.Repositories.CourseRepository;


@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	



	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course c) {
	    	
		courseRepository.save(c);
		System.out.print(c);
		return c;
	}
	
	@GetMapping("/course")
	
	public List<Course> findAll(){
	    return courseRepository.findAll();
	}
	
	@GetMapping("/course/{cid}")
	public Optional<Course> getById(@PathVariable Integer cid) {
	    return courseRepository.findById(cid);
	    
	}

	

}
