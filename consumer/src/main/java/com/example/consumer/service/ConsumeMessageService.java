package com.example.consumer.service;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.consumer.dto.MessageDto;
import com.example.consumer.rabbitmq.ConfigureRabbitMq;

@Component
public class ConsumeMessageService {
    @RabbitListener(queues = ConfigureRabbitMq.QUEUE)
    public void listener(MessageDto  messageBody) {

        System.out.println("Consumed Message: " + messageBody);
    }
}