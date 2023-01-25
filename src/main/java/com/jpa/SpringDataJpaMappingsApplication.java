package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaMappingsApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJpaMappingsApplication.class, args);
        System.out.println("jpa mapping");
    }

}
