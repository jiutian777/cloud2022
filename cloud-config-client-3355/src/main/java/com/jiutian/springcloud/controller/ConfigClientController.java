package com.jiutian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2022/5/15 22:21
 * @Author: jiutian
 * @Description:
 */
@RestController
@RefreshScope   // 需要 curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
