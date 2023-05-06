package com.example.apiworkshop.Controllers;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	    return studentRepository.findById(sid);
	    
	}

	

}
