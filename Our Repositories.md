## Coach repository

```Java
package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.apiworkshop.Models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer> {
}



```

## Promotion Repository

```Java

package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiworkshop.Models.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}
```

## Course Repository

```Java

package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiworkshop.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
```

## Student Repository

```Java
package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiworkshop.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
```


Finally we have all the pieces to rebuild our Controllers in a way that they can interact with our database.

[[Rebuilding Controllers]]