package com.example.api;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println( application.contextFactory(ApplicationContextFactory.DEFAULT).toString());
        return application.sources(ApiApplication.class);
    }

}
