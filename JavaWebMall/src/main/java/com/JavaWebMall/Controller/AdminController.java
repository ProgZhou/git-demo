package com.JavaWebMall.Controller;

import com.JavaWebMall.Bean.Admin;
import com.JavaWebMall.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request){
        Admin admin = adminService.login(name, password);
        if(admin != null){
            request.setAttribute("admin", admin);
            return "main";
        } else {
            request.setAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

}
