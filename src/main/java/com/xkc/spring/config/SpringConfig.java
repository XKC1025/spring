package com.xkc.spring.config;

import com.xkc.spring.condition.LinuxCondition;
import com.xkc.spring.condition.WindowsCondition;
import com.xkc.spring.controller.TestController;
import com.xkc.spring.entity.Color;
import com.xkc.spring.entity.ColorFactoryBean;
import com.xkc.spring.entity.Dog;
import com.xkc.spring.entity.Teacher;
import com.xkc.spring.filtertypeimpl.MyFilterType;
import com.xkc.spring.registrar.MyImportBeanDefinitionRegistrar;
import com.xkc.spring.selector.MySelector;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScans(value = {
        @ComponentScan(basePackages = {"com.xkc"}, includeFilters = {
                @Filter(type = FilterType.ANNOTATION, classes = {Service.class}),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {TestController.class}),
                @Filter(type = FilterType.CUSTOM, classes = {MyFilterType.class})
        }, useDefaultFilters = false)
})
@Import(value = {Color.class, MySelector.class, MyImportBeanDefinitionRegistrar.class})
//@ComponentScan(basePackages = {"com.xkc"}, excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Component.class})})
public class SpringConfig {

    @Bean
    @Lazy
    @Scope(value = "singleton")
    public Teacher teacher() {
        System.out.println("创建Teacher");
        return new Teacher();
    }

    @Bean("keji")
    @Conditional(value = {WindowsCondition.class})
    public Dog dog() {
        return new Dog();
    }

    @Bean("hasaky")
    @Conditional(value = {LinuxCondition.class})
    public Dog dog1() {
        return new Dog();
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}