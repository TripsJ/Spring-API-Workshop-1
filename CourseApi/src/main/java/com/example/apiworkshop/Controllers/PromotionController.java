package com.example.apiworkshop.Controllers;





import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiworkshop.Models.Promotion;
import com.example.apiworkshop.Repositories.PromotionRepository;

@RestController
public class PromotionController {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	
	



	@PostMapping("/promotion")
	public Promotion savePromotion(@RequestBody Promotion p) {
	    	
		promotionRepository.save(p);
		System.out.print(p);
		return p;
	}
	
	@GetMapping("/promotion")
	
	public List<Promotion> findAll(){
	    return promotionRepository.findAll();
	}
	
	@GetMapping("/promotion/{pid}")
	public Optional<Promotion> getById(@PathVariable Integer pid) {
	    return promotionRepository.findById(pid);
	    
	}

	

}
