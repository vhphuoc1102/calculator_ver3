package com.calculator.calculator_ver3.MathFeatures;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class ScientificCalculate {
//    public static String scientificCalculate(String expression, String unit){
//        // Create a new evaluator
//        DoubleEvaluator evaluator = new DoubleEvaluator();
////        String expression = "(2^3-1)*sin(pi/4)/ln(pi^2)";
//        // Evaluate an expression
//
//        Double result = evaluator.evaluate(expression);
//
//        // Ouput the result
//        System.out.println(expression + " = " + result);
//        return result + "";
//    }
    public static String scientificCalculate(String expression, String unit){
        Expression e = new Expression(expression);
        if (unit == "deg") mXparser.setDegreesMode();
        else mXparser.setRadiansMode();
        double number = e.calculate();
        if(number % 1 == 0) return "" + (int)number;
        else return "" + number;
    }
}
