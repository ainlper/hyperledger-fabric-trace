package com.xinyu.traceserver.repository;

import com.xinyu.traceserver.entity.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodRepositoryTest {
    @Autowired
    private FoodRepository foodRepository;

    @Test
    void register(){
        System.out.println(foodRepository.findAll());
    }

    @Test
    void findoone(){

        System.out.println(foodRepository.findById(12));
    }

    @Test
    void save(){
        Food food = new Food();
        food.setName("vvv");
        food.setPassword("vvv");
        food.setRegistration_type("生产商");
        Food food1 = foodRepository.save(food);
//        System.out.println(food1);
    }

}