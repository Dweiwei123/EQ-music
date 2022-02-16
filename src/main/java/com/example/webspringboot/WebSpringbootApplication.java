package com.example.webspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringbootApplication.class, args);
    }

}
