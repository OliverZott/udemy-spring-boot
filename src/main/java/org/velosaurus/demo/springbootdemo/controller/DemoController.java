package org.velosaurus.demo.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello-v2")
    public String sayHello(Model model) {
        model.addAttribute("date", new Date());
        logger.info(String.format("Call from %s", this.getClass()));
        return "hello";
    }
}
