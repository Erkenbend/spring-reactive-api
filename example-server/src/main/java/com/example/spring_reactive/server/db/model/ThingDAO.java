package com.example.spring_reactive.server.db.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("thing")
public class ThingDAO {
    @Id
    private Long id;
    private String content;
}
