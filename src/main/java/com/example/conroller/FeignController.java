package com.example.conroller;

import com.example.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tw0519
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {

        return feignService.sayHello(name);
    }
}
