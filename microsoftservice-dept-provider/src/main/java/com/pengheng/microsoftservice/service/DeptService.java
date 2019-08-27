package com.pengheng.microsoftservice.service;

import com.pengheng.microsoftservice.entity.Dept;

import java.util.List;

public interface DeptService {

    boolean add(Dept dept);

    boolean delete(String id);

    boolean update(Dept dept);

    Dept get(String id);

    List<Dept> list();


}
