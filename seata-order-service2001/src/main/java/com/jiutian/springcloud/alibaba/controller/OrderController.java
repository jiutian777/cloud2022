package com.jiutian.springcloud.alibaba.controller;

import com.jiutian.springcloud.alibaba.domain.CommonResult;
import com.jiutian.springcloud.alibaba.domain.Order;
import com.jiutian.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<String> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
