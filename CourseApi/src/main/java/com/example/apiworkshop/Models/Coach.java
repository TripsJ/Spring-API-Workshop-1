package com.example.apiworkshop.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

public class Coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String lastname;
	private String[] expertise;
	@JsonManagedReference
	@OneToMany(mappedBy= "responsibleCoach")
	private List<Course> givingCourses;
	@JsonManagedReference
	@OneToMany(mappedBy = "headCoach")
	
	private List<Promotion> headCoachOf;
	

}
