package com.jiutian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2022/5/15 21:49
 * @Author: jiutian
 * @Description:
 */
@Component
public class MyLB implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current, next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*******第几次访问，次数next:"+next);
        return next;
    }

    @Override
    public ServiceInstance getInstances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
