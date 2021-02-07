package com.example.spring_reactive.server.db.repository;

import com.example.spring_reactive.server.db.model.ThingDAO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ThingsRepository extends ReactiveCrudRepository<ThingDAO, Long> {
    // no fancy methods needed for now
}
