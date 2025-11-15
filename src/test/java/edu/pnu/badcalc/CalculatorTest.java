package edu.pnu.badcalc;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Add two positive numbers")
    void testAddPositive() {
        Calculator c = new Calculator();
        double result = c.add(5.0, 3.0);
        assertEquals(8.0, result, 1e-6);
    }

    @Test
    @DisplayName("Subtract keeps negative result")
    void testSubtractNegative() {
        Calculator c = new Calculator();
        double result = c.subtract(5.0, 8.0);
        assertEquals(-3.0, result, 1e-6);
    }

    @Test
    @DisplayName("Multiply numbers")
    void testMultiply() {
        Calculator c = new Calculator();
        double result = c.multiply(2.5, 4.0);
        assertEquals(10.0, result, 1e-6);
    }

    @Test
    @DisplayName("Divide normal case")
    void testDivide() {
        Calculator c = new Calculator();
        double result = c.divide(10.0, 2.0);
        assertEquals(5.0, result, 1e-6);
    }

    @Test
    @DisplayName("Divide by zero throws exception")
    void testDivideByZero() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> c.divide(10.0, 0.0));
    }

    @Test
    @DisplayName("parseAndCompute: 5 + 3")
    void testParseAndComputeAdd() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("5 + 3");
        assertEquals(8.0, result, 1e-6);
    }

    @Test
    @DisplayName("parseAndCompute: 10 - 12")
    void testParseAndComputeSubtract() {
        Calculator c = new Calculator();
        double result = c.parseAndCompute("10 - 12");
        assertEquals(-2.0, result, 1e-6);
    }

    @Test
    @DisplayName("parseAndCompute invalid operator")
    void testParseAndComputeInvalidOperator() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> c.parseAndCompute("5 ^ 3"));
    }

    @Test
    @DisplayName("parseAndCompute invalid format")
    void testParseAndComputeInvalidFormat() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> c.parseAndCompute("5+3"));
    }
}
