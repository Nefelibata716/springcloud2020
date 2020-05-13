package com.gguoliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 4:37 下午
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class OrderFeginHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeginHystrixMain80.class,args);
    }
}
