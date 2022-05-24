package com.jiutian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Date: 2022/5/15 21:47
 * @Author: jiutian
 * @Description:
 */
public interface LoadBalancer {
    ServiceInstance getInstances(List<ServiceInstance> serviceInstances);
}
