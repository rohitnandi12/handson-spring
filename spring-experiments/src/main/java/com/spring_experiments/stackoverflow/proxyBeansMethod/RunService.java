package com.spring_experiments.stackoverflow.proxyBeansMethod;

import org.springframework.web.client.RestTemplate;

public class RunService {

    private final RestTemplate restTemplate;

    public RunService(RestTemplate restTemplate) {
        System.out.println("RunService called with restTemplate " + restTemplate);
        this.restTemplate = restTemplate;
    }
}
