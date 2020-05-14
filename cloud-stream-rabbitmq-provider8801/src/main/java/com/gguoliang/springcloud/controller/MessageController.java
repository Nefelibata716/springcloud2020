package com.gguoliang.springcloud.controller;

import com.gguoliang.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author GGuoLiang
 * @Date 2020/5/14 11:45 下午
 * @Version 1.0
 */
@RestController
public class MessageController {

    @Resource
    private IMessageService iMessageService;

    @GetMapping("/sendMessage")
    public void sendMessage(){
        iMessageService.send();
    }
}
