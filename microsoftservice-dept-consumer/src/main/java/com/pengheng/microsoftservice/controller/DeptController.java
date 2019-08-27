package com.pengheng.microsoftservice.controller;

import com.pengheng.microsoftservice.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;

//    private final String REST_URL_PREFIX="http://localhost:8002/";
    //负载均衡方式调用接口  前缀使用spring.application.name 去eureka 获取服务对象
    private final String REST_URL_PREFIX="http://PROVIDER-DEPT/";


    @RequestMapping("comsumer/dept/list")
    public List<Dept> list(){
        List forObject = restTemplate.getForObject(REST_URL_PREFIX + "/provider/dept/list", List.class);
        return forObject;
    }
}
