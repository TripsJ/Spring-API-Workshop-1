package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiworkshop.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

} 
