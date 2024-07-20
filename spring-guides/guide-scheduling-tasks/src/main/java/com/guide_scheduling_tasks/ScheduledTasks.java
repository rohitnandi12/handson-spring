package com.guide_scheduling_tasks;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ScheduledTasks {

    /**
     * This is not safe in a distributed environment. Each node works independently.
     */
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Task executed at fixedRate {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 * * * * ?") // Executes every minute
    public void taskWithCronExpression() {
        log.info("Task executed using cron expression at " + new Date());
    }

    @Scheduled(fixedDelay = 10000) // Executes every 10 seconds after the completion of the previous invocation
    public void taskWithFixedDelay() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5) * 1000L);
        log.info("Task with fixed delay executed at " + new Date());
    }

    @Scheduled(initialDelay = 5000, fixedRate = 10000) // Executes after 5 seconds and then every 10 seconds
    public void oneTimeTaskWithInitialDelay() {
        log.info("One-time task with initial delay executed at " + new Date());
    }
}