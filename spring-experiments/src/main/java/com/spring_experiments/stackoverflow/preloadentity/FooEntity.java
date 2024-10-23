package com.spring_experiments.stackoverflow.preloadentity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(schema = "foo")
@Data
@Builder
public class FooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
