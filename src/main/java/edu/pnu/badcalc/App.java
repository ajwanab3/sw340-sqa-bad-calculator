package edu.pnu.badcalc;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        if (args.length == 3) {
            String expr = String.join(" ", args);
            double result = calculator.parseAndCompute(expr);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Usage: java App <a> <op> <b>");
            System.out.println("Example: java App 5 + 3");
        }
    }
}
