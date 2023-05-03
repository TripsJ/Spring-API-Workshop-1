package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.apiworkshop.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {


}
