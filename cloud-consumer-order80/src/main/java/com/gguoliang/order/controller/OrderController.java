package com.gguoliang.order.controller;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.common.entities.Payment;
import com.gguoliang.order.lb.LoadBalancer;
import com.gguoliang.order.properties.PaymentProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 11:58 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentProperties paymentProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/order/getPaymentById")
    public CommonResult getPaymentById(@RequestBody Payment payment){
        log.info("请求参数{}",payment.getId());
        return restTemplate.postForObject(paymentProperties.getPaymentService() + paymentProperties.getGetPaymentByIdUrl(), payment, CommonResult.class);
    }

    @PostMapping(value = "/order/savePayment")
    public CommonResult savePayment(@RequestBody Payment payment){
        log.info("请求参数{}",payment.toString());
        return restTemplate.postForObject(paymentProperties.getPaymentService() + paymentProperties.getSaveUrl(), payment, CommonResult.class);
    }

    @GetMapping("/order/payment/getPaymentLB")
    public CommonResult getPaymentLB() {
        // 通过容器中的 discoveryClient和服务名来获取服务集群
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        // 传入服务集群来计算出获取具体的服务实例
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return  restTemplate.getForObject(uri+"/payment/getPaymentLB",CommonResult.class);
    }

}
