package com.harris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // 映射
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("User save ...");
        // Responsebody 告诉 print mvc 下面的就是响应体
        return "{'info' : springmvc'}";
    }
}