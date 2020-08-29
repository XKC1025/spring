package com.xkc.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器, 初始化之前。。。");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器, 初始化之后。。。");
        return null;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct初始化方法.....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy销毁方法...");
    }
}
