package com.guide_scheduling_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GuideSchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuideSchedulingTasksApplication.class, args);
	}

}
