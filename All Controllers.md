Here i will show you the Same controller implemented for all our classes

## PromotionController

```Java
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
```

## CourseController

```Java
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
```

## CoachController

```Java
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
```

## StudentController

```Java
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
```

You will notice that they all follow the same pattern. They also all only import their respective Model and Repository.