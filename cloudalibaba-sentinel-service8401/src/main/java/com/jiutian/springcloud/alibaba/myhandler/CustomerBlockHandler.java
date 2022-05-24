package com.jiutian.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiutian.springcloud.pojo.CommonResult;
import com.jiutian.springcloud.pojo.Payment;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> handlerException(BlockException exception) {
        return new CommonResult<>(4444, "按客户自定义,global handlerException----1");
    }

    public static CommonResult<Payment> handlerException2(BlockException exception) {
        return new CommonResult<>(4444, "按客戶自定义,global handlerException----2");
    }
}
