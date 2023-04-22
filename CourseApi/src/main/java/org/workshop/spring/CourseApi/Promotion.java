package org.workshop.spring.CourseApi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Promotion {
	private Integer id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Coach headCoach;
	private Student[] containedStudents;

}
