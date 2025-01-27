package com.diycomputersystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diycomputersystem.entity.Admin;
import com.diycomputersystem.entity.BigType;


public interface AdminMapper extends BaseMapper<Admin> {
    public BigType findById(Integer id);
}

