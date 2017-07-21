package com.bridgephase.helloworld.controller;

import com.bridgephase.helloworld.domain.Message;
import com.bridgephase.helloworld.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public Message getMessage() {
        logger.info("HTTP request received for message.");
        return messageService.createMessage();
    }

    @CrossOrigin
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String healthCheck() {
        return "OK";
    }

}
