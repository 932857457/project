package com.diycomputersystem.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diycomputersystem.entity.OrderDetail;
import com.diycomputersystem.entity.R;
import com.diycomputersystem.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin/orderDetail")
public class AdminOrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 根据订单号查询商品订单详情
     * @param id
     * @return
     */
    @RequestMapping("/list/{id}")
    public R listByOrderId(@PathVariable(value = "id") Integer id){
        List<OrderDetail> orderDetailList = orderDetailService.list(new QueryWrapper<OrderDetail>().eq("mId", id));
        Map<String,Object> map=new HashMap<>();
        map.put("list",orderDetailList);
        return R.ok(map);
    }
}
