package com.gguoliang.springcloud.service;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.Impl.PaymentFallbockServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 4:40 下午
 * @Version 1.0
 */
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbockServiceImpl.class)
@Component
public interface PaymentService {
    @GetMapping(value = "/payment/hystrix/{id}")
    public CommonResult getPaymentHystrixById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public CommonResult getPaymentHystrixTimeOutById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public CommonResult getPaymentHystrixErrorById(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/error1/{id}")
    public CommonResult getPaymentHystrixErrorById1(@PathVariable("id") Integer id);

}
