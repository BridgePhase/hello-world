package com.bridgephase.helloworld.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    private Message unitUnderTest;

    @Test
    public void testGetText() throws Exception {
        String expected = "some-text";
        unitUnderTest = new Message(expected);

        assertEquals(expected, unitUnderTest.getText());
    }

    @Test
    public void testSetText() throws Exception {
        String expected = "more-text";
        unitUnderTest = new Message("other-text");

        unitUnderTest.setText(expected);

        assertEquals(expected, unitUnderTest.getText());
    }

    @Test
    public void testToString() throws Exception {
        String expected = "even-more-text";
        unitUnderTest = new Message(expected);

        String result = unitUnderTest.toString();

        assertEquals(expected, result);
    }

}