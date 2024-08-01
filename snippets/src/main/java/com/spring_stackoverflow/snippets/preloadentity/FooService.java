package com.spring_stackoverflow.snippets.preloadentity;

import org.springframework.stereotype.Service;

@Service
public class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public FooEntity getFooById(Long fooId) {
        return fooRepository.getReferenceById(fooId);
    }
}
