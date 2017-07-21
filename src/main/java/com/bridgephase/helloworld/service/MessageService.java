package com.bridgephase.helloworld.service;

import com.bridgephase.helloworld.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final String MESSAGE = "Hello World!!";
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    public Message createMessage() {
        Message message = new Message(MESSAGE);
        logger.info("Received message request. Returning: {}", message.toString());
        return message;
    }
}
