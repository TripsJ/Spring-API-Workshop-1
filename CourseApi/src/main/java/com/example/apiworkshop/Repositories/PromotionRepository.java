package com.example.apiworkshop.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiworkshop.Models.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}


