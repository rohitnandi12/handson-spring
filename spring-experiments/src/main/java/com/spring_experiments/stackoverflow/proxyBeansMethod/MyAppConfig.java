package com.spring_experiments.stackoverflow.proxyBeansMethod;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
public class MyAppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public RunService runService(RestTemplate restTemplate) {
        return new RunService(restTemplate);
    }

    @Bean
    public TrackService trackService(RestTemplate restTemplate) {
        return new TrackService(restTemplate);
    }
}