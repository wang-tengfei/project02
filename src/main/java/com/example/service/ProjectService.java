package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tw0519
 */
@Service
public class ProjectService {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，熔断方法直接返回了一个字符串
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(String name){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://PROJECT-ONE/hello?name={name}", String.class, name);

        return forEntity.getBody();
    }

    public String helloError(String name){
        return String.format("hello %s, sorry , error", name);
    }



}
