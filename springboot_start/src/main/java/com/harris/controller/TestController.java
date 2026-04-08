package com.harris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody // 直接返回文本，不找 JSP 页面
    public String test() {
        return "Spring MVC is Working!";
    }
}