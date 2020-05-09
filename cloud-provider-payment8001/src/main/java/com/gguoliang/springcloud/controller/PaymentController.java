package com.gguoliang.springcloud.controller;

import com.gguoliang.springcloud.entities.CommonResult;
import com.gguoliang.springcloud.entities.Payment;
import com.gguoliang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:34 上午
 * @Version 1.0
 */

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/save")
    public CommonResult save(@RequestBody  Payment payment){
        int save = paymentService.save(payment);
        if(save > 0){
            return new CommonResult(200,"插入成功");
        }
        return new CommonResult(500,"插入失败");
    }


}
