package com.diycomputersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.diycomputersystem.entity.SmallType;

import java.util.List;
import java.util.Map;

public interface ISmallTypeService extends IService<SmallType> {
    List<SmallType> list(Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

}
