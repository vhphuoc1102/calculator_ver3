package com.calculator.calculator_ver3.MathFeatures;

import org.mariuszgromada.math.mxparser.Expression;

public class BasicCalculate {
    public static Double basicCalculate(String expression){
        return new Expression(expression).calculate();
    }
    public static String intOrDouble(double number){
        if(number % 1 == 0) return "" + (int)number;
        else return "" + number;
    }
}
