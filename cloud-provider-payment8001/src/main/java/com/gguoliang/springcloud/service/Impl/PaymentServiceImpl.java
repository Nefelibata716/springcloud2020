package com.gguoliang.springcloud.service.Impl;

import com.gguoliang.springcloud.entities.Payment;
import com.gguoliang.springcloud.mapper.PaymentMapper;
import com.gguoliang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:32 上午
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentMapper.getPaymentById(paymentId);
    }
}
