package com.jiutian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date: 2022/5/14 21:35
 * @Author: jiutian
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced   // 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
