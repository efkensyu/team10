package com.example.demo.infratest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Team10WarTest2Controller {

    @GetMapping("/infra-test")
    public String infraTest() {
        return "Spring Boot起動OK：DB未使用";
    }
}
