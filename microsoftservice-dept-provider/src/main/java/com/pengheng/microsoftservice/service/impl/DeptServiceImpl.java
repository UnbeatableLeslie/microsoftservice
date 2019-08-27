package com.pengheng.microsoftservice.service.impl;

import com.pengheng.microsoftservice.dao.DeptMapper;
import com.pengheng.microsoftservice.entity.Dept;
import com.pengheng.microsoftservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        int insert = deptMapper.insert(dept);
        return insert>0?true:false;
    }

    @Override
    public boolean delete(String id) {
        int i = deptMapper.deleteById(id);
        return i>0?true:false;
    }

    @Override
    public boolean update(Dept dept) {
        int i = deptMapper.updateById(dept);
        return i>0?true:false;
    }

    @Override
    public Dept get(String id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public List<Dept> list() {
        List<Dept> depts = deptMapper.selectList(null);
        return depts;
    }
}
