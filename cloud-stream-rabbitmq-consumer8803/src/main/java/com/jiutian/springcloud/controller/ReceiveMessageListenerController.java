package com.jiutian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/5/14 20:41
 * @Author: jiutian
 * @Description:
 */
@Component
@EnableBinding(Sink.class)  // input
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号,----->接受到的消息: " + message.getPayload() + "\t  port: " + serverPort);
    }
}
