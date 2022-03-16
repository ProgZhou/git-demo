package com.JavaWebMall.Service;

import com.JavaWebMall.Bean.ProductType;
import com.JavaWebMall.DAO.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeImplement implements ProductTypeService{
    @Autowired
    ProductTypeMapper typeMapper;


    @Override
    public List<ProductType> getAllType() {
        return typeMapper.selectByExample(null);
    }
}
