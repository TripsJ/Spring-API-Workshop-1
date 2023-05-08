package com.example.apiworkshop.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.apiworkshop.Models.Student;
import com.example.apiworkshop.Repositories.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	



	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student s) {
	    	
		studentRepository.save(s);
		System.out.print(s);
		return s;
	}
	
	@GetMapping("/student")
	
	public List<Student> findAll(){
	    return studentRepository.findAll();
	}
	
	@GetMapping("/student/{sid}")
	public Optional<Student> getById(@PathVariable Integer sid) {
	    Optional<Student>foundStudent = studentRepository.findById(sid);
	    if (foundStudent.isEmpty()) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given ID not found");
	    }
	    
	    return foundStudent;
	    
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student s) {
	    try {
	   Optional<Student>found=getById(s.getId());
	   studentRepository.save(s);
	   return s;
	   
	    }
	    catch (ResponseStatusException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Resource");
	    }
		    
	    }
	    
	    
	}

	

