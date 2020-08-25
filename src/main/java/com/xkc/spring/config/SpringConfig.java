package com.xkc.spring.config;

import com.xkc.spring.component.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.xkc"})
public class SpringConfig {

    @Bean
    public Student student() {
        return new Student();
    }

}