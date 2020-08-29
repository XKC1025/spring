package com.xkc.spring.lifecycle;

import lombok.Data;
import org.springframework.context.annotation.*;

/**
 * 生命周期  初始化方法 和 销毁方法
 */
@Data
@Configuration
@ComponentScan("com.xkc.spring.lifecycle")
@Import(value = {Benz.class})
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Accord accord() {
        return new Accord();
    }

}
