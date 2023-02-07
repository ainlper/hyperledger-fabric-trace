package com.xinyu.traceserver.controller;

import com.xinyu.traceserver.entity.Food;
import com.xinyu.traceserver.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/fabricUser")
public class FoodHandler {
    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(value = "/register")
    public void register(Food food, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        //注册用户
        Food food1 = foodRepository.save(food);
        if (food1 != null) {
            System.out.println("123成功了");
            System.out.println(food1.getName());
            System.out.println(food1.getPassword());
            System.out.println(food1.getRegistration_type());
            System.out.println("register save success");
            System.out.println(food);
            System.out.println(food.getId());
            response.sendRedirect("http://localhost:8080/");
        } else {
            System.out.println("register save failed");
        }

    }

    @PostMapping(value = "/login")
    public Object login(Food food, HttpServletResponse response) throws IOException {
        Example<Food> example = Example.of(food);
        Optional<Food> one = foodRepository.findOne(example);
        //判断admin用户登录是否成功
        if ("admin".equals(food.getName())) {
            if ("admin".equals(food.getPassword())) {
                System.out.println("admin login  success");
//                System.out.println(one);
                response.sendRedirect("http://localhost:8080/Food_manufacturers");
                return "admin";
            } else {
                response.sendRedirect("http://localhost:8080/");
            }
        } else if (one.get().getName().equals(food.getName())) {//判断用户是否登录成功
            if (one.get().getPassword().equals(food.getPassword())) {
                if (one.get().getRegistration_type().equals(food.getRegistration_type())) {
                    if ("生产商".equals(food.getRegistration_type())) {
                        System.out.println("manufacturer login  success");
//                        System.out.println(one);
                        response.sendRedirect("http://localhost:8080/xxx");
                    } else if ("经销商".equals(food.getRegistration_type())) {
                        System.out.println("distributor login  success");
//                        System.out.println(one);

                        response.sendRedirect("http://localhost:8080/yyy");
                    } else if ("消费者".equals(food.getRegistration_type())) {
                        System.out.println("consumer login  success");
//                        System.out.println(one);
                        response.sendRedirect("http://localhost:8080/zzz");
                    }
                }
            }
        }
        return "user";
    }


}
