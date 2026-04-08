package com.harris.controller;

import com.harris.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    public UserController() {
        System.out.println("Controller is loaded");
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        System.out.println("save!");
        return "User is saving";
    }

    @RequestMapping("/commParam")
    @ResponseBody
    public String commParam(@RequestParam("name") String user_name, int age) {
        System.out.println("name == " + user_name + " age == " + age);
        return "{'module': 'commParam'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        System.out.println("user delete");
        return "{'module' : 'user delete'}";
    }

    // POJO param
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo param: user: " + user);
        return "{'module': 'pojo param'}";
    }

    @RequestMapping("/containPojoParam")
    @ResponseBody
    public String containPojoParam (User user) {
        System.out.println(user.toString());
        return "{'module': 'contain pojo param'}";
    }

    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println(Arrays.toString(likes));
        return "{'module': 'arrayParam'}";
    }

    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String > likes){
        System.out.println(likes);
        return "{'module': 'list param'}";
    }
}
