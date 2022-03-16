package com.JavaWebMall.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/prod")
    public String product(){
        return "product";
    }

    @RequestMapping("/addProd")
    public String addProduct(){
        return "addProduct";
    }
}
