package com.gguoliang.springcloud.mapper;

import com.gguoliang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:22 上午
 * @Version 1.0
 */
@Mapper
public interface PaymentMapper {

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
