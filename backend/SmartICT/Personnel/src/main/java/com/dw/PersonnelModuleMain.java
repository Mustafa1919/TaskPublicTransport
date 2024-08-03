package com.dw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PersonnelModuleMain {
    public static void main(String[] args) {
        SpringApplication.run(PersonnelModuleMain.class,args);
    }
}