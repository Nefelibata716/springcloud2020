package com.gguoliang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GGuoLiang
 * @Date 2020/5/11 11:00 上午
 * @Version 1.0
 *  自定义的Ribbon算法规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule mySelfRule(){
        return new RandomRule();
    }
}
