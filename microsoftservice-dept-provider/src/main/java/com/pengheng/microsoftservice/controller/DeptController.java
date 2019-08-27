package com.pengheng.microsoftservice.controller;

import com.pengheng.microsoftservice.entity.Dept;
import com.pengheng.microsoftservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/provider/dept/add")
    public Dept add(){
        Dept dept = new Dept();
        dept.setDeptname("财务部");
        dept.setRemark("结算工资的部门");
        dept.setDb_source("test");
        boolean add = deptService.add(dept);
        return dept;
    }

    @RequestMapping("/provider/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

}
