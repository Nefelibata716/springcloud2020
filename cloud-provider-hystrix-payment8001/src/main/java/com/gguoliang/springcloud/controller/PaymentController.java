package com.gguoliang.springcloud.controller;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 2:00 下午
 * @Version 1.0
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/{id}")
    public CommonResult getPaymentHystrixById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixById(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public CommonResult getPaymentHystrixTimeOutById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixTimeOutById(id);
    }

    @GetMapping(value = "/payment/hystrix/error/{id}")
    public CommonResult getPaymentHystrixErrorById(@PathVariable("id") Integer id){
        return paymentService.getPaymentHystrixErrorById(id);
    }

    @GetMapping(value = "/payment/hystrix/error1/{id}")
    public CommonResult getPaymentHystrixErrorById1(@PathVariable("id") Integer id){
        int a = 1/id;
        return new CommonResult(200,"成功");
    }


    @GetMapping(value = "/payment/hystrix/paymentCircuitBreaker/{id}")
    public CommonResult paymentCircuitBreaker(@PathVariable("id") Integer id){
        return new CommonResult(200,paymentService.paymentCircuitBreaker(id));
    }

}
