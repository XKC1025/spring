package com.xkc.spring.entity;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<White> {
    public White getObject() {
        System.out.println("调用工厂Bean...");
        return new White();
    }

    public Class<?> getObjectType() {
        return White.class;
    }

    public boolean isSingleton() {
        return true;
    }
}