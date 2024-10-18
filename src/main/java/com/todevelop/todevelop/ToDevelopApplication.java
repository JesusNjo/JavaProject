package com.todevelop.todevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.todevelop")
public class ToDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDevelopApplication.class, args);
    }

}
