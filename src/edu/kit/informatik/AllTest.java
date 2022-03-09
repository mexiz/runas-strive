package edu.kit.informatik;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class AllTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }



    @Test
    public void tesaasdt() {
        Main.main(null);
        System.out.println("Hello World!");
        assertEquals("Hello World!", outContent.toString().trim());
    }
}
