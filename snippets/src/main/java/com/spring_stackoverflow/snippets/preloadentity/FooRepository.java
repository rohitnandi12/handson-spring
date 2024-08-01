package com.spring_stackoverflow.snippets.preloadentity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<FooEntity, Long> {
}
