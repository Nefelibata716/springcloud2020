package com.gguoliang.springcloud.controller;

import com.gguoliang.common.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GGuoLiang
 * @Date 2020/5/10 5:42 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    final static String PAYMENT_SERVICE = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/order/getZkTest")
    public CommonResult getZkTest(){
        return restTemplate.getForObject(PAYMENT_SERVICE+"/payment/getZkTest",CommonResult.class);
    }
}
