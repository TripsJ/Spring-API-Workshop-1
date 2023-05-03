package com.example.apiworkshop.Controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiworkshop.Models.Coach;
import com.example.apiworkshop.Models.Promotion;
import com.example.apiworkshop.Models.Student;
import com.example.apiworkshop.Repositories.PromotionRepository;

@RestController
public class PromotionController {
	
	
	@Autowired
	private PromotionRepository promotionRepository;


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
