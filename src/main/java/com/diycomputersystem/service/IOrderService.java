package com.diycomputersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.diycomputersystem.entity.Order;

import java.util.List;
import java.util.Map;


public interface IOrderService extends IService<Order> {

    List<Order> list(Map<String,Object> map);


    Long getTotal(Map<String,Object> map);

}
