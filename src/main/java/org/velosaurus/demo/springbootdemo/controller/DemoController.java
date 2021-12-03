package org.velosaurus.demo.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping("/hello-v2")
    public String sayHello(Model model) {
        model.addAttribute("date", new Date());
        return "hello";
    }
}
