package com.xkc.spring.config;

import com.xkc.spring.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:person.properties")
public class PropertiesConfig {

    @Bean
    public Person person() {
        return new Person();
    }

}
