package com.pengheng.microsoftservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pengheng.microsoftservice.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
