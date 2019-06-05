package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @author tw0519
 */
@Component(value = "feignServiceHystric")
public class FeignServiceHystricImpl implements FeignService {

    @Override
    public String sayHello(String name) {
        return "hello "+ name + ", error";
    }
}
