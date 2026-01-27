package com.bms.bms_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsBackendApplication.class, args);
    }

}
