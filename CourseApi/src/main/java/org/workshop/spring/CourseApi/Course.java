package org.workshop.spring.CourseApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
	private Integer id;
	private String subject;
	private Coach responsibleCoach;
	private Student[] attendingStudents;

}
