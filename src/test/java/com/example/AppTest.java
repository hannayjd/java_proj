package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    @DisplayName("App initialization test")
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest);
    }

    @Test
    @DisplayName("Greeting test with valid name")
    void testGreetingWithName() {
        App app = new App();
        String result = app.getGreeting("John");
        assertEquals("Hello, John!", result);
    }

    @Test
    @DisplayName("Greeting test with empty name")
    void testGreetingWithEmptyName() {
        App app = new App();
        String result = app.getGreeting("");
        assertEquals("Hello, stranger!", result);
    }

    @ParameterizedTest(name = "Factorial of {0} should be {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "5, 120"
    })
    void testFactorialCalculation(int input, int expected) {
        App app = new App();
        int result = app.calculateFactorial(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Factorial with negative number throws exception")
    void testFactorialWithNegativeNumber() {
        App app = new App();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.calculateFactorial(-1);
        });

        assertTrue(exception.getMessage().contains("Factorial not defined"));
    }

    @Test
    @DisplayName("Process text with uppercase option")
    void testProcessTextUppercase() {
        App app = new App();
        String result = app.processText("hello  world", true);
        assertEquals("HELLO WORLD", result);
    }

    @Test
    @DisplayName("Process text with lowercase option")
    void testProcessTextLowercase() {
        App app = new App();
        String result = app.processText("Hello  WORLD", false);
        assertEquals("hello world", result);
    }
}
