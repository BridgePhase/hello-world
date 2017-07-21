package com.bridgephase.helloworld.service;

import com.bridgephase.helloworld.domain.Message;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

public class MessageServiceTest {

    private MessageService unitUnderTest;

    @Test
    public void testCreateMessage() throws Exception {
        unitUnderTest = new MessageService();

        Message result = unitUnderTest.createMessage();

        assertNotNull(result);
        assertEquals(ReflectionTestUtils.getField(MessageService.class, "MESSAGE"), result.getText());
    }

}