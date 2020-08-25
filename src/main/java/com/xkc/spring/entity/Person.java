package com.xkc.spring.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {

    private Integer age;

    private String name;

}
