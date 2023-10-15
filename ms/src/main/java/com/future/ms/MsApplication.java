package com.future.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.future")
public class MsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsApplication.class,args);
    }
}
