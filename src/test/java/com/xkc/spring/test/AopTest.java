package com.xkc.spring.test;

import com.xkc.spring.aop.MainConfigOfAop;
import com.xkc.spring.aop.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

    @Test
    public void testAop() {
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10, 10);
        System.out.println();
    }

}
