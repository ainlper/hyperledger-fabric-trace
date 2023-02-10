package com.xinyu.traceserver.repository;

import com.xinyu.traceserver.entity.Trace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRepository extends JpaRepository<Trace, Integer> {
}
