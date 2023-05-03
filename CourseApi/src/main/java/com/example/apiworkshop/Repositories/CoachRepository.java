package com.example.apiworkshop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.apiworkshop.Models.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer> {
}


