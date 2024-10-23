package com.spring_experiments.stackoverflow;

import com.spring_experiments.stackoverflow.proxyBeansMethod.RunService;
import com.spring_experiments.stackoverflow.proxyBeansMethod.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExperimentsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringExperimentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
