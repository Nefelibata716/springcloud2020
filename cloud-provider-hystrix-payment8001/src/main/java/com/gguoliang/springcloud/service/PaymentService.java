package com.gguoliang.springcloud.service;

import com.gguoliang.common.entities.CommonResult;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 1:55 下午
 * @Version 1.0
 */
public interface PaymentService {

    /**
     * 正常测试
     * @param id
     * @return
     */
    CommonResult getPaymentHystrixById(int id);


    /**
     * 服务降级超时测试
     * @param id
     * @return
     */
    CommonResult getPaymentHystrixTimeOutById(int id);


    /**
     * 服务降级错误测试
     * @param id
     * @return
     */
    CommonResult getPaymentHystrixErrorById(int id);


    /**
     * 服务熔断测试
     * @param id
     * @return
     */
     String paymentCircuitBreaker(Integer id);
}
