package com.dw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthModuleMain {
    public static void main(String[] args) {
        SpringApplication.run(AuthModuleMain.class, args);
    }
}