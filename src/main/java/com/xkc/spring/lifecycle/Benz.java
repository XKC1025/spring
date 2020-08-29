package com.xkc.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Benz implements ApplicationContextAware {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct初始化方法.....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy销毁方法...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println();
    }
}

