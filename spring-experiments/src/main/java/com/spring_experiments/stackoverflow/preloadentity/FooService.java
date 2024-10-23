package com.spring_experiments.stackoverflow.preloadentity;

import org.springframework.stereotype.Service;

@Service
public class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public FooEntity getFooById(Long fooId) {
        return FooEntity.builder().id(fooId).name("FooWithID: " + fooId).build();
//        return fooRepository.getReferenceById(fooId);
    }
}
