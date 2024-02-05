package com.example.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Javaspring {

    @GetMapping("/message")
    public String getMessage() {
        return "Welcome chez DSK.....!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Javaspring.class, args);
    }
}
