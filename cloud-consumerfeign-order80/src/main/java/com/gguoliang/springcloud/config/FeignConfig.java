package com.gguoliang.springcloud.config;

import feign.Feign;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 10:38 下午
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.FULL;
    }
}
