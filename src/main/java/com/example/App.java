package com.example;

public class App {
    public static void main(String[] args) {
        App app = new App();
        String greeting = app.getGreeting("World");
        System.out.println(greeting);

        int result = app.calculateFactorial(5);
        System.out.println("Factorial of 5 is: " + result);

        String processedText = app.processText("Hello World", true);
        System.out.println("Processed text: " + processedText);
    }

    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, stranger!";
        }
        return "Hello, " + name + "!";
    }

    public int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public String processText(String text, boolean uppercase) {
        if (text == null) {
            return "";
        }

        String result = text;

        // Remove extra spaces
        result = result.trim().replaceAll("\\s+", " ");

        // Apply case transformation
        if (uppercase) {
            result = result.toUpperCase();
        } else {
            result = result.toLowerCase();
        }

        return result;
    }
}
