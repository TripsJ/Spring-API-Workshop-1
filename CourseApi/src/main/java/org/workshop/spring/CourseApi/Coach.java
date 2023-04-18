package org.workshop.spring.CourseApi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coach {
	private Integer id;
	private String firstname;
	private String lastname;
	private String[] expertise;
	private Course[] givingCourses;
	

}
