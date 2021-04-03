package com.example.test.serviceImpl;

import com.example.test.entity.Admin;
import com.example.test.mapper.AdminMapper;
import com.example.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin Login(String adminName, String adminPassword) {
        return adminMapper.Login(adminName, adminPassword);

    }
}
