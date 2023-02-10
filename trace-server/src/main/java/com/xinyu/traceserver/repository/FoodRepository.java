package com.xinyu.traceserver.repository;

import com.xinyu.traceserver.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
