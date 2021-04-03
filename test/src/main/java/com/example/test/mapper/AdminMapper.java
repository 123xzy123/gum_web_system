package com.example.test.mapper;

import com.example.test.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    Admin Login(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);
}
