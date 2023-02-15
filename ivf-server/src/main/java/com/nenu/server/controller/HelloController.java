package com.nenu.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Breon
 * @description: TODO
 * @date: 2022/10/18 9:48
 */
@RestController
public class HelloController {

    @GetMapping("/experiment/patient/hello")
    public String hello2(){
        return "/experiment/patient/hello";
    }
}
