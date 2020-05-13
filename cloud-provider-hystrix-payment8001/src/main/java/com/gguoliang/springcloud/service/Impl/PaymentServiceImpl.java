package com.gguoliang.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/5/13 1:55 下午
 * @Version 1.0
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

   @Override
   @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
   })
   public CommonResult getPaymentHystrixById(int id){
       log.info("服务降级测试id为{}当前执行的线程为{}",id,Thread.currentThread().getName());
       return new CommonResult(200,"服务调用成功线程为"+Thread.currentThread().getName());
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public CommonResult getPaymentHystrixTimeOutById(int id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"服务调用成功线程为"+Thread.currentThread().getName());
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler")
    public CommonResult getPaymentHystrixErrorById(int id) {
       int a = id/0;
        return new CommonResult(200,"服务调用成功线程为"+Thread.currentThread().getName());
    }

    /**
     * 服务降级调用的方法
     * 注 参数类型保持跟原方法一致
     * @param id
     * @return
     */
    public CommonResult paymentInfo_TimeoutHandler(int id) {
        return new CommonResult(500,"/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName());
    }



    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数,请稍后再试， o(╥﹏╥)o id: " + id;
    }
}
