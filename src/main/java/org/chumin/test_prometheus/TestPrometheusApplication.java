package org.chumin.test_prometheus;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TestPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestPrometheusApplication.class, args);
    }

    @PostConstruct
    public void onStart() {
        log.info("Application started successfully!");
    }

    @PreDestroy
    public void onShutDown() throws Exception {
        log.info("Application shut down successfully!");
    }

}
