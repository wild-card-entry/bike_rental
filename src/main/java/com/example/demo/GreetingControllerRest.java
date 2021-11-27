package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerRest {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    public Greet greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greet(counter.incrementAndGet(), String.format(template, name));
    }
}