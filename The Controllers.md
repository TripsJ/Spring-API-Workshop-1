
The Following are the controllers for the various classes, for now they are filled with dummy data as we do not yet have a database.

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

This controller is pretty similar to the student controller except for the fact that a Coach object needs some expertise in the form of an Array
wich is this

```Java
String[] expertise = new String[] {"Java","JavaScript"};
```

