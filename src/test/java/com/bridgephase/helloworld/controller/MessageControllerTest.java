package com.bridgephase.helloworld.controller;

import com.bridgephase.helloworld.domain.Message;
import com.bridgephase.helloworld.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController unitUnderTest;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(unitUnderTest).build();
    }

    @Test
    public void testTetMessage() throws Exception {
        String expectedMessage = "hello-from-test";
        when(messageService.createMessage()).thenReturn(new Message(expectedMessage));

        MvcResult result = mockMvc.perform(get("/message").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andReturn();

        assertNotNull(result);
        String json = result.getResponse().getContentAsString();
        assertTrue(json.contains(expectedMessage));
    }

    @Test
    public void testHealthCheck() throws Exception {
        String expected = "OK";

        MvcResult result = mockMvc.perform(get("/health").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andReturn();

        assertNotNull(result);
        String json = result.getResponse().getContentAsString();
        assertTrue(json.contains(expected));
    }

    @Test
    public void testVersion() throws Exception {
        String expected = "version1";
        ReflectionTestUtils.setField(unitUnderTest, "version", expected);

        String actual = unitUnderTest.version();

        assertEquals(expected, actual);
    }

}