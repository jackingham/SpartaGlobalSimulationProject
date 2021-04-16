package com.sparta.eng82.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Tests that printmessage works as expected with plain text")
    public void testPrintMessage() {
        Printer.printMessage("Hello world!");
        assertEquals("Hello world!\r\n", outContent.toString()); //uses different line separators.
    }

    @Test
    @DisplayName("Tests that printmessage works as expected with embedded strings")
    public void testPrintMessageString() {
        String name = "Jack";
        Printer.printMessage("Hello " + name);
        assertEquals("Hello Jack\r\n", outContent.toString()); //uses different line separators.
    }

    @Test
    @DisplayName("Tests that printmessage works as expected with embedded ints")
    public void testPrintMessageInt() {
        int number = 82;
        Printer.printMessage("Engineering " + number);
        assertEquals("Engineering 82\r\n", outContent.toString()); //uses different line separators.
    }
}
