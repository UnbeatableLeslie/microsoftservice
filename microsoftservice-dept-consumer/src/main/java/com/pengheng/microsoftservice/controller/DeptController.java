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

    private final String REST_URL_PREFIX="http://localhost:8002/";

    @RequestMapping("comsumer/dept/list")
    public List<Dept> list(){
        List forObject = restTemplate.getForObject(REST_URL_PREFIX + "/provider/dept/list", List.class);
        return forObject;
    }
}
