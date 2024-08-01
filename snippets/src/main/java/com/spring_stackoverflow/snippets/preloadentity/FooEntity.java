package com.spring_stackoverflow.snippets.preloadentity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "foo")
@Data
public class FooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
