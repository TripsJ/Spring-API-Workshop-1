package com.example.apiworkshop.Controllers;





import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiworkshop.Models.Coach;
import com.example.apiworkshop.Repositories.CoachRepository;


@RestController
public class CoachController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	
	



	@PostMapping("/coach")
	public Coach saveCoach(@RequestBody Coach c) {
	    	
		coachRepository.save(c);
		System.out.print(c);
		return c;
	}
	
	@GetMapping("/coach")
	
	public List<Coach> findAll(){
	    return coachRepository.findAll();
	}
	
	@GetMapping("/coach/{cid}")
	public Optional<Coach> getById(@PathVariable Integer cid) {
	    return coachRepository.findById(cid);
	    
	}

	

}
