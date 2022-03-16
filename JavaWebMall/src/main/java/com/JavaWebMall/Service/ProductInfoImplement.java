package com.JavaWebMall.Service;

import com.JavaWebMall.Bean.ProductInfo;
import com.JavaWebMall.Bean.ProductInfoExample;
import com.JavaWebMall.Bean.ProductSelectCondition;
import com.JavaWebMall.DAO.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoImplement implements ProductInfoService{
    @Autowired
    ProductInfoMapper infoMapper;


    @Override
    public List<ProductInfo> getAll() {
        return infoMapper.selectByExample(null);
    }

    @Override
    public ProductInfo getProdInfoById(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProdInfo(ProductInfo productInfo) {
        infoMapper.updateByPrimaryKeySelective(productInfo);
    }

    @Override
    public void addProdInfo(ProductInfo productInfo) {
        infoMapper.insertSelective(productInfo);
    }

    @Override
    public void deleteProdOne(Integer id) {
        infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteProdBatch(List<Integer> ids) {
        ProductInfoExample infoExample = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andPIdIn(ids);
        infoMapper.deleteByExample(infoExample);
    }

    @Override
    public List<ProductInfo> getProdByCondition(ProductSelectCondition condition) {
        return infoMapper.selectProdByCondition(condition);
    }

}
