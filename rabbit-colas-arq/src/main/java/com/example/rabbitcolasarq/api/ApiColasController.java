package com.example.rabbitcolasarq.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rabbitcolasarq.config.RabbitMqConfig;
import com.example.rabbitcolasarq.dto.MessageDto;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/colas")
public class ApiColasController {
    private static Logger LOGGER = LoggerFactory.getLogger(ApiColasController.class);
    
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(method = RequestMethod.POST,value = "producer")
    public ResponseEntity<Object> producerMessage(@RequestBody MessageDto messageDto) {
        LOGGER.info("REQUEST: Producer message");
        messageDto.setId("11adssa");
        messageDto.setDate(new Date());
        // TodoEntity result = todoBl.producerMessage(messageDto);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTING_KEY,messageDto);
        String result="Mensaje enviado a la cola OK";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
