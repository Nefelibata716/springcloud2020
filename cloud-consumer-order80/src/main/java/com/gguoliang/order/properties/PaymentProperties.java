package com.gguoliang.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author GGuoLiang
 * @Date 2020/5/10 12:34 上午
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "payment")
@Data
@Component
public class PaymentProperties {

    private String paymentService;
    private String saveUrl;
    private String getPaymentByIdUrl;

}
