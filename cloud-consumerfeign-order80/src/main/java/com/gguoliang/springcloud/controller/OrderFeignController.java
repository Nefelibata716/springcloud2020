package com.gguoliang.springcloud.controller;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 10:26 下午
 * @Version 1.0
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/order/getPaymentFeign")
    public CommonResult getPaymentFeign(){
       return paymentService.getPaymentFeign();
    }
}
