package com.gguoliang.springcloud.controller;


import com.gguoliang.common.entities.CommonResult;
import com.gguoliang.common.entities.Payment;
import com.gguoliang.springcloud.service.PaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/5/9 9:34 上午
 * @Version 1.0
 */

@RestController
public class PaymentController {
    private Logger logger = LoggerFactory.getLogger(PaymentController.class);


    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/save")
    public CommonResult save(@RequestBody Payment payment){
        int save = paymentService.save(payment);
        logger.info("增加的参数{}",payment.toString());
        if(save > 0){
            return new CommonResult(200,"插入成功,serverPort"+serverPort);
        }
        return new CommonResult(500,"插入失败");
    }

    @PostMapping(value = "/payment/getPaymentById")
    public CommonResult getPaymentById(@RequestBody  Payment payment){
        if(payment.getId() == null){
            return new CommonResult(500,"参数缺失");
        }
        payment = paymentService.getPaymentById(payment.getId());
        return new CommonResult(200,"成功,serverPort"+serverPort,payment);
    }


    @GetMapping(value = "/payment/discovery")
    public CommonResult discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            logger.info("发现的服务有{}",service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                logger.info(instance.getServiceId()+"\t" + instance.getHost() +
                        "\t" + instance.getPort() +"\t" + instance.getUri());
            }
        }
        return new CommonResult(200,"成功",this.discoveryClient);
    }

    @GetMapping(value = "/payment/getPaymentLB")
    public CommonResult getPaymentLB(){
        return new CommonResult(200,"成功",serverPort);
    }

    @GetMapping(value = "/payment/getPaymentFeign")
    public CommonResult getPaymentFeign(){
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"成功，serverPort ="+serverPort, UUID.randomUUID());
    }


}
