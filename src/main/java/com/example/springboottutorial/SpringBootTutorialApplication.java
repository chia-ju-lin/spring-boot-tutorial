package com.example.springboottutorial;

import org.owasp.esapi.errors.EncodingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.owasp.esapi.ESAPI;


@SpringBootApplication
@RestController
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) throws EncodingException {
//        System.out.println("before encode: "+name);
        String validatedName=ESAPI.encoder().encodeForURL(name);
//        System.out.println("after encode: "+validatedName);
        return String.format("Hello %s!", validatedName);


    }
}
