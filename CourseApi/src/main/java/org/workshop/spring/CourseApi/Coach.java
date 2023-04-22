package org.workshop.spring.CourseApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Coach {
	private Integer id;
	private String firstname;
	private String lastname;
	private String[] expertise;
	private Course[] givingCourses;
	

}
