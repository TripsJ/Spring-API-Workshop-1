package org.workshop.spring.CourseApi;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Promotion {
	private Integer id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Coach headCoach;
	private Student[] containedStudents;

}
