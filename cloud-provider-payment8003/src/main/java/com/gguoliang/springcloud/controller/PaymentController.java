package com.gguoliang.springcloud.controller;

import com.gguoliang.common.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author GGuoLiang
 * @Date 2020/5/10 5:21 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/getZkTest")
    public CommonResult getZkTest(){
        return new CommonResult(200,"成功,serverPort"+serverPort, UUID.randomUUID());

    }
}
