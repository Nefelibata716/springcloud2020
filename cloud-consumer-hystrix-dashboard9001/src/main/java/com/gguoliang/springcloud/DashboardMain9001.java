package com.gguoliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 6:14 下午
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class,args);
    }
}
