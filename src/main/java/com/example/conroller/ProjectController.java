package com.example.conroller;

import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tw0519
 */
@RestController
@RequestMapping("/two")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return projectService.sayHello(name);
    }

    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }
}
