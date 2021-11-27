package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           @RequestParam(name="title", required=false, defaultValue="World") String title,Model model) {
        model.addAttribute("name", name);
        model.addAttribute("title", title);
        System.out.println(name);
        return "greeting";
    }
    @GetMapping("/")
    public String home()
    {
        return "home_main";
    }
    @GetMapping("/demo")
    public String demo()
    {
        return "main";
    }
}