package com.diycomputersystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diycomputersystem.entity.BigType;
import com.diycomputersystem.entity.Product;
import com.diycomputersystem.entity.R;
import com.diycomputersystem.entity.SmallType;
import com.diycomputersystem.service.IBigTypeService;
import com.diycomputersystem.service.IProductService;
import com.diycomputersystem.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigType")
public class BigTypeController {

    @Autowired
    private IBigTypeService bigTypeService;
    @Autowired
    private ISmallTypeService smallTypeService;
    @Autowired
    private IProductService productService;
    @GetMapping("/findAll")
    public R findsAll(){
        List<BigType> bigTypeList=bigTypeService.list();
        Map<String,Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return R.ok(map);
    }
    @GetMapping("/findCategories")
    public R findCategories(){
        List<BigType> bigTypeList = bigTypeService.list();
        for(BigType bigType:bigTypeList){
            List<SmallType> smallTypeList= smallTypeService.list(new QueryWrapper<SmallType>().eq("bigTypeId", bigType.getId()));
            bigType.setSmallTypeList(smallTypeList);
            for(SmallType smallType:smallTypeList){
                List<Product> productList=productService.list(new QueryWrapper<Product>().eq("typeId",smallType.getId()));
                smallType.setProductList(productList);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("message",bigTypeList);
        return R.ok(map);
    }
}
