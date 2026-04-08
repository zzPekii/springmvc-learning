package com.harris;

import com.harris.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] names = ctx.getBeanDefinitionNames();

        System.out.println("--- Container Bean list ---");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
