package com.JavaWebMall.Service;

import com.JavaWebMall.Bean.Admin;
import com.JavaWebMall.Bean.AdminExample;
import com.JavaWebMall.DAO.AdminMapper;
import com.JavaWebMall.Utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminServiceImplement implements AdminService{
    @Autowired
    AdminMapper adminMapper;


    @Override
    public Admin login(String name, String password) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();;
        criteria.andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size() > 0){
            Admin admin = admins.get(0);
            String s = MD5Util.getMD5(password);
            if(admin.getaPass().equals(s)){
                return admin;
            }
        }
        return null;
    }
}
