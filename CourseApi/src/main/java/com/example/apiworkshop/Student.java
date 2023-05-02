package com.example.apiworkshop;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

private String name;

private String firstname;
@ManyToOne
private Promotion promotion;

private String orientation;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "Student_Promotion", 
joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
inverseJoinColumns = @JoinColumn(name = "promotion_id", 
referencedColumnName = "id"))

private Course[] courses;



}
