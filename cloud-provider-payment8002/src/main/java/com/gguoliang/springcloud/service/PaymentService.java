package com.gguoliang.springcloud.service;


import com.gguoliang.common.entities.Payment;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:31 上午
 * @Version 1.0
 */
public interface PaymentService {


    /**
     * 保存
     * @param payment
     * @return
     */
    int save(Payment payment);

    /**
     * 获取详情
     * @param paymentId
     * @return
     */
    Payment getPaymentById(Long paymentId);
}
