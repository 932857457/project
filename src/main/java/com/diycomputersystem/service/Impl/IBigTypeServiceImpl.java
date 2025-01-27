package com.diycomputersystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diycomputersystem.entity.BigType;
import com.diycomputersystem.mapper.BigTypeMapper;
import com.diycomputersystem.service.IBigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bigTypeService")
public class IBigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType> implements IBigTypeService {
    @Autowired
    private BigTypeMapper bigTypeMapper;
}
