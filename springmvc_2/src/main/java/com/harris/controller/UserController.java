package com.harris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    public UserController() {
        System.out.println("Controller is loaded");
    }

    @RequestMapping("save")
    @ResponseBody
    public String save() {
        System.out.println("save!");
        return "User is saving";
    }

    @RequestMapping("commParam")
    @ResponseBody
    public String commParam(String name, int age) {
        System.out.println("name == " + name + " age == " + age);
        return "{'module': 'commParam'}";
    }
}
