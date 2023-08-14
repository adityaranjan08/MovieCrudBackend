package com.niit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Main applicatin class
 */
@SpringBootApplication
@EnableEurekaClient
@Configuration
@EnableFeignClients
public class MovieSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieSpringApplication.class, args);

    }
}
