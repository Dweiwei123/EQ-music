package com.example.webspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {

    /**
     * 向 spring容器中注入一个组件，组件的类型是 WebMvcConfigurer，组件的id是 webMvcConfigurer
     * 这里是添加一个自定义的视图控制
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * 添加一个自定义的视图控制，用于访问 springboot 项目的默认首页
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("signin.html");
            }

        };
    }
}
