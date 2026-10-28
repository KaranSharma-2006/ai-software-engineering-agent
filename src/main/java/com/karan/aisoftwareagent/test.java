package com.karan.aisoftwareagent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/p")
    public String t() {
        return "helo";
    }
}
