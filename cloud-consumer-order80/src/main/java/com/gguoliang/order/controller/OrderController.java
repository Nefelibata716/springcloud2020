package com.gguoliang.order.controller;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 11:58 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    final static String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/order/getPaymentById")
    public CommonResult getPaymentById(@RequestBody Payment payment){
        log.info("请求参数{}",payment.getId());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/getPaymentById", payment, CommonResult.class);
    }

    @PostMapping(value = "/order/savePayment")
    public CommonResult savePayment(@RequestBody Payment payment){
        log.info("请求参数{}",payment.toString());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

}
