package com.example.javaspring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JavaSpringApplicationTests {

 @Test
    public void testGetMessage() {
        Javaspring javaspring = new Javaspring();
        String expectedMessage = "Welcome chez DSK.....!";

        assertEquals(expectedMessage, javaspring.getMessage());
    }

}


