package com.jiutian.springcloud.service;

import com.jiutian.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Date: 2022/5/14 20:39
 * @Author: jiutian
 * @Description:
 */
public interface PaymentService {
    int insertPayment(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
