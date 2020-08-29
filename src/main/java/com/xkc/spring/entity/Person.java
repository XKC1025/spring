package com.xkc.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {

    @Value("#{24 - 6}")
    private Integer age;

    @Value("XKC")
    private String name;

    @Value("${person.nickName}")
    private String nickName;

}
