package com.example.test.service;

import com.example.test.entity.Admin;

public interface AdminService {
    Admin Login(String adminName, String adminPassword);
}
