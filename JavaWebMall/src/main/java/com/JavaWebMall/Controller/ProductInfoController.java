package com.JavaWebMall.Controller;

import com.JavaWebMall.Bean.Message;
import com.JavaWebMall.Bean.ProductInfo;
import com.JavaWebMall.Bean.ProductSelectCondition;
import com.JavaWebMall.Bean.ProductType;
import com.JavaWebMall.Service.ProductInfoService;
import com.JavaWebMall.Service.ProductTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductInfoController {
    @Autowired
    ProductInfoService infoService;

    @Autowired
    ProductTypeService typeService;

    private String fileNameAll = "";

    //查询商品信息，分页显示
    @RequestMapping("/prodInfo")
    @ResponseBody
    public Message getProductSplit(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        List<ProductType> types = typeService.getAllType();
        PageHelper.startPage(pn, 5);
        List<ProductInfo> infos = infoService.getAll();
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(infos, 5);
        return Message.success().add("pageInfo", pageInfo).add("types", types);
    }


    //接收上传来的图片
    @RequestMapping("/prodImage")
    @ResponseBody
    public String ajaxImage(MultipartFile pimage, HttpServletRequest request){
        //提取生成文件名UUID + 上传图片的后缀
        String fileName = pimage.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + suffix;
        fileNameAll = fileName;
        //得到项目中，图片存储的路径
        String path = request.getServletContext().getRealPath("static/image_big") ;
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = path + File.separator + fileName;
        try {
            pimage.transferTo(new File(finalPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    //按照id获取商品信息
    @RequestMapping(value = "/getProdInfo/{prodId}", method = RequestMethod.GET)
    @ResponseBody
    public Message getProdInfo(@PathVariable("prodId") Integer id){
        ProductInfo info = infoService.getProdInfoById(id);

        return Message.success().add("info", info);
    }

    //获取所有的商品类型
    @RequestMapping("/getTypes")
    @ResponseBody
    public Message getProdTypes(){
        List<ProductType> typeList = typeService.getAllType();
        return Message.success().add("typeList", typeList);
    }


    //保存更新的商品数据
    @RequestMapping(value = "/product/{pId}", method = RequestMethod.PUT)
    @ResponseBody
    public Message updateProd(ProductInfo productInfo){
        infoService.updateProdInfo(productInfo);
        return Message.success();
    }

    //添加商品信息
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseBody
    public Message productAdd(ProductInfo info){
        info.setpImage(fileNameAll);
        info.setpDate(new Date());
        System.out.println(info);
        infoService.addProdInfo(info);
        return Message.success();
    }

    //删除商品信息
    @RequestMapping(value = "/product/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message deleteProdById(@PathVariable("ids") String ids){
        if(ids.contains("-")){
            String[] strings = ids.split("-");
            List<Integer> list = new ArrayList<>();
            for (String id: strings) {
                list.add(Integer.valueOf(id));
            }
            infoService.deleteProdBatch(list);
        } else{
            infoService.deleteProdOne(Integer.valueOf(ids));
        }
        return Message.success();
    }

    @RequestMapping("/selectProd")
    @ResponseBody
    public Message selectByType(@RequestParam(value = "pn", defaultValue = "1") Integer pn ,ProductSelectCondition condition){
        //System.out.println(condition);
        PageHelper.startPage(pn, 5);
        List<ProductInfo> infos = infoService.getProdByCondition(condition);
        PageInfo<ProductInfo> infoPageInfo = new PageInfo<>(infos, 5);
        return Message.success().add("pageInfo", infoPageInfo);
    }
}
