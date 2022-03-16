package com.JavaWebMall.Service;

import com.JavaWebMall.Bean.ProductInfo;
import com.JavaWebMall.Bean.ProductSelectCondition;

import java.util.List;

public interface ProductInfoService {

    //查询所有商品信息
    public List<ProductInfo> getAll();

    //按照id查询商品信息
    public ProductInfo getProdInfoById(Integer id);

    //更新商品信息
    public void updateProdInfo(ProductInfo productInfo);

    //添加商品信息
    public void addProdInfo(ProductInfo productInfo);

    //按照id删除单个商品信息
    public void deleteProdOne(Integer id);

    //按照id批量删除商品
    public void deleteProdBatch(List<Integer> ids);

    //按照条件筛选商品，并分页显示
    public List<ProductInfo> getProdByCondition(ProductSelectCondition condition);

    //List<ProductInfo> getProdByCondition(Integer typeId);
}
