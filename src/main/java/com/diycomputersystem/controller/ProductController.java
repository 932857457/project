package com.diycomputersystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diycomputersystem.entity.Product;
import com.diycomputersystem.entity.ProductSwiperImage;
import com.diycomputersystem.entity.R;
import com.diycomputersystem.service.IProductService;
import com.diycomputersystem.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductSwiperImageService productSwiperImageService;
    @GetMapping("/findSwiper")
    public R findswiper(){
        List<Product> swiperProductlist = productService.list(new QueryWrapper<Product>().eq("isSwiper",true).orderByAsc("swiperSort"));
        Map<String,Object> map = new HashMap<>();
        map.put("message",swiperProductlist);
        return R.ok(map);
    }

    @GetMapping("/findHot")
    public R findsHot(){
        Page<Product> page = new Page<>(0,8);
        Page<Product> pageProduct = productService.page(page,new QueryWrapper<Product>().eq("isHot",true).orderByAsc("HotDateTime"));
        List<Product> hotProductList = pageProduct.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("message",hotProductList);
        return R.ok(map);
    }

    @GetMapping("/detail")
    public R detail(Integer id){
        Product product = productService.getById(id);
        List<ProductSwiperImage> productSwiperImageList=productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId",product.getId()).orderByAsc("sort"));
        product.setProductSwiperImageList(productSwiperImageList);
        Map<String,Object> map = new HashMap<>();
        map.put("message",product);
        return R.ok(map);
    }
}
