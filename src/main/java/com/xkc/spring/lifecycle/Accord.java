package com.xkc.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Accord implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 属性赋值完毕。。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 对象被回收。。。。");
    }
}
