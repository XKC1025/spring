package com.xkc.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

}
