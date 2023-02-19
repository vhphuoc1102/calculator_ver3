package com.calculator.calculator_ver3.MathFeatures;

public class FloatPresent {
    public static String getFloat(String expressionBin){
        int bits = Integer.parseInt(expressionBin, 2);
        float num = Float.intBitsToFloat(bits);
        return num + "";
    }
    public static String getBin32(String expressionFloat){
        float num = Float.parseFloat(expressionFloat);
        int bits = Float.floatToIntBits(num);
        String binary = Integer.toBinaryString(bits);
        String formattedBinary = String.format("%32s", binary).replace(' ', '0');
        return formattedBinary;
    }
}
