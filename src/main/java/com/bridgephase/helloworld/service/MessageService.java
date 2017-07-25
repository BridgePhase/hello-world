package com.bridgephase.helloworld.service;

import com.bridgephase.helloworld.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final String MESSAGE = "Hello World!! - Matt";
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${service.version}")
    private String version;

    public Message createMessage() {
        Message message = new Message(MESSAGE, version);
        logger.info("Received message request. Returning: {}", message.toString());
        return message;
    }
}
