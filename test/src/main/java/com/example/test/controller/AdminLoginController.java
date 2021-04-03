package com.example.test.controller;

import com.example.test.entity.Admin;
import com.example.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminLoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/to_index_admin")
    String to_index_admin() {return "index_admin";}

    @RequestMapping("/adminLogin")
    String adminLogin() {
        return "admin_login"; // admin_login.html
    }

    @RequestMapping(value = "/admin_loginIn",method = RequestMethod.POST)
    public String admin_loginIn(String adminName, String adminPassword, HttpServletRequest request){
        Admin bean = adminService.Login(adminName,adminPassword);

        if(bean != null){
            request.getSession().setAttribute("curAdminName", adminName);
            return "index_admin";
        }
        else {
            System.out.println("Bean为null");
            return "404_admin";
        }
    }

    @RequestMapping("adminLogOut")
    public String adminLogOut(HttpServletRequest request) {
        request.getSession().removeAttribute("curAdminName");
        return "admin_login"; //admin_login.html
    }


}
