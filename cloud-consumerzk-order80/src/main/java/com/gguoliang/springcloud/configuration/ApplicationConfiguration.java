package com.gguoliang.springcloud.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 11:56 下午
 * @Version 1.0
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
