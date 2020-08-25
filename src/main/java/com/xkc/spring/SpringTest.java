package com.xkc.spring;

import com.xkc.spring.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

}
