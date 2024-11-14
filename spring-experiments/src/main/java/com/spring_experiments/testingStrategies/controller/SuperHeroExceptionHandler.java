package com.spring_experiments.testingStrategies.controller;

import com.spring_experiments.testingStrategies.exceptions.NonExistingHeroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Maps exceptions to HTTP codes
 * @author moises.macero
 */
@RestControllerAdvice
public class SuperHeroExceptionHandler {

    @ExceptionHandler(NonExistingHeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNonExistingHero() {
    }
}
