package com.spring_stackoverflow.snippets;

import com.spring_stackoverflow.snippets.proxyBeansMethod.RunService;
import com.spring_stackoverflow.snippets.proxyBeansMethod.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnippetsApplication implements CommandLineRunner {

	@Autowired
	RunService runService;
	@Autowired
	TrackService trackService;

	public static void main(String[] args) {
		SpringApplication.run(SnippetsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
