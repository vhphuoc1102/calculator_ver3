package com.calculator.calculator_ver3.MathFeatures;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitwiseOperate {
    public static String bitwiseOperate(String expression) {
        // Create a map of operator symbols to operator functions
        Map<String, BinaryOperator> operators = new HashMap<>();
        operators.put("AND", (x, y) -> x & y);
        operators.put("OR", (x, y) -> x | y);
        operators.put("NOT", (x, y) -> ~x);
        operators.put("XOR", (x, y) -> x ^ y);
        operators.put("NAND", (x, y) -> ~(x & y));
        operators.put("NOR", (x, y) -> ~(x | y));
        operators.put(">>", (x, y) -> x >> y);
        operators.put("<<", (x, y) -> x << y);

        // Split the expression into operands and operators
        String[] parts = expression.split("\\s+");
        List<Integer> operands = new ArrayList<>();
        List<String> operatorsList = new ArrayList<>();
        for (String part : parts) {
            if (part.matches("[01]+")) {
                operands.add(Integer.parseInt(part, 2));
            } else if (operators.containsKey(part)) {
                operatorsList.add(part);
            } else {
                throw new IllegalArgumentException("Invalid expression: " + expression);
            }
        }

        // Evaluate the expression
        int result = operands.get(0);
        for (int i = 0; i < operatorsList.size(); i++) {
            String operator = operatorsList.get(i);
            int operand = operands.get(i + 1);
            result = operators.get(operator).apply(result, operand);
        }

        // Convert the result to a binary string and remove redundant zeros
        return Integer.toBinaryString(result).replaceAll("^0+(?!$)", "");
    }

    // Define a functional interface for binary operators
    interface BinaryOperator {
        int apply(int x, int y);
    }
//    public static String bitwiseOperate(String expression) {
//        // Create a map of operator symbols to operator functions
//        Map<String, BinaryOperator> operators = new HashMap<>();
//        operators.put("AND", (x, y) -> x & y);
//        operators.put("OR", (x, y) -> x | y);
//        operators.put("NOT", (x, y) -> ~x);
//        operators.put("XOR", (x, y) -> x ^ y);
//        operators.put("NAND", (x, y) -> ~(x & y));
//        operators.put("NOR", (x, y) -> ~(x | y));
//
//        // Split the expression into operands and operators
//        String[] parts = expression.split("\\s+");
//        List<Integer> operands = new ArrayList<>();
//        List<String> operatorsList = new ArrayList<>();
//        for (String part : parts) {
//            if (part.matches("[01]+")) {
//                operands.add(Integer.parseInt(part, 2));
//            } else if (operators.containsKey(part)) {
//                operatorsList.add(part);
//            } else {
//                throw new IllegalArgumentException("Invalid expression: " + expression);
//            }
//        }
//
//        // Evaluate the expression
//        int result = operands.get(0);
//        for (int i = 0; i < operatorsList.size(); i++) {
//            String operator = operatorsList.get(i);
//            int operand = operands.get(i + 1);
//            result = operators.get(operator).apply(result, operand);
//        }
//
//        // Convert the result to a 32-bit binary string
//        return String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0');
//    }
//
//    // Define a functional interface for binary operators
//    interface BinaryOperator {
//        int apply(int x, int y);
//    }
}

