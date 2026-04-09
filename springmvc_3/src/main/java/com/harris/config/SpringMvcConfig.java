package com.harris.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.harris.controller")     // it will only scan controller
@EnableWebMvc       // label json -> obj
public class SpringMvcConfig {
}
