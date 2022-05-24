package com.jiutian.springcloud.alibaba.service;

import com.jiutian.springcloud.pojo.CommonResult;
import com.jiutian.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
