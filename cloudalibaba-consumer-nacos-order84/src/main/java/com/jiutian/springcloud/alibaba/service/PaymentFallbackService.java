package com.jiutian.springcloud.alibaba.service;

import com.jiutian.springcloud.pojo.CommonResult;
import com.jiutian.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
