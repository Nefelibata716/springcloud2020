package com.gguoliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author GGuoLiang
 * @Date 2020/5/18 11:50 下午
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClientMain3377.class,args);
    }
}
