package com.xkc.spring.test;

import com.xkc.spring.config.PropertiesConfig;
import com.xkc.spring.config.SpringConfig;
import com.xkc.spring.entity.Color;
import com.xkc.spring.entity.ColorFactoryBean;
import com.xkc.spring.entity.Person;
import com.xkc.spring.entity.White;
import com.xkc.spring.lifecycle.MainConfigOfLifeCycle;
import com.xkc.spring.lifecycle.MyBeanPostProcessor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

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

    @Test
    public void testLifeCycle(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
//        Car car = applicationContext.getBean(Car.class);
//        applicationContext.close();
//        car.destroy();

//        Accord accord = applicationContext.getBean(Accord.class);

        MyBeanPostProcessor myBeanPostProcessor = applicationContext.getBean(MyBeanPostProcessor.class);
        applicationContext.close();
    }

    @Test
    public void testProperty() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertiesConfig.class);
        System.out.println(applicationContext.getBean(Person.class));

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

    }

}
