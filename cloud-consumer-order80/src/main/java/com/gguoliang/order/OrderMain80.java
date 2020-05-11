package com.gguoliang.order;

import com.gguoliang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 11:53 下午
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-payment",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }


}
