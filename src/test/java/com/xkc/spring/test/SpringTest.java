package com.xkc.spring.test;

import com.xkc.spring.config.SpringConfig;
import com.xkc.spring.entity.Color;
import com.xkc.spring.entity.ColorFactoryBean;
import com.xkc.spring.entity.White;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    @Test
    public void testConditional() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    public void testImport() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        ColorFactoryBean colorFactoryBean = applicationContext.getBean(ColorFactoryBean.class);
        System.out.println(colorFactoryBean);

        White white = colorFactoryBean.getObject();
        System.out.println(white);

        // 获取的是White对象  协变返回类型
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean2);
        // 加& 返回工厂bean
        Object colorFactoryBean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean3);

    }

}
