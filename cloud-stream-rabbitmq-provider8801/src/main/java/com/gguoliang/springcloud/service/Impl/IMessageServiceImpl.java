package com.gguoliang.springcloud.service.Impl;

import com.gguoliang.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author GGuoLiang
 * @Date 2020/5/14 11:40 下午
 * @Version 1.0
 */
@Slf4j
@EnableBinding(Source.class)
public class IMessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "  +serial);
        return null;
    }
}
