package com.coursework.repair.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("services/*").setViewName("forward:/index.html");
        registry.addViewController("login/*").setViewName("forward:/index.html");
        registry.addViewController("logout/*").setViewName("forward:/index.html");
        registry.addViewController("driver/*").setViewName("forward:/index.html");
        registry.addViewController("mechanic/*").setViewName("forward:/index.html");
        registry.addViewController("service/*").setViewName("forward:/index.html");
        registry.addViewController("car/*").setViewName("forward:/index.html");
        registry.addViewController("registration/*").setViewName("forward:/index.html");
        registry.addViewController("guest/*").setViewName("forward:/index.html");
        registry.addViewController("user/*").setViewName("forward:/index.html");
        registry.addViewController("get/*").setViewName("forward:/index.html");
        registry.addViewController("request/*").setViewName("forward:/index.html");
        registry.addViewController("messaging/*").setViewName("forward:/index.html");
        registry.addViewController("messaging/dialog/*").setViewName("forward:/index.html");
    }

}
