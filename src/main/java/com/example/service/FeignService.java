package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tw0519
 * Feign 采用的是基于接口的注解
 * Feign 整合了ribbon，具有负载均衡的能力
 * 整合了Hystrix，具有熔断的能力
 */
@FeignClient(value = "project-one", fallback = FeignServiceHystricImpl.class)
public interface FeignService {

    /**
     * hello
     * @param name
     * @return
     */
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);
}
