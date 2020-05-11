package com.gguoliang.order.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 11:19 上午
 * @Version 1.0
 */
public interface LoadBalancer {
    /**
     * 获取服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
