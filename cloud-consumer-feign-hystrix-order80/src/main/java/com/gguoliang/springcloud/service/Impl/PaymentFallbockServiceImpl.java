package com.gguoliang.springcloud.service.Impl;

import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.PaymentFallbockService;
import com.gguoliang.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 5:05 下午
 * @Version 1.0
 */
@Component
public class PaymentFallbockServiceImpl implements PaymentService {
    @Override
    public CommonResult getPaymentHystrixById(Integer id) {
        return new CommonResult(501,"/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName());
    }

    @Override
    public CommonResult getPaymentHystrixTimeOutById(Integer id) {
        return new CommonResult(501,"/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName());
    }

    @Override
    public CommonResult getPaymentHystrixErrorById(Integer id) {
        return new CommonResult(501,"/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName());
    }

    @Override
    public CommonResult getPaymentHystrixErrorById1(Integer id) {
        return new CommonResult(501,"/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName());
    }
}
