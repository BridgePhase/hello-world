package com.bridgephase.helloworld.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    private Message unitUnderTest;

    @Test
    public void testGetText() throws Exception {
        String expected = "some-text";
        unitUnderTest = new Message(expected, null);

        assertEquals(expected, unitUnderTest.getText());
    }

    @Test
    public void testSetText() throws Exception {
        String expected = "more-text";
        unitUnderTest = new Message("other-text", null);

        unitUnderTest.setText(expected);

        assertEquals(expected, unitUnderTest.getText());
    }

    @Test
    public void testGetVersion() throws Exception {
        String expected = "v1.0";
        unitUnderTest = new Message(null, expected);

        assertEquals(expected, unitUnderTest.getVersion());
    }

    @Test
    public void testSetVersion() throws Exception {
        String expected = "v1.0";
        unitUnderTest = new Message(null, "v1.1");

        unitUnderTest.setVersion(expected);

        assertEquals(expected, unitUnderTest.getVersion());
    }

    @Test
    public void testToString() throws Exception {
        String expectedMessage = "meh";
        String version = "1.0";
        unitUnderTest = new Message(expectedMessage, version);

        String result = unitUnderTest.toString();

        assertTrue(result.contains(expectedMessage));
        assertTrue(result.contains(version));
    }

}