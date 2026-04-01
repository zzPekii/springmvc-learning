package com.harris.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration // 1. 必须有这个，告诉 Spring 这是个配置类
//@ComponentScan(value = "com.harris", // 2. 确保路径和你左侧目录完全一致
//        excludeFilters = @ComponentScan.Filter(
//                type = FilterType.ANNOTATION,
//                classes = Controller.class
//        )
//)
@ComponentScan({"com.harris.service", "com.harris.dao"})
public class SpringConfig {
}