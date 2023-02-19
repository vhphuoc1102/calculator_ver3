package com.calculator.calculator_ver3.MathFeatures;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

public class Calc {
    public static String calc(
            String expression,
            String aValue,
            String bValue,
            String cValue,
            String dValue,
            String eValue,
            String fValue,
            String gValue,
            String hValue,
            String mValue,
            String nValue,
            String xValue,
            String yValue,
            String zValue,
            String tValue){
        Expression ex = new Expression(expression);
        if(!aValue.equals("")) ex.addArguments(new Argument("a = " + aValue));
        if(!bValue.equals("")) ex.addArguments(new Argument("b = " + bValue));
        if(!cValue.equals("")) ex.addArguments(new Argument("c = " + cValue));
        if(!dValue.equals("")) ex.addArguments(new Argument("d = " + dValue));
        if(!eValue.equals("")) ex.addArguments(new Argument("e = " + eValue));
        if(!fValue.equals("")) ex.addArguments(new Argument("f = " + fValue));
        if(!gValue.equals("")) ex.addArguments(new Argument("g = " + gValue));
        if(!hValue.equals("")) ex.addArguments(new Argument("h = " + hValue));
        if(!mValue.equals("")) ex.addArguments(new Argument("m = " + mValue));
        if(!nValue.equals("")) ex.addArguments(new Argument("n = " + nValue));
        if(!xValue.equals("")) ex.addArguments(new Argument("x = " + xValue));
        if(!yValue.equals("")) ex.addArguments(new Argument("y = " + yValue));
        if(!zValue.equals("")) ex.addArguments(new Argument("z = " + zValue));
        if(!tValue.equals("")) ex.addArguments(new Argument("t = " + tValue));
        return ex.calculate() + "";
    }
}
