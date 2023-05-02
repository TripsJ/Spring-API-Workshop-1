package com.example.apiworkshop;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	@OneToMany(mappedBy = "headCoachOf")
	private Coach headCoach;
	@OneToMany(mappedBy = "promotion")
	private Student[] containedStudents;

}
