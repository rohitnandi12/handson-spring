package com.spring_experiments.stackoverflow;

import com.spring_experiments.stackoverflow.proxyBeansMethod.RunService;
import com.spring_experiments.stackoverflow.proxyBeansMethod.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TestProxyBeansMethod {

    @Autowired
    RunService runService;
    @Autowired
    TrackService trackService;

    @Test
    void testServiceMethod() {
        assertNotNull(runService);
        assertNotNull(trackService);
    }
}
