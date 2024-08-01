package com.spring_stackoverflow.snippets.proxyBeansMethod;

import org.springframework.web.client.RestTemplate;

public class TrackService {
    private final RestTemplate restTemplate;

    public TrackService(RestTemplate restTemplate) {
        System.out.println("TrackService called with restTemplate " + restTemplate);
        this.restTemplate = restTemplate;
    }
}
