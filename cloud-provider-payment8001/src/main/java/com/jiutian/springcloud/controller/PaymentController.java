package com.jiutian.springcloud.controller;

import com.jiutian.springcloud.pojo.CommonResult;
import com.jiutian.springcloud.pojo.Payment;
import com.jiutian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2022/5/14 20:41
 * @Author: jiutian
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult<Integer> insertPayment(@RequestBody Payment payment) {
        int result = paymentService.insertPayment(payment);
        log.info("插入結果" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功,serverPort:" + serverPort, result);
        }
        return new CommonResult<>(444, "插入失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询結果" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult<>(444, "查询失败,查询ID" + id, null);
    }

    @GetMapping("payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                    + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentZipkin server fall back，welcome，O(∩_∩)O哈哈~";
    }
}
