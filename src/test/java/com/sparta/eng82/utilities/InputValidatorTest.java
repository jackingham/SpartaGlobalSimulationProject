package com.sparta.eng82.utilities;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


public class InputValidatorTest {

    @Test
    public void shouldReturnInteger() {
        /*Assertions.assertEquals(5, InputValidator.getUserInput());*/
        InputValidator obj = new InputValidator();
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("5", InputValidator.verifyInteger());

    }
}


