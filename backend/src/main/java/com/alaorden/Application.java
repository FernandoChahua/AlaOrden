package com.alaorden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Application  {
    public static void main(String[]args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean registrationBean =
                new FilterRegistrationBean(new CORSFilter());
        registrationBean.setName("CORS Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
