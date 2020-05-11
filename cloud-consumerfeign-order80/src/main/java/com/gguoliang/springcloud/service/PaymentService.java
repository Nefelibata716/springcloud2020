package com.gguoliang.springcloud.service;

import com.gguoliang.common.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 10:11 下午
 * @Version 1.0
 */
@FeignClient(value = "cloud-provider-payment")
@Component
public interface PaymentService {

    @GetMapping(value = "/payment/getPaymentFeign")
    public CommonResult getPaymentFeign();

}
