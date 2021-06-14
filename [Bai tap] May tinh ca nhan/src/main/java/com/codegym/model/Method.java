package com.codegym.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Method {
    public static List<String> method = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public static Float calculate(float num1, float num2, String method){
        switch (method){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num1 == 0){
                    return null;
                } else {
                    return num1 / num2;
                }
            default:
                return null;
        }
    }
}
