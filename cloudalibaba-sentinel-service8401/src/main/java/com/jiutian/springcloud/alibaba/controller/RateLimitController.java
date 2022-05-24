package com.jiutian.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiutian.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.jiutian.springcloud.pojo.CommonResult;
import com.jiutian.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@RestController
public class RateLimitController {

    // 按资源名称，使用自定义处理逻辑，没配 blockHandler 则 500 error page
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult<Payment> handleException(BlockException exception) {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    // 按 url，使用系统默认处理逻辑，Blocked by Sentinel (flow limiting)
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    // 全局
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}
