package com.access.control.controller;

import com.access.control.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class


MainController {
    private UserService userService;

//    @Autowired
//    public MainController(UserService userService) {
//        this.userService = userService;
//    }

//    @RequestMapping("/home")
//    private String index() {
//        return "Joyce";
//    }
@RequestMapping(value = "/home", produces = {MediaType.APPLICATION_JSON_VALUE})
private String index() {
    return "Joyce";
}


}
