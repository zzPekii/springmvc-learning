package com.harris.config;

import org.springframework.lang.Nullable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        // 要求你在这里加载mvc的容器对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    @Override
    protected String[] getServletMappings() {
        // 哪些请求归springMvc处理
        // 这里表示所有的请求归spring管
        return new String[]{"/"};
    }

    @Nullable
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // 加载Spring对应的容器配置，这里return null就行了
        return null;
    }
}