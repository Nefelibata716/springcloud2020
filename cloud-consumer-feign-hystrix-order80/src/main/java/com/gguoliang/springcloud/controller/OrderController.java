package com.gguoliang.springcloud.controller;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 4:44 下午
 * @Version 1.0
 */
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/{id}")
    public CommonResult getPaymentHystrixById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixById(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public CommonResult getPaymentHystrixTimeOutById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixTimeOutById(id);
    }

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public CommonResult getPaymentHystrixErrorById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixErrorById(id);
    }

    @GetMapping(value = "/payment/hystrix/error1/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallbackMethod")
    public CommonResult getPaymentHystrixErrorById1(@PathVariable("id") Integer id){
     return paymentService.getPaymentHystrixErrorById1(id);
    }

    public CommonResult paymentInfo_TimeoutFallbackMethod(Integer id) {
        return new CommonResult(500,"\"/(ToT)/我是消费者80，调用8001支付系统繁忙，请10秒钟后重新尝试、\\t\"");
    }

    // 下面是全局fallback方法
    public CommonResult paymentInfo_Global_FallbackMethod() {
        return new CommonResult(200,"\"Global异常处理信息，请稍后再试， /(ToT)/\"");
    }
}
