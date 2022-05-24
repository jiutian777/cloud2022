package com.jiutian.springcloud.mapper;

import com.jiutian.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Date: 2022/5/14 20:23
 * @Author: jiutian
 * @Description:
 */
@Mapper
public interface PaymentMapper {
    int insertPayment(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
