package com.cloud.service.controller;

import com.cloud.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author w
 * @date 2020/11/10
 */
@Controller
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id){
//        return restTemplate.getForObject("http://localhost:8081/user/"+id,User.class);
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-server");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String baseUrl = "http://" + "127.0.0.1" + ":" + serviceInstance.getPort() + "/user/" + id;
        System.out.println(baseUrl);
        return restTemplate.getForObject(baseUrl,User.class);
    }
}
