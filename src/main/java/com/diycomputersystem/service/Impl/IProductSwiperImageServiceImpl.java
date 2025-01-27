package com.diycomputersystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diycomputersystem.entity.ProductSwiperImage;
import com.diycomputersystem.mapper.ProductSwiperImageMapper;
import com.diycomputersystem.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductSwiperImageService")
public class IProductSwiperImageServiceImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements IProductSwiperImageService {
    @Autowired
    private ProductSwiperImageMapper productSwiperImageMapper;
}
