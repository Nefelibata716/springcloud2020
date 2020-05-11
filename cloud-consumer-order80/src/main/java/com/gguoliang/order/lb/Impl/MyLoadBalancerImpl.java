package com.gguoliang.order.lb.Impl;

import com.gguoliang.order.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 11:22 上午
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLoadBalancerImpl implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement(){
        atomicInteger.getAndIncrement();
        log.info("<自动定义轮询算法>第{}访问接口",atomicInteger.get());
        return atomicInteger.get();
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
