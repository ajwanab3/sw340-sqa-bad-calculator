package edu.pnu.badcalc;

public class Calculator {

    private double lastResult = 0.0;

    public double add(double a, double b) {
        lastResult = a + b;
        return lastResult;
    }

    public double subtract(double a, double b) {
        lastResult = a - b;
        return lastResult;
    }

    public double multiply(double a, double b) {
        lastResult = a * b;
        return lastResult;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        lastResult = a / b;
        return lastResult;
    }

    public double getLastResult() {
        return lastResult;
    }

    public void clear() {
        lastResult = 0.0;
    }

    public double parseAndCompute(String expr) {
        if (expr == null || expr.isBlank())
            throw new IllegalArgumentException("Expression cannot be empty");

        String[] parts = expr.trim().split("\\s+");
        if (parts.length != 3)
            throw new IllegalArgumentException("Expression must be: <a> <op> <b>");

        double a;
        double b;

        try {
            a = Double.parseDouble(parts[0]);
            b = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }

        return switch (parts[1]) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("Unknown operator: " + parts[1]);
        };
    }
}
