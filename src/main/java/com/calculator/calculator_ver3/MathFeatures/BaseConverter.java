package com.calculator.calculator_ver3.MathFeatures;

public class BaseConverter {
    public static String baseConversion(String number, int sBase, int dBase) {
        if(number.length() == 32 && number.charAt(0) == '1' && sBase == 2 && dBase == 10){
            return "" + (-(long)Math.pow(2, 31) + Long.parseLong(number.substring(1),2));
        }
        // Parse the number with source radix
        // and return in specified radix(base)

        return Long.toString(Long.parseLong(number, sBase), dBase);
    }
}
