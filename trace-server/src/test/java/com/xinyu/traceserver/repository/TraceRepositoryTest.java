package com.xinyu.traceserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TraceRepositoryTest {
    @Autowired
    private TraceRepository traceRepository;

    @Test
    void register() {
        System.out.println(traceRepository.findAll());
    }

    @Test
    void findoone() {
        System.out.println(traceRepository.findById(12));
    }

    @Test
    void findAll() {
        System.out.println(traceRepository.findAll());
    }
}