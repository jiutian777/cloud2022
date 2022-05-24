package com.jiutian.springcloud.service;

import com.jiutian.springcloud.mapper.PaymentMapper;
import com.jiutian.springcloud.pojo.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2022/5/14 20:38
 * @Author: jiutian
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentMapper paymentMapper;


    @Override
    public int insertPayment(Payment payment) {
        return paymentMapper.insertPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
