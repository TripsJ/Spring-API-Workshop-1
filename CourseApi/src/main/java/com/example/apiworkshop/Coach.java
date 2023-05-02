package com.example.apiworkshop;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy= "responsibleCoach")
	private List<Course> givingCourses;
	@OneToMany(mappedBy = "headCoach")
	
	private List<Promotion> headCoachOf;
	

}
