package com.JavaWebMall.Service;

import com.JavaWebMall.Bean.Admin;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {

    //登录功能
    Admin login(String name, String password);

}
