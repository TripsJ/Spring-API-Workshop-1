package org.workshop.spring.CourseApi;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {



private Integer id;

private String name;

private String firstname;

private Promotion promotion;

private String orientation;

private Course[] courses;



}
