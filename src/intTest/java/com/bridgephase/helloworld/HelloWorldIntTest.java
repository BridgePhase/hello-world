package com.bridgephase.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldIntTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMessageEndpoint() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/message", String.class);
        String message = response.getBody();
        assertEquals("Hello World!!", message);
    }
}
