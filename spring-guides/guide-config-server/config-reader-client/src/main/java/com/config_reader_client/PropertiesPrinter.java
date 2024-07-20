package com.config_reader_client;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PropertiesPrinter implements ApplicationRunner {

    private final Environment environment;

    public PropertiesPrinter(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Loaded properties:");

        // Example: Print specific known properties or use a predefined set of keys
        Arrays.asList("spring.application.name", "server.port", "spring.profiles.active", "message", "native-message")
                .forEach(key -> System.out.println(key + "=" + environment.getProperty(key)));
    }
}
